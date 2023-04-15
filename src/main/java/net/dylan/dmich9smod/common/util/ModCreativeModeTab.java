package net.dylan.dmich9smod.common.util;

import net.dylan.dmich9smod.init.ModBlocksAndItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab COURSE_TAB = new CreativeModeTab("coursemodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocksAndItems.AZURITE.get());
        }
    };
}
