package net.dylan.dmich9smod.common.worldgen.biomes;

import net.dylan.dmich9smod.init.ModBlocksAndItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;

import static net.minecraft.world.level.levelgen.SurfaceRules.isBiome;

public class SurfaceRuleData {
    /**
     * This class chooses what will be on and under the ground in certain biomes
     */


    private static final SurfaceRules.RuleSource DREAMSCAPE_DIRT = makeStateRule(ModBlocksAndItems.DREAMSCAPE_DIRT.get());
    private static final SurfaceRules.RuleSource DREAMSCAPE_GRASS_BLOCK = makeStateRule(ModBlocksAndItems.DREAMSCAPE_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource DREAMSCAPE_STONE = makeStateRule(ModBlocksAndItems.DREAMSCAPE_STONE.get());

    /**
     * this method makes the rules and applies them to what block can be where
     *
     */
    public static SurfaceRules.RuleSource makeRules()
    {
        // these 2 lines of code under this comment are just to make sure there's a block; this is just a failsafe
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ifTrue(isAtOrAboveWaterLevel, DREAMSCAPE_GRASS_BLOCK);
        // condition that we use later to check if we're setting blocks in the dreamscape biome; just make another method with another biome and replicate the code to have the same effect
        SurfaceRules.ConditionSource inDreamScape = isBiome(BiomesData.DREAMSCAPE);


        return SurfaceRules.sequence(
                // example for the first method under this comment:
                // if the block is on the floor and it is in the dreamscape biome, put a dreamscape grass block
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(inDreamScape, DREAMSCAPE_GRASS_BLOCK)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.ifTrue(inDreamScape, DREAMSCAPE_DIRT)),
                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SurfaceRules.ifTrue(inDreamScape, DREAMSCAPE_STONE)),
                SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SurfaceRules.ifTrue(inDreamScape, DREAMSCAPE_STONE))

        );
    }


    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }
}