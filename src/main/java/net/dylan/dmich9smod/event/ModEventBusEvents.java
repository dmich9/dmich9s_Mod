package net.dylan.dmich9smod.event;

import net.dylan.dmich9smod.dmich9sMod;
import net.dylan.dmich9smod.particle.ModParticles;
import net.dylan.dmich9smod.particle.custom.EndTorchParticles;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = dmich9sMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                   event) {
        event.getRegistry().registerAll(

        );
    }
    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.END_TORCH_PARTICLES.get(), EndTorchParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NETHER_TORCH_PARTICLES.get(), EndTorchParticles.Provider::new);

    }

}
