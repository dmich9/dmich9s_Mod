/**
 * (c) skyjay1 2023
 * GNU LGPLv3
 **/
package net.dylan.dmich9smod.client.renderer;

import net.dylan.dmich9smod.client.CorruptedZombieModel;
import net.dylan.dmich9smod.common.entity.CorruptedZombie;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CorruptedZombieRenderer extends GeoEntityRenderer<CorruptedZombie> {

    public CorruptedZombieRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CorruptedZombieModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public float getWidthScale(CorruptedZombie animatable) {
        return 0.8F;
    }

    @Override
    public float getHeightScale(CorruptedZombie entity) {
        return 0.8F;
    }
}
