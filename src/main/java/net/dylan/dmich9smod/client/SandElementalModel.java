/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.client;

import net.dylan.dmich9smod.common.entity.SandElemental;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SandElementalModel extends AnimatedGeoModel<SandElemental> {

    public static final ResourceLocation MODEL_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "geo/entity/sand_elemental.geo.json");
    public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "textures/entity/sand_elemental/sand_elemental.png");
    public static final ResourceLocation ANIMATION_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "animations/entity/sand_elemental.animation.json");

    public SandElementalModel() {
        super();
    }

    @Override
    public ResourceLocation getModelLocation(SandElemental object) {
        return MODEL_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(SandElemental object) {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SandElemental animatable) {
        return ANIMATION_LOCATION;
    }
}
