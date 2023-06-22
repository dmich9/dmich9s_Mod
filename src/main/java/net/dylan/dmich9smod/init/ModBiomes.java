package net.dylan.dmich9smod.init;

import net.dylan.dmich9smod.common.worldgen.biomes.BiomesData;
import net.dylan.dmich9smod.common.worldgen.biomes.OverworldBiomes;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomes {

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event)
    {
        IForgeRegistry<Biome> registry = event.getRegistry();
        registry.register(OverworldBiomes.fracturedForest().setRegistryName(BiomesData.FRACTURED_FOREST.location()));
        registry.register(OverworldBiomes.endSprings().setRegistryName(BiomesData.END_SPRINGS.location()));
    }
}