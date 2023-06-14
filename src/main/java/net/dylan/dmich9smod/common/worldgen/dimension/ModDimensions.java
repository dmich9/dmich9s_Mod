package net.dylan.dmich9smod.common.worldgen.dimension;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.client.ISkyRenderHandler;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = dmich9sMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDimensions {
    public static final ResourceKey<Level> FRACTURED_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(dmich9sMod.MOD_ID, "fractured_reality"));
    public static final ResourceKey<DimensionType> FRACTURED_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, FRACTURED_KEY.getRegistryName());

    private static class FracturedSkyRenderer implements ISkyRenderHandler {
        private static final ResourceLocation TEXTURE = new ResourceLocation(dmich9sMod.MOD_ID, "textures/environment/fractured_skybox.png");

        @Override
        public void render(int ticks, float partialTicks, PoseStack matrixStack, ClientLevel world, Minecraft mc) {
            mc.getTextureManager().bindForSetup(TEXTURE);
        }
    }
    public static void register() {
        System.out.println("Registering ModDimensions for: " + dmich9sMod.MOD_ID);
    }
}