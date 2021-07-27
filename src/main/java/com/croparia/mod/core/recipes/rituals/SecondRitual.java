package com.croparia.mod.core.recipes.rituals;

import com.croparia.mod.core.init.CropsInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;

public class SecondRitual extends RitualUtils
{
	public static boolean checkRitual(BlockState blockNeed, Level worldIn, BlockPos pos, boolean bypass)
	{
		if(FirstRitual.checkRitual(blockNeed, worldIn, pos, bypass))
		{
			if(getBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.SOUTH), pos.above(2).east(4).north(), worldIn)
			&& getBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.NORTH), pos.above(2).east(4).south(), worldIn)
			&& getBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.SOUTH), pos.above(2).west(4).north(), worldIn)
			&& getBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.NORTH), pos.above(2).west(4).south(), worldIn)
			&& getBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.WEST), pos.above(2).north(4).east(), worldIn)
			&& getBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.EAST), pos.above(2).north(4).west(), worldIn)
			&& getBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.WEST), pos.above(2).south(4).east(), worldIn)
			&& getBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.EAST), pos.above(2).south(4).west(), worldIn))
			{
				if(getBlock(Blocks.DIORITE, pos.above().north(4).east(), worldIn)
				&& getBlock(Blocks.DIORITE, pos.above().north(4).west(), worldIn)
				&& getBlock(Blocks.DIORITE, pos.above().south(4).east(), worldIn)
				&& getBlock(Blocks.DIORITE, pos.above().south(4).west(), worldIn)
				&& getBlock(Blocks.DIORITE, pos.above().east(4).north(), worldIn)
				&& getBlock(Blocks.DIORITE, pos.above().east(4).south(), worldIn)
				&& getBlock(Blocks.DIORITE, pos.above().west(4).north(), worldIn)
				&& getBlock(Blocks.DIORITE, pos.above().west(4).south(), worldIn))
				{
					if(getBlock(Blocks.ANDESITE, pos.above(2).north(3).east(3), worldIn)
					&& getBlock(Blocks.ANDESITE, pos.above(2).north(3).west(3), worldIn)
					&& getBlock(Blocks.ANDESITE, pos.above(2).south(3).east(3), worldIn)
					&& getBlock(Blocks.ANDESITE, pos.above(2).south(3).west(3), worldIn))
					{
						if(getBlock(Blocks.SHROOMLIGHT, pos.above(3).north(3).east(3), worldIn)
						&& getBlock(Blocks.SHROOMLIGHT, pos.above(3).north(3).west(3), worldIn)
						&& getBlock(Blocks.SHROOMLIGHT, pos.above(3).south(3).east(3), worldIn)
						&& getBlock(Blocks.SHROOMLIGHT, pos.above(3).south(3).west(3), worldIn)
						&& getBlock(Blocks.SHROOMLIGHT, pos.above(2).east(4), worldIn)
						&& getBlock(Blocks.SHROOMLIGHT, pos.above(2).west(4), worldIn)
						&& getBlock(Blocks.SHROOMLIGHT, pos.above(2).north(4), worldIn)
						&& getBlock(Blocks.SHROOMLIGHT, pos.above(2).south(4), worldIn))
						{
							if(getBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.north(3).west(2), worldIn)
							&& getBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.north(3).east(2), worldIn)
							&& getBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.south(3).west(2), worldIn)
							&& getBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.south(3).east(2), worldIn)
							&& getBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.north(2).west(3), worldIn)
							&& getBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.north(2).east(3), worldIn)
							&& getBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.south(2).west(3), worldIn)
							&& getBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.south(2).east(3), worldIn))
							{
								return true;
							}
							else 
								bad("ELEMENTAL CROP", worldIn, pos);					
						}
						else 
							bad("SHROOMLIGHT", worldIn, pos);	
					}
					else 
						bad("ANDESITE", worldIn, pos);
				}
				else 
					bad("DIORITE", worldIn, pos);
			}
			else 
				bad("POLISHED DIORITE STAIRS", worldIn, pos);	
		}
		return false;
	}					
			
	public static void placeRitual(Level worldIn, BlockPos pos)
	{
		setBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.SOUTH), pos.above(2).east(4).north(), worldIn);
		setBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.NORTH), pos.above(2).east(4).south(), worldIn);
		setBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.SOUTH), pos.above(2).west(4).north(), worldIn);
		setBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.NORTH), pos.above(2).west(4).south(), worldIn);
		setBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.WEST), pos.above(2).north(4).east(), worldIn);
		setBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.EAST), pos.above(2).north(4).west(), worldIn);
		setBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.WEST), pos.above(2).south(4).east(), worldIn);
		setBlockState(Blocks.POLISHED_DIORITE_STAIRS.defaultBlockState().setValue(StairBlock.HALF, Half.BOTTOM).setValue(StairBlock.FACING, Direction.EAST), pos.above(2).south(4).west(), worldIn);
		setBlock(Blocks.DIORITE, pos.above().north(4).east(), worldIn);
		setBlock(Blocks.DIORITE, pos.above().north(4).west(), worldIn);
		setBlock(Blocks.DIORITE, pos.above().south(4).east(), worldIn);
		setBlock(Blocks.DIORITE, pos.above().south(4).west(), worldIn);
		setBlock(Blocks.DIORITE, pos.above().east(4).north(), worldIn);
		setBlock(Blocks.DIORITE, pos.above().east(4).south(), worldIn);
		setBlock(Blocks.DIORITE, pos.above().west(4).north(), worldIn);
		setBlock(Blocks.DIORITE, pos.above().west(4).south(), worldIn);
		setBlock(Blocks.ANDESITE, pos.above(2).north(3).east(3), worldIn);
		setBlock(Blocks.ANDESITE, pos.above(2).north(3).west(3), worldIn);
		setBlock(Blocks.ANDESITE, pos.above(2).south(3).east(3), worldIn);
		setBlock(Blocks.ANDESITE, pos.above(2).south(3).west(3), worldIn);
		setBlock(Blocks.SHROOMLIGHT, pos.above(3).north(3).east(3), worldIn);
		setBlock(Blocks.SHROOMLIGHT, pos.above(3).north(3).west(3), worldIn);
		setBlock(Blocks.SHROOMLIGHT, pos.above(3).south(3).east(3), worldIn);
		setBlock(Blocks.SHROOMLIGHT, pos.above(3).south(3).west(3), worldIn);
		setBlock(Blocks.SHROOMLIGHT, pos.above(2).east(4), worldIn);
		setBlock(Blocks.SHROOMLIGHT, pos.above(2).west(4), worldIn);
		setBlock(Blocks.SHROOMLIGHT, pos.above(2).north(4), worldIn);
		setBlock(Blocks.SHROOMLIGHT, pos.above(2).south(4), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.below().north(3).west(2), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.below().north(3).east(2), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.below().south(3).west(2), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.below().south(3).east(2), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.below().north(2).west(3), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.below().north(2).east(3), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.below().south(2).west(3), worldIn);
		setBlockState(Blocks.FARMLAND.defaultBlockState().setValue(FarmBlock.MOISTURE, 7), pos.below().south(2).east(3), worldIn);
		setBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.north(3).west(2), worldIn);
		setBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.north(3).east(2), worldIn);
		setBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.south(3).west(2), worldIn);
		setBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.south(3).east(2), worldIn);
		setBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.north(2).west(3), worldIn);
		setBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.north(2).east(3), worldIn);
		setBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.south(2).west(3), worldIn);
		setBlockState(CropsInit.ELEMENTAL.getCrop().get().defaultBlockState().setValue(CropBlock.AGE, 7), pos.south(2).east(3), worldIn);
	}
}