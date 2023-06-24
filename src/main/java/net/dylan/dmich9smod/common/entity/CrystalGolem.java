/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.common.entity;

import net.dylan.dmich9smod.init.ModEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.EnumSet;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;

public class CrystalGolem extends Monster implements IAnimatable {

    // GECKOLIB //
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private static final AnimationBuilder ANIM_IDLE = new AnimationBuilder().addAnimation("animation.model.idle", ILoopType.EDefaultLoopTypes.LOOP);
    private static final AnimationBuilder ANIM_ATTACKING = new AnimationBuilder().addAnimation("animation.model.attacking", ILoopType.EDefaultLoopTypes.LOOP);

    // EVENTS //
    private static final byte START_LEAP_ATTACK_EVENT = 11;
    private static final byte STOP_LEAP_ATTACK_EVENT = 12;

    // LEAP ATTACK //
    private BlockPos leapToTarget = null;
    private static final double MAX_LEAP_SPEED = 1.48D;
    private static final float MIN_LEAP_DISTANCE = 4.0F;
    private static final float MAX_LEAP_DISTANCE = 12.0F;
    private static final float MAX_LEAP_HEIGHT = 12.0F;
    private static final int LEAP_ATTACK_COOLDOWN = 120;

    // OTHER //
    private static final Predicate<LivingEntity> CAN_LEAP_ATTACK_HURT = e -> e.getType() != ModEntityTypes.CRYSTAL_GOLEM.get() && e.canChangeDimensions() && e.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE) < 1.0D;
    private static final AttributeModifier LEAP_ATTACK_BONUS = new AttributeModifier("Leap Attack Bonus", 2.0D, AttributeModifier.Operation.MULTIPLY_BASE);

    public CrystalGolem(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.24D)
                .add(Attributes.ARMOR, 8.0D)
                .add(Attributes.MAX_HEALTH, 80.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .build();
    }

    public static boolean canCrystalGolemSpawn(EntityType<? extends CrystalGolem> entityType, ServerLevelAccessor level, MobSpawnType mobSpawnType, BlockPos pos, Random random) {
        return pos.getY() < level.getSeaLevel() && !level.canSeeSky(pos.above()) && Monster.checkMonsterSpawnRules(entityType, level, mobSpawnType, pos, random);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new LeapToTargetGoal(this, MAX_LEAP_SPEED, MIN_LEAP_DISTANCE, MAX_LEAP_DISTANCE, MAX_LEAP_HEIGHT, LEAP_ATTACK_COOLDOWN));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));

        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class,8.0F));

        this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false, false));
    }

    @Override
    public boolean isInvulnerableTo(DamageSource pSource) {
        return pSource == DamageSource.CACTUS || pSource == DamageSource.FALLING_STALACTITE
                || pSource == DamageSource.STALAGMITE || pSource == DamageSource.SWEET_BERRY_BUSH
                || super.isInvulnerableTo(pSource);
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        final boolean isLeaping = this.getPose() == Pose.LONG_JUMPING;
        final BlockPos blockPosBelow = this.getBlockPosBelowThatAffectsMyMovement();
        final boolean isDoneLeaping = isLeaping && this.leapToTarget != null
                && this.isOnGround()
                && this.level.getBlockState(blockPosBelow).getMaterial().blocksMotion();
        if(isDoneLeaping) {
            this.stopLeapAttack();
        }
    }

    @Override
    protected int decreaseAirSupply(int pCurrentAir) {
        return pCurrentAir;
    }

    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource source) {
        return false;
    }

    @Override
    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {}

    @Override
    public void push(Entity pEntity) {}

    @Override
    protected void doPush(Entity pEntity) {}

    //// JUMPING ////

    protected boolean canLeapAttack() {
        return this.getPose() != Pose.LONG_JUMPING && this.isOnGround();
    }

    protected void startLeapAttack(final Vec3 leapVec, final BlockPos leapPos) {
        if(!this.level.isClientSide()) {
            this.leapToTarget = leapPos;
            this.setPose(Pose.LONG_JUMPING);
            this.setDeltaMovement(leapVec);
            this.hurtMarked = true;
            this.hasImpulse = true;
            this.onGround = false;
            this.level.broadcastEntityEvent(this, START_LEAP_ATTACK_EVENT);
        }
    }

    protected void stopLeapAttack() {
        if(this.level.isClientSide()) {
            return;
        }
        this.leapToTarget = null;
        if(this.getPose() == Pose.LONG_JUMPING) {
            this.setPose(Pose.STANDING);
        }
        // damage nearby entities
        this.getAttribute(Attributes.ATTACK_DAMAGE).addTransientModifier(LEAP_ATTACK_BONUS);
        final AABB aabb = getBoundingBox().inflate(2.0D);
        for(LivingEntity e : this.level.getEntitiesOfClass(LivingEntity.class, aabb, CAN_LEAP_ATTACK_HURT)) {
            doHurtTarget(e);
        }
        this.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(LEAP_ATTACK_BONUS);
        // broadcast event
        this.level.broadcastEntityEvent(this, STOP_LEAP_ATTACK_EVENT);
    }

    @Override
    public void handleEntityEvent(byte pId) {
        switch (pId) {
            case START_LEAP_ATTACK_EVENT:
                addLeapAttackParticles(ParticleTypes.CLOUD, this.position(), 12, 0.10D);
                break;
            case STOP_LEAP_ATTACK_EVENT:
                addLeapAttackParticles(ParticleTypes.CLOUD, this.position(), 32, 0.15D);
                break;
            default:
                super.handleEntityEvent(pId);
        }
    }

    //// SOUNDS ////

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.STONE_STEP, getSoundVolume() * 0.5F, getVoicePitch());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.STONE_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 1.0F;
    }

    //// ANIMATIONS ////

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(ANIM_ATTACKING);
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(ANIM_IDLE);
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
     * Spawns particles that move away from a central point
     * @param particle the particle
     * @param center the center point
     * @param count the number of particles
     * @param motion the maximum particle motion
     */
    private void addLeapAttackParticles(final ParticleOptions particle, final Vec3 center,
                            final int count, final double motion) {
        double dx, dy, dz;
        for(int i = 0; i < count; i++) {
            // calculate random motion
            dx = (this.getRandom().nextDouble() - 0.5D) * 2.0D * motion;
            dy = (this.getRandom().nextDouble() * 0.5D) * motion;
            dz = (this.getRandom().nextDouble() - 0.5D) * 2.0D * motion;
            level.addParticle(particle, center.x(), center.y(), center.z(), dx, dy, dz);
        }
    }

    //// GOALS ////

    private static class LeapToTargetGoal extends Goal {

        private final CrystalGolem entity;
        private final double maxLeapSpeed;
        private final float minLeapDistance;
        private final float maxLeapDistance;
        private final float maxLeapHeight;

        private Vec3 leapVec;
        private BlockPos leapToTarget;
        private final int cooldown;

        private int cooldownProgress;

        private LeapToTargetGoal(CrystalGolem entity, double maxLeapSpeed, float minLeapDistance, float maxLeapDistance, float maxLeapHeight, int cooldown) {
            this.entity = entity;
            this.maxLeapSpeed = maxLeapSpeed;
            this.minLeapDistance = minLeapDistance;
            this.maxLeapDistance = maxLeapDistance;
            this.maxLeapHeight = maxLeapHeight;
            this.cooldown = cooldown;
            this.cooldownProgress = cooldown / 3;
            this.setFlags(EnumSet.noneOf(Goal.Flag.class));
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return this.cooldownProgress > 0;
        }

        @Override
        public boolean canUse() {
            if(--this.cooldownProgress > 0) {
                return false;
            }
            if(!this.entity.canLeapAttack()) {
                return false;
            }
            // validate distance to target
            final LivingEntity target = this.entity.getTarget();
            if(null == target) {
                return false;
            }
            final double verticalDis = target.getY() - this.entity.getY();
            final double disSq = target.position().multiply(1.0D, 0.0D, 1.0D)
                    .distanceToSqr(this.entity.position().multiply(1.0D, 0.0D, 1.0D));
            if(verticalDis > maxLeapHeight || disSq < (minLeapDistance * minLeapDistance) || disSq > (maxLeapDistance * maxLeapDistance)) {
                return false;
            }
            // validate landing position
            final BlockPos jumpToTarget = target.blockPosition().below();
            final BlockState jumpToState = this.entity.level.getBlockState(jumpToTarget);
            if(!canLandOn(jumpToTarget, jumpToState)) {
                return false;
            }
            // calculate jump vector
            final Optional<Vec3> oJumpVec = calculateJumpVec(this.entity.position(), new Vec3(jumpToTarget.getX() + 0.5D, jumpToTarget.getY() + 1.1D, jumpToTarget.getZ() + 0.5D));
            if(oJumpVec.isEmpty()) {
                return false;
            }
            this.leapVec = oJumpVec.get();
            this.leapToTarget = jumpToTarget;
            return true;
        }

        @Override
        public void start() {
            this.entity.startLeapAttack(this.leapVec, this.leapToTarget);
        }

        @Override
        public boolean canContinueToUse() {
            return false;
        }

        @Override
        public void stop() {
            this.leapToTarget = BlockPos.ZERO;
            this.leapVec = Vec3.ZERO;
            this.cooldownProgress = this.cooldown;
        }

        protected boolean canLandOn(final BlockPos pos, final BlockState blockState) {
            if(!blockState.isFaceSturdy(this.entity.level, pos, Direction.UP)) {
                return blockState.getMaterial().blocksMotion();
            }
            return true;
        }

        protected Optional<Vec3> calculateJumpVec(final Vec3 start, final Vec3 end) {
            final double gravity = this.entity.getAttributeValue(ForgeMod.ENTITY_GRAVITY.get());
            final double verticalFriction = 0.98F;
            final double horizontalFriction = this.entity.shouldDiscardFriction() ? 1.0D : 0.91F;
            final double cubicHorizontalFriction = horizontalFriction * horizontalFriction * horizontalFriction;
            double dx;
            double dz;
            Vec3 motion;
            double halfGravity = -0.5D * gravity * verticalFriction;
            double deltaY = end.y() - start.y();
            double travelTime;
            double quadraticRoot;
            for(double yMotionMax = Math.sqrt(2 * gravity * verticalFriction * maxLeapHeight), dy = (Math.random() * 0.25D + 0.75D) * yMotionMax; dy > 0.12D; dy -= 0.125D) {
                // determine amount of time that will be spent in the air
                quadraticRoot = Math.sqrt((dy * dy) - 4 * halfGravity * Math.abs(deltaY));
                travelTime = Math.floor(Math.max((-dy - quadraticRoot) / (2 * halfGravity), (-dy + quadraticRoot) / (2 * halfGravity)));
                // calculate motion for a parabola with the given y velocity and travel time
                dx = ((end.x() - start.x()) / travelTime);
                dx /= (0.21600002F / cubicHorizontalFriction);
                dz = ((end.z() - start.z()) / travelTime);
                dz /= (0.21600002F / cubicHorizontalFriction);
                motion = new Vec3(dx, dy, dz);
                // verify speed
                if(motion.horizontalDistanceSqr() > (maxLeapSpeed * maxLeapSpeed)) {
                    continue;
                }
                // verify no collisions
                if(hasNoCollisions(start, end, motion, gravity, verticalFriction, horizontalFriction)) {
                    return Optional.of(motion);
                }
            }

            return Optional.empty();
        }

        protected boolean hasNoCollisions(final Vec3 start, final Vec3 end, final Vec3 motionVec,
                                          final double gravity, final double verticalFriction, final double horizontalFriction) {
            // step along the resulting positions
            final double stepSize = 1.0D;
            Vec3 point = start;
            double time = 0;
            for(int step = 0; point.closerThan(end, stepSize + 0.1D); step++) {
                // determine position for this step
                time = step * stepSize;
                // x = (dx)t, y = (dyi)t - (dy/2)t2, z = (dz)t
                point = new Vec3((motionVec.x() / horizontalFriction) * time,
                        ((motionVec.y() / verticalFriction) * time) - (0.5D * gravity) * (time * time),
                        (motionVec.z() / horizontalFriction) * time);
                // check for collisions
                if(hasCollisions(point)) {
                    return false;
                }
            }
            // all checks passed
            return true;
        }

        protected boolean hasCollisions(final Vec3 pos) {
            return this.entity.level.collidesWithSuffocatingBlock(this.entity, this.entity.getDimensions(Pose.LONG_JUMPING).makeBoundingBox(pos));
        }
    }
}