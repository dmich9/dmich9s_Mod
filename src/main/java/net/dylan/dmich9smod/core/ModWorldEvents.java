package net.dylan.dmich9smod.core;

import net.dylan.dmich9smod.common.worldgen.generation.ModGrassGeneration;
import net.dylan.dmich9smod.common.worldgen.generation.ModOreGeneration;
import net.dylan.dmich9smod.common.worldgen.generation.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = dmich9sMod.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

        ModOreGeneration.generateOres(event);
        ModTreeGeneration.generateTrees(event);
        ModGrassGeneration.generateGrass(event);
    }
}