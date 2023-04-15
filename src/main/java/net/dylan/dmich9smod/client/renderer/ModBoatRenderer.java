package net.dylan.dmich9smod.client.renderer;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.dylan.dmich9smod.common.entity.ModBoatEntity;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.dylan.dmich9smod.core.dmich9sMod;

import java.util.Map;
import java.util.stream.Stream;

public class ModBoatRenderer extends BoatRenderer {
    private final Map<ModBoatEntity.Type, Pair<ResourceLocation, BoatModel>> boatResources;

    public ModBoatRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.8F;
        this.boatResources = Stream.of(ModBoatEntity.Type.values()).collect(ImmutableMap.toImmutableMap((p_173938_) -> p_173938_,
                (type) -> Pair.of(new ResourceLocation(dmich9sMod.MOD_ID,"textures/entity/boat/" + type.getName() + ".png"),
                        new BoatModel(context.bakeLayer(
                                new ModelLayerLocation(new ResourceLocation("minecraft", "boat/oak"),"main"))))));

    }

    @Override
    public ResourceLocation getTextureLocation(Boat pEntity) {
        if(pEntity instanceof ModBoatEntity modBoat) {
            return this.boatResources.get(modBoat.getModBoatType()).getFirst();
        }

        return new ResourceLocation("minecraft", "boat/oak");
    }

    public Pair<ResourceLocation, BoatModel> getModelWithLocation(Boat boat) {
        if(boat instanceof ModBoatEntity modBoat) {
            return this.boatResources.get(modBoat.getModBoatType());
        }

        return null;
    }
}