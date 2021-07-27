package com.croparia.mod.core.recipes.rituals;

import com.croparia.mod.CropariaMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class RitualUtils extends CropariaMod{

	public static boolean getBlock(Block block, BlockPos pos, Level worldIn)
	{
		if(worldIn.getBlockState(pos) == block.defaultBlockState()) return true;
		return false;
	}
	
	public static void setBlock(Block block, BlockPos pos, Level worldIn)
	{
		worldIn.setBlockAndUpdate(pos, block.defaultBlockState());
	}	

	public static boolean getBlockState(BlockState block, BlockPos pos, Level worldIn)
	{
		if(worldIn.getBlockState(pos) == block) return true;
		return false;
	}
	
	public static void setBlockState(BlockState state, BlockPos pos, Level worldIn)
	{
		worldIn.setBlockAndUpdate(pos, state);
	}
	
	public static void endFirst(ItemStack out, ItemStack in, BlockPos pos, Level worldIn)
	{		
			in.shrink(1);
			ItemEntity entityOut = new ItemEntity(worldIn, pos.getX()+0.5, pos.getY()+1, pos.getZ()+0.5, out);
			worldIn.addFreshEntity(entityOut);
			worldIn.setBlockAndUpdate(pos.below().north(), Blocks.AIR.defaultBlockState());
			worldIn.setBlockAndUpdate(pos.below().east(), Blocks.AIR.defaultBlockState());
			worldIn.setBlockAndUpdate(pos.below().south(), Blocks.AIR.defaultBlockState());
			worldIn.setBlockAndUpdate(pos.below().west(), Blocks.AIR.defaultBlockState());		
			entityOut.setDeltaMovement(0, 0.3, 0);
	}

	public static void endSecond(Entity entityIn, BlockPos pos, Level worldIn)
	{
		entityIn.remove(false);
		worldIn.setBlockAndUpdate(pos.north(2).west(2), Blocks.AIR.defaultBlockState());
		worldIn.setBlockAndUpdate(pos.north(2).east(2), Blocks.AIR.defaultBlockState());
		worldIn.setBlockAndUpdate(pos.south(2).east(2), Blocks.AIR.defaultBlockState());
		worldIn.setBlockAndUpdate(pos.south(2).west(2), Blocks.AIR.defaultBlockState());
	}
	/*
	
	public static void endStone(Entity entityIn, BlockPos pos, World worldIn)
	{
		entityIn.remove();
		worldIn.setBlockState(pos.west(7), BlockInit.INFUSOR.defaultBlockState());
		worldIn.setBlockState(pos.north(7),  BlockInit.INFUSOR.defaultBlockState());
		worldIn.setBlockState(pos.south(7),  BlockInit.INFUSOR.defaultBlockState());
		worldIn.setBlockState(pos.east(7),  BlockInit.INFUSOR.defaultBlockState());
		worldIn.setBlockState(pos.south(5).east(5),  BlockInit.INFUSOR.defaultBlockState());
		worldIn.setBlockState(pos.north(5).west(5),  BlockInit.INFUSOR.defaultBlockState());
		worldIn.setBlockState(pos.north(5).east(5),  BlockInit.INFUSOR.defaultBlockState());
		worldIn.setBlockState(pos.south(5).west(5),  BlockInit.INFUSOR.defaultBlockState());
	} */
	
	public static void bad(String error, Level level, BlockPos pos)
	{
		Player player = level.getNearestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
		if(player != null)
			CropariaMod.sendMessage(player, "It seems there is an error with the " + error);
	}
	
	public static void bad(BlockState error, Level level, BlockPos pos)
	{
		Player player = level.getNearestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
		if(player != null)
			CropariaMod.sendMessage(player, "It seems there is an error with the " + error);
	}
	
	public static void fail(Level world, ItemEntity entityIn) {
		int j = world.random.nextInt(1);
		if(j > 0) {
			j = -1;
		} else { j=1; }
		int k = world.random.nextInt(1);
		if(k> 0) {
			k = -1;
		} else { k=1; }
		entityIn.setDeltaMovement((world.random.nextFloat() + 0.5) * j/100, world.random.nextFloat() + 0.1, (world.random.nextFloat() + 0.5) * k/100);
	}
}