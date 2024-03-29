package net.dylan.dmich9smod.common.block;

import net.dylan.dmich9smod.init.ModBlocksAndItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;

public class DurianCropBlock extends BeetrootBlock {
    public DurianCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {return ModBlocksAndItems.DURIAN_SEEDS.get();
    }
}