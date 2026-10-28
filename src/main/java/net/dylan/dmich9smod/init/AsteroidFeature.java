package net.dylan.dmich9smod.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.Random;

public class AsteroidFeature extends Feature<AsteroidConfig> {

    public AsteroidFeature(Codec<AsteroidConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<AsteroidConfig> ctx) {
        WorldGenLevel level = ctx.level();
        BlockPos origin = ctx.origin();
        Random random = ctx.random();
        AsteroidConfig cfg = ctx.config();

        // pick one of the 16 colored asteroid blocks
        BlockState state = ModBlocksAndItems.ASTEROIDS
                .get(random.nextInt(ModBlocksAndItems.ASTEROIDS.size()))
                .get().defaultBlockState();

        // base radius, then squash each axis so asteroids aren't perfect spheres
        float r = cfg.minRadius() + random.nextFloat() * (cfg.maxRadius() - cfg.minRadius());
        float rx = Math.max(1f, r * (0.7f + 0.3f * random.nextFloat()));
        float ry = Math.max(1f, r * (0.7f + 0.3f * random.nextFloat()));
        float rz = Math.max(1f, r * (0.7f + 0.3f * random.nextFloat()));

        int reach = (int) Math.ceil(Math.max(rx, Math.max(ry, rz)));
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        boolean placed = false;

        for (int dx = -reach; dx <= reach; dx++) {
            for (int dy = -reach; dy <= reach; dy++) {
                for (int dz = -reach; dz <= reach; dz++) {
                    float d = (dx * dx) / (rx * rx) + (dy * dy) / (ry * ry) + (dz * dz) / (rz * rz);
                    // random edge threshold gives a rough, rocky surface
                    if (d > 1.0f - random.nextFloat() * 0.3f) continue;

                    pos.set(origin.getX() + dx, origin.getY() + dy, origin.getZ() + dz);
                    if (level.isOutsideBuildHeight(pos)) continue;
                    if (!level.getBlockState(pos).isAir()) continue; // don't overwrite other asteroids

                    level.setBlock(pos, state, 2);
                    placed = true;
                }
            }
        }
        return placed;
    }
}