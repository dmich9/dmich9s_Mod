package net.dylan.dmich9smod.common.worldgen.generation;

import net.dylan.dmich9smod.common.worldgen.features.ModPlacedFeature;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;

public class ModGrassGeneration {
    public static void generateGrass(final BiomeLoadingEvent event)
    // this method actually generates the grass/flowers
    {
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
        if (event.getName().toString().equals("dmich9smod:dreamscape")) // -> this line specifically has to be like this or else it does not recognize it and won't spawn it in the right biome;
        {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);


            base.add(ModPlacedFeature.DREAMGRASS_PLACED);
            base.add(ModPlacedFeature.DREAMGRASS_TALL_PLACED);
            base.add(ModPlacedFeature.DREAMSCAPE_BUCKWEED);
            base.add(ModPlacedFeature.DREAMSCAPE_OXALLIS);
            base.add(ModPlacedFeature.DREAMSCAPE_TORNBELL);
            base.add(ModPlacedFeature.DREAMSCAPE_FERN);

        }
        if (event.getName().toString().equals("dmich9smod:fractured_forest") || event.getName().toString().equals("dmich9smod:end_springs")) // -> this line specifically has to be like this or else it does not recognize it and won't spawn it in the right biome;
        {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);


            base.add(ModPlacedFeature.ENDGRASS_PLACED);
            base.add(ModPlacedFeature.ENDGRASS_TALL_PLACED);
            base.add(ModPlacedFeature.END_FERN);
            base.add(ModPlacedFeature.END_RAGWEED);
            base.add(ModPlacedFeature.END_LILY);
            base.add(ModPlacedFeature.END_DELIGHT);
            base.add(ModPlacedFeature.END_DEATHTOLL);
            base.add(ModPlacedFeature.END_NIGHTSHADE);

        }
    }
}