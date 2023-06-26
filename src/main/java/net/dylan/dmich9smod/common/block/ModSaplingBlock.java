package net.dylan.dmich9smod.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.PlantType;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class ModSaplingBlock extends SaplingBlock {

    private final TagKey<Block> placeableOn;

    //Makes the Anguish/Fright/Might/Dream/Fractured saplings only placeable on their respective blocks
    //Fractured is only placeable on End Stone and Overgrown End stone, the other 4 are placeable on Dreamscape Grass/Dirt
    public ModSaplingBlock(AbstractTreeGrower pTreeGrower, Properties pProperties, TagKey<Block> canPlaceOn) {
        super(pTreeGrower, pProperties);
        this.placeableOn = canPlaceOn;
    }

    @Override
    public PlantType getPlantType(BlockGetter level, BlockPos pos) {
        return PlantType.get("fractured_reality_plants");
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(placeableOn);
    }
}
