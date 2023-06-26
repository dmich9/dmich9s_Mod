package net.dylan.dmich9smod.common.worldgen.features.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class WeightedTemplateFeatureConfiguration implements FeatureConfiguration {
    public static final Codec<WeightedTemplateFeatureConfiguration> CODEC = RecordCodecBuilder.create((instance) ->
        instance.group(
            SimpleWeightedRandomList.wrappedCodec(ResourceLocation.CODEC).fieldOf("structures").forGetter((o) -> o.structures),
            StructureProcessorType.LIST_CODEC.fieldOf("processors").forGetter((o) -> o.processors)
        ).apply(instance, WeightedTemplateFeatureConfiguration::new));

    public final SimpleWeightedRandomList<ResourceLocation> structures;
    public final Holder<StructureProcessorList> processors;

    public WeightedTemplateFeatureConfiguration(SimpleWeightedRandomList<ResourceLocation> structures, Holder<StructureProcessorList> processors) {
        this.structures = structures;
        this.processors = processors;
    }
}
