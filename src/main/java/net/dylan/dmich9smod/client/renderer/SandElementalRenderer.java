/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.client.renderer;

import net.dylan.dmich9smod.client.SandElementalModel;
import net.dylan.dmich9smod.common.entity.SandElemental;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SandElementalRenderer extends GeoEntityRenderer<SandElemental> {

    public SandElementalRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SandElementalModel());
        this.shadowRadius = 0.3f;
    }

}
