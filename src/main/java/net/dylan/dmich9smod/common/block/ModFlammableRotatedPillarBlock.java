package net.dylan.dmich9smod.common.block;
import net.dylan.dmich9smod.init.ModBlocksAndItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public ModFlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(ToolActions.AXE_STRIP.equals(toolAction)) {
            if(state.is(ModBlocksAndItems.ANGUISH_LOG.get())) {
                return ModBlocksAndItems.STRIPPED_ANGUISH_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocksAndItems.ANGUISH_WOOD.get())) {
                return ModBlocksAndItems.STRIPPED_ANGUISH_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocksAndItems.MIGHT_LOG.get())) {
                return ModBlocksAndItems.STRIPPED_MIGHT_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocksAndItems.MIGHT_WOOD.get())) {
                return ModBlocksAndItems.STRIPPED_MIGHT_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocksAndItems.FRIGHT_LOG.get())) {
                return ModBlocksAndItems.STRIPPED_FRIGHT_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocksAndItems.FRIGHT_WOOD.get())) {
                return ModBlocksAndItems.STRIPPED_FRIGHT_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocksAndItems.DREAM_LOG.get())) {
                return ModBlocksAndItems.STRIPPED_DREAM_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocksAndItems.DREAM_WOOD.get())) {
                return ModBlocksAndItems.STRIPPED_DREAM_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocksAndItems.FRACTURED_LOG.get())) {
                return ModBlocksAndItems.STRIPPED_FRACTURED_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocksAndItems.FRIGHT_WOOD.get())) {
                return ModBlocksAndItems.STRIPPED_FRACTURED_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocksAndItems.MAPLE_LOG.get())) {
                return ModBlocksAndItems.STRIPPED_MAPLE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocksAndItems.MAPLE_WOOD.get())) {
                return ModBlocksAndItems.STRIPPED_MAPLE_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}