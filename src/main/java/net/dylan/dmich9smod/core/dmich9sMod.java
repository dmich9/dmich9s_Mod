package net.dylan.dmich9smod.core;

import com.mojang.logging.LogUtils;
//import net.dylan.dmich9smod.common.worldgen.ModStructures;
import net.dylan.dmich9smod.client.renderer.*;
import net.dylan.dmich9smod.common.util.ModPOIs;
import net.dylan.dmich9smod.common.worldgen.biomes.RegionData;
import net.dylan.dmich9smod.common.worldgen.biomes.SurfaceRuleData;
import net.dylan.dmich9smod.common.worldgen.dimension.ModDimensions;
import net.dylan.dmich9smod.init.*;
import net.dylan.dmich9smod.init.ModWoodTypes;
import net.dylan.dmich9smod.init.ModBlockEntities;
import net.dylan.dmich9smod.init.ModEntityTypes;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(dmich9sMod.MOD_ID)
public class dmich9sMod
{
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "dmich9smod";

    public dmich9sMod()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEffects.MOB_EFFECTS.register(eventBus);
        ModPotions.register(eventBus);
        ModParticles.register(eventBus);
        ModDimensions.register();
        ModPOIs.register(eventBus);
        ModFluids.register(eventBus);
        ModSounds.register(eventBus);
        ModPaintings.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModFeatures.register(eventBus);
        ModStructures.register(eventBus);
        ModDimensions.register();
        ModBlocksAndItems.register(eventBus);
        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.DRAGONFRUIT_CROP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.DURIAN_CROP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.STARFRUIT_CROP.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.END_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.NETHER_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.DUNGEON_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.FRACTURED_REALITY_PORTAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.DREAMSCAPE_OVERGROWTH.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.ANGUISH_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.ANGUISH_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.MIGHT_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.MIGHT_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.FRIGHT_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.FRIGHT_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.DREAM_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.DREAM_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.FRACTURED_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.FRACTURED_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.MAPLE_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.MAPLE_TRAPDOOR.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.ANGUISH_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.FRIGHT_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.MIGHT_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.DREAM_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.FRACTURED_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.MAPLE_LEAVES_YELLOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.MAPLE_LEAVES_ORANGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.MAPLE_LEAVES_RED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.DREAM_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.ANGUISH_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.FRIGHT_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.MIGHT_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.FRACTURED_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.MAPLE_SAPLING_YELLOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.MAPLE_SAPLING_ORANGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.MAPLE_SAPLING_RED.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.DREAMSCAPE_FERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.DREAMSCAPE_BUCKWEED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.DREAMSCAPE_TORNBELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.DREAMSCAPE_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.DREAMSCAPE_TALL_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.DREAMSCAPE_OXALLIS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.END_FERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.END_RAGWEED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.ENDER_LILY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.ENDERS_DELIGHT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.END_DEATHTOLL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.END_NIGHTSHADE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.END_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksAndItems.END_TALL_GRASS.get(), RenderType.cutout());

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
        EntityRenderers.register(ModEntityTypes.CORRUPTED_ZOMBIE.get(), CorruptedZombieRenderer::new);
        EntityRenderers.register(ModEntityTypes.THUNDERBIRD.get(), ThunderbirdRenderer::new);
        EntityRenderers.register(ModEntityTypes.FRACTURED_WANDERER.get(), FracturedWandererRenderer::new);
        EntityRenderers.register(ModEntityTypes.SAND_ELEMENTAL.get(), SandElementalRenderer::new);
        EntityRenderers.register(ModEntityTypes.CRYSTAL_GOLEM.get(), CrystalGolemRenderer::new);
        EntityRenderers.register(ModEntityTypes.SAND_BALL.get(), SandBallRenderer::new);
    }
    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.DRAGONFRUIT_SEEDS.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.DRAGONFRUIT.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.DURIAN_SEEDS.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.DURIAN.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.STARFRUIT_SEEDS.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.STARFRUIT.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.ANGUISH_LEAVES.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.FRIGHT_LEAVES.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.MIGHT_LEAVES.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.DREAM_LEAVES.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.FRACTURED_LEAVES.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.MAPLE_LEAVES_YELLOW.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.MAPLE_LEAVES_ORANGE.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.MAPLE_LEAVES_RED.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.ANGUISH_SAPLING.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.FRIGHT_SAPLING.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.MIGHT_SAPLING.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.DREAM_SAPLING.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.FRACTURED_SAPLING.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.MAPLE_SAPLING_YELLOW.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.MAPLE_SAPLING_ORANGE.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.MAPLE_SAPLING_RED.get().asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.DREAMSCAPE_FERN.get().asItem(), 0.70f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.DREAMSCAPE_BUCKWEED.get().asItem(), 0.70f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.DREAMSCAPE_TORNBELL.get().asItem(), 0.70f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.DREAMSCAPE_GRASS.get().asItem(), 0.70f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.DREAMSCAPE_TALL_GRASS.get().asItem(), 0.70f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.DREAMSCAPE_OXALLIS.get().asItem(), 0.70f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.END_FERN.get().asItem(), 0.70f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.END_RAGWEED.get().asItem(), 0.70f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.ENDER_LILY.get().asItem(), 0.70f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.ENDERS_DELIGHT.get().asItem(), 0.70f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.END_DEATHTOLL.get().asItem(), 0.70f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.END_NIGHTSHADE.get().asItem(), 0.70f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.END_GRASS.get().asItem(), 0.70f);
            ComposterBlock.COMPOSTABLES.put(ModBlocksAndItems.END_TALL_GRASS.get().asItem(), 0.70f);

            Sheets.addWoodType(ModWoodTypes.ANGUISH);
            Sheets.addWoodType(ModWoodTypes.FRIGHT);
            Sheets.addWoodType(ModWoodTypes.MIGHT);
            Sheets.addWoodType(ModWoodTypes.DREAM);
            Sheets.addWoodType(ModWoodTypes.FRACTURED);
            Sheets.addWoodType(ModWoodTypes.MAPLE);
            Regions.register(new RegionData(new ResourceLocation(MOD_ID, "overworld"), 2));
            
            // Register our surface rules
            SurfaceRules.RuleSource overworldSurfaceRules = SurfaceRuleData.makeRules(); // Get the surface rules for the overworld
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, overworldSurfaceRules); // Add the overworld surface rules


        });
    }
}