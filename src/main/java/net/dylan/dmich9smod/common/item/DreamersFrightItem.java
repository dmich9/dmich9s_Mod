package net.dylan.dmich9smod.common.item;

import net.dylan.dmich9smod.common.util.ModCreativeModeTab;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;

public class DreamersFrightItem extends CustomEffectItem {
    public DreamersFrightItem() {
        super(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB));
        this.setEffectInstance(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 1));
    }
}
