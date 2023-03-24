package net.dylan.dmich9smod.block.entity;

import net.dylan.dmich9smod.block.ModBlocks;
import net.dylan.dmich9smod.block.entity.custom.*;
import net.dylan.dmich9smod.dmich9sMod;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, dmich9sMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<AnguishSignBlockEntity>> ANGUISH_SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("anguish_sign_block_entity", () ->
                    BlockEntityType.Builder.of(AnguishSignBlockEntity::new,
                            ModBlocks.ANGUISH_WALL_SIGN.get(),
                            ModBlocks.ANGUISH_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<FrightSignBlockEntity>> FRIGHT_SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("fright_sign_block_entity", () ->
                    BlockEntityType.Builder.of(FrightSignBlockEntity::new,
                            ModBlocks.FRIGHT_WALL_SIGN.get(),
                            ModBlocks.FRIGHT_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<MightSignBlockEntity>> MIGHT_SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("might_sign_block_entity", () ->
                    BlockEntityType.Builder.of(MightSignBlockEntity::new,
                            ModBlocks.MIGHT_WALL_SIGN.get(),
                            ModBlocks.MIGHT_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<DreamSignBlockEntity>> DREAM_SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("dream_sign_block_entity", () ->
                    BlockEntityType.Builder.of(DreamSignBlockEntity::new,
                            ModBlocks.DREAM_WALL_SIGN.get(),
                            ModBlocks.DREAM_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<FracturedSignBlockEntity>> FRACTURED_SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("fractured_sign_block_entity", () ->
                    BlockEntityType.Builder.of(FracturedSignBlockEntity::new,
                            ModBlocks.FRACTURED_WALL_SIGN.get(),
                            ModBlocks.FRACTURED_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<MapleSignBlockEntity>> MAPLE_SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("maple_sign_block_entity", () ->
                    BlockEntityType.Builder.of(MapleSignBlockEntity::new,
                            ModBlocks.MAPLE_WALL_SIGN.get(),
                            ModBlocks.MAPLE_SIGN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}

