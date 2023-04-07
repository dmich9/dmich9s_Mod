package net.dylan.dmich9smod.item;

import net.dylan.dmich9smod.block.ModBlocksAndItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier AZURITE = new ForgeTier(3,2000,2,
            4,15, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModBlocksAndItems.AZURITE.get()));
    public static final ForgeTier CARNELIAN = new ForgeTier(3,2000,2,
            4,15, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModBlocksAndItems.CARNELIAN.get()));
    public static final ForgeTier GARNET = new ForgeTier(3,2000,2,
            4,15, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModBlocksAndItems.GARNET.get()));
    public static final ForgeTier SERENDIBITE = new ForgeTier(3,2000,2,
            4,15, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModBlocksAndItems.SERENDIBITE.get()));
    public static final ForgeTier STRONTIUM = new ForgeTier(3,2000,2,
            4,15, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModBlocksAndItems.STRONTIUM_INGOT.get()));
    public static final ForgeTier AMBROSIA = new ForgeTier(3,2000,2,
            4,15, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModBlocksAndItems.AMBROSIA.get()));
}