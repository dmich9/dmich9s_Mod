package net.dylan.dmich9smod.init;

import net.dylan.dmich9smod.common.worldgen.features.TemplatePoolFeature;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, dmich9sMod.MOD_ID);
    public static final RegistryObject<Feature<AsteroidConfig>> ASTEROID =
            FEATURES.register("asteroid", () -> new AsteroidFeature(AsteroidConfig.CODEC));
    public static final RegistryObject<Feature<TemplatePoolConfig>> TEMPLATE_POOL =
            FEATURES.register("template_pool", () -> new TemplatePoolFeature(TemplatePoolConfig.CODEC));
    public static void register (IEventBus eventBus) {
        FEATURES.register(eventBus);
    }


}
