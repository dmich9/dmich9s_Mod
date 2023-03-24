package net.dylan.dmich9smod.world;
import net.dylan.dmich9smod.dmich9sMod;
import net.dylan.dmich9smod.world.gen.ModOreGeneration;
import net.dylan.dmich9smod.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = dmich9sMod.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

        ModOreGeneration.generateOres(event);
        ModTreeGeneration.generateTrees(event);
    }
}