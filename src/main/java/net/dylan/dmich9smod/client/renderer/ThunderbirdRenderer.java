/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.client.renderer;

import net.dylan.dmich9smod.client.ThunderbirdModel;
import net.dylan.dmich9smod.common.entity.Thunderbird;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ThunderbirdRenderer extends GeoEntityRenderer<Thunderbird> {
    public ThunderbirdRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ThunderbirdModel());
        this.shadowRadius = 0.9f;
    }
}
