package net.dylan.dmich9smod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier AZURITE = new ForgeTier(3,2000,2,
            4,15, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.AZURITE.get()));
    public static final ForgeTier CARNELIAN = new ForgeTier(3,2000,2,
            4,15, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.CARNELIAN.get()));

    public static final ForgeTier GARNET = new ForgeTier(3,2000,2,
            4,15, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.GARNET.get()));

    public static final ForgeTier SERENDIBITE = new ForgeTier(3,2000,2,
            4,15, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.SERENDIBITE.get()));

    public static final ForgeTier STRONTIUM = new ForgeTier(3,2000,2,
            4,15, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.STRONTIUM_INGOT.get()));

    public static final ForgeTier AMBROSIA = new ForgeTier(3,2000,2,
            4,15, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.AMBROSIA.get()));
}
