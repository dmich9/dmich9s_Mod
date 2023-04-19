package net.dylan.dmich9smod.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.dedicated.Settings;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class TransformKeyItem extends Item {
    private final Block targetBlock;
    private final Block resultBlock;

    public TransformKeyItem(Properties properties, Block targetBlock, Block resultBlock) {
        super(properties);
        this.targetBlock = targetBlock;
        this.resultBlock = resultBlock;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        if (!player.isCreative()) {
            stack.shrink(1);
        }

        if (state.getBlock() == targetBlock) {
            world.setBlock(pos, resultBlock.defaultBlockState(), Block.UPDATE_NONE);
            world.playSound(player, pos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
