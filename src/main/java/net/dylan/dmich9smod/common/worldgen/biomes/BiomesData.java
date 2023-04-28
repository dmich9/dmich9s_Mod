package net.dylan.dmich9smod.common.worldgen.biomes;

import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class BiomesData {
    // this class only registers the custom biomes


    public static final ResourceKey<Biome> DREAMSCAPE = register("dreamscape");
    public static final ResourceKey<Biome> MAPLE_FOREST = register("maple_forest");
    public static final ResourceKey<Biome> FRACTURED_FOREST = register("fractured_forest");
    public static final ResourceKey<Biome> END_SPRINGS = register("end_springs");
    public static final ResourceKey<Biome> ASTEROID_FIELD = register("asteroid_field");
    private static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(dmich9sMod.MOD_ID, name));
    }
}