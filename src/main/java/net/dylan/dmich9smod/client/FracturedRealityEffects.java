package net.dylan.dmich9smod.client;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;

public class FracturedRealityEffects extends DimensionSpecialEffects {
    public FracturedRealityEffects() {
        // cloudLevel, hasGround, skyType, forceBrightLightmap, constantAmbientLight
        super(Float.NaN, true, SkyType.NORMAL, false, false); // NaN = no clouds
        setSkyRenderHandler(new FracturedRealitySkyRenderer());
    }

    @Override
    public Vec3 getBrightnessDependentFogColor(Vec3 color, float brightness) {
        return color; // tint this to match your skybox horizon
    }

    @Override
    public boolean isFoggyAt(int x, int z) {
        return false;
    }
}