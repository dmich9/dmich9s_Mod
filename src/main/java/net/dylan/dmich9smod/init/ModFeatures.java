package net.dylan.dmich9smod.init;

import net.dylan.dmich9smod.common.worldgen.features.TemplatePoolFeature;
import net.dylan.dmich9smod.common.worldgen.features.configuration.WeightedTemplateFeatureConfiguration;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, dmich9sMod.MOD_ID);

    public static RegistryObject<TemplatePoolFeature> TEMPLATE_POOL_FEATURE = FEATURES.register("template_pool", () ->
            new TemplatePoolFeature(WeightedTemplateFeatureConfiguration.CODEC));

    public static void register (IEventBus eventBus) {
        FEATURES.register(eventBus);
    }


}
