package net.dylan.dmich9smod.client;

import net.dylan.dmich9smod.common.entity.CorruptedZombieEntity;
import net.dylan.dmich9smod.common.entity.CrystalGolemEntity;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CrystalGolemModel extends AnimatedGeoModel<CrystalGolemEntity> {
    @Override
    public ResourceLocation getModelLocation(CrystalGolemEntity object) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "geo/crystal_golem.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalGolemEntity object) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "textures/entity/crystal_golem/crystal_golem.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CrystalGolemEntity animatable) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "animations/crystal_golem.animation.idle.json");
    }
}
