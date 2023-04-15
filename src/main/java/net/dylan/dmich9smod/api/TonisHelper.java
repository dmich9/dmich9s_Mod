package net.dylan.dmich9smod.api;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.entity.SpawnPlacements;


import javax.annotation.Nullable;
import java.util.Random;

public class TonisHelper {

    public static BlockPos findOnGroundSpawnLocation(Level world, EntityType type, BlockPos spawnLocation, int radius)
    {
        return findOnGroundSpawnLocation(world, type, spawnLocation, radius, 0);
    }

    @Nullable
    public static BlockPos findOnGroundSpawnLocation(Level world, EntityType type, BlockPos spawnLocation, int radius, int offset)
    {
        BlockPos blockpos = null;
        for (int i = 0; i < 10; ++i)
        {
            int x = (int) TonisHelper.randomWithRange((spawnLocation.getX() - offset) - radius, (spawnLocation.getX() + offset) + radius);
            int z = (int) TonisHelper.randomWithRange((spawnLocation.getZ() - offset) - radius, (spawnLocation.getZ() + offset) + radius);
            int y = world.getHeight(Heightmap.Types.WORLD_SURFACE, x, z);
            BlockPos blockpos1 = new BlockPos(x, y, z);
            if (NaturalSpawner.canSpawnAtBody(SpawnPlacements.Type.ON_GROUND, world, blockpos1, type))
            {
                blockpos = blockpos1;
                break;
            }
        }

        return blockpos;
    }

    public static double randomWithRange(int min, int max)
    {
        return new Random().nextInt(max + 1 - min) + min;
    }

    public static double randomWithRange(Random rand, int min, int max)
    {
        return rand.nextInt(max + 1 - min) + min;
    }


    public static EntityType randomEntity () {
        int rand = Mth.randomBetweenInclusive(new Random(), 1, 5);
        switch (rand) {
            case 1 -> {
                return EntityType.ZOMBIE;
            }
            case 2 -> {
                return EntityType.SKELETON;
            }
            case 3 -> {
                return EntityType.SPIDER;
            }
            case 4 -> {
                return EntityType.CREEPER;
            }
            case 5 -> {
                return EntityType.ENDERMAN;
            }
        }
        return EntityType.ZOMBIE;
    }

}
