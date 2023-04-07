package net.dylan.dmich9smod.block.entity;

import net.dylan.dmich9smod.block.ModBlocksAndItems;
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
                            ModBlocksAndItems.ANGUISH_WALL_SIGN.get(),
                            ModBlocksAndItems.ANGUISH_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<FrightSignBlockEntity>> FRIGHT_SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("fright_sign_block_entity", () ->
                    BlockEntityType.Builder.of(FrightSignBlockEntity::new,
                            ModBlocksAndItems.FRIGHT_WALL_SIGN.get(),
                            ModBlocksAndItems.FRIGHT_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<MightSignBlockEntity>> MIGHT_SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("might_sign_block_entity", () ->
                    BlockEntityType.Builder.of(MightSignBlockEntity::new,
                            ModBlocksAndItems.MIGHT_WALL_SIGN.get(),
                            ModBlocksAndItems.MIGHT_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<DreamSignBlockEntity>> DREAM_SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("dream_sign_block_entity", () ->
                    BlockEntityType.Builder.of(DreamSignBlockEntity::new,
                            ModBlocksAndItems.DREAM_WALL_SIGN.get(),
                            ModBlocksAndItems.DREAM_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<FracturedSignBlockEntity>> FRACTURED_SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("fractured_sign_block_entity", () ->
                    BlockEntityType.Builder.of(FracturedSignBlockEntity::new,
                            ModBlocksAndItems.FRACTURED_WALL_SIGN.get(),
                            ModBlocksAndItems.FRACTURED_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<MapleSignBlockEntity>> MAPLE_SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("maple_sign_block_entity", () ->
                    BlockEntityType.Builder.of(MapleSignBlockEntity::new,
                            ModBlocksAndItems.MAPLE_WALL_SIGN.get(),
                            ModBlocksAndItems.MAPLE_SIGN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}

