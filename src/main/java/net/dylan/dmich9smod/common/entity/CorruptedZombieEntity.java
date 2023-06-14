package net.dylan.dmich9smod.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

public class CorruptedZombieEntity extends Monster implements IAnimatable {

    // GECKOLIB //
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private static final AnimationBuilder ANIM_IDLE = new AnimationBuilder().addAnimation("animation.model.idle", ILoopType.EDefaultLoopTypes.LOOP);
    private static final AnimationBuilder ANIM_ATTACKING = new AnimationBuilder().addAnimation("animation.model.attacking", ILoopType.EDefaultLoopTypes.LOOP);

    // OTHER //
    private static final AttributeModifier CHARGE_SPEED_MODIFIER = new AttributeModifier("Charge movement speed", 1.72D, AttributeModifier.Operation.MULTIPLY_BASE);

    public CorruptedZombieEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes() {
        return Zombie.createAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.26D)
                .add(Attributes.ARMOR, 2.0D)
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_SPEED, 2.0D)
                .build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new CorruptedZombieEntity.InertGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this,1.0D,false));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class,8.0F));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(0, new TargetLookingGoal(this, 15));
    }

    @Override
    public void aiStep() {
        super.aiStep();
        final AttributeInstance speedAttribute = getAttribute(Attributes.MOVEMENT_SPEED);
        if(null == this.getTarget() && speedAttribute.hasModifier(CHARGE_SPEED_MODIFIER)) {
            speedAttribute.removeModifier(CHARGE_SPEED_MODIFIER);
        }
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        final boolean success = super.doHurtTarget(pEntity);
        final AttributeInstance speedAttribute = getAttribute(Attributes.MOVEMENT_SPEED);
        if(success && speedAttribute.hasModifier(CHARGE_SPEED_MODIFIER) && this.getTarget() == pEntity) {
            speedAttribute.removeModifier(CHARGE_SPEED_MODIFIER);
        }
        return success;
    }

    @Override
    protected void doPush(Entity pEntity) {
        if (pEntity instanceof Player player && this.getRandom().nextInt(4) == 0) {
            this.setTarget(player);
        }

        super.doPush(pEntity);
    }

    //// SOUNDS ////

    @Nullable
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


    //// GOALS ////

    private static class InertGoal extends Goal {

        private final PathfinderMob entity;

        private InertGoal(PathfinderMob entity) {
            this.entity = entity;
            this.setFlags(EnumSet.allOf(Goal.Flag.class));
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public boolean canUse() {
            return this.entity.getTarget() == null;
        }

        @Override
        public void tick() {
            this.entity.getNavigation().stop();
        }
    }

    private static class TargetLookingGoal extends TargetGoal {
        private final TargetingConditions lookingAtTargeting;
        private LivingEntity targetCandidate;
        private int lookingTicks;
        private final int lookingDuration;

        public TargetLookingGoal(final Mob pMob, final int lookingDuration) {
            super(pMob, true);
            this.lookingDuration = lookingDuration;
            this.lookingAtTargeting = TargetingConditions.forCombat().ignoreInvisibilityTesting()
                    .selector(this::isLookingAt);
        }

        @Override
        public boolean canUse() {
            // verify target does not exist
            if(this.mob.getTarget() != null) {
                return false;
            }
            // locate nearby players
            final AABB aabb = this.mob.getBoundingBox().inflate(getFollowDistance());
            final List<Player> players = this.mob.level.getNearbyPlayers(lookingAtTargeting, this.mob, aabb);
            // verify players found
            if(players.isEmpty()) {
                return false;
            }
            // sort by distance
            players.sort(Comparator.comparingDouble(p -> p.position().distanceToSqr(this.mob.position())));
            this.targetCandidate = players.get(0);
            return canAttack(this.targetCandidate, lookingAtTargeting);
        }

        @Override
        public boolean canContinueToUse() {
            return (null == targetMob && targetCandidate != null) || super.canContinueToUse();
        }

        @Override
        public void start() {
            super.start();
            if(this.targetCandidate != null) {
                this.mob.getLookControl().setLookAt(this.targetCandidate);
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return this.targetCandidate != null;
        }

        @Override
        public void tick() {
            // update looking ticks
            if(targetCandidate != null && null == this.targetMob && isLookingAt(targetCandidate) && lookingTicks++ > lookingDuration) {
                this.targetMob = this.targetCandidate;
                this.mob.setTarget(this.targetCandidate);
                this.mob.getAttribute(Attributes.MOVEMENT_SPEED).addTransientModifier(CHARGE_SPEED_MODIFIER);
                this.unseenMemoryTicks = 300;
                super.start();
            }
        }

        @Override
        public void stop() {
            super.stop();
            this.targetCandidate = null;
            this.lookingTicks = 0;
        }

        private boolean isLookingAt(final LivingEntity entity) {
            Vec3 entityViewVec = entity.getViewVector(1.0F).normalize();
            Vec3 deltaVec = new Vec3(this.mob.getX() - entity.getX(), this.mob.getEyeY() - entity.getEyeY(), this.mob.getZ() - entity.getZ());
            double distanceToEntity = deltaVec.length();
            deltaVec = deltaVec.normalize();
            double dotProduct = entityViewVec.dot(deltaVec);
            return dotProduct > (1.0D - 0.025D / distanceToEntity) && entity.hasLineOfSight(this.mob);
        }
    }

}