package net.dylan.dmich9smod.block;
import net.dylan.dmich9smod.block.entity.custom.*;
import net.dylan.dmich9smod.dmich9sMod;
import net.dylan.dmich9smod.item.ModCreativeModeTab;
import net.dylan.dmich9smod.item.ModItems;
import net.dylan.dmich9smod.world.feature.tree.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, dmich9sMod.MOD_ID);

//Blocks for main 6 ore sets

    public static final RegistryObject<Block> STRONTIUM_BLOCK = registerBlock("strontium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRONTIUM_ORE = registerBlock("strontium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DEEPSLATE_STRONTIUM_ORE = registerBlock("deepslate_strontium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> CARNELIAN_BLOCK = registerBlock("carnelian_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> CARNELIAN_ORE = registerBlock("carnelian_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DEEPSLATE_CARNELIAN_ORE = registerBlock("deepslate_carnelian_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> GARNET_BLOCK = registerBlock("garnet_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> GARNET_ORE = registerBlock("garnet_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DEEPSLATE_GARNET_ORE = registerBlock("deepslate_garnet_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> AZURITE_BLOCK = registerBlock("azurite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> AZURITE_ORE = registerBlock("azurite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DEEPSLATE_AZURITE_ORE = registerBlock("deepslate_azurite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> SERENDIBITE_BLOCK = registerBlock("serendibite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> SERENDIBITE_ORE = registerBlock("serendibite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DEEPSLATE_SERENDIBITE_ORE = registerBlock("deepslate_serendibite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> AMBROSIA_BLOCK = registerBlock("ambrosia_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> AMBROSIA_ORE = registerBlock("ambrosia_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DEEPSLATE_AMBROSIA_ORE = registerBlock("deepslate_ambrosia_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> DRAGONFRUIT_CROP = BLOCKS.register("dragonfruit_crop",
            () -> new DragonfruitCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().noOcclusion()));

    public static final RegistryObject<Block> ANGUISH_LOG = registerBlock("anguish_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_ANGUISH_LOG = registerBlock("stripped_anguish_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ANGUISH_WOOD = registerBlock("anguish_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_ANGUISH_WOOD = registerBlock("stripped_anguish_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ANGUISH_PLANKS = registerBlock("anguish_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ANGUISH_STAIRS = registerBlock("anguish_stairs",
            () -> new StairBlock(() -> ModBlocks.ANGUISH_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ANGUISH_SLAB = registerBlock("anguish_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ANGUISH_FENCE = registerBlock("anguish_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ANGUISH_FENCE_GATE = registerBlock("anguish_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ANGUISH_DOOR = registerBlock("anguish_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noOcclusion()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ANGUISH_TRAPDOOR = registerBlock("anguish_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noOcclusion()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ANGUISH_BUTTON = registerBlock("anguish_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ANGUISH_PRESSURE_PLATE = registerBlock("anguish_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRIGHT_LOG = registerBlock("fright_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_FRIGHT_LOG = registerBlock("stripped_fright_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRIGHT_WOOD = registerBlock("fright_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_FRIGHT_WOOD = registerBlock("stripped_fright_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRIGHT_PLANKS = registerBlock("fright_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRIGHT_STAIRS = registerBlock("fright_stairs",
            () -> new StairBlock(() -> ModBlocks.FRIGHT_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOD)
                            .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRIGHT_SLAB = registerBlock("fright_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRIGHT_FENCE = registerBlock("fright_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRIGHT_FENCE_GATE = registerBlock("fright_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRIGHT_DOOR = registerBlock("fright_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noOcclusion()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRIGHT_TRAPDOOR = registerBlock("fright_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noOcclusion()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRIGHT_BUTTON = registerBlock("fright_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRIGHT_PRESSURE_PLATE = registerBlock("fright_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MIGHT_LOG = registerBlock("might_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_MIGHT_LOG = registerBlock("stripped_might_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MIGHT_WOOD = registerBlock("might_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_MIGHT_WOOD = registerBlock("stripped_might_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MIGHT_PLANKS = registerBlock("might_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MIGHT_STAIRS = registerBlock("might_stairs",
            () -> new StairBlock(() -> ModBlocks.MIGHT_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOD)
                            .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MIGHT_SLAB = registerBlock("might_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MIGHT_FENCE = registerBlock("might_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MIGHT_FENCE_GATE = registerBlock("might_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MIGHT_DOOR = registerBlock("might_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noOcclusion()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MIGHT_TRAPDOOR = registerBlock("might_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noOcclusion()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MIGHT_BUTTON = registerBlock("might_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MIGHT_PRESSURE_PLATE = registerBlock("might_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAM_LOG = registerBlock("dream_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_DREAM_LOG = registerBlock("stripped_dream_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAM_WOOD = registerBlock("dream_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_DREAM_WOOD = registerBlock("stripped_dream_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAM_PLANKS = registerBlock("dream_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAM_STAIRS = registerBlock("dream_stairs",
            () -> new StairBlock(() -> ModBlocks.DREAM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOD)
                            .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAM_SLAB = registerBlock("dream_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAM_FENCE = registerBlock("dream_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAM_FENCE_GATE = registerBlock("dream_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAM_DOOR = registerBlock("dream_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noOcclusion()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAM_TRAPDOOR = registerBlock("dream_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noOcclusion()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAM_BUTTON = registerBlock("dream_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAM_PRESSURE_PLATE = registerBlock("dream_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> FRACTURED_LOG = registerBlock("fractured_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRACTURED_WOOD = registerBlock("fractured_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_FRACTURED_LOG = registerBlock("stripped_fractured_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_FRACTURED_WOOD = registerBlock("stripped_fractured_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRACTURED_PLANKS = registerBlock("fractured_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRACTURED_STAIRS = registerBlock("fractured_stairs",
            () -> new StairBlock(() -> ModBlocks.FRACTURED_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOD)
                            .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRACTURED_SLAB = registerBlock("fractured_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRACTURED_FENCE = registerBlock("fractured_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRACTURED_FENCE_GATE = registerBlock("fractured_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRACTURED_DOOR = registerBlock("fractured_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noOcclusion()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRACTURED_TRAPDOOR = registerBlock("fractured_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noOcclusion()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRACTURED_BUTTON = registerBlock("fractured_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRACTURED_PRESSURE_PLATE = registerBlock("fractured_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_LOG = registerBlock("maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_WOOD = registerBlock("maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_PLANKS = registerBlock("maple_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_STAIRS = registerBlock("maple_stairs",
            () -> new StairBlock(() -> ModBlocks.MAPLE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOD)
                            .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_SLAB = registerBlock("maple_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_FENCE = registerBlock("maple_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_DOOR = registerBlock("maple_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noOcclusion()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noOcclusion()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_BUTTON = registerBlock("maple_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRACTURED_SAPLING = registerBlock("fractured_sapling",
            () -> new SaplingBlock(new FracturedTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_SAPLING_YELLOW = registerBlock("maple_sapling_yellow",
            () -> new SaplingBlock(new YellowMapleTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_SAPLING_ORANGE = registerBlock("maple_sapling_orange",
            () -> new SaplingBlock(new OrangeMapleTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_SAPLING_RED = registerBlock("maple_sapling_red",
            () -> new SaplingBlock(new RedMapleTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAM_SAPLING = registerBlock("dream_sapling",
            () -> new SaplingBlock(new DreamTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ANGUISH_SAPLING = registerBlock("anguish_sapling",
            () -> new SaplingBlock(new AnguishTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MIGHT_SAPLING = registerBlock("might_sapling",
            () -> new SaplingBlock(new MightTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRIGHT_SAPLING = registerBlock("fright_sapling",
            () -> new SaplingBlock(new FrightTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> ANGUISH_LEAVES = registerBlock("anguish_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRIGHT_LEAVES = registerBlock("fright_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MIGHT_LEAVES = registerBlock("might_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAM_LEAVES = registerBlock("dream_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FRACTURED_LEAVES = registerBlock("fractured_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_LEAVES_YELLOW = registerBlock("maple_leaves_yellow",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_LEAVES_ORANGE = registerBlock("maple_leaves_orange",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> MAPLE_LEAVES_RED = registerBlock("maple_leaves_red",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ANGUISH_SIGN = BLOCKS.register("anguish_sign",
            () -> new AnguishStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1f).noCollission(), ModWoodTypes.ANGUISH));
    public static final RegistryObject<Block> ANGUISH_WALL_SIGN = BLOCKS.register("anguish_wall_sign",
            () -> new AnguishWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1f).noCollission(), ModWoodTypes.ANGUISH));
    public static final RegistryObject<Block> FRIGHT_SIGN = BLOCKS.register("fright_sign",
            () -> new FrightStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1f).noCollission(), ModWoodTypes.FRIGHT));
    public static final RegistryObject<Block> FRIGHT_WALL_SIGN = BLOCKS.register("fright_wall_sign",
            () -> new FrightWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1f).noCollission(), ModWoodTypes.FRIGHT));
    public static final RegistryObject<Block> MIGHT_SIGN = BLOCKS.register("might_sign",
            () -> new MightStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1f).noCollission(), ModWoodTypes.MIGHT));
    public static final RegistryObject<Block> MIGHT_WALL_SIGN = BLOCKS.register("might_wall_sign",
            () -> new MightWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1f).noCollission(), ModWoodTypes.MIGHT));
    public static final RegistryObject<Block> DREAM_SIGN = BLOCKS.register("dream_sign",
            () -> new DreamStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1f).noCollission(), ModWoodTypes.DREAM));
    public static final RegistryObject<Block> DREAM_WALL_SIGN = BLOCKS.register("dream_wall_sign",
            () -> new DreamWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1f).noCollission(), ModWoodTypes.DREAM));
    public static final RegistryObject<Block> FRACTURED_SIGN = BLOCKS.register("fractured_sign",
            () -> new FracturedStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1f).noCollission(), ModWoodTypes.FRACTURED));
    public static final RegistryObject<Block> FRACTURED_WALL_SIGN = BLOCKS.register("fractured_wall_sign",
            () -> new FracturedWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1f).noCollission(), ModWoodTypes.FRACTURED));
    public static final RegistryObject<Block> MAPLE_SIGN = BLOCKS.register("maple_sign",
            () -> new MapleStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1f).noCollission(), ModWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_WALL_SIGN = BLOCKS.register("maple_wall_sign",
            () -> new MapleWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1f).noCollission(), ModWoodTypes.MAPLE));

    public static final RegistryObject<Block> OVERWORLD_DUNGEON_BRICKS = registerBlock("overworld_dungeon_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> OVERWORLD_DUNGEON_BRICKS_KEYHOLE = registerBlock("overworld_dungeon_bricks_keyhole",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> OVERWORLD_DUNGEON_BRICKS_KEYED = registerBlock("overworld_dungeon_bricks_keyed",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> OVERWORLD_DUNGEON_BRICKS_CRACKED = registerBlock("overworld_dungeon_bricks_cracked",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> OVERWORLD_DUNGEON_BRICKS_PILLAR = registerBlock("overworld_dungeon_bricks_pillar",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> OVERWORLD_DUNGEON_BRICKS_chiseled = registerBlock("overworld_dungeon_bricks_chiseled",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> OVERWORLD_DUNGEON_BRICK_STAIRS = registerBlock("overworld_dungeon_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.OVERWORLD_DUNGEON_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE)
                            .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> OVERWORLD_DUNGEON_BRICK_SLAB = registerBlock("overworld_dungeon_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> NETHER_DUNGEON_BRICKS = registerBlock("nether_dungeon_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> NETHER_DUNGEON_BRICKS_KEYHOLE = registerBlock("nether_dungeon_bricks_keyhole",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> NETHER_DUNGEON_BRICKS_KEYED = registerBlock("nether_dungeon_bricks_keyed",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> NETHER_DUNGEON_BRICKS_CRACKED = registerBlock("nether_dungeon_bricks_cracked",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> NETHER_DUNGEON_BRICKS_PILLAR = registerBlock("nether_dungeon_bricks_pillar",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> NETHER_DUNGEON_BRICKS_chiseled = registerBlock("nether_dungeon_bricks_chiseled",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> NETHER_DUNGEON_BRICK_STAIRS = registerBlock("nether_dungeon_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.NETHER_DUNGEON_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE)
                            .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> NETHER_DUNGEON_BRICK_SLAB = registerBlock("nether_dungeon_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> END_DUNGEON_BRICKS = registerBlock("end_dungeon_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> END_DUNGEON_BRICKS_KEYHOLE = registerBlock("end_dungeon_bricks_keyhole",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> END_DUNGEON_BRICKS_KEYED = registerBlock("end_dungeon_bricks_keyed",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> END_DUNGEON_BRICKS_CRACKED = registerBlock("end_dungeon_bricks_cracked",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> END_DUNGEON_BRICKS_PILLAR = registerBlock("end_dungeon_bricks_pillar",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> END_DUNGEON_BRICKS_CHISELED = registerBlock("end_dungeon_bricks_chiseled",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> END_DUNGEON_BRICK_STAIRS = registerBlock("end_dungeon_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.END_DUNGEON_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE)
                            .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> END_DUNGEON_BRICK_SLAB = registerBlock("end_dungeon_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> END_QUARTZ_BLOCK = registerBlock("end_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> END_QUARTZ_BLOCK_STAIRS = registerBlock("end_quartz_block_stairs",
            () -> new StairBlock(() -> ModBlocks.END_QUARTZ_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE)
                            .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> END_QUARTZ_BLOCK_SLAB = registerBlock("end_quartz_block_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> END_QUARTZ_BLOCK_CHISELED = registerBlock("end_quartz_block_chiseled",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FIERY_QUARTZ_BLOCK = registerBlock("fiery_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FIERY_QUARTZ_BLOCK_CHISELED = registerBlock("fiery_quartz_block_chiseled",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FIERY_QUARTZ_BLOCK_STAIRS = registerBlock("fiery_quartz_block_stairs",
            () -> new StairBlock(() -> ModBlocks.FIERY_QUARTZ_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE)
                            .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> FIERY_QUARTZ_BLOCK_SLAB = registerBlock("fiery_quartz_block_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> DREAMSCAPE_STONE = registerBlock("dreamscape_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAMSCAPE_DIRT = registerBlock("dreamscape_dirt",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAMSCAPE_GRASS_BLOCK = registerBlock("dreamscape_grass_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> OVERGROWN_END_STONE = registerBlock("overgrown_end_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> END_SPRING_DRAIN = registerBlock("end_spring_drain",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> CHORUS_BRICKS = registerBlock("chorus_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> CHORUS_BRICK_STAIRS = registerBlock("chorus_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.CHORUS_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE)
                            .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> CHORUS_BRICK_SLAB = registerBlock("chorus_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> ENDER_LILY = registerBlock("ender_lily",
            () -> new FlowerBlock(MobEffects.LEVITATION, 4,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> END_GRASS = registerBlock("end_grass",
            () -> new GrassBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAMSCAPE_FERN_1 = registerBlock("dreamscape_fern_1",
            () -> new GrassBlock(BlockBehaviour.Properties.copy(Blocks.FERN)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DREAMSCAPE_FERN_2 = registerBlock("dreamscape_fern_2",
            () -> new GrassBlock(BlockBehaviour.Properties.copy(Blocks.FERN)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> END_FERN_1 = registerBlock("end_fern_1",
            () -> new GrassBlock(BlockBehaviour.Properties.copy(Blocks.FERN)), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> END_FERN_2 = registerBlock("end_fern_2",
            () -> new GrassBlock(BlockBehaviour.Properties.copy(Blocks.FERN)), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> ASTEROID_WHITE = registerBlock("asteroid_white",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ASTEROID_ORANGE = registerBlock("asteroid_orange",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ASTEROID_MAGENTA = registerBlock("asteroid_magenta",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ASTEROID_LIGHT_BLUE = registerBlock("asteroid_light_blue",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ASTEROID_YELLOW = registerBlock("asteroid_yellow",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ASTEROID_LIME = registerBlock("asteroid_lime",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ASTEROID_PINK = registerBlock("asteroid_pink",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ASTEROID_GRAY = registerBlock("asteroid_gray",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ASTEROID_LIGHT_GRAY = registerBlock("asteroid_light_gray",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ASTEROID_CYAN = registerBlock("asteroid_cyan",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ASTEROID_PURPLE = registerBlock("asteroid_purple",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ASTEROID_BLUE = registerBlock("asteroid_blue",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ASTEROID_BROWN = registerBlock("asteroid_brown",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ASTEROID_GREEN = registerBlock("asteroid_green",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ASTEROID_RED = registerBlock("asteroid_red",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> ASTEROID_BLACK = registerBlock("asteroid_black",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> STAR_WHITE = registerBlock("star_white",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STAR_ORANGE = registerBlock("star_orange",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STAR_MAGENTA = registerBlock("star_magenta",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STAR_LIGHT_BLUE = registerBlock("star_light_blue",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STAR_YELLOW = registerBlock("star_yellow",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STAR_LIME = registerBlock("star_lime",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STAR_PINK = registerBlock("star_pink",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STAR_GRAY = registerBlock("star_gray",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STAR_LIGHT_GRAY = registerBlock("star_light_gray",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STAR_CYAN = registerBlock("star_cyan",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STAR_PURPLE = registerBlock("star_purple",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STAR_BLUE = registerBlock("star_blue",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STAR_BROWN = registerBlock("star_brown",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STAR_GREEN = registerBlock("star_green",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STAR_RED = registerBlock("star_red",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STAR_BLACK = registerBlock("star_black",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
