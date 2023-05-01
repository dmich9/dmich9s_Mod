package net.dylan.dmich9smod.common.util;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.dylan.dmich9smod.init.ModBlocksAndItems;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPOIs {
    public static final DeferredRegister<PoiType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, dmich9sMod.MOD_ID);

    public static final RegistryObject<PoiType> DREAMSCAPE_PORTAL =
            POI.register("dreamscape_portal", () -> new PoiType("dreamscape_portal",
                    PoiType.getBlockStates(ModBlocksAndItems.DREAMSCAPE_PORTAL.get()), 0, 1));


    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}