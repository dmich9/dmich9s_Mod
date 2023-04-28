package net.dylan.dmich9smod.common.worldgen.features;

import net.dylan.dmich9smod.init.ModBlocksAndItems;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.antlr.runtime.tree.Tree;

import java.util.List;

public class ModConfiguredFeature {

    /**
     * This code makes "features" or things to use for the generation of the biome;
     * Everything what a biome has (outside of structures) is made here and the code can be replicated;
     * Always test out the numbers to be comfortable with how many and in what way they get spawned
     */


    // FLOWERS -> the flowers have another way of spawning than the (tall) grass, you can replicate the code and just change blocks for other flowers or change numbers for other probabilities;
    // DREAMSCAPE
    // DREAM FERN
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> DREAMSCAPE_FERN =
            FeatureUtils.register("dreamscape_fern", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocksAndItems.DREAMSCAPE_FERN.get())))));
    // BUCKWEED
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> DREAMSCAPE_BUCKWEED =
            FeatureUtils.register("dreamscape_buckweed", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocksAndItems.DREAMSCAPE_BUCKWEED.get())))));
    // TORNBELL
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> DREAMSCAPE_TORNBELL =
            FeatureUtils.register("dreamscape_tornbell", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocksAndItems.DREAMSCAPE_TORNBELL.get())))));
    //OXALLIS
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> DREAMSCAPE_OXALLIS =
            FeatureUtils.register("dreamscape_oxallis", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocksAndItems.DREAMSCAPE_OXALLIS.get())))));


    // FRACTURED FOREST
    // FERN
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> END_FERN =
            FeatureUtils.register("end_fern", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocksAndItems.END_FERN.get())))));
    // RAGWEED
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> END_RAGWEED =
            FeatureUtils.register("end_ragweed", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocksAndItems.END_RAGWEED.get())))));
    // LILY
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> END_LILY =
            FeatureUtils.register("end_lily", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocksAndItems.ENDER_LILY.get())))));
    // DELIGHT
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> END_DELIGHT =
            FeatureUtils.register("end_delight", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocksAndItems.ENDERS_DELIGHT.get())))));
    // DEATHTOLL
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> END_DEATHTOLL =
            FeatureUtils.register("end_deathtoll", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocksAndItems.END_DEATHTOLL.get())))));
    // NIGHTSHADE
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> END_NIGHTSHADE =
            FeatureUtils.register("end_nightshade", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocksAndItems.END_NIGHTSHADE.get())))));


    // this code is pretty much copied and pasted from vanilla to generate patches of grass
    private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int pTries) {
        return FeatureUtils.simpleRandomPatchConfiguration(pTries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
    }
    // DREAMSCAPE
    // DREAM GRASS
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GRASS_DREAM =
            FeatureUtils.register("patch_grass_dream", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ModBlocksAndItems.DREAMSCAPE_GRASS.get()), 32));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_TALLGRASS_DREAM =
            FeatureUtils.register("patch_tallgrass_dream", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ModBlocksAndItems.DREAMSCAPE_TALL_GRASS.get()), 32));

    // END GRASS
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GRASS_END =
            FeatureUtils.register("patch_grass_end", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ModBlocksAndItems.END_GRASS.get()), 32));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_TALLGRASS_END =
            FeatureUtils.register("patch_tallgrass_end", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ModBlocksAndItems.END_TALL_GRASS.get()), 32));

    /**
     * There is some code added for the trees outside of the tree code
     * Mostly like the flower, code needed for the trees to generate, this is code specifically made to generate the trees;
     * As always, you can modify the numbers to make the trees look more customisable;
     */

    // FULL ANGUISH TREE
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> ANGUISH_TREE =
            FeatureUtils.register("anguish", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.ANGUISH_LOG.get()),
                    new ForkingTrunkPlacer(6, 2, 4),
                    BlockStateProvider.simple(ModBlocksAndItems.ANGUISH_LEAVES.get()),
                    new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<PlacedFeature> ANGUISH_CHECKED = PlacementUtils.register("anguish", ANGUISH_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocksAndItems.ANGUISH_SAPLING.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ANGUISH_SPAWN =
            FeatureUtils.register("anguish_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(ANGUISH_CHECKED, 0.5F)), ANGUISH_CHECKED));

    // FULL FRIGHT TREE
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FRIGHT_TREE =
            FeatureUtils.register("fright", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.FRIGHT_LOG.get()),
                    new ForkingTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocksAndItems.FRIGHT_LEAVES.get()),
                    new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<PlacedFeature> FRIGHT_CHECKED = PlacementUtils.register("fright", FRIGHT_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocksAndItems.FRIGHT_LEAVES.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> FRIGHT_SPAWN =
            FeatureUtils.register("fright_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(FRIGHT_CHECKED, 0.5F)), FRIGHT_CHECKED));

    // FULL MIGHT TREE
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> MIGHT_TREE =
            FeatureUtils.register("might", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.MIGHT_LOG.get()),
                    new ForkingTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocksAndItems.MIGHT_LEAVES.get()),
                    new FancyFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), 8),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<PlacedFeature> MIGHT_CHECKED = PlacementUtils.register("might", MIGHT_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocksAndItems.MIGHT_LEAVES.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MIGHT_SPAWN =
            FeatureUtils.register("might_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(MIGHT_CHECKED, 0.5F)), MIGHT_CHECKED));

    // FULL DREAM TREE
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DREAM_TREE =
            FeatureUtils.register("dream", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.DREAM_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocksAndItems.DREAM_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<PlacedFeature> DREAM_CHECKED = PlacementUtils.register("dream", DREAM_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocksAndItems.DREAM_SAPLING.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> DREAM_SPAWN =
            FeatureUtils.register("dream_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(DREAM_CHECKED, 0.5F)), DREAM_CHECKED));

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FRACTURED_TREE =
            FeatureUtils.register("fractured", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.FRACTURED_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocksAndItems.FRACTURED_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<PlacedFeature> FRACTURED_CHECKED = PlacementUtils.register("fractured", FRACTURED_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocksAndItems.FRACTURED_SAPLING.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> FRACTURED_SPAWN =
            FeatureUtils.register("fractured_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(FRACTURED_CHECKED, 0.5F)), FRACTURED_CHECKED));

    // MAPLE TREES
    // YELLOW
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> YELLOW_MAPLE_TREE =
            FeatureUtils.register("yellow_maple", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.MAPLE_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocksAndItems.MAPLE_LEAVES_YELLOW.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<PlacedFeature> YELLOW_CHECKED = PlacementUtils.register("yellow", YELLOW_MAPLE_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocksAndItems.MAPLE_SAPLING_YELLOW.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> YELLOW_SPAWN =
            FeatureUtils.register("yellow_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(YELLOW_CHECKED, 0.5F)), YELLOW_CHECKED));
    //ORANGE
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> ORANGE_MAPLE_TREE =
            FeatureUtils.register("orange_maple", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.MAPLE_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocksAndItems.MAPLE_LEAVES_ORANGE.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<PlacedFeature> ORANGE_CHECKED = PlacementUtils.register("orange", ORANGE_MAPLE_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocksAndItems.MAPLE_SAPLING_ORANGE.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ORANGE_SPAWN =
            FeatureUtils.register("orange_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(ORANGE_CHECKED, 0.5F)), ORANGE_CHECKED));

    // RED
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> RED_MAPLE_TREE =
            FeatureUtils.register("red_maple", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.MAPLE_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocksAndItems.MAPLE_LEAVES_RED.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<PlacedFeature> RED_CHECKED = PlacementUtils.register("red", RED_MAPLE_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocksAndItems.MAPLE_SAPLING_RED.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> RED_SPAWN =
            FeatureUtils.register("red_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(RED_CHECKED, 0.5F)), RED_CHECKED));

}