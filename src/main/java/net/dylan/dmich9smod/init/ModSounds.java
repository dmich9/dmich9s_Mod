package net.dylan.dmich9smod.init;

import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, dmich9sMod.MOD_ID);

    public static RegistryObject<SoundEvent> ASTEROID_FIELD = registerSoundEvents("asteroid_field");
    public static RegistryObject<SoundEvent> FRACTURED_FOREST = registerSoundEvents("fractured_forest");
    public static RegistryObject<SoundEvent> DREAMSCAPE = registerSoundEvents("dreamscape");
    public static RegistryObject<SoundEvent> END_SPRINGS = registerSoundEvents("end_springs");
    public static RegistryObject<SoundEvent> MINI_DUNGEON = registerSoundEvents("mini_dungeon");
    public static RegistryObject<SoundEvent> OVERWORLD_DUNGEON = registerSoundEvents("overworld_dungeon");
    public static RegistryObject<SoundEvent> NETHER_DUNGEON = registerSoundEvents("nether_dungeon");
    public static RegistryObject<SoundEvent> END_DUNGEON = registerSoundEvents("end_dungeon");
    public static RegistryObject<SoundEvent> BOSS = registerSoundEvents("boss");
    public static RegistryObject<SoundEvent> FINAL_BOSS = registerSoundEvents("final_boss");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        ResourceLocation id = new ResourceLocation(dmich9sMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> new SoundEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}