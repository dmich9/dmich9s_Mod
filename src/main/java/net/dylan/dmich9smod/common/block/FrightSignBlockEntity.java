package net.dylan.dmich9smod.common.block;

import net.dylan.dmich9smod.api.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FrightSignBlockEntity extends SignBlockEntity {
    public FrightSignBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(pWorldPosition, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.FRIGHT_SIGN_BLOCK_ENTITY.get();
    }

}