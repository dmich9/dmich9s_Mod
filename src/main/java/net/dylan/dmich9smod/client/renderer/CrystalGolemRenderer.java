package net.dylan.dmich9smod.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dylan.dmich9smod.client.CorruptedZombieModel;
import net.dylan.dmich9smod.client.CrystalGolemModel;
import net.dylan.dmich9smod.common.entity.CorruptedZombieEntity;
import net.dylan.dmich9smod.common.entity.CrystalGolemEntity;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CrystalGolemRenderer extends GeoEntityRenderer<CrystalGolemEntity> {
    public CrystalGolemRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrystalGolemModel());
        this.shadowRadius = 0.3f;
    }
    @Override
    public ResourceLocation getTextureLocation(CrystalGolemEntity instace) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "textures/entity/crystal_golem/crystal_golem.png");
    }
    @Override
    public RenderType getRenderType(CrystalGolemEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
