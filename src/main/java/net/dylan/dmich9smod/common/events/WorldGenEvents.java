package net.dylan.dmich9smod.common.events;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = "dmich9smod", bus = Mod.EventBusSubscriber.Bus.MOD)
public class WorldGenEvents {
    /*
    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        ResourceLocation resourceLocation = new ResourceLocation("dmich9smod:worldgen/biome/dreamscape");
        System.out.println("RESOURCE LOCATION IS HERE: " + resourceLocation);
        Biome biome = ForgeRegistries.BIOMES.getValue(resourceLocation);
        ForgeRegistries.BIOMES.register(biome.setRegistryName("dmich9smod:dreamscape"));
        if (biome != null) {
            event.getRegistry().register(biome);
        } else {
            throw new IllegalStateException("Failed to find biome: " + resourceLocation);
        }
    }

     */
}
