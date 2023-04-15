package net.dylan.dmich9smod.common.worldgen;

import net.dylan.dmich9smod.common.worldgen.structures.*;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
/*
public class ModStructures {
    public static final DeferredRegister<StructureFeature<?>> DEFERRED_REGISTRY_STRUCTURE =
            DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, dmich9sMod.MOD_ID);

    public static final RegistryObject<StructureFeature<?>> OVERWORLD_DUNGEON =
            DEFERRED_REGISTRY_STRUCTURE.register("overworld_dungeon", OverworldDungeon::new);
    public static final RegistryObject<StructureFeature<?>> ANGUISH_TREE_1 =
            DEFERRED_REGISTRY_STRUCTURE.register("anguish_tree_1", AnguishTree1::new);
    public static final RegistryObject<StructureFeature<?>> ANGUISH_TREE_2 =
            DEFERRED_REGISTRY_STRUCTURE.register("anguish_tree_2", AnguishTree2::new);
    public static final RegistryObject<StructureFeature<?>> ANGUISH_TREE_3 =
            DEFERRED_REGISTRY_STRUCTURE.register("anguish_tree_3", AnguishTree3::new);
    public static final RegistryObject<StructureFeature<?>> FRIGHT_TREE_1 =
            DEFERRED_REGISTRY_STRUCTURE.register("fright_tree_1", FrightTree1::new);
    public static final RegistryObject<StructureFeature<?>> FRIGHT_TREE_2 =
            DEFERRED_REGISTRY_STRUCTURE.register("fright_tree_2", FrightTree2::new);
    public static final RegistryObject<StructureFeature<?>> FRIGHT_TREE_3 =
            DEFERRED_REGISTRY_STRUCTURE.register("fright_tree_3", FrightTree3::new);
    public static final RegistryObject<StructureFeature<?>> MIGHT_TREE_1 =
            DEFERRED_REGISTRY_STRUCTURE.register("might_tree_1", MightTree1::new);
    public static final RegistryObject<StructureFeature<?>> MIGHT_TREE_2 =
            DEFERRED_REGISTRY_STRUCTURE.register("might_tree_2", MightTree2::new);
    public static final RegistryObject<StructureFeature<?>> MIGHT_TREE_3 =
            DEFERRED_REGISTRY_STRUCTURE.register("might_tree_3", MightTree3::new);
    public static final RegistryObject<StructureFeature<?>> DREAM_TREE_1 =
            DEFERRED_REGISTRY_STRUCTURE.register("dream_tree_1", DreamTree1::new);
    public static final RegistryObject<StructureFeature<?>> DREAM_TREE_2 =
            DEFERRED_REGISTRY_STRUCTURE.register("dream_tree_2", DreamTree2::new);
    public static final RegistryObject<StructureFeature<?>> DREAM_TREE_3 =
            DEFERRED_REGISTRY_STRUCTURE.register("dream_tree_3", DreamTree3::new);
    public static final RegistryObject<StructureFeature<?>> FRACTURED_TREE_1 =
            DEFERRED_REGISTRY_STRUCTURE.register("fractured_tree_1", FracturedTree1::new);
    public static final RegistryObject<StructureFeature<?>> FRACTURED_TREE_2 =
            DEFERRED_REGISTRY_STRUCTURE.register("fractured_tree_2", FracturedTree2::new);
    public static final RegistryObject<StructureFeature<?>> FRACTURED_TREE_3 =
            DEFERRED_REGISTRY_STRUCTURE.register("fractured_tree_3", FracturedTree3::new);
    public static final RegistryObject<StructureFeature<?>> YELLOW_MAPLE_TREE_1 =
            DEFERRED_REGISTRY_STRUCTURE.register("yellow_maple_tree_1", YellowMapleTree1::new);
    public static final RegistryObject<StructureFeature<?>> YELLOW_MAPLE_TREE_2 =
            DEFERRED_REGISTRY_STRUCTURE.register("yellow_maple_tree_2", YellowMapleTree2::new);
    public static final RegistryObject<StructureFeature<?>> YELLOW_MAPLE_TREE_3 =
            DEFERRED_REGISTRY_STRUCTURE.register("yellow_maple_tree_3", YellowMapleTree3::new);
    public static final RegistryObject<StructureFeature<?>> ORANGE_MAPLE_TREE_1 =
            DEFERRED_REGISTRY_STRUCTURE.register("orange_maple_tree_1", OrangeMapleTree1::new);
    public static final RegistryObject<StructureFeature<?>> ORANGE_MAPLE_TREE_2 =
            DEFERRED_REGISTRY_STRUCTURE.register("orange_maple_tree_2", OrangeMapleTree2::new);
    public static final RegistryObject<StructureFeature<?>> ORANGE_MAPLE_TREE_3 =
            DEFERRED_REGISTRY_STRUCTURE.register("orange_maple_tree_3", OrangeMapleTree3::new);
    public static final RegistryObject<StructureFeature<?>> RED_MAPLE_TREE_1 =
            DEFERRED_REGISTRY_STRUCTURE.register("red_maple_tree_1", RedMapleTree1::new);
    public static final RegistryObject<StructureFeature<?>> RED_MAPLE_TREE_2 =
            DEFERRED_REGISTRY_STRUCTURE.register("red_maple_tree_2", RedMapleTree2::new);
    public static final RegistryObject<StructureFeature<?>> RED_MAPLE_TREE_3 =
            DEFERRED_REGISTRY_STRUCTURE.register("red_maple_tree_3", RedMapleTree3::new);

    public static void register(IEventBus eventBus) {
        DEFERRED_REGISTRY_STRUCTURE.register(eventBus);
    }
}
*///