package net.dylan.dmich9smod.common.events;

import net.dylan.dmich9smod.api.TonisHelper;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.dylan.dmich9smod.init.ModEffects;
import net.dylan.dmich9smod.init.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = dmich9sMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EffectEvents {

    @SubscribeEvent
    public static void onTravelDimension(EntityTravelToDimensionEvent event){
        if(event.getEntity() instanceof LivingEntity){
            LivingEntity living = (LivingEntity) event.getEntity();
            if(living.hasEffect(ModEffects.STRANDED.get())){

                /*Basically just tells the entity no when they try to change dimensions.
                 * You can add more conditions if need be like letting the player through if they're in creative.*/

                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void pickUpXP(PlayerXpEvent.PickupXp event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if(player.hasEffect(ModEffects.PROSPERITY.get())){
                MobEffectInstance effect = player.getEffect(ModEffects.PROSPERITY.get());
                int amplifier = effect.getAmplifier();

                /*Changes the value of xp gained here.
                 * If the amplifier is 1 the player would get 1.5x more xp.*/

                event.getOrb().value = event.getOrb().value * (1 + (amplifier/2)) ;
            }
        }
    }

    static int timer = 0;

    @SubscribeEvent
    public static void entityTick(LivingEvent.LivingUpdateEvent event) {

        LivingEntity entity = (LivingEntity) event.getEntity();

        if (entity.level.getBlockStatesIfLoaded(event.getEntity().getBoundingBox().deflate(1.0E-6D)).anyMatch((p_20127_) -> p_20127_.is(ModFluids.SPRING_BLOCK.get()))) {
            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 5, 3, true, true));
        }

        if (entity.hasEffect(ModEffects.FURY.get())) {

            if(Mth.randomBetweenInclusive(new Random(), 10, 35) == 25) {
                BlockPos targetPos = entity.blockPosition();
                EntityType entityType = TonisHelper.randomEntity();
                BlockPos spawnPos = TonisHelper.findOnGroundSpawnLocation(entity.level, entityType, targetPos, 20);

                if (spawnPos != null)
                {
                    boolean canSpawnInBiome = Biome.getBiomeCategory(entity.level.getBiome(targetPos)) != Biome.BiomeCategory.OCEAN;

                    if(entity.level instanceof ServerLevel){

                        //int brightness = entity.level.getBrightness(LightLayer.BLOCK, targetPos.above(1));

                        Boolean canSpawnInPose = Monster.checkMonsterSpawnRules(entityType, (ServerLevel) entity.level, MobSpawnType.NATURAL, spawnPos, entity.level.random);
                        if (canSpawnInBiome && canSpawnInPose)
                        {
                            entityType.spawn((ServerLevel) entity.level, (CompoundTag) null, (Component) null, (Player) null, spawnPos, MobSpawnType.NATURAL, false, false);
                        }
                    }
                }
            }
        }
    }



}