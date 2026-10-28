package net.dylan.dmich9smod.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

import java.util.List;

public record TemplatePoolConfig(Holder<StructureProcessorList> processors, List<Entry> structures)
        implements FeatureConfiguration {

    public record Entry(ResourceLocation data, int weight) {
        public static final Codec<Entry> CODEC = RecordCodecBuilder.create(i -> i.group(
                ResourceLocation.CODEC.fieldOf("data").forGetter(Entry::data),
                Codec.intRange(1, 10000).optionalFieldOf("weight", 1).forGetter(Entry::weight)
        ).apply(i, Entry::new));
    }

    public static final Codec<TemplatePoolConfig> CODEC = RecordCodecBuilder.create(i -> i.group(
            StructureProcessorType.LIST_CODEC.fieldOf("processors").forGetter(TemplatePoolConfig::processors),
            Entry.CODEC.listOf().fieldOf("structures").forGetter(TemplatePoolConfig::structures)
    ).apply(i, TemplatePoolConfig::new));
}