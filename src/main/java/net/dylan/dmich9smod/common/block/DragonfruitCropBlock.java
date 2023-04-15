package net.dylan.dmich9smod.common.block;

import net.dylan.dmich9smod.init.ModBlocksAndItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;

public class DragonfruitCropBlock extends BeetrootBlock {
    public DragonfruitCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {return ModBlocksAndItems.DRAGONFRUIT_SEEDS.get();
    }
}