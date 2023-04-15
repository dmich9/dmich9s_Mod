package net.dylan.dmich9smod.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ProsperityEffect extends MobEffect {
    public ProsperityEffect(MobEffectCategory mobEffectCategory, int p_19452_) {
        super(MobEffectCategory.BENEFICIAL, 16764160);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
