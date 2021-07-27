package com.croparia.mod.common.items;

import com.croparia.mod.CropariaMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Pestle extends Item {

	public Pestle() {
		super(new Item.Properties().tab(CropariaMod.MAIN).stacksTo(1));
	}

	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		return this.getDefaultInstance();
	}
}
