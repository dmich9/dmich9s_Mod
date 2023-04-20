package net.dylan.dmich9smod.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier CARNELIAN = new ForgeTier(1,180,5.0F,
            4,7, BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(ModBlocksAndItems.CARNELIAN.get()));
    public static final ForgeTier STRONTIUM = new ForgeTier(2,325,6.0F,
            4,15, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModBlocksAndItems.STRONTIUM_INGOT.get()));
    public static final ForgeTier GARNET = new ForgeTier(2,750,7.5F,
            4,10, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModBlocksAndItems.GARNET.get()));
    public static final ForgeTier AZURITE = new ForgeTier(3,1750,9.0F,
            4,12, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModBlocksAndItems.AZURITE.get()));
    public static final ForgeTier SERENDIBITE = new ForgeTier(4,2500,10.0F,
            4,15, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModBlocksAndItems.SERENDIBITE.get()));
    public static final ForgeTier AMBROSIA = new ForgeTier(5,3000,12.0F,
            4,20, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModBlocksAndItems.AMBROSIA.get()));
}