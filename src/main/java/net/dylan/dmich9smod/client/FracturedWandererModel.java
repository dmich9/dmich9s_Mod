/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.client;

import net.dylan.dmich9smod.common.entity.FracturedWanderer;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FracturedWandererModel extends AnimatedGeoModel<FracturedWanderer> {

    public static final ResourceLocation MODEL_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "geo/entity/fractured_wanderer.geo.json");
    public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "textures/entity/fractured_wanderer/fractured_wanderer.png");
    public static final ResourceLocation ANIMATION_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "animations/entity/fractured_wanderer.animation.json");

    public FracturedWandererModel() {
        super();
    }

    @Override
    public ResourceLocation getModelLocation(FracturedWanderer object) {
        return MODEL_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(FracturedWanderer object) {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(FracturedWanderer animatable) {
        return ANIMATION_LOCATION;
    }
}
