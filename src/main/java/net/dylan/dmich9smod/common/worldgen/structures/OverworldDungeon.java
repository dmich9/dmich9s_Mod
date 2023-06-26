package net.dylan.dmich9smod.common.worldgen.structures;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.QuartPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.MineshaftConfiguration;
import net.minecraft.world.level.levelgen.structure.BuiltinStructureSets;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.PostPlacementProcessor;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import java.util.Optional;

public class OverworldDungeon extends StructureFeature<JigsawConfiguration> {

    public OverworldDungeon(final Codec<JigsawConfiguration> codec) {
        // Create the pieces layout of the structure and give it to the game
        super(codec, OverworldDungeon::createPiecesGenerator, PostPlacementProcessor.NONE);
    }
    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    private static boolean isFeatureChunk(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
            WorldgenRandom worldgenrandom = new WorldgenRandom(new LegacyRandomSource(0L));
            worldgenrandom.setLargeFeatureSeed(context.seed(), context.chunkPos().x, context.chunkPos().z);
            double failureChance = 0.25D;
            final Vec3i pos = new Vec3i(QuartPos.fromBlock(context.chunkPos().getMiddleBlockX()), QuartPos.fromBlock(50), QuartPos.fromBlock(context.chunkPos().getMiddleBlockZ()));
            return (worldgenrandom.nextDouble() >= failureChance) && context.validBiome().test(context.chunkGenerator().getNoiseBiome(pos.getX(), pos.getY(), pos.getZ()));
    }

    public static Optional<PieceGenerator<JigsawConfiguration>> createPiecesGenerator(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
        if (!OverworldDungeon.isFeatureChunk(context)) {
            return Optional.empty();
        }
        BlockPos blockpos = context.chunkPos().getMiddleBlockPosition(0);
        int topLandY = context.chunkGenerator().getFirstFreeHeight(blockpos.getX(), blockpos.getZ(),
                Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor());
        blockpos = blockpos.above(topLandY + 60);

        Optional<PieceGenerator<JigsawConfiguration>> structurePiecesGenerator =
                JigsawPlacement.addPieces(
                        context, // Used for JigsawPlacement to get all the proper behaviors done.
                        PoolElementStructurePiece::new, // Needed in order to create a list of jigsaw pieces when making the structure's layout.
                        blockpos, // Position of the structure. Y value is ignored if last parameter is set to true.
                        false,  // Special boundary adjustments for villages. It's... hard to explain. Keep this false and make your pieces not be partially intersecting.
                        // Either not intersecting or fully contained will make children pieces spawn just fine. It's easier that way.
                        false // Place at heightmap (top land). Set this to false for structure to be place at the passed in blockpos's Y value instead.
                        // Definitely keep this false when placing structures in the nether as otherwise, heightmap placing will put the structure on the Bedrock roof.
                );

        if(structurePiecesGenerator.isPresent()) {
            LogManager.getLogger().log(Level.DEBUG, "Overworld Dungeon at {}", blockpos);
        }
        return structurePiecesGenerator;
    }
}