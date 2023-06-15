package net.dylan.dmich9smod.init;
import net.dylan.dmich9smod.common.entity.CorruptedZombie;
import net.dylan.dmich9smod.common.entity.CrystalGolem;
import net.dylan.dmich9smod.common.entity.FracturedWanderer;
import net.dylan.dmich9smod.common.entity.ModBoat;
import net.dylan.dmich9smod.common.entity.SandBall;
import net.dylan.dmich9smod.common.entity.SandElemental;
import net.dylan.dmich9smod.common.entity.Thunderbird;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, dmich9sMod.MOD_ID);

    public static final RegistryObject<EntityType<ModBoat>> BOAT_ENTITY =
            ENTITY_TYPES.register("mod_boat", () -> EntityType.Builder.<ModBoat>of(ModBoat::new,
                            MobCategory.MISC).fireImmune().sized(1.375F, 0.5625F)
                    .setCustomClientFactory((spawnEntity, world) -> new ModBoat(world, 0, 0, 0))
                    .build("mod_boat"));

    public static final RegistryObject<EntityType<CorruptedZombie>> CORRUPTED_ZOMBIE = ENTITY_TYPES.register("corrupted_zombie",
            () -> EntityType.Builder.of(CorruptedZombie::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).build("corrupted_zombie"));
    public static final RegistryObject<EntityType<Thunderbird>> THUNDERBIRD = ENTITY_TYPES.register("thunderbird",
            () -> EntityType.Builder.of(Thunderbird::new, MobCategory.MONSTER)
                    .sized(0.8f, 0.6f).build("thunderbird"));
    public static final RegistryObject<EntityType<FracturedWanderer>> FRACTURED_WANDERER = ENTITY_TYPES.register("fractured_wanderer",
            () -> EntityType.Builder.of(FracturedWanderer::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).build("fractured_wanderer"));
    public static final RegistryObject<EntityType<SandElemental>> SAND_ELEMENTAL = ENTITY_TYPES.register("sand_elemental",
            () -> EntityType.Builder.of(SandElemental::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).build("sand_elemental"));
    public static final RegistryObject<EntityType<CrystalGolem>> CRYSTAL_GOLEM = ENTITY_TYPES.register("crystal_golem",
            () -> EntityType.Builder.of(CrystalGolem::new, MobCategory.MONSTER)
                    .sized(0.8f, 0.6f).build("crystal_golem"));
    public static final RegistryObject<EntityType<SandBall>> SAND_BALL = ENTITY_TYPES.register("sand_ball",
            () -> EntityType.Builder.<SandBall>of(SandBall::new, MobCategory.MISC)
                    .sized(0.25f, 0.25f).build("sand_ball"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
