package net.dylan.dmich9smod.common.block;

import net.dylan.dmich9smod.api.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FracturedSignBlockEntity extends SignBlockEntity {
    public FracturedSignBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(pWorldPosition, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.FRACTURED_SIGN_BLOCK_ENTITY.get();
    }

}