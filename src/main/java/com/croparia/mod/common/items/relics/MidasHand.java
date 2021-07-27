package com.croparia.mod.common.items.relics;

import com.croparia.mod.CropariaMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;


public class MidasHand extends Item
{
	public MidasHand()
	{
		super(new Item.Properties().tab(CropariaMod.MAIN).stacksTo(1));
	}
	
	@Override
	public InteractionResult useOn(UseOnContext context)
	{
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		if(worldIn.getBlockState(pos).getBlock() != Blocks.BEDROCK && !worldIn.isClientSide)
		{
			worldIn.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
			worldIn.addFreshEntity(new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, new ItemStack(Items.GOLD_INGOT)));	
			return InteractionResult.SUCCESS;
		}
		else
			return InteractionResult.FAIL;
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity)
	{
		if(!entity.level.isClientSide)
		{
			entity.level.setBlockAndUpdate(entity.blockPosition(), Blocks.GOLD_BLOCK.defaultBlockState());
			entity.remove(false);
			return true;
		}
		else
			return false;
	}
}
