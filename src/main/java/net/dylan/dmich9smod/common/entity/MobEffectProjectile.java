/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.common.entity;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.network.NetworkHooks;

import java.util.List;

public abstract class MobEffectProjectile extends ThrowableProjectile {

    public MobEffectProjectile(EntityType<? extends MobEffectProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public MobEffectProjectile(EntityType<? extends MobEffectProjectile> pEntityType, double pX, double pY, double pZ, Level pLevel) {
        super(pEntityType, pX, pY, pZ, pLevel);
    }

    public MobEffectProjectile(EntityType<? extends MobEffectProjectile> pEntityType, LivingEntity pShooter, Level pLevel) {
        super(pEntityType, pShooter, pLevel);
    }

    @Override
    public void tick() {
        Entity thrower = getOwner();
        if (thrower instanceof Player && !thrower.isAlive()) {
            discard();
            return;
        }
        // remove if too old
        if (this.tickCount > getLifespan()) {
            discard();
            return;
        }
        // particle trail
        if (this.tickCount > 2) {
            addParticles(getTrailParticle(), 2);
        }
        // super method
        super.tick();
    }

    @Override
    protected void onHit(HitResult raytrace) {
        super.onHit(raytrace);
        if (this.isAlive()) {
            discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult raytrace) {
        super.onHitEntity(raytrace);
        Entity thrower = getOwner();
        if (raytrace.getEntity() != thrower && raytrace.getEntity() instanceof LivingEntity livingEntity) {
            // add potion effects
            for (final MobEffectInstance effect : getMobEffects(livingEntity)) {
                livingEntity.addEffect(effect);
            }
            // impact may inflict damage
            float damage = getImpactDamage(livingEntity);
            if (damage > 0 && thrower instanceof LivingEntity) {
                livingEntity.hurt(DamageSource.indirectMobAttack(this, (LivingEntity) thrower), damage);
            }
            // add particle effect
            addParticles(getImpactParticle(livingEntity), 10 + random.nextInt(6));
        }
    }

    @Override
    public Entity changeDimension(ServerLevel serverWorld, ITeleporter iTeleporter) {
        Entity entity = getOwner();
        if (entity != null && entity.level.dimension() != serverWorld.dimension()) {
            setOwner(null);
        }
        return super.changeDimension(serverWorld, iTeleporter);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    //// PARTICLES AND EFFECTS ////

    abstract List<MobEffectInstance> getMobEffects(final LivingEntity entity);

    abstract ParticleOptions getImpactParticle(final LivingEntity entity);

    abstract ParticleOptions getTrailParticle();

    abstract float getImpactDamage(final LivingEntity entity);

    abstract long getLifespan();

    protected void addParticles(final ParticleOptions type, final int count) {
        if(!this.level.isClientSide()) {
            return;
        }

        final double x = getX();
        final double y = getY() + 0.1D;
        final double z = getZ();
        final double motion = 0.08D;
        final double width = getBbWidth() / 2;
        final double height = getBbHeight() / 2;
        for (int i = 0; i < count; i++) {
            level.addParticle(type,
                    x + (level.random.nextDouble() - 0.5D) * width,
                    y + height,
                    z + (level.random.nextDouble() - 0.5D) * width,
                    (level.random.nextDouble() - 0.5D) * motion,
                    (level.random.nextDouble() - 0.5D) * motion,
                    (level.random.nextDouble() - 0.5D) * motion);
        }
    }
}
