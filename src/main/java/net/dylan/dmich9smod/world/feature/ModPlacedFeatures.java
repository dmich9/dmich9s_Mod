package net.dylan.dmich9smod.world.feature;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> YELLOW_MAPLE_PLACED = PlacementUtils.register("yellow_maple_placed",
            ModConfiguredFeature.YELLOW_MAPLE_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(2, 0.1f, 1)));
    public static final Holder<PlacedFeature> ORANGE_MAPLE_PLACED = PlacementUtils.register("orange_maple_placed",
            ModConfiguredFeature.ORANGE_MAPLE_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(2, 0.1f, 1)));
    public static final Holder<PlacedFeature> RED_MAPLE_PLACED = PlacementUtils.register("red_maple_placed",
            ModConfiguredFeature.RED_MAPLE_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(2, 0.1f, 1)));

    public static final Holder<PlacedFeature> CARNELIAN_ORE_PLACED = PlacementUtils.register("carnelian_ore_placed",
            ModConfiguredFeature.CARNELIAN_ORE, ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> STRONTIUM_ORE_PLACED = PlacementUtils.register("strontium_ore_placed",
            ModConfiguredFeature.STRONTIUM_ORE, ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> GARNET_ORE_PLACED = PlacementUtils.register("garnet_ore_placed",
            ModConfiguredFeature.GARNET_ORE, ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> AZURITE_ORE_PLACED = PlacementUtils.register("azurite_ore_placed",
            ModConfiguredFeature.AZURITE_ORE, ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> SERENDIBITE_ORE_PLACED = PlacementUtils.register("serendibite_ore_placed",
            ModConfiguredFeature.SERENDIBITE_ORE, ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> AMBROSIA_ORE_PLACED = PlacementUtils.register("ambrosia_ore_placed",
            ModConfiguredFeature.AMBROSIA_ORE, ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
}