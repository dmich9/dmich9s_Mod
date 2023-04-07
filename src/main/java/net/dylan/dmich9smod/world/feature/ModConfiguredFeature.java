package net.dylan.dmich9smod.world.feature;

import net.dylan.dmich9smod.block.ModBlocksAndItems;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import java.util.List;

public class ModConfiguredFeature {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> ANGUISH_TREE =
            FeatureUtils.register("anguish", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.ANGUISH_LOG.get()),
                    new ForkingTrunkPlacer(6, 2, 4),
                    BlockStateProvider.simple(ModBlocksAndItems.ANGUISH_LEAVES.get()),
                    new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FRIGHT_TREE =
            FeatureUtils.register("fright", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.FRIGHT_LOG.get()),
                    new ForkingTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocksAndItems.FRIGHT_LEAVES.get()),
                    new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> MIGHT_TREE =
            FeatureUtils.register("might", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.MIGHT_LOG.get()),
                    new ForkingTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocksAndItems.MIGHT_LEAVES.get()),
                    new FancyFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), 8),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DREAM_TREE =
            FeatureUtils.register("dream", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.DREAM_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocksAndItems.DREAM_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FRACTURED_TREE =
            FeatureUtils.register("fractured", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.FRACTURED_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocksAndItems.FRACTURED_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> YELLOW_MAPLE_TREE =
            FeatureUtils.register("yellow_maple", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.MAPLE_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocksAndItems.MAPLE_LEAVES_YELLOW.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<PlacedFeature> YELLOW_MAPLE_CHECKED = PlacementUtils.register("yellow_maple_checked", YELLOW_MAPLE_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocksAndItems.MAPLE_SAPLING_YELLOW.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> YELLOW_MAPLE_SPAWN =
            FeatureUtils.register("yellow_maple_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(YELLOW_MAPLE_CHECKED,
                            0.5F)), YELLOW_MAPLE_CHECKED));
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> ORANGE_MAPLE_TREE =
            FeatureUtils.register("orange_maple", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.MAPLE_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocksAndItems.MAPLE_LEAVES_ORANGE.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<PlacedFeature> ORANGE_MAPLE_CHECKED = PlacementUtils.register("orange_maple_checked", ORANGE_MAPLE_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocksAndItems.MAPLE_SAPLING_ORANGE.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ORANGE_MAPLE_SPAWN =
            FeatureUtils.register("orange_maple_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(ORANGE_MAPLE_CHECKED,
                            0.5F)), ORANGE_MAPLE_CHECKED));
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> RED_MAPLE_TREE =
            FeatureUtils.register("red_maple", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocksAndItems.MAPLE_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocksAndItems.MAPLE_LEAVES_RED.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final Holder<PlacedFeature> RED_MAPLE_CHECKED = PlacementUtils.register("red_maple_checked", RED_MAPLE_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocksAndItems.MAPLE_SAPLING_RED.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> RED_MAPLE_SPAWN =
            FeatureUtils.register("red_maple_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(RED_MAPLE_CHECKED,
                            0.5F)), RED_MAPLE_CHECKED));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_CARNELIAN_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocksAndItems.CARNELIAN_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocksAndItems.DEEPSLATE_CARNELIAN_ORE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CARNELIAN_ORE = FeatureUtils.register("carnelian_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_CARNELIAN_ORES, 9));
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_STRONTIUM_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocksAndItems.STRONTIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocksAndItems.DEEPSLATE_STRONTIUM_ORE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> STRONTIUM_ORE = FeatureUtils.register("strontium_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_STRONTIUM_ORES, 9));
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_GARNET_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocksAndItems.GARNET_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocksAndItems.DEEPSLATE_GARNET_ORE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> GARNET_ORE = FeatureUtils.register("garnet_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_GARNET_ORES, 9));
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_AZURITE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocksAndItems.AZURITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocksAndItems.DEEPSLATE_AZURITE_ORE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> AZURITE_ORE = FeatureUtils.register("azurite_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_AZURITE_ORES, 9));
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_SERENDIBITE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocksAndItems.SERENDIBITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocksAndItems.DEEPSLATE_SERENDIBITE_ORE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SERENDIBITE_ORE = FeatureUtils.register("serendibite_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_SERENDIBITE_ORES, 9));
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_AMBROSIA_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocksAndItems.AMBROSIA_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocksAndItems.DEEPSLATE_AMBROSIA_ORE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> AMBROSIA_ORE = FeatureUtils.register("ambrosia_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_AMBROSIA_ORES, 9));
}
