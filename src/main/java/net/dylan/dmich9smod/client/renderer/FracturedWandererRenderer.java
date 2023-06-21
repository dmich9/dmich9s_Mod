/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.client.renderer;

import net.dylan.dmich9smod.client.FracturedWandererModel;
import net.dylan.dmich9smod.common.entity.FracturedWanderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FracturedWandererRenderer extends GeoEntityRenderer<FracturedWanderer> {
    public FracturedWandererRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FracturedWandererModel());
        this.shadowRadius = 0.3f;
    }
}
