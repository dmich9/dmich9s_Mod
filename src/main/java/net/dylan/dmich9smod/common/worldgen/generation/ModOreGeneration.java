package net.dylan.dmich9smod.common.worldgen.generation;
import net.dylan.dmich9smod.common.worldgen.ModOrePlacement;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(ModOrePlacement.ORE_CARNELIAN);
        base.add(ModOrePlacement.ORE_STRONTIUM);
        base.add(ModOrePlacement.ORE_GARNET);
        base.add(ModOrePlacement.ORE_AZURITE);
        base.add(ModOrePlacement.ORE_SERENDIBITE);
        base.add(ModOrePlacement.ORE_AMBROSIA);
    }
}