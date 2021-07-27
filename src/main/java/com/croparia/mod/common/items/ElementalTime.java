package com.croparia.mod.common.items;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ElementalTime extends Item {

	private boolean activated = false;

	public ElementalTime(Properties properties) {
		super(properties);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(worldIn instanceof ServerLevel && activated) {
			((ServerLevel) worldIn).setDayTime(worldIn.getDayTime() + 100);
		}
	}
	
	@Override
	public InteractionResult useOn(UseOnContext context)
	{
		if(!context.getLevel().isClientSide) {
			activated = !activated;
		}
		return InteractionResult.SUCCESS;
	}
}
