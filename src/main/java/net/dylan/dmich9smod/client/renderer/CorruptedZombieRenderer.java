package net.dylan.dmich9smod.client.renderer;
import net.dylan.dmich9smod.core.dmich9sMod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dylan.dmich9smod.client.CorruptedZombieModel;
import net.dylan.dmich9smod.common.entity.CorruptedZombieEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CorruptedZombieRenderer extends GeoEntityRenderer<CorruptedZombieEntity> {
    public CorruptedZombieRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CorruptedZombieModel());
        this.shadowRadius = 0.3f;
    }
    @Override
    public ResourceLocation getTextureLocation(CorruptedZombieEntity instace) {
        return new ResourceLocation(dmich9sMod.MOD_ID, "textures/entity/corrupted_zombie/corrupted_zombie.png");
    }
    @Override
    public RenderType getRenderType(CorruptedZombieEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
