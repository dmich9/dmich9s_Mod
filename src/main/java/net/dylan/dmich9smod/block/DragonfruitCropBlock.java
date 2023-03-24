package net.dylan.dmich9smod.block;

import net.dylan.dmich9smod.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class DragonfruitCropBlock extends CropBlock {
    public DragonfruitCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.DRAGONFRUIT_SEEDS.get();
    }
}
