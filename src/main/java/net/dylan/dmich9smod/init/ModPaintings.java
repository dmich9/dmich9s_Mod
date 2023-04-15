package net.dylan.dmich9smod.init;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<Motive> PAINTING_MOTIVES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, dmich9sMod.MOD_ID);

    public static final RegistryObject<Motive> THE_HAVEN =
            PAINTING_MOTIVES.register("the_haven", () -> new Motive(64,48));
    public static final RegistryObject<Motive> THE_AVALANCHES =
            PAINTING_MOTIVES.register("the_avalanches", () -> new Motive(48,48));
    public static final RegistryObject<Motive> BLUE_RIDGE =
            PAINTING_MOTIVES.register("blue_ridge", () -> new Motive(64,48));
    public static final RegistryObject<Motive> INTIMIDATOR =
            PAINTING_MOTIVES.register("intimidator", () -> new Motive(64,48));
    public static final RegistryObject<Motive> GALAX_VA =
            PAINTING_MOTIVES.register("galax_va", () -> new Motive(48,64));

    public static void register(IEventBus eventBus){
        PAINTING_MOTIVES.register(eventBus);
    }
}
