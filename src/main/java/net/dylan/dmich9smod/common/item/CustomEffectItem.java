package net.dylan.dmich9smod.common.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CustomEffectItem extends Item {
    // this class is a simple class that can be extended to make any custom item give an effect to the player while hold in the inventory
    private MobEffectInstance effectInstance;

    public CustomEffectItem(Properties properties) {
        super(properties);

    }

    // Override this method to apply the effect when the item is in the player's inventory
    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity entity, int pSlotId, boolean pIsSelected) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            player.addEffect(this.effectInstance);
        }
    }

    public void setEffectInstance(MobEffectInstance mobEffectInstance)
    {
        this.effectInstance = mobEffectInstance;
    }
    public MobEffectInstance getEffectInstance()
    {
        return this.effectInstance;
    }
}
