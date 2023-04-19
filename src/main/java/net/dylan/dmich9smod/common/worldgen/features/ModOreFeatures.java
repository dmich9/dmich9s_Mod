package net.dylan.dmich9smod.common.worldgen.features;

import net.dylan.dmich9smod.init.ModBlocksAndItems;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModOreFeatures {
    public static final RuleTest NATURAL_STONE = new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD);
    public static final RuleTest STONE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    public static final RuleTest DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    public static final RuleTest NETHERRACK = new BlockMatchTest(Blocks.NETHERRACK);
    public static final RuleTest NETHER_ORE_REPLACEABLES = new TagMatchTest(BlockTags.BASE_STONE_NETHER);

    public static final List<OreConfiguration.TargetBlockState> ORE_CARNELIAN_TARGET_LIST =
            List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocksAndItems.CARNELIAN_ORE.get().defaultBlockState()),
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocksAndItems.DEEPSLATE_CARNELIAN_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_STRONTIUM_TARGET_LIST =
            List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocksAndItems.STRONTIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocksAndItems.DEEPSLATE_STRONTIUM_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_GARNET_TARGET_LIST =
            List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocksAndItems.GARNET_ORE.get().defaultBlockState()),
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocksAndItems.DEEPSLATE_GARNET_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_AZURITE_TARGET_LIST =
            List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocksAndItems.AZURITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocksAndItems.DEEPSLATE_AZURITE_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_SERENDIBITE_TARGET_LIST =
            List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocksAndItems.SERENDIBITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocksAndItems.DEEPSLATE_SERENDIBITE_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_AMBROSIA_TARGET_LIST =
            List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocksAndItems.AMBROSIA_ORE.get().defaultBlockState()),
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocksAndItems.DEEPSLATE_AMBROSIA_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CARNELIAN_ORE = FeatureUtils.register("carnelian_ore",
            Feature.ORE, new OreConfiguration(ORE_CARNELIAN_TARGET_LIST, 9));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> STRONTIUM_ORE = FeatureUtils.register("strontium_ore",
            Feature.ORE, new OreConfiguration(ORE_STRONTIUM_TARGET_LIST, 9));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> GARNET_ORE = FeatureUtils.register("garnet_ore",
            Feature.ORE, new OreConfiguration(ORE_GARNET_TARGET_LIST, 9));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> AZURITE_ORE = FeatureUtils.register("azurite_ore",
            Feature.ORE, new OreConfiguration(ORE_AZURITE_TARGET_LIST, 9));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SERENDIBITE_ORE = FeatureUtils.register("serendibite_ore",
            Feature.ORE, new OreConfiguration(ORE_SERENDIBITE_TARGET_LIST, 9));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> AMBROSIA_ORE = FeatureUtils.register("ambrosia_ore",
            Feature.ORE, new OreConfiguration(ORE_AMBROSIA_TARGET_LIST, 9));

}
