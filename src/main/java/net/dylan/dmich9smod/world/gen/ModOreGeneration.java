package net.dylan.dmich9smod.world.gen;
import net.dylan.dmich9smod.world.feature.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(ModPlacedFeatures.CARNELIAN_ORE_PLACED);
        base.add(ModPlacedFeatures.STRONTIUM_ORE_PLACED);
        base.add(ModPlacedFeatures.GARNET_ORE_PLACED);
        base.add(ModPlacedFeatures.AZURITE_ORE_PLACED);
        base.add(ModPlacedFeatures.SERENDIBITE_ORE_PLACED);
        base.add(ModPlacedFeatures.AMBROSIA_ORE_PLACED);
    }
}