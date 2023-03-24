package net.dylan.dmich9smod.fluid;
import net.dylan.dmich9smod.dmich9sMod;
import net.dylan.dmich9smod.block.ModBlocks;
import net.dylan.dmich9smod.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, dmich9sMod.MOD_ID);


    public static final RegistryObject<FlowingFluid> SPRING_WATER_FLUID
            = FLUIDS.register("spring_water_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.SPRING_WATER_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SPRING_WATER_FLOWING
            = FLUIDS.register("spring_water_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.SPRING_WATER_PROPERTIES));


    public static final ForgeFlowingFluid.Properties SPRING_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
            SPRING_WATER_FLUID, SPRING_WATER_FLOWING, FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.HONEY_DRINK).overlay(WATER_OVERLAY_RL)
            .color(0x14fff3)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModFluids.SPRING_BLOCK).bucket(ModItems.SPRING_WATER_BUCKET);

    public static final RegistryObject<LiquidBlock> SPRING_BLOCK = ModBlocks.BLOCKS.register("spring",
            () -> new LiquidBlock(ModFluids.SPRING_WATER_FLUID, BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));
    //FlowingFluidBlock
    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}