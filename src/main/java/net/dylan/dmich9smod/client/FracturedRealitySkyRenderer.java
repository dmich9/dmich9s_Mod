package net.dylan.dmich9smod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.ISkyRenderHandler;

public class FracturedRealitySkyRenderer implements ISkyRenderHandler {
    private static final float MIN_UV = 0.001f;
    private static final float MAX_UV = 0.999f;
    private static final ResourceLocation[] FACES = new ResourceLocation[6];
    static {
        for (int i = 0; i < 6; i++)
            FACES[i] = new ResourceLocation("dmich9smod", "textures/environment/fractured_reality_" + i + ".png");
    }

    @Override
    public void render(int ticks, float partialTick, PoseStack poseStack, ClientLevel level, Minecraft mc) {
        RenderSystem.disableBlend();
        RenderSystem.depthMask(false);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);

        Tesselator tess = Tesselator.getInstance();
        BufferBuilder buf = tess.getBuilder();

        for (int i = 0; i < 6; i++) {
            poseStack.pushPose();
            switch (i) {
                case 1 -> poseStack.mulPose(Vector3f.XP.rotationDegrees(-90f));
                case 2 -> poseStack.mulPose(Vector3f.XP.rotationDegrees(90f));
                case 3 -> poseStack.mulPose(Vector3f.XP.rotationDegrees(180f));
                case 4 -> poseStack.mulPose(Vector3f.ZP.rotationDegrees(-90f));
                case 5 -> poseStack.mulPose(Vector3f.ZP.rotationDegrees(90f));
            }
            Matrix4f m = poseStack.last().pose();
            RenderSystem.setShaderTexture(0, FACES[i]);
            buf.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
            buf.vertex(m, -100f, -100f, -100f).uv(MIN_UV, MIN_UV).endVertex();
            buf.vertex(m, -100f, -100f,  100f).uv(MIN_UV, MAX_UV).endVertex();
            buf.vertex(m,  100f, -100f,  100f).uv(MAX_UV, MAX_UV).endVertex();
            buf.vertex(m,  100f, -100f, -100f).uv(MAX_UV, MIN_UV).endVertex();
            tess.end();
            poseStack.popPose();
        }

        RenderSystem.depthMask(true);
    }
}