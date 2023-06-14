package net.dylan.dmich9smod.common.entity;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.dylan.dmich9smod.common.entity.ModBoatEntity;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, dmich9sMod.MOD_ID);

    public static final RegistryObject<EntityType<ModBoatEntity>> BOAT_ENTITY =
            ENTITY_TYPES.register("mod_boat", () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
                            MobCategory.MISC).fireImmune().sized(1.375F, 0.5625F)
                    .setCustomClientFactory((spawnEntity, world) -> new ModBoatEntity(world, 0, 0, 0))
                    .build("mod_boat"));

    public static final RegistryObject<EntityType<CorruptedZombieEntity>> CORRUPTED_ZOMBIE = ENTITY_TYPES.register("corrupted_zombie",
            () -> EntityType.Builder.of(CorruptedZombieEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).build(new ResourceLocation(dmich9sMod.MOD_ID, "corrupted_zombie").toString()));
    public static final RegistryObject<EntityType<ThunderbirdEntity>> THUNDERBIRD = ENTITY_TYPES.register("thunderbird",
            () -> EntityType.Builder.of(ThunderbirdEntity::new, MobCategory.MONSTER)
                    .sized(0.8f, 0.6f).build(new ResourceLocation(dmich9sMod.MOD_ID, "thunderbird").toString()));
    public static final RegistryObject<EntityType<FracturedWandererEntity>> FRACTURED_WANDERER = ENTITY_TYPES.register("fractured_wanderer",
            () -> EntityType.Builder.of(FracturedWandererEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).build(new ResourceLocation(dmich9sMod.MOD_ID, "fractured_wanderer").toString()));
    public static final RegistryObject<EntityType<SandElementalEntity>> SAND_ELEMENTAL = ENTITY_TYPES.register("sand_elemental",
            () -> EntityType.Builder.of(SandElementalEntity::new, MobCategory.MONSTER)
                    .sized(0.8f, 0.6f).build(new ResourceLocation(dmich9sMod.MOD_ID, "sand_elemental").toString()));
    public static final RegistryObject<EntityType<CrystalGolemEntity>> CRYSTAL_GOLEM = ENTITY_TYPES.register("crystal_golem",
            () -> EntityType.Builder.of(CrystalGolemEntity::new, MobCategory.MONSTER)
                    .sized(0.8f, 0.6f).build(new ResourceLocation(dmich9sMod.MOD_ID, "crystal_golem").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
