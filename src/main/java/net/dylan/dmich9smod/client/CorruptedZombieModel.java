package net.dylan.dmich9smod.client;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.dylan.dmich9smod.common.entity.CorruptedZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CorruptedZombieModel extends AnimatedGeoModel<CorruptedZombieEntity> {
    @Override
    public ResourceLocation getModelLocation(CorruptedZombieEntity object) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "geo/corrupted_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CorruptedZombieEntity object) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "textures/entity/corrupted_zombie/corrupted_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CorruptedZombieEntity animatable) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "animations/corrupted_zombie.animation.idle.json");
    }
}
