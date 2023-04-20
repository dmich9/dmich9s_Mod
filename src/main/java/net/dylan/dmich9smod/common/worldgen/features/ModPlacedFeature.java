package net.dylan.dmich9smod.common.worldgen.features;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.*;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.worldSurfaceSquaredWithCount;


public class ModPlacedFeature {

    /**
     * ModConfiguredFeatures made the Features but the ModPlacedFeature class (this class) does something with the features and actually places them;
     * How features get placed depend on which feature, the trees, patches of grass and flowers all three have different ways that they get generated;
     * As always, heavily suggest playing with the numbers so you get comfortable biomes that look like you want them to look;
     */

    // TREES
    public static final Holder<PlacedFeature> DREAM_PLACED = PlacementUtils.register("dream_placed",
            ModConfiguredFeature.DREAM_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 5)
            ));
    public static final Holder<PlacedFeature> ANGUISH_PLACED = PlacementUtils.register("anguish_placed",
            ModConfiguredFeature.ANGUISH_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 5)
            ));
    public static final Holder<PlacedFeature> FRIGHT_PLACED = PlacementUtils.register("fright_placed",
            ModConfiguredFeature.FRIGHT_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 5)
            ));
    public static final Holder<PlacedFeature> MIGHT_PLACED = PlacementUtils.register("might_placed",
            ModConfiguredFeature.MIGHT_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 5)
            ));

    public static final Holder<PlacedFeature> YELLOW_PLACED = PlacementUtils.register("yellow_placed",
            ModConfiguredFeature.YELLOW_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 5)
            ));
    public static final Holder<PlacedFeature> RED_PLACED = PlacementUtils.register("red_placed",
            ModConfiguredFeature.RED_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 5)
            ));
    public static final Holder<PlacedFeature> ORANGE_PLACED = PlacementUtils.register("orange_placed",
            ModConfiguredFeature.ORANGE_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 5)
            ));

    // GRASS
    public static final Holder<PlacedFeature> DREAMGRASS_PLACED = PlacementUtils.register("patch_dream_grass",
            ModConfiguredFeature.PATCH_GRASS_DREAM, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> DREAMGRASS_TALL_PLACED = PlacementUtils.register("patch_tall_dream_grass",
            ModConfiguredFeature.PATCH_TALLGRASS_DREAM, worldSurfaceSquaredWithCount(1));

    // FLOWERS
    public static final Holder<PlacedFeature> DREAMSCAPE_FERN = PlacementUtils.register("dreamscape_fern",
            ModConfiguredFeature.DREAMSCAPE_FERN, RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> DREAMSCAPE_BUCKWEED = PlacementUtils.register("dreamscape_buckweed",
            ModConfiguredFeature.DREAMSCAPE_BUCKWEED, RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> DREAMSCAPE_TORNBELL = PlacementUtils.register("dreamscape_tornbell",
            ModConfiguredFeature.DREAMSCAPE_TORNBELL, RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> DREAMSCAPE_OXALLIS = PlacementUtils.register("dreamscape_oxallis",
            ModConfiguredFeature.DREAMSCAPE_OXALLIS, RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

}