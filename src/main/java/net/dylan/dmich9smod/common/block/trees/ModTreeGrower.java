package net.dylan.dmich9smod.common.block.trees;

import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class ModTreeGrower extends AbstractTreeGrower {

    protected final ResourceLocation featureId;

    public ModTreeGrower(final String featureName) {
        this.featureId = new ResourceLocation(dmich9sMod.MOD_ID, featureName);
    }

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random pRandom, boolean pLargeHive) {
        ConfiguredFeature<?, ?> cf = ServerLifecycleHooks.getCurrentServer().registryAccess().registryOrThrow(Registry.CONFIGURED_FEATURE_REGISTRY).get(featureId);
        if (null == cf) {
            throw new IllegalArgumentException("Failed to create holder for unknown configured feature '" + featureId + "'");
        }
        return Holder.direct(cf);
    }
}
