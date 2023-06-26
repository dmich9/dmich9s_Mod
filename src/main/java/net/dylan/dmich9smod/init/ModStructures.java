package net.dylan.dmich9smod.init;

import net.dylan.dmich9smod.common.worldgen.structures.OverworldDungeon;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModStructures {
    public static final DeferredRegister<StructureFeature<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, dmich9sMod.MOD_ID);

    public static RegistryObject<OverworldDungeon> OVERWORLD_DUNGEON = STRUCTURES.register("overworld_dungeon", () ->
            new OverworldDungeon(JigsawConfiguration.CODEC));

    public static void register (IEventBus eventBus) {
        STRUCTURES.register(eventBus);
    }


}
