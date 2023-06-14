package net.dylan.dmich9smod.client;

import net.dylan.dmich9smod.common.entity.CorruptedZombieEntity;
import net.dylan.dmich9smod.common.entity.SandElementalEntity;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SandElementalModel extends AnimatedGeoModel<SandElementalEntity> {
    @Override
    public ResourceLocation getModelLocation(SandElementalEntity object) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "geo/sand_elemental.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SandElementalEntity object) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "textures/entity/sand_elemental/sand_elemental.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SandElementalEntity animatable) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "animations/sand_elemental.animation.idle.json");
    }
}
