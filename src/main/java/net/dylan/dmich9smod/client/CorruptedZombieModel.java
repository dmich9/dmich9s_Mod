/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.client;

import net.dylan.dmich9smod.common.entity.CorruptedZombie;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CorruptedZombieModel extends AnimatedGeoModel<CorruptedZombie> {

    public static final ResourceLocation MODEL_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "geo/entity/corrupted_zombie.geo.json");
    public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "textures/entity/corrupted_zombie/corrupted_zombie.png");
    public static final ResourceLocation ANIMATION_LOCATION = new ResourceLocation(dmich9sMod.MOD_ID, "animations/entity/corrupted_zombie.animation.json");

    public CorruptedZombieModel() {
        super();
    }

    @Override
    public ResourceLocation getModelLocation(CorruptedZombie object) {
        return MODEL_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(CorruptedZombie object) {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CorruptedZombie animatable) {
        return ANIMATION_LOCATION;
    }
}
