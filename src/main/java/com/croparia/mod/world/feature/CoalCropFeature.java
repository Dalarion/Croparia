package com.croparia.mod.world.feature;

import com.croparia.mod.core.init.CropsInit;
import com.croparia.mod.world.config.PlantsConfig;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.Set;

public class CoalCropFeature extends Feature<PlantsConfig> {
	public CoalCropFeature() {
		super(PlantsConfig.CODEC);
	}

	public static final Set<BlockState> BLOCKSTATE_WHITELIST = ImmutableSet.of(
			Blocks.GRASS_BLOCK.defaultBlockState(),
			Blocks.DIRT.defaultBlockState(),
			Blocks.COARSE_DIRT.defaultBlockState()
	);

	@Override
	public boolean place(FeaturePlaceContext<PlantsConfig> context) {
		PlantsConfig config = context.config();
		ServerLevel world = context.level().getLevel();
		Random rand = context.random();
		BlockPos pos = context.origin();

		boolean any = false;
		int dist = Math.min(8, Math.max(1, config.getPatchRadius()));
		for (int i = 0; i < config.getPatchCount(); i++) {
			if (rand.nextInt(config.getPatchChance()) == 0) {
				int x = pos.getX() + rand.nextInt(16);
				int z = pos.getZ() + rand.nextInt(16);
				int y = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z);

				BlockState state = CropsInit.COAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 5);

				for (int j = 0; j < config.getPatchDensity() * config.getPatchChance(); j++) {
					int x1 = x + rand.nextInt(dist * 2) - dist;
					int y1 = y + rand.nextInt(4) - rand.nextInt(4);
					int z1 = z + rand.nextInt(dist * 2) - dist;
					BlockPos pos2 = new BlockPos(x1, y1, z1);
					if (world.isEmptyBlock(pos2) && (!world.dimensionType().hasCeiling() || y1 < 127) && BLOCKSTATE_WHITELIST.contains(world.getBlockState(pos2.below()))) {
						world.setBlock(pos2, state, 2);
						any = true;
					}
				}
			}
		}
		return any;
	}
}
