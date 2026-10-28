package net.dylan.dmich9smod.common.worldgen.features;

import com.mojang.serialization.Codec;
import net.dylan.dmich9smod.init.TemplatePoolConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.Optional;
import java.util.Random;

public class TemplatePoolFeature extends Feature<TemplatePoolConfig> {

    // Raise this to bury the base of the tree in the ground, lower it to float it.
    private static final int Y_OFFSET = 0;

    public TemplatePoolFeature(Codec<TemplatePoolConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<TemplatePoolConfig> ctx) {
        WorldGenLevel level = ctx.level();
        BlockPos origin = ctx.origin();
        Random random = ctx.random();
        TemplatePoolConfig cfg = ctx.config();

        if (cfg.structures().isEmpty()) return false;

        // Solid ground check: sturdy block below, and the spot itself is empty or replaceable
        BlockPos below = origin.below();
        BlockState ground = level.getBlockState(below);
        if (!ground.isFaceSturdy(level, below, Direction.UP)) return false;
        if (!level.getBlockState(origin).getMaterial().isReplaceable()) return false;
        if (!level.getFluidState(origin).isEmpty()) return false;

        // Weighted pick
        int total = 0;
        for (TemplatePoolConfig.Entry e : cfg.structures()) total += e.weight();
        int roll = random.nextInt(total);
        TemplatePoolConfig.Entry chosen = cfg.structures().get(0);
        for (TemplatePoolConfig.Entry e : cfg.structures()) {
            roll -= e.weight();
            if (roll < 0) { chosen = e; break; }
        }

        Optional<StructureTemplate> opt = level.getLevel().getStructureManager().get(chosen.data());
        if (opt.isEmpty()) return false; // file missing: nothing placed
        StructureTemplate template = opt.get();

        // Rotate around the horizontal center so the trunk stays at the origin
        BlockPos size = new BlockPos(template.getSize());
        BlockPos pivot = new BlockPos(size.getX() / 2, 0, size.getZ() / 2);

        // Writes outside the 3x3 chunks around the origin are not allowed during worldgen,
        // so clip to that area. Very wide trees are cut off at the edge instead of causing errors.
        ChunkPos chunk = new ChunkPos(origin);
        BoundingBox clip = new BoundingBox(
                chunk.getMinBlockX() - 16, level.getMinBuildHeight(), chunk.getMinBlockZ() - 16,
                chunk.getMaxBlockX() + 16, level.getMaxBuildHeight() - 1, chunk.getMaxBlockZ() + 16);

        StructurePlaceSettings settings = new StructurePlaceSettings()
                .setRotation(Rotation.getRandom(random))
                .setMirror(Mirror.NONE)
                .setRotationPivot(pivot)
                .setBoundingBox(clip)
                .setRandom(random)
                .setIgnoreEntities(true)
                // leave existing terrain where the tree file has air, and skip structure blocks
                .addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);

        // processors from the JSON ("minecraft:empty" adds none)
        cfg.processors().value().list().forEach(settings::addProcessor);

        BlockPos pos = origin.offset(-pivot.getX(), Y_OFFSET, -pivot.getZ());
        return template.placeInWorld(level, pos, pos, settings, random, 2);
    }
}