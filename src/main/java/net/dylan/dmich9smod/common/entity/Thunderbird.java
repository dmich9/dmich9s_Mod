/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class Thunderbird extends Monster implements FlyingAnimal, IAnimatable {
    
    // SYNCHED DATA //
    private static final EntityDataAccessor<Byte> DATA_FLAGS = SynchedEntityData.defineId(Thunderbird.class, EntityDataSerializers.BYTE);
    private static final byte FLAG_NONE = 0;
    private static final byte FLAG_POWERED = 1;
    
    // GECKOLIB //
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private static final AnimationBuilder ANIM_IDLE_STANDING = new AnimationBuilder().addAnimation("animation.dmich_tbird.standing", ILoopType.EDefaultLoopTypes.LOOP);
    private static final AnimationBuilder ANIM_IDLE_FLYING = new AnimationBuilder().addAnimation("animation.dmich_tbird.flying", ILoopType.EDefaultLoopTypes.LOOP);

    // FLYING //
    private boolean wantsToFly;
    private Vec3 moveTargetPoint = Vec3.ZERO;
    private BlockPos anchorPoint = BlockPos.ZERO;

    // NAVIGATION //
    private final PathNavigation groundNavigation;
    private final PathNavigation flyingNavigation;
    private final MoveControl simpleFlyingMoveControl;
    private final MoveControl circlingFlyingMoveControl;
    private final MoveControl walkingMoveControl;
    private boolean isNavigationDirty;

    // ATTACK //
    private static final byte START_POWERED_EVENT = 61;
    private static final byte POWERED_ATTACK_EVENT = 62;
    private static final int POWERED_ATTACK_DURATION = 65;
    private static final int MIN_POWERED_ATTACK_COOLDOWN = 180; // TODO balance
    private static final int MAX_POWERED_ATTACK_COOLDOWN = 250; // TODO balance
    
    public Thunderbird(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.simpleFlyingMoveControl = new FlyingMoveControl(this, 10, false);
        this.circlingFlyingMoveControl = new Thunderbird.ThunderbirdMoveControl(this);
        this.walkingMoveControl = new MoveControl(this);
        this.moveControl = this.walkingMoveControl;
        this.groundNavigation = createNavigation(level);
        this.flyingNavigation = createFlyingNavigation(level);
        this.navigation = groundNavigation;
        this.wantsToFly = false;
        this.lookControl = new Thunderbird.ThunderbirdLookControl(this);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.ATTACK_DAMAGE, 6.0D)
                .add(Attributes.FOLLOW_RANGE, 50.0D)
                .add(Attributes.MOVEMENT_SPEED,0.30F)
                .add(Attributes.FLYING_SPEED, 1.30D)
                .add(Attributes.MAX_HEALTH, 20.0D)
                .build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new Thunderbird.PoweredAttackGoal(this, POWERED_ATTACK_DURATION, MIN_POWERED_ATTACK_COOLDOWN, MAX_POWERED_ATTACK_COOLDOWN, 48.0D));
        this.goalSelector.addGoal(2, new Thunderbird.CircleAroundAnchorGoal(this));

        this.goalSelector.addGoal(5, new Thunderbird.WanderGoal(this, 0.9D, 7.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class,8.0F));

        this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true, false));
        // TODO remove after testing
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Sheep.class, true, false));

    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(DATA_FLAGS, FLAG_NONE);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @javax.annotation.Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        this.anchorPoint = this.blockPosition().above(5);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        if(this.getNavigation().isDone() && this.isFlying() && !this.isAggressive()) {
            this.setWantsToFly(false);
            this.isNavigationDirty = true;
        }
        if(this.isNavigationDirty) {
            this.isNavigationDirty = false;
            // update navigation and move control
            final BlockPos oldTargetPos = this.getNavigation().getTargetPos();
            final boolean oldInProgress = this.getNavigation().isInProgress();
            if(isAggressive()) {
                this.moveControl = circlingFlyingMoveControl;
                this.navigation = flyingNavigation;
            } else if(wantsToFly) {
                this.moveControl = simpleFlyingMoveControl;
                this.navigation = flyingNavigation;
            } else {
                this.moveControl = walkingMoveControl;
                this.navigation = groundNavigation;
                this.setNoGravity(false);
            }
            // update navigation path
            if(oldInProgress && oldTargetPos != null) {
                final Vec3 vec = Vec3.atBottomCenterOf(oldTargetPos);
                // TODO make speed public so we can keep that?
                this.getNavigation().moveTo(vec.x(), vec.y(), vec.z(), 1.0D);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        // slow falling
        if(this.getDeltaMovement().y() < 0.0D) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
        }
        // powered particles
        if(this.level.isClientSide() && this.isPowered()) {
            addPoweredParticles(ParticleTypes.ELECTRIC_SPARK, this.position().add(0, this.getBbHeight() * 0.5D, 0), this.getBbWidth(), 3, 0.002D);
        }
    }

    //// FLYING ANIMAL ////

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }

    @Override
    protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {}

    @Override
    protected PathNavigation createNavigation(Level pLevel) {
        return new GroundPathNavigation(this, pLevel);
    }

    protected PathNavigation createFlyingNavigation(final Level pLevel) {
        final FlyingPathNavigation nav = new FlyingPathNavigation(this, pLevel);
        nav.setCanPassDoors(true);
        nav.setCanOpenDoors(false);
        nav.setCanFloat(false);
        return nav;
    }

    @Override
    public PathNavigation getNavigation() {
        return wantsToFly() ? flyingNavigation : groundNavigation;
    }

    @Override
    public void travel(Vec3 pTravelVector) {
        if(this.isFlying()) {
            flyingTravel(pTravelVector);
            return;
        }
        super.travel(pTravelVector);
    }

    protected void flyingTravel(final Vec3 pTravelVector) {
        /* Copied from Phantom#travel */
        if (this.isInWater()) {
            this.moveRelative(0.02F, pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale((double)0.8F));
        } else if (this.isInLava()) {
            this.moveRelative(0.02F, pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
        } else {
            BlockPos ground = new BlockPos(this.getX(), this.getY() - 1.0D, this.getZ());
            float f = 0.91F;
            if (this.onGround) {
                f = this.level.getBlockState(ground).getFriction(this.level, ground, this) * 0.91F;
            }

            float f1 = 0.16277137F / (f * f * f);
            f = 0.91F;
            if (this.onGround) {
                f = this.level.getBlockState(ground).getFriction(this.level, ground, this) * 0.91F;
            }

            this.moveRelative(this.onGround ? 0.1F * f1 : 0.02F, pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale((double)f));
        }

        this.calculateEntityAnimation(this, false);
    }

    @Override
    public boolean onClimbable() {
        return false;
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double pDistance) {
        return true;
    }
    
    @Override
    public boolean isFlying() {
        return wantsToFly && !this.isOnGround();
    }

    @Override
    public void setAggressive(boolean pAggressive) {
        super.setAggressive(pAggressive);
        this.isNavigationDirty = true;
    }

    public boolean wantsToFly() {
        return wantsToFly;
    }

    public void setWantsToFly(boolean wantsToFly) {
        this.wantsToFly = wantsToFly;
        this.isNavigationDirty = true;
    }

    @Override
    public MoveControl getMoveControl() {
        return super.getMoveControl();
    }

    //// POWERED ////
    
    private byte getThunderbirdFlags() {
        return getEntityData().get(DATA_FLAGS);
    }
    
    private void setThunderbirdFlags(final byte flags) {
        getEntityData().set(DATA_FLAGS, flags);
    }
    
    public boolean isPowered() {
        return (getThunderbirdFlags() & FLAG_POWERED) > 0;
    }
    
    public void setPowered(final boolean powered) {
        if(powered) {
            setThunderbirdFlags((byte) (getThunderbirdFlags() | FLAG_POWERED));
            if(!this.level.isClientSide()) {
                this.level.broadcastEntityEvent(this, START_POWERED_EVENT);
            }
        } else {
            setThunderbirdFlags((byte) (getThunderbirdFlags() & ~FLAG_POWERED));
        }
    }

    public void performPoweredAttack(final Vec3 targetPos) {
        // verify server and powered
        if(this.level.isClientSide() || !this.isPowered()) {
            return;
        }
        // summon lightning
        final LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(this.level);
        bolt.setPos(targetPos);
        bolt.setDamage((float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue());
        this.level.addFreshEntity(bolt);
        this.level.broadcastEntityEvent(this, POWERED_ATTACK_EVENT);
        // unpower
        this.setPowered(false);
    }

    @Override
    public void handleEntityEvent(byte pId) {
        switch (pId) {
            case START_POWERED_EVENT:
                this.playSound(getPoweredSound(), 2.0F, getVoicePitch());
                break;
            case POWERED_ATTACK_EVENT:
                // TODO anything?
                break;
            default:
                super.handleEntityEvent(pId);
        }
    }

    //// SOUNDS ////

    protected SoundEvent getPoweredSound() {
        return SoundEvents.TNT_PRIMED;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.PARROT_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.PARROT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PARROT_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 1.0F;
    }

    @Override
    public float getVoicePitch() {
        return super.getVoicePitch() - 0.15F;
    }

    //// NBT ////

    private static final String KEY_ANCHOR = "AnchorPoint";
    private static final String KEY_FLAGS = "ThunderbirdFlags";
    
    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setThunderbirdFlags(pCompound.getByte(KEY_FLAGS));
        this.anchorPoint = NbtUtils.readBlockPos(pCompound.getCompound(KEY_ANCHOR));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putByte(KEY_FLAGS, getThunderbirdFlags());
        pCompound.put(KEY_ANCHOR, NbtUtils.writeBlockPos(this.anchorPoint));
    }

    //// ANIMATIONS ////

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(!this.isOnGround()) {
            event.getController().setAnimation(ANIM_IDLE_FLYING);
        } else {
            event.getController().setAnimation(ANIM_IDLE_STANDING);
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 2F, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }


    //// OTHER ////

    /**
     * Spawns particles in a radius around the given position
     * @param particle the particle
     * @param center the center point
     * @param radius the maximum radius of particle spawns
     * @param count the number of particles
     * @param motion the maximum particle motion
     */
    public void addPoweredParticles(final ParticleOptions particle, final Vec3 center, final double radius, final int count, final double motion) {
        if(this.level instanceof ServerLevel serverLevel) {
            spawnServerPoweredParticles(serverLevel, particle, center, radius, count, motion);
        } else {
            spawnClientPoweredParticles(particle, center, radius, count, motion);
        }
    }

    private void spawnClientPoweredParticles(final ParticleOptions particle, final Vec3 center, final double radius, final int count, final double motion) {
        double x, y, z;
        double dx, dy, dz;
        for(int i = 0; i < count; i++) {
            // calculate random position in radius
            x = center.x() + (this.getRandom().nextDouble() - 0.5D) * 2.0D * radius;
            y = center.y() + (this.getRandom().nextDouble() - 0.5D) * 2.0D * radius;
            z = center.z() + (this.getRandom().nextDouble() - 0.5D) * 2.0D * radius;
            // calculate random motion
            dx = (this.getRandom().nextDouble() - 0.5D) * 2.0D * motion;
            dy = (this.getRandom().nextDouble()) * motion;
            dz = (this.getRandom().nextDouble() - 0.5D) * 2.0D * motion;
            level.addParticle(particle, x, y, z, dx, dy, dz);
        }
    }

    private void spawnServerPoweredParticles(final ServerLevel serverLevel, final ParticleOptions particle, final Vec3 center, final double radius, final int count, final double motion) {
        serverLevel.sendParticles(particle, center.x(), center.y(), center.z(), count, radius, radius, radius, motion);
    }
    
    //// MOVE CONTROL ////

    /**
     * Copied from Phantom.PhantomMoveControl
     */
    private static class ThunderbirdMoveControl extends MoveControl {
        private final Thunderbird entity;
        private float speed = 0.2F;

        public ThunderbirdMoveControl(Thunderbird pMob) {
            super(pMob);
            this.entity = pMob;
        }

        public void tick() {
            if (this.entity.horizontalCollision) {
                this.entity.setYRot(this.entity.getYRot() + 180.0F);
                this.speed = 0.2F;
            }

            double d0 = this.entity.moveTargetPoint.x - this.entity.getX();
            double d1 = this.entity.moveTargetPoint.y - this.entity.getY();
            double d2 = this.entity.moveTargetPoint.z - this.entity.getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            if (Math.abs(d3) > (double)1.0E-5F) {
                double d4 = 1.0D - Math.abs(d1 * (double)0.7F) / d3;
                d0 *= d4;
                d2 *= d4;
                d3 = Math.sqrt(d0 * d0 + d2 * d2);
                double d5 = Math.sqrt(d0 * d0 + d2 * d2 + d1 * d1);
                float f = this.entity.getYRot();
                float f1 = (float)Mth.atan2(d2, d0);
                float f2 = Mth.wrapDegrees(this.entity.getYRot() + 90.0F);
                float f3 = Mth.wrapDegrees(f1 * (180F / (float)Math.PI));
                this.entity.setYRot(Mth.approachDegrees(f2, f3, 4.0F) - 90.0F);
                this.entity.yBodyRot = this.entity.getYRot();
                if (Mth.degreesDifferenceAbs(f, this.entity.getYRot()) < 3.0F) {
                    this.speed = Mth.approach(this.speed, 1.8F, 0.005F * (1.8F / this.speed));
                } else {
                    this.speed = Mth.approach(this.speed, 0.2F, 0.025F);
                }

                float f4 = (float)(-(Mth.atan2(-d1, d3) * (double)(180F / (float)Math.PI)));
                this.entity.setXRot(f4);
                float f5 = this.entity.getYRot() + 90.0F;
                double d6 = (double)(this.speed * Mth.cos(f5 * ((float)Math.PI / 180F))) * Math.abs(d0 / d5);
                double d7 = (double)(this.speed * Mth.sin(f5 * ((float)Math.PI / 180F))) * Math.abs(d2 / d5);
                double d8 = (double)(this.speed * Mth.sin(f4 * ((float)Math.PI / 180F))) * Math.abs(d1 / d5);
                Vec3 vec3 = this.entity.getDeltaMovement();
                this.entity.setDeltaMovement(vec3.add((new Vec3(d6, d8, d7)).subtract(vec3).scale(0.2D)));
            }

        }
    }

    private static class ThunderbirdLookControl extends LookControl {
        private final Thunderbird entity;

        public ThunderbirdLookControl(final Thunderbird pMob) {
            super(pMob);
            this.entity = pMob;
        }

        @Override
        public void tick() {
            if(!entity.isFlying()) {
                super.tick();
            }
        }
    }

    //// GOALS ////

    private static class PoweredAttackGoal extends Goal {

        private final Thunderbird entity;
        private final int duration;
        private final int cooldown;
        private final double maxDistance;

        private Vec3 targetPoint;
        private int durationProgress;
        private int cooldownProgress;

        private PoweredAttackGoal(Thunderbird entity, int duration, int minCooldown, int maxCooldown, double maxDistance) {
            this.entity = entity;
            this.duration = duration;
            this.cooldown = entity.getRandom().nextInt(minCooldown, maxCooldown);
            this.maxDistance = maxDistance;
            this.cooldownProgress = cooldown / 3;
            this.durationProgress = duration;
            this.setFlags(EnumSet.noneOf(Goal.Flag.class));
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return this.cooldownProgress > 0 || this.durationProgress > 0;
        }

        @Override
        public boolean canUse() {
            if(--cooldownProgress > 0) {
                return false;
            }
            final LivingEntity target = this.entity.getTarget();
            if(null == target || !target.isAlive()) {
                return false;
            }
            this.targetPoint = target.position();
            return true;
        }

        @Override
        public boolean canContinueToUse() {
            final LivingEntity target = this.entity.getTarget();
            return this.entity.isPowered() && target != null && target.isAlive() && this.targetPoint.closerThan(this.entity.position(), this.maxDistance);
        }

        @Override
        public void start() {
            this.durationProgress = duration;
            this.entity.setPowered(true);
        }

        @Override
        public void tick() {
            this.entity.addPoweredParticles(ParticleTypes.ELECTRIC_SPARK, this.targetPoint, 0.25D, 1, 0.002F);
            if(--this.durationProgress <= 0) {
                this.entity.performPoweredAttack(this.targetPoint);
                this.cooldownProgress = this.cooldown;
                this.durationProgress = this.duration;
            }
        }

        @Override
        public void stop() {
            this.cooldownProgress = this.cooldown;
            this.durationProgress = 0;
        }
    }

    private static class WanderGoal extends WaterAvoidingRandomStrollGoal {
        private final Thunderbird entity;
        private final double maxDistance;

        public WanderGoal(final Thunderbird entity, final double speedModifier, final double maxDistance) {
            super(entity, speedModifier, 0.05F);
            this.entity = entity;
            this.maxDistance = maxDistance;
        }

        @Override
        public boolean canUse() {
            return super.canUse();
        }

        @Override
        public void start() {
            super.start();
            final Vec3 targetPos = new Vec3(wantedX, wantedY, wantedZ);
            this.entity.setWantsToFly(!targetPos.closerThan(this.entity.position(), maxDistance));
        }

        @Override
        protected Vec3 getPosition() {
            if(this.entity.getRandom().nextFloat() < 0.28F) {
                return DefaultRandomPos.getPos(this.mob, 20, 10);
            }
            return super.getPosition();
        }

    }

    private static class CircleAroundAnchorGoal extends MoveTargetGoal {
        private final Thunderbird entity;
        private float angle;
        private float distance;
        private float height;
        private float clockwise;

        public CircleAroundAnchorGoal(final Thunderbird entity) {
            super(entity);
            this.entity = entity;
        }

        @Override
        public boolean canUse() {
            return this.entity.getTarget() != null;
        }

        @Override
        public void start() {
            this.entity.anchorPoint = this.entity.getTarget().blockPosition().above(5);
            this.distance = 5.0F + this.entity.random.nextFloat() * 10.0F;
            this.height = -4.0F + this.entity.random.nextFloat() * 9.0F;
            this.clockwise = this.entity.random.nextBoolean() ? 1.0F : -1.0F;
            this.selectNext();
            this.entity.setAggressive(true);
            this.entity.setWantsToFly(true);
        }

        @Override
        public void tick() {
            if (this.entity.random.nextInt(this.adjustedTickDelay(350)) == 0) {
                this.height = -4.0F + this.entity.random.nextFloat() * 9.0F;
            }

            if (this.entity.random.nextInt(this.adjustedTickDelay(250)) == 0) {
                ++this.distance;
                if (this.distance > 15.0F) {
                    this.distance = 5.0F;
                    this.clockwise = -this.clockwise;
                }
            }

            if (this.entity.random.nextInt(this.adjustedTickDelay(450)) == 0) {
                this.angle = this.entity.random.nextFloat() * 2.0F * (float)Math.PI;
                this.selectNext();
            }

            if (this.touchingTarget()) {
                this.selectNext();
            }

            if (this.entity.moveTargetPoint.y < this.entity.getY() && !this.entity.level.isEmptyBlock(this.entity.blockPosition().below(1))) {
                this.height = Math.max(1.0F, this.height);
                this.selectNext();
            }

            if (this.entity.moveTargetPoint.y > this.entity.getY() && !this.entity.level.isEmptyBlock(this.entity.blockPosition().above(1))) {
                this.height = Math.min(-1.0F, this.height);
                this.selectNext();
            }

        }

        @Override
        public void stop() {
            super.stop();
            final LivingEntity target = this.entity.getTarget();
            this.entity.setAggressive(false);
            this.entity.setWantsToFly(target != null && target.isAlive());
        }

        private void selectNext() {
            if (BlockPos.ZERO.equals(this.entity.anchorPoint)) {
                this.entity.anchorPoint = this.entity.blockPosition();
            }

            this.angle += this.clockwise * 15.0F * ((float)Math.PI / 180F);
            this.entity.moveTargetPoint = Vec3.atLowerCornerOf(this.entity.anchorPoint).add((double)(this.distance * Mth.cos(this.angle)), (double)(-4.0F + this.height), (double)(this.distance * Mth.sin(this.angle)));
        }
    }

    private static abstract class MoveTargetGoal extends Goal {

        protected final Thunderbird entity;
        
        public MoveTargetGoal(final Thunderbird entity) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        protected boolean touchingTarget() {
            return this.entity.moveTargetPoint.distanceToSqr(this.entity.getX(), this.entity.getY(), this.entity.getZ()) < 4.0D;
        }
    }
}