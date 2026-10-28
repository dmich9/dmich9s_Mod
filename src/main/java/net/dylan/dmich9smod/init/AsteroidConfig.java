package net.dylan.dmich9smod.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record AsteroidConfig(int minRadius, int maxRadius) implements FeatureConfiguration {
    public static final Codec<AsteroidConfig> CODEC = RecordCodecBuilder.create(i -> i.group(
            Codec.intRange(1, 15).fieldOf("min_radius").forGetter(AsteroidConfig::minRadius),
            Codec.intRange(1, 15).fieldOf("max_radius").forGetter(AsteroidConfig::maxRadius)
    ).apply(i, AsteroidConfig::new));
}