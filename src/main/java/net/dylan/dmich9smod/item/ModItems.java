package net.dylan.dmich9smod.item;

import net.dylan.dmich9smod.entity.custom.ModBoatEntity;
import net.dylan.dmich9smod.block.ModBlocks;
import net.dylan.dmich9smod.dmich9sMod;
import net.dylan.dmich9smod.fluid.ModFluids;
import net.dylan.dmich9smod.item.custom.ModBoatItem;
import net.dylan.dmich9smod.sound.ModSounds;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, dmich9sMod.MOD_ID);

    public static final RegistryObject<Item> CARNELIAN_SWORD = ITEMS.register("carnelian_sword",
            () -> new SwordItem(ModTiers.CARNELIAN,0,-2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> CARNELIAN_PICKAXE = ITEMS.register("carnelian_pickaxe",
            () -> new PickaxeItem(ModTiers.CARNELIAN,-2,-2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> CARNELIAN_AXE = ITEMS.register("carnelian_axe",
            () -> new AxeItem(ModTiers.CARNELIAN,1.0f,-3.2f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> CARNELIAN_SHOVEL = ITEMS.register("carnelian_shovel",
            () -> new ShovelItem(ModTiers.CARNELIAN,-1.5f,-3.0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> CARNELIAN_HOE = ITEMS.register("carnelian_hoe",
            () -> new HoeItem(ModTiers.CARNELIAN,-4,-3.0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> CARNELIAN_HELMET = ITEMS.register("carnelian_helmet",
            () -> new ArmorItem(ModArmorMaterials.CARNELIAN, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> CARNELIAN_CHESTPLATE = ITEMS.register("carnelian_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CARNELIAN, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> CARNELIAN_LEGGINGS = ITEMS.register("carnelian_leggings",
            () -> new ArmorItem(ModArmorMaterials.CARNELIAN, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> CARNELIAN_BOOTS = ITEMS.register("carnelian_boots",
            () -> new ArmorItem(ModArmorMaterials.CARNELIAN, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> STRONTIUM_SWORD = ITEMS.register("strontium_sword",
            () -> new SwordItem(ModTiers.STRONTIUM,0,-2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> STRONTIUM_PICKAXE = ITEMS.register("strontium_pickaxe",
            () -> new PickaxeItem(ModTiers.STRONTIUM,-2,-2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> STRONTIUM_AXE = ITEMS.register("strontium_axe",
            () -> new AxeItem(ModTiers.STRONTIUM,2.0f,-3.2f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> STRONTIUM_SHOVEL = ITEMS.register("strontium_shovel",
            () -> new ShovelItem(ModTiers.STRONTIUM,-1.5f,-3.0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> STRONTIUM_HOE = ITEMS.register("strontium_hoe",
            () -> new HoeItem(ModTiers.STRONTIUM,-4,-2.0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> STRONTIUM_HELMET = ITEMS.register("strontium_helmet",
            () -> new ArmorItem(ModArmorMaterials.STRONTIUM, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> STRONTIUM_CHESTPLATE = ITEMS.register("strontium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.STRONTIUM, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> STRONTIUM_LEGGINGS = ITEMS.register("strontium_leggings",
            () -> new ArmorItem(ModArmorMaterials.STRONTIUM, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> STRONTIUM_BOOTS = ITEMS.register("strontium_boots",
            () -> new ArmorItem(ModArmorMaterials.STRONTIUM, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> GARNET_SWORD = ITEMS.register("garnet_sword",
            () -> new SwordItem(ModTiers.GARNET,1,-2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> GARNET_PICKAXE = ITEMS.register("garnet_pickaxe",
            () -> new PickaxeItem(ModTiers.GARNET,-1,-2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> GARNET_AXE = ITEMS.register("garnet_axe",
            () -> new AxeItem(ModTiers.GARNET,3.0f,-3.0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> GARNET_SHOVEL = ITEMS.register("garnet_shovel",
            () -> new ShovelItem(ModTiers.GARNET,-0.5f,-3.0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> GARNET_HOE = ITEMS.register("garnet_hoe",
            () -> new HoeItem(ModTiers.GARNET,-4,-1.0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> GARNET_HELMET = ITEMS.register("garnet_helmet",
            () -> new ArmorItem(ModArmorMaterials.GARNET, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> GARNET_CHESTPLATE = ITEMS.register("garnet_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GARNET, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> GARNET_LEGGINGS = ITEMS.register("garnet_leggings",
            () -> new ArmorItem(ModArmorMaterials.GARNET, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> GARNET_BOOTS = ITEMS.register("garnet_boots",
            () -> new ArmorItem(ModArmorMaterials.GARNET, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AZURITE_SWORD = ITEMS.register("azurite_sword",
            () -> new SwordItem(ModTiers.AZURITE,2,-2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AZURITE_PICKAXE = ITEMS.register("azurite_pickaxe",
            () -> new PickaxeItem(ModTiers.AZURITE,0,-2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AZURITE_AXE = ITEMS.register("azurite_axe",
            () -> new AxeItem(ModTiers.AZURITE,4.0f,-3.0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AZURITE_SHOVEL = ITEMS.register("azurite_shovel",
            () -> new ShovelItem(ModTiers.AZURITE,0.5f,-3.0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AZURITE_HOE = ITEMS.register("azurite_hoe",
            () -> new HoeItem(ModTiers.AZURITE,-4,-1.0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AZURITE_HELMET = ITEMS.register("azurite_helmet",
            () -> new ArmorItem(ModArmorMaterials.AZURITE, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AZURITE_CHESTPLATE = ITEMS.register("azurite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.AZURITE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AZURITE_LEGGINGS = ITEMS.register("azurite_leggings",
            () -> new ArmorItem(ModArmorMaterials.AZURITE, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AZURITE_BOOTS = ITEMS.register("azurite_boots",
            () -> new ArmorItem(ModArmorMaterials.AZURITE, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> SERENDIBITE_SWORD = ITEMS.register("serendibite_sword",
            () -> new SwordItem(ModTiers.SERENDIBITE,3,-2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> SERENDIBITE_PICKAXE = ITEMS.register("serendibite_pickaxe",
            () -> new PickaxeItem(ModTiers.SERENDIBITE,1,-2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> SERENDIBITE_AXE = ITEMS.register("serendibite_axe",
            () -> new AxeItem(ModTiers.SERENDIBITE,5.0f,-3.0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> SERENDIBITE_SHOVEL = ITEMS.register("serendibite_shovel",
            () -> new ShovelItem(ModTiers.SERENDIBITE,1.0f,-3.0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> SERENDIBITE_HOE = ITEMS.register("serendibite_hoe",
            () -> new HoeItem(ModTiers.SERENDIBITE,-4,0.0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> SERENDIBITE_HELMET = ITEMS.register("serendibite_helmet",
            () -> new ArmorItem(ModArmorMaterials.SERENDIBITE, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> SERENDIBITE_CHESTPLATE = ITEMS.register("serendibite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SERENDIBITE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> SERENDIBITE_LEGGINGS = ITEMS.register("serendibite_leggings",
            () -> new ArmorItem(ModArmorMaterials.SERENDIBITE, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> SERENDIBITE_BOOTS = ITEMS.register("serendibite_boots",
            () -> new ArmorItem(ModArmorMaterials.SERENDIBITE, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AMBROSIA_SWORD = ITEMS.register("ambrosia_sword",
            () -> new SwordItem(ModTiers.AMBROSIA,4,-2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AMBROSIA_PICKAXE = ITEMS.register("ambrosia_pickaxe",
            () -> new PickaxeItem(ModTiers.AMBROSIA,1,-2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AMBROSIA_AXE = ITEMS.register("ambrosia_axe",
            () -> new AxeItem(ModTiers.AMBROSIA,6.0f,-2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AMBROSIA_SHOVEL = ITEMS.register("ambrosia_shovel",
            () -> new ShovelItem(ModTiers.AMBROSIA,1.5f,-3.0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AMBROSIA_HOE = ITEMS.register("ambrosia_hoe",
            () -> new HoeItem(ModTiers.AMBROSIA,-4,0.0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AMBROSIA_HELMET = ITEMS.register("ambrosia_helmet",
            () -> new ArmorItem(ModArmorMaterials.AMBROSIA, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AMBROSIA_CHESTPLATE = ITEMS.register("ambrosia_chestplate",
            () -> new ArmorItem(ModArmorMaterials.AMBROSIA, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AMBROSIA_LEGGINGS = ITEMS.register("ambrosia_leggings",
            () -> new ArmorItem(ModArmorMaterials.AMBROSIA, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AMBROSIA_BOOTS = ITEMS.register("ambrosia_boots",
            () -> new ArmorItem(ModArmorMaterials.AMBROSIA, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> CARNELIAN = ITEMS.register("carnelian",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> CARNELIAN_SHARD = ITEMS.register("carnelian_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> STRONTIUM_INGOT = ITEMS.register("strontium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> STRONTIUM_NUGGET = ITEMS.register("strontium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> GARNET_SHARD = ITEMS.register("garnet_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AZURITE = ITEMS.register("azurite",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AZURITE_SHARD = ITEMS.register("azurite_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> SERENDIBITE = ITEMS.register("serendibite",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> SERENDIBITE_SHARD = ITEMS.register("serendibite_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AMBROSIA = ITEMS.register("ambrosia",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> AMBROSIA_SHARD = ITEMS.register("ambrosia_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));




    public static final RegistryObject<Item> DRAGONFRUIT_SEEDS = ITEMS.register("dragonfruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.DRAGONFRUIT_CROP.get(),
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> DRAGONFRUIT = ITEMS.register("dragonfruit",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).food(ModFoods.DRAGONFRUIT)));

    public static final RegistryObject<Item> GROOVE_RIDE = ITEMS.register("groove_ride_record",
            () -> new RecordItem(4, ModSounds.GROOVE_RIDE,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> TWOFORTY_BITS = ITEMS.register("twoforty_bits_record",
            () -> new RecordItem(4, ModSounds.TWOFORTY_BITS,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));

    public static final RegistryObject<Item> ASTEROID_FIELD = ITEMS.register("asteroid_field_record",
            () -> new RecordItem(4, ModSounds.ASTEROID_FIELD,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> FRACTURED_FOREST = ITEMS.register("fractured_forest_record",
            () -> new RecordItem(4, ModSounds.FRACTURED_FOREST,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> DREAMSCAPE = ITEMS.register("dreamscape_record",
            () -> new RecordItem(4, ModSounds.DREAMSCAPE,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> END_SPRINGS = ITEMS.register("end_springs_record",
            () -> new RecordItem(4, ModSounds.END_SPRINGS,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> MINI_DUNGEON = ITEMS.register("mini_dungeon_record",
            () -> new RecordItem(4, ModSounds.MINI_DUNGEON,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> OVERWORLD_DUNGEON = ITEMS.register("overworld_dungeon_record",
            () -> new RecordItem(4, ModSounds.OVERWORLD_DUNGEON,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> NETHER_DUNGEON = ITEMS.register("nether_dungeon_record",
            () -> new RecordItem(4, ModSounds.NETHER_DUNGEON,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> END_DUNGEON = ITEMS.register("end_dungeon_record",
            () -> new RecordItem(4, ModSounds.END_DUNGEON,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> BOSS = ITEMS.register("boss_record",
            () -> new RecordItem(4, ModSounds.BOSS,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> FINAL_BOSS = ITEMS.register("final_boss_record",
            () -> new RecordItem(4, ModSounds.FINAL_BOSS,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));

    public static final RegistryObject<Item> SPRING_WATER_BUCKET = ITEMS.register("spring_water_bucket",
            () -> new BucketItem(ModFluids.SPRING_WATER_FLUID,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).durability(500)));

    public static final RegistryObject<Item> ANGUISH_SIGN_ITEM = ITEMS.register("anguish_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(16),
                    ModBlocks.ANGUISH_SIGN.get(), ModBlocks.ANGUISH_WALL_SIGN.get()));
    public static final RegistryObject<Item> FRIGHT_SIGN_ITEM = ITEMS.register("fright_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(16),
                    ModBlocks.FRIGHT_SIGN.get(), ModBlocks.FRIGHT_WALL_SIGN.get()));
    public static final RegistryObject<Item> MIGHT_SIGN_ITEM = ITEMS.register("might_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(16),
                    ModBlocks.MIGHT_SIGN.get(), ModBlocks.MIGHT_WALL_SIGN.get()));
    public static final RegistryObject<Item> DREAM_SIGN_ITEM = ITEMS.register("dream_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(16),
                    ModBlocks.DREAM_SIGN.get(), ModBlocks.DREAM_WALL_SIGN.get()));
    public static final RegistryObject<Item> FRACTURED_SIGN_ITEM = ITEMS.register("fractured_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(16),
                    ModBlocks.FRACTURED_SIGN.get(), ModBlocks.FRACTURED_WALL_SIGN.get()));
    public static final RegistryObject<Item> MAPLE_SIGN_ITEM = ITEMS.register("maple_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(16),
                    ModBlocks.MAPLE_SIGN.get(), ModBlocks.MAPLE_WALL_SIGN.get()));

    public static final RegistryObject<Item> ANGUISH_SHARD = ITEMS.register("anguish_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> FRIGHT_SHARD = ITEMS.register("fright_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> MIGHT_SHARD = ITEMS.register("might_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> DREAM_SHARD = ITEMS.register("dream_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> FRACTURED_SHARD = ITEMS.register("fractured_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> MAPLE_SHARD = ITEMS.register("maple_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> DREAMERS_ANGUISH = ITEMS.register("dreamers_anguish",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> DREAMERS_FRIGHT = ITEMS.register("dreamers_fright",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> DREAMERS_MIGHT = ITEMS.register("dreamers_might",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> FIERY_QUARTZ = ITEMS.register("fiery_quartz",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> END_QUARTZ = ITEMS.register("end_quartz",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> ANGUISH_BOAT = ITEMS.register("anguish_boat",
            () -> new ModBoatItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB), ModBoatEntity.Type.ANGUISH));
    public static final RegistryObject<Item> FRIGHT_BOAT = ITEMS.register("fright_boat",
            () -> new ModBoatItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB), ModBoatEntity.Type.FRIGHT));
    public static final RegistryObject<Item> MIGHT_BOAT = ITEMS.register("might_boat",
            () -> new ModBoatItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB), ModBoatEntity.Type.MIGHT));
    public static final RegistryObject<Item> DREAM_BOAT = ITEMS.register("dream_boat",
            () -> new ModBoatItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB), ModBoatEntity.Type.DREAM));
    public static final RegistryObject<Item> FRACTURED_BOAT = ITEMS.register("fractured_boat",
            () -> new ModBoatItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB), ModBoatEntity.Type.FRACTURED));
    public static final RegistryObject<Item> MAPLE_BOAT = ITEMS.register("maple_boat",
            () -> new ModBoatItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB), ModBoatEntity.Type.MAPLE));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
