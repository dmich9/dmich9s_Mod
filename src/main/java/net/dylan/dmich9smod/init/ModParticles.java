package net.dylan.dmich9smod.init;

import net.dylan.dmich9smod.core.dmich9sMod;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, dmich9sMod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> END_TORCH_PARTICLES =
            PARTICLE_TYPES.register("end_torch_particles", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NETHER_TORCH_PARTICLES =
            PARTICLE_TYPES.register("nether_torch_particles", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}