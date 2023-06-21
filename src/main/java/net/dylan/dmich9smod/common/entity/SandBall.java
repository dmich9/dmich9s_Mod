/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.common.entity;

import com.mojang.math.Vector3f;
import net.dylan.dmich9smod.init.ModEffects;
import net.dylan.dmich9smod.init.ModEntityTypes;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.List;

public class SandBall extends MobEffectProjectile implements IAnimatable {

    // GECKOLIB //
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    // OTHER //
    private static final Vector3f COLOR = new Vector3f(1.0F, 0.827F, 0.667F);

    public SandBall(EntityType<? extends SandBall> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SandBall(double pX, double pY, double pZ, Level pLevel) {
        super(ModEntityTypes.SAND_BALL.get(), pX, pY, pZ, pLevel);
    }

    public SandBall(LivingEntity pShooter, Level pLevel) {
        super(ModEntityTypes.SAND_BALL.get(), pShooter, pLevel);
    }

    @Override
    protected void defineSynchedData() {
        // do nothing
    }

    @Override
    protected float getGravity() {
        return 0.012F;
    }

    //// MOB EFFECT PROJECTILE ////

    @Override
    protected List<MobEffectInstance> getMobEffects(LivingEntity entity) {
        return List.of(new MobEffectInstance(ModEffects.STRANDED.get(), 20 * 60 * 10, 0, true, true));
    }

    @Override
    protected ParticleOptions getImpactParticle(LivingEntity entity) {
        return new DustParticleOptions(COLOR, 2.0F);
    }

    @Override
    protected ParticleOptions getTrailParticle() {
        return new DustParticleOptions(COLOR, 1.0F);
    }

    @Override
    protected float getImpactDamage(LivingEntity entity) {
        return 2.0F;
    }

    @Override
    protected long getLifespan() {
        return 300;
    }

    //// ANIMATIONS ////

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        // TODO sand ball animations, if any
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

}
