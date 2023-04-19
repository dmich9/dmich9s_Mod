package net.dylan.dmich9smod.common.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CustomEffectItem extends Item {
    private final MobEffectInstance effectInstance;

    public CustomEffectItem(Properties properties, MobEffectInstance effectInstance) {
        super(properties);
        this.effectInstance = effectInstance;
    }

    // Override this method to apply the effect when the item is in the player's inventory
    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity entity, int pSlotId, boolean pIsSelected) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            player.addEffect(this.effectInstance);
        }
    }

}
