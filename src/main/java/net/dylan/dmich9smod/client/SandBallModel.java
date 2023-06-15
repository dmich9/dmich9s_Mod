/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/

package net.dylan.dmich9smod.client;

import net.dylan.dmich9smod.common.entity.SandBall;
import net.dylan.dmich9smod.common.entity.SandElemental;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SandBallModel extends AnimatedGeoModel<SandBall> {

    public static final ResourceLocation MODEL_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "geo/entity/sand_ball.geo.json");
    public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "textures/entity/sand_ball/sand_ball.png");
    public static final ResourceLocation ANIMATION_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "animations/entity/sand_ball.animation.json");

    public SandBallModel() {
        super();
    }

    @Override
    public ResourceLocation getModelLocation(SandBall object) {
        return MODEL_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(SandBall object) {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SandBall animatable) {
        return ANIMATION_LOCATION;
    }
}
