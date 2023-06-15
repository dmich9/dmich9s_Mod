/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.client;

import net.dylan.dmich9smod.common.entity.CrystalGolem;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CrystalGolemModel extends AnimatedGeoModel<CrystalGolem> {

    public static final ResourceLocation MODEL_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "geo/entity/crystal_golem.geo.json");
    public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "textures/entity/crystal_golem/crystal_golem.png");
    public static final ResourceLocation ANIMATION_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "animations/entity/crystal_golem.animation.json");

    public CrystalGolemModel() {
        super();
    }

    @Override
    public ResourceLocation getModelLocation(CrystalGolem object) {
        return MODEL_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalGolem object) {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CrystalGolem animatable) {
        return ANIMATION_LOCATION;
    }
}
