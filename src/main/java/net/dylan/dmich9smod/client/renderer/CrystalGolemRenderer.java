/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.client.renderer;

import net.dylan.dmich9smod.client.CrystalGolemModel;
import net.dylan.dmich9smod.common.entity.CrystalGolem;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CrystalGolemRenderer extends GeoEntityRenderer<CrystalGolem> {
    public CrystalGolemRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrystalGolemModel());
        this.shadowRadius = 0.3f;
    }
}
