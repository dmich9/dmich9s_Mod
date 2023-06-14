package net.dylan.dmich9smod.client.renderer;

import net.dylan.dmich9smod.core.dmich9sMod;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ISkyRenderHandler;

public class DreamscapeDimensionSkybox extends DimensionSpecialEffects {
    public static final ResourceLocation ID = new ResourceLocation(dmich9sMod.MOD_ID, "dreamscape");

    public DreamscapeDimensionSkybox(float pCloudLevel, boolean pHasGround, SkyType pSkyType, boolean pForceBrightLightmap, boolean pConstantAmbientLight) {
        super(pCloudLevel, pHasGround, pSkyType, pForceBrightLightmap, pConstantAmbientLight);
        setSkyRenderHandler(new DreamscapeSkyRenderer());
    }

    @Override
    public Vec3 getBrightnessDependentFogColor(Vec3 pFogColor, float pBrightness) {
        return null;
    }

    @Override
    public boolean isFoggyAt(int pX, int pY) {
        return false;
    }
    public static class DreamscapeSkyRenderer implements ISkyRenderHandler {
        private static final ResourceLocation TEXTURE = new ResourceLocation(dmich9sMod.MOD_ID, "textures/environment/fractured_skybox.png");
        @Override
        public void render(int ticks, float partialTick, PoseStack poseStack, ClientLevel level, Minecraft minecraft) {

        }
    }
}