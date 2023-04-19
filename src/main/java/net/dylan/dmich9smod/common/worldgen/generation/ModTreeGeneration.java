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

public class ModTreeGeneration {
    public static void generateTrees(final BiomeLoadingEvent event)
    {
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
        //System.out.println(types);
        //System.out.println(event.getName());
        //System.out.println(BiomesData.DREAMSCAPE.getRegistryName());
        if (event.getName().toString().equals("dmich9smod:dreamscape"))
        {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeature.DREAM_PLACED);
            base.add(ModPlacedFeature.ANGUISH_PLACED);
            base.add(ModPlacedFeature.FRIGHT_PLACED);
            base.add(ModPlacedFeature.MIGHT_PLACED);

        }
        else if (event.getName().toString().equals("dmich9smod:maple_forest"))
        {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeature.ORANGE_PLACED);
            base.add(ModPlacedFeature.RED_PLACED);
            base.add(ModPlacedFeature.YELLOW_PLACED);
        }
    }
}
