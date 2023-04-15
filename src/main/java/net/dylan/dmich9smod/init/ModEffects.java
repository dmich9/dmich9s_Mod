package net.dylan.dmich9smod.init;

import net.dylan.dmich9smod.common.effect.FuryEffect;
import net.dylan.dmich9smod.common.effect.ProsperityEffect;
import net.dylan.dmich9smod.common.effect.StrandedEffect;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, dmich9sMod.MOD_ID);

    public static final RegistryObject<MobEffect> STRANDED = MOB_EFFECTS.register("stranded",
            () -> new StrandedEffect(MobEffectCategory.HARMFUL, 11870719));
    public static final RegistryObject<MobEffect> PROSPERITY = MOB_EFFECTS.register("prosperity",
            () -> new ProsperityEffect(MobEffectCategory.BENEFICIAL, 16764160));
    public static final RegistryObject<MobEffect> FURY = MOB_EFFECTS.register("fury",
            () -> new FuryEffect(MobEffectCategory.NEUTRAL, 9504512));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
