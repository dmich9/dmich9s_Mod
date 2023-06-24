package net.dylan.dmich9smod.common.worldgen.biomes;

import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class BiomesData {
    public static final ResourceKey<Biome> DREAMSCAPE = createKey("dreamscape");
    public static final ResourceKey<Biome> MAPLE_FOREST = createKey("maple_forest");
    public static final ResourceKey<Biome> FRACTURED_FOREST = createKey("fractured_forest");
    public static final ResourceKey<Biome> END_SPRINGS = createKey("end_springs");
    public static final ResourceKey<Biome> ASTEROID_FIELD = createKey("asteroid_field");

    /**
     * Creates a reference to a biome that is registered elsewhere (in JSON)
     * @param name the biome name
     * @return a resource key for the given biome with the mod namespace
     */
    private static ResourceKey<Biome> createKey(String name)
    {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(dmich9sMod.MOD_ID, name));
    }
}