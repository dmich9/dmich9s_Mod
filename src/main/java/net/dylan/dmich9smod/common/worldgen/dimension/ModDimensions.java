package net.dylan.dmich9smod.common.worldgen.dimension;

import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<Level> FRACTURED_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(dmich9sMod.MOD_ID, "fractured_reality"));
    public static final ResourceKey<DimensionType> FRACTURED_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, FRACTURED_KEY.getRegistryName());

    public static void register()
    {
        System.out.println("Registering ModDimensions for: " + dmich9sMod.MOD_ID);
    }
}
