package net.dylan.dmich9smod.common.block.trees;

import net.dylan.dmich9smod.common.worldgen.ModConfiguredFeature;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class DreamTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_204307_, boolean p_204308_) {
        return ModConfiguredFeature.DREAM_TREE;
    }
}