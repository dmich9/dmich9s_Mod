package net.dylan.dmich9smod.common.worldgen.biomes;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.RegionType;

import java.util.List;
import java.util.function.Consumer;

public class RegionData extends terrablender.api.Region {
    // this class changes the chances of the biome spawning in the world


    public RegionData(ResourceLocation name, int weight)
    {
        super(name, RegionType.OVERWORLD, weight);
    }

    /**
     * This whole method actively adds the custom biomes to the world;
     * There are a lot of ways to add biomes to the world from very simple (see the first method used to spawn the maple forest) to highly customizable like the dreamscape biome;
     * The best advice I could give as user of this code is to tinker around with it and test it a lot until you feel like the biome generates well;
     * You can always do the easy way and use the first method as shown to spawn the biomes more easily (you will definitely have less control over it then though);
     */
    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
    {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            // if a forest biome could spawn, there is a chance it's a maple forest (very basic implementation)
            builder.replaceBiome(Biomes.FOREST, BiomesData.MAPLE_FOREST);

            // this is a highly customized way to spawn the dreamscape biome
            List<Climate.ParameterPoint> dreamScapeBiome = new ParameterUtils.ParameterPointListBuilder()
                    .temperature(ParameterUtils.Temperature.NEUTRAL, ParameterUtils.Temperature.COOL, ParameterUtils.Temperature.WARM)
                    .humidity(ParameterUtils.Humidity.ARID, ParameterUtils.Humidity.DRY, ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.WET, ParameterUtils.Humidity.HUMID)
                    .continentalness(ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.COAST, ParameterUtils.Continentalness.FAR_INLAND), ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.MID_INLAND, ParameterUtils.Continentalness.FAR_INLAND))
                    .erosion(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_1)
                    .depth(ParameterUtils.Depth.SURFACE, ParameterUtils.Depth.FLOOR)
                    .weirdness(ParameterUtils.Weirdness.HIGH_SLICE_VARIANT_ASCENDING, ParameterUtils.Weirdness.PEAK_VARIANT, ParameterUtils.Weirdness.HIGH_SLICE_VARIANT_DESCENDING)
                    .build();

            dreamScapeBiome.forEach(point -> builder.replaceBiome(point, BiomesData.DREAMSCAPE));



        });
    }
}
