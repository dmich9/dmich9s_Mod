package net.dylan.dmich9smod.block;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;

public class StarfruitCropBlock extends BeetrootBlock {
    public StarfruitCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {return ModBlocksAndItems.STARFRUIT_CROP.get();
    }
}