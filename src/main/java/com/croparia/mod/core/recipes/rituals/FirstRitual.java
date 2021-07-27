package com.croparia.mod.core.recipes.rituals;

import com.croparia.mod.common.blocks.CropariaCrops;
import com.croparia.mod.core.init.BlockInit;
import com.croparia.mod.core.init.CropsInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FirstRitual extends RitualUtils
{
	public static boolean checkRitual(BlockState blockNeed, Level worldIn, BlockPos pos, boolean bypass)
	{
		if(getBlock(BlockInit.ELEMENTAL_STONE.get(), pos.below(), worldIn))
		{
			if(getBlockState(CropsInit.IRON.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.north().east(), worldIn) && getBlockState(CropsInit.IRON.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.north().west(), worldIn) && getBlockState(CropsInit.IRON.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.south().east(), worldIn) && getBlockState(CropsInit.IRON.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.south().west(), worldIn))	
			{
				if(getBlockState(CropsInit.GOLD.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.north(3), worldIn) && getBlockState(CropsInit.GOLD.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.south(3), worldIn) && getBlockState(CropsInit.GOLD.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.east(3), worldIn) && getBlockState(CropsInit.GOLD.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.west(3), worldIn))
				{
					if(getBlock(Blocks.WATER, pos.below().north(2).west(2), worldIn) && getBlock(Blocks.WATER, pos.below().north(2).east(2), worldIn) && getBlock(Blocks.WATER, pos.below().south(2).west(2), worldIn) && getBlock(Blocks.WATER, pos.below().south(2).east(2), worldIn))
					{
						if(getBlock(Blocks.DIORITE, pos.north(4).east(), worldIn) && getBlock(Blocks.DIORITE, pos.north(4).west(), worldIn) && getBlock(Blocks.DIORITE, pos.south(4).east(), worldIn) && getBlock(Blocks.DIORITE, pos.south(4).west(), worldIn) && getBlock(Blocks.DIORITE, pos.east(4).north(), worldIn) && getBlock(Blocks.DIORITE, pos.east(4).south(), worldIn) && getBlock(Blocks.DIORITE, pos.west(4).north(), worldIn) && getBlock(Blocks.DIORITE, pos.west(4).south(), worldIn))
						{
							if(getBlock(Blocks.ANDESITE, pos.north(3).east(3), worldIn) && getBlock(Blocks.ANDESITE, pos.north(3).west(3), worldIn) && getBlock(Blocks.ANDESITE, pos.south(3).east(3), worldIn) && getBlock(Blocks.ANDESITE, pos.south(3).west(3), worldIn) && getBlock(Blocks.ANDESITE, pos.above().north(3).east(3), worldIn) && getBlock(Blocks.ANDESITE, pos.above().north(3).west(3), worldIn) && getBlock(Blocks.ANDESITE, pos.above().south(3).east(3), worldIn) && getBlock(Blocks.ANDESITE, pos.above().south(3).west(3), worldIn))
							{
								if(bypass || (getBlockState(blockNeed, pos.below().north(), worldIn) && getBlockState(blockNeed, pos.below().east(), worldIn) && getBlockState(blockNeed, pos.below().south(), worldIn) && getBlockState(blockNeed, pos.below().west(), worldIn)))
								{
									return true;
								}
								else {
									bad(blockNeed, worldIn, pos);
								}
							}
							else 
								bad("ANDESITES", worldIn, pos);						
						}
						else 
							bad("DIORITES", worldIn, pos);	
					}
					else 
						bad("WATER BLOCKS", worldIn, pos);
				}
				else 
					bad("GOLD CROPS", worldIn, pos);
			}
			else 
				bad("IRON CROPS", worldIn, pos);	
		}
		else 
			bad("ELEMENTAL STONE", worldIn, pos);	
		return false;
	}
	
	public static void placeRitual(Level worldIn, BlockPos pos)
	{
		setBlock(BlockInit.ELEMENTAL_STONE.get(), pos.below(), worldIn);
		setBlockState(CropsInit.IRON.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.north().east(), worldIn);
		setBlockState(CropsInit.IRON.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.north().west(), worldIn);
		setBlockState(CropsInit.IRON.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.south().east(), worldIn);
		setBlockState(CropsInit.IRON.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.south().west(), worldIn);
		setBlockState(CropsInit.GOLD.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.north(3), worldIn);
		setBlockState(CropsInit.GOLD.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.south(3), worldIn);
		setBlockState(CropsInit.GOLD.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.east(3), worldIn);
		setBlockState(CropsInit.GOLD.getCrop().get().defaultBlockState().setValue(CropariaCrops.AGE, 7), pos.west(3), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.north().east().below(), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.north().west().below(), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.south().east().below(), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.south().west().below(), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.north(3).below(), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.south(3).below(), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.east(3).below(), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.west(3).below(), worldIn);
		setBlock(Blocks.WATER, pos.below().north(2).west(2), worldIn);
		setBlock(Blocks.WATER, pos.below().north(2).east(2), worldIn);
		setBlock(Blocks.WATER, pos.below().south(2).west(2), worldIn);
		setBlock(Blocks.WATER, pos.below().south(2).east(2), worldIn);
		setBlock(Blocks.DIORITE, pos.north(4).east(), worldIn);
		setBlock(Blocks.DIORITE, pos.north(4).west(), worldIn);
		setBlock(Blocks.DIORITE, pos.south(4).east(), worldIn);
		setBlock(Blocks.DIORITE, pos.south(4).west(), worldIn);
		setBlock(Blocks.DIORITE, pos.east(4).north(), worldIn);
		setBlock(Blocks.DIORITE, pos.east(4).south(), worldIn);
		setBlock(Blocks.DIORITE, pos.west(4).north(), worldIn);
		setBlock(Blocks.DIORITE, pos.west(4).south(), worldIn);
		setBlock(Blocks.ANDESITE, pos.north(3).east(3), worldIn);
		setBlock(Blocks.ANDESITE, pos.north(3).west(3), worldIn);
		setBlock(Blocks.ANDESITE, pos.south(3).east(3), worldIn);
		setBlock(Blocks.ANDESITE, pos.south(3).west(3), worldIn);
		setBlock(Blocks.ANDESITE, pos.above().north(3).east(3), worldIn);
		setBlock(Blocks.ANDESITE, pos.above().north(3).west(3), worldIn);
		setBlock(Blocks.ANDESITE, pos.above().south(3).east(3), worldIn);
		setBlock(Blocks.ANDESITE, pos.above().south(3).west(3), worldIn);
	}
}