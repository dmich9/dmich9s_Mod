package net.dylan.dmich9smod.common.item;

import net.dylan.dmich9smod.common.util.ModCreativeModeTab;
import net.dylan.dmich9smod.init.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;

public class DreamersMightItem extends CustomEffectItem{
    public DreamersMightItem() {
        super(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB));
        this.setEffectInstance(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 1));
    }
}
