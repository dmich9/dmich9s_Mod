/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.client.renderer;

import net.dylan.dmich9smod.client.SandBallModel;
import net.dylan.dmich9smod.common.entity.SandBall;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class SandBallRenderer extends GeoProjectilesRenderer<SandBall> {
    public SandBallRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SandBallModel());
        this.shadowRadius = 0F;
        this.shadowStrength = 0F;
    }
}
