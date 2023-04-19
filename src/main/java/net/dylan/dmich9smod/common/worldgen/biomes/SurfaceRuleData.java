package net.dylan.dmich9smod.common.worldgen.biomes;

import net.dylan.dmich9smod.init.ModBlocksAndItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;

import static net.minecraft.world.level.levelgen.SurfaceRules.isBiome;

public class SurfaceRuleData {
    private static final SurfaceRules.RuleSource DREAMSCAPE_DIRT = makeStateRule(ModBlocksAndItems.DREAMSCAPE_DIRT.get());
    private static final SurfaceRules.RuleSource DREAMSCAPE_GRASS_BLOCK = makeStateRule(ModBlocksAndItems.DREAMSCAPE_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource DREAMSCAPE_STONE = makeStateRule(ModBlocksAndItems.DREAMSCAPE_STONE.get());
    private static final SurfaceRules.RuleSource DREAMSCAPE_GRASS = makeStateRule(ModBlocksAndItems.DREAMSCAPE_GRASS.get());

    public static SurfaceRules.RuleSource makeRules()
    {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        //SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DREAMSCAPE_DIRT);
        //SurfaceRules.RuleSource aboveGrassBlock = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, DREAMSCAPE_GRASS_BLOCK), DREAMSCAPE_GRASS);
        //SurfaceRules.ConditionSource check = SurfaceRules.
        SurfaceRules.ifTrue(isAtOrAboveWaterLevel, DREAMSCAPE_GRASS_BLOCK);
        SurfaceRules.ConditionSource inDreamScape = isBiome(BiomesData.DREAMSCAPE);


            return SurfaceRules.sequence(
                    //SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomesData.DREAMSCAPE), DREAMSCAPE_GRASS_BLOCK),
                    //SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, DREAMSCAPE_GRASS_BLOCK),
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
