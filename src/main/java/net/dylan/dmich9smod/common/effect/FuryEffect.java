package net.dylan.dmich9smod.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class FuryEffect extends MobEffect {
    public FuryEffect(MobEffectCategory mobEffectCategory, int p_19452_) {
        super(MobEffectCategory.NEUTRAL, 9504512);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
