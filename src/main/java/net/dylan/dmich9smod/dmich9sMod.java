package net.dylan.dmich9smod;

import com.mojang.logging.LogUtils;
import net.dylan.dmich9smod.block.ModBlocks;
import net.dylan.dmich9smod.block.ModWoodTypes;
import net.dylan.dmich9smod.block.entity.ModBlockEntities;
import net.dylan.dmich9smod.entity.ModEntityTypes;
import net.dylan.dmich9smod.entity.client.ModBoatRenderer;
import net.dylan.dmich9smod.fluid.ModFluids;
import net.dylan.dmich9smod.item.ModItems;
import net.dylan.dmich9smod.sound.ModSounds;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(dmich9sMod.MOD_ID)
public class dmich9sMod
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "dmich9smod";

    public dmich9sMod()
    {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModFluids.register(eventBus);
        ModSounds.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModEntityTypes.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRAGONFRUIT_CROP.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANGUISH_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANGUISH_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIGHT_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIGHT_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FRIGHT_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FRIGHT_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DREAM_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DREAM_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FRACTURED_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FRACTURED_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAPLE_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAPLE_TRAPDOOR.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANGUISH_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FRIGHT_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIGHT_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DREAM_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FRACTURED_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAPLE_LEAVES_YELLOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAPLE_LEAVES_ORANGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAPLE_LEAVES_RED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DREAM_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANGUISH_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FRIGHT_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MIGHT_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FRACTURED_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAPLE_SAPLING_YELLOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAPLE_SAPLING_ORANGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAPLE_SAPLING_RED.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.END_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ENDER_LILY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DREAMSCAPE_FERN_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DREAMSCAPE_FERN_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.END_FERN_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.END_FERN_2.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModFluids.SPRING_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.SPRING_WATER_FLUID.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.SPRING_WATER_FLOWING.get(), RenderType.translucent());

        WoodType.register(ModWoodTypes.ANGUISH);
        WoodType.register(ModWoodTypes.FRIGHT);
        WoodType.register(ModWoodTypes.MIGHT);
        WoodType.register(ModWoodTypes.DREAM);
        WoodType.register(ModWoodTypes.FRACTURED);
        WoodType.register(ModWoodTypes.MAPLE);
        BlockEntityRenderers.register(ModBlockEntities.ANGUISH_SIGN_BLOCK_ENTITY.get(), SignRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.FRIGHT_SIGN_BLOCK_ENTITY.get(), SignRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.MIGHT_SIGN_BLOCK_ENTITY.get(), SignRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.DREAM_SIGN_BLOCK_ENTITY.get(), SignRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.FRACTURED_SIGN_BLOCK_ENTITY.get(), SignRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.MAPLE_SIGN_BLOCK_ENTITY.get(), SignRenderer::new);
        EntityRenderers.register(ModEntityTypes.BOAT_ENTITY.get(), ModBoatRenderer::new);
    }
    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItems.DRAGONFRUIT_SEEDS.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModItems.DRAGONFRUIT.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.ANGUISH_LEAVES.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.FRIGHT_LEAVES.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.MIGHT_LEAVES.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.DREAM_LEAVES.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.FRACTURED_LEAVES.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.MAPLE_LEAVES_YELLOW.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.MAPLE_LEAVES_ORANGE.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.MAPLE_LEAVES_RED.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.ANGUISH_SAPLING.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.FRIGHT_SAPLING.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.MIGHT_SAPLING.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.DREAM_SAPLING.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.FRACTURED_SAPLING.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.MAPLE_SAPLING_YELLOW.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.MAPLE_SAPLING_ORANGE.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.MAPLE_SAPLING_RED.get().asItem(), 0.30f);

            Sheets.addWoodType(ModWoodTypes.ANGUISH);
            Sheets.addWoodType(ModWoodTypes.FRIGHT);
            Sheets.addWoodType(ModWoodTypes.MIGHT);
            Sheets.addWoodType(ModWoodTypes.DREAM);
            Sheets.addWoodType(ModWoodTypes.FRACTURED);
            Sheets.addWoodType(ModWoodTypes.MAPLE);
        });
    }
}
