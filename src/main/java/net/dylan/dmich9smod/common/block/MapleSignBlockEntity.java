package net.dylan.dmich9smod.common.block;

import net.dylan.dmich9smod.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MapleSignBlockEntity extends SignBlockEntity {
    public MapleSignBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(pWorldPosition, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.MAPLE_SIGN_BLOCK_ENTITY.get();
    }

}