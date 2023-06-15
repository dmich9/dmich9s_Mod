/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.client;

import net.dylan.dmich9smod.common.entity.Thunderbird;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ThunderbirdModel extends AnimatedGeoModel<Thunderbird> {

    public static final ResourceLocation MODEL_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "geo/entity/thunderbird.geo.json");
    public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "textures/entity/thunderbird/thunderbird.png");
    public static final ResourceLocation ANIMATION_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "animations/entity/thunderbird.animation.json");

    public ThunderbirdModel() {
        super();
    }

    @Override
    public ResourceLocation getModelLocation(Thunderbird object) {
        return MODEL_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(Thunderbird object) {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Thunderbird animatable) {
        return ANIMATION_LOCATION;
    }
}
