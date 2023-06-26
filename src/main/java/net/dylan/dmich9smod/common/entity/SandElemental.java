/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.common.entity;

import net.dylan.dmich9smod.common.entity.goal.IntervalRangedAttackGoal;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.Random;

public class SandElemental extends Monster implements FlyingAnimal, RangedAttackMob, IAnimatable {

    // GECKOLIB //
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private static final AnimationBuilder ANIM_IDLE = new AnimationBuilder().addAnimation("animation.s_elemental.idle", ILoopType.EDefaultLoopTypes.LOOP);
    private static final AnimationBuilder ANIM_ATTACKING_MELEE = new AnimationBuilder().addAnimation("animation.s_elemental.attackingmelee", ILoopType.EDefaultLoopTypes.PLAY_ONCE);
    private static final AnimationBuilder ANIM_ATTACKING_RANGED = new AnimationBuilder().addAnimation("animation.s_elemental.attackingdistance", ILoopType.EDefaultLoopTypes.PLAY_ONCE);
    private static final int MELEE_ATTACK_DURATION = 10;
    private static final int RANGED_ATTACK_DURATION = 10;
    private byte animationEvent;
    private int animationTime;

    // EVENTS //
    private static final byte START_MELEE_ATTACK_EVENT = 61;
    private static final byte START_RANGED_ATTACK_EVENT = 62;

    // OTHER //
    private static final float MELEE_ATTACK_DISTANCE = 6.0F;
    private static final float RANGED_ATTACK_DISTANCE = 15.0F;

    public SandElemental(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new FlyingMoveControl(this, 10, true);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 25.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.32D)
                .add(Attributes.ARMOR, 0.0D)
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_SPEED, 1.0D)
                .add(Attributes.FLYING_SPEED, 1.32D)
                .build();
    }

    public static boolean canSandElementalSpawn(EntityType<? extends SandElemental> entityType, ServerLevelAccessor level, MobSpawnType mobSpawnType, BlockPos pos, Random random) {
        return level.getBlockState(pos.below()).is(BlockTags.SAND) && Monster.checkMonsterSpawnRules(entityType, level, mobSpawnType, pos, random);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SandElemental.SandElementalRangedGoal(this, MELEE_ATTACK_DISTANCE, RANGED_ATTACK_DISTANCE));
        this.goalSelector.addGoal(2, new SandElemental.SandElementalMeleeGoal(this, MELEE_ATTACK_DISTANCE));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, LivingEntity.class, RANGED_ATTACK_DISTANCE, 1.0D, 1.0D, e -> e == this.getTarget() && !e.closerThan(this, MELEE_ATTACK_DISTANCE)));

        this.goalSelector.addGoal(6, new WaterAvoidingRandomFlyingGoal(this, 0.9F));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class,8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false));
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation flyingpathnavigator = new FlyingPathNavigation(this, level);
        flyingpathnavigator.setCanOpenDoors(false);
        flyingpathnavigator.setCanFloat(true);
        flyingpathnavigator.setCanPassDoors(true);
        return flyingpathnavigator;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.animationTime > 0) {
            --this.animationTime;
        }
    }

    //// FLYING ANIMAL ////

    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource source) {
        return false;
    }

    @Override
    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    @Override
    public boolean isFlying() {
        return !isOnGround();
    }


    //// RANGED ATTACK ////

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        final float velocity = 0.88F;
        SandBall projectile = new SandBall(this, level);
        projectile.shootFromRotation(this, this.getXRot(), this.getYRot(), 0.0F, velocity, 0.4F);
        projectile.getDeltaMovement().add(0, (target.distanceTo(this) / velocity) * projectile.getGravity() + target.getEyeHeight(), 0);
        projectile.hurtMarked = true;
        level.addFreshEntity(projectile);
        this.level.broadcastEntityEvent(this, START_RANGED_ATTACK_EVENT);
        this.playSound(SoundEvents.SNOWBALL_THROW, 1.2F, 1.0F);
    }

    //// SOUNDS ////

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, 0.15F, 1.0F);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ZOMBIE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ZOMBIE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ZOMBIE_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 0.2F;
    }

    //// ANIMATIONS ////

    @Override
    public void handleEntityEvent(byte pId) {
        switch(pId) {
            case START_MELEE_ATTACK_EVENT:
                this.animationEvent = pId;
                this.animationTime = MELEE_ATTACK_DURATION;
                break;
            case START_RANGED_ATTACK_EVENT:
                this.animationEvent = pId;
                this.animationTime = RANGED_ATTACK_DURATION;
                break;
            default:
                super.handleEntityEvent(pId);
        }
    }

    @Override
    public void swing(InteractionHand pHand, boolean pUpdateSelf) {
        super.swing(pHand, pUpdateSelf);
        if(!level.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
            this.level.broadcastEntityEvent(this, START_MELEE_ATTACK_EVENT);
        }
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(animationTime > 0) {
            switch (animationEvent) {
                case START_MELEE_ATTACK_EVENT:
                    event.getController().setAnimation(ANIM_ATTACKING_MELEE);
                    break;
                case START_RANGED_ATTACK_EVENT:
                    event.getController().setAnimation(ANIM_ATTACKING_RANGED);
                    break;
                default:
                    break;
            }
        } else {
            event.getController().setAnimation(ANIM_IDLE);
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

    //// GOALS ////

    public static class SandElementalMeleeGoal extends MeleeAttackGoal {
        private final SandElemental entity;
        private final float attackRadius;

        public SandElementalMeleeGoal(SandElemental entity, final float attackRadius) {
            super(entity, 1.0D, true);
            this.entity = entity;
            this.attackRadius = attackRadius;
        }

        @Override
        public boolean canUse() {
            return super.canUse() && this.mob.getTarget() != null && this.mob.getTarget().closerThan(this.mob, attackRadius);
        }
    }

    public static class SandElementalRangedGoal extends IntervalRangedAttackGoal<SandElemental> {

        public SandElementalRangedGoal(SandElemental pRangedAttackMob, final float minAttackRadius, final float maxAttackRadius) {
            super(pRangedAttackMob, 20, 3, 60, minAttackRadius, maxAttackRadius);
        }
    }

}