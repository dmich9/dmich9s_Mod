package net.dylan.dmich9smod.common.worldgen.features;

import com.mojang.serialization.Codec;
import net.dylan.dmich9smod.common.worldgen.features.configuration.WeightedTemplateFeatureConfiguration;
import net.dylan.dmich9smod.core.dmich9sMod;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProtectedBlockProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.Optional;

public class TemplatePoolFeature extends Feature<WeightedTemplateFeatureConfiguration> {

    public TemplatePoolFeature(final Codec<WeightedTemplateFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<WeightedTemplateFeatureConfiguration> context) {
        // rotation / mirror
        Mirror mirror = Mirror.NONE;
        Rotation rotation = Rotation.getRandom(context.random());

        // tree variant
        final Optional<ResourceLocation> oStructureId = context.config().structures.getRandomValue(context.random());
        if(oStructureId.isEmpty()) {
            dmich9sMod.LOGGER.error("Failed to load a random structure from config: " + context.config().structures);
        }

        // template for tree
        final StructureManager manager = context.level().getLevel().getStructureManager();
        final StructureTemplate template = manager.getOrCreate(oStructureId.get());

        // position for tree
        final int xWidth = template.getSize().getX() / 2;
        final int zWidth = template.getSize().getZ() / 2;
        final BlockPos offset = new BlockPos(-xWidth, 0, -zWidth);
        BlockPos pos = context.origin().offset(offset.rotate(rotation));

        // placement settings
        BoundingBox mbb = new BoundingBox(pos.getX() - xWidth - 8, pos.getY() - 16, pos.getZ() - zWidth - 8,
                pos.getX() + xWidth + 8, pos.getY() + template.getSize().getY() + 16, pos.getZ() + zWidth + 8);
        StructurePlaceSettings placement = new StructurePlaceSettings()
                .setRotation(rotation).setMirror(mirror).setRandom(context.random()).setBoundingBox(mbb)
                .addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR)
                .addProcessor(new ProtectedBlockProcessor(BlockTags.FEATURES_CANNOT_REPLACE));
        context.config().processors.value().list().forEach(placement::addProcessor);
        // actually build using the template
        template.placeInWorld(context.level(), pos, pos, placement, context.random(), 2);
        return true;
    }
}
