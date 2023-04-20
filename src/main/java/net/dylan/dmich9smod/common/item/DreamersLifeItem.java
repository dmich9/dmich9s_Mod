package net.dylan.dmich9smod.common.item;

import net.dylan.dmich9smod.common.util.ModCreativeModeTab;
import net.dylan.dmich9smod.init.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DreamersLifeItem extends CustomEffectItem{
    //
    public DreamersLifeItem() {
        super(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB));
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity entity, int pSlotId, boolean pIsSelected) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            player.addEffect(new MobEffectInstance(ModEffects.PROSPERITY.get(), 600, 1));
        }
    }
}
