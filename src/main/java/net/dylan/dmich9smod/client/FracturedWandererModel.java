package net.dylan.dmich9smod.client;

import net.dylan.dmich9smod.common.entity.CorruptedZombieEntity;
import net.dylan.dmich9smod.common.entity.FracturedWandererEntity;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FracturedWandererModel extends AnimatedGeoModel<FracturedWandererEntity> {
    @Override
    public ResourceLocation getModelLocation(FracturedWandererEntity object) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "geo/fractured_wanderer.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(FracturedWandererEntity object) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "textures/entity/fractured_wanderer/fractured_wanderer.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(FracturedWandererEntity animatable) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "animations/fractured_wanderer.animation.idle.json");
    }
}
