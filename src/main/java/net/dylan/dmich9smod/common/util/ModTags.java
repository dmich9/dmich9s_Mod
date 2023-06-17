package net.dylan.dmich9smod.common.util;

import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> PORTAL_FRAME_BLOCKS = ForgeRegistries.BLOCKS.tags().createTagKey(new ResourceLocation(dmich9sMod.MOD_ID, "portal_frame_blocks"));
    }

    public static class Items {
        public static final TagKey<Item> AMBROSIA_GEMS = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("forge", "gems/ambrosia"));
    }
}