package net.dylan.dmich9smod.init;

import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, dmich9sMod.MOD_ID);

    public static final RegistryObject<Potion> STRANDED_POTION = POTIONS.register("stranded_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.STRANDED.get(),200,0)));
    public static final RegistryObject<Potion> PROSPERITY_POTION = POTIONS.register("prosperity_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.PROSPERITY.get(),200,0)));
    public static final RegistryObject<Potion> FURY_POTION = POTIONS.register("fury_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FURY.get(),200,0)));

    public static void register(IEventBus eventBus){
        POTIONS.register(eventBus);
    }
}
