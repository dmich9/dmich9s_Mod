package net.dylan.dmich9smod.init;

import net.dylan.dmich9smod.client.particle.EndTorchParticles;
import net.dylan.dmich9smod.common.entity.*;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = dmich9sMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                   event) {
        event.getRegistry().registerAll(

        );
    }
    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.END_TORCH_PARTICLES.get(), EndTorchParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NETHER_TORCH_PARTICLES.get(), EndTorchParticles.Provider::new);

    }
    @SubscribeEvent
    public static void entityAtributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.CORRUPTED_ZOMBIE.get(), CorruptedZombie.setAttributes());
        event.put(ModEntityTypes.THUNDERBIRD.get(), Thunderbird.setAttributes());
        event.put(ModEntityTypes.FRACTURED_WANDERER.get(), FracturedWanderer.setAttributes());
        event.put(ModEntityTypes.SAND_ELEMENTAL.get(), SandElemental.setAttributes());
        event.put(ModEntityTypes.CRYSTAL_GOLEM.get(), CrystalGolem.setAttributes());
        registerSpawnPlacements();
    }

    public static void registerSpawnPlacements() {
        SpawnPlacements.register(ModEntityTypes.CORRUPTED_ZOMBIE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CorruptedZombie::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntityTypes.THUNDERBIRD.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Thunderbird::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntityTypes.FRACTURED_WANDERER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, FracturedWanderer::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntityTypes.SAND_ELEMENTAL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SandElemental::canSandElementalSpawn);
        SpawnPlacements.register(ModEntityTypes.CRYSTAL_GOLEM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrystalGolem::canCrystalGolemSpawn);
    }

}
