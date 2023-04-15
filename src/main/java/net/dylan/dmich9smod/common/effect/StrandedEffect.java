package net.dylan.dmich9smod.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class StrandedEffect extends MobEffect {
    public StrandedEffect(MobEffectCategory mobEffectCategory, int p_19452_) {
        super(MobEffectCategory.HARMFUL, 11870719);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
