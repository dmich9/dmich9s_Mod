package net.dylan.dmich9smod.client;

import net.dylan.dmich9smod.common.entity.CorruptedZombieEntity;
import net.dylan.dmich9smod.common.entity.ThunderbirdEntity;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ThunderbirdModel extends AnimatedGeoModel<ThunderbirdEntity> {
    @Override
    public ResourceLocation getModelLocation(ThunderbirdEntity object) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "geo/thunderbird.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ThunderbirdEntity object) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "textures/entity/thunderbird/thunderbird.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ThunderbirdEntity animatable) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "animations/thunderbird.animation.idle.json");
    }
}
