package com.croparia.mod.common.blocks;

import com.croparia.mod.core.Crops;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;

import java.util.*;

public class CropariaModdedCrops extends CropariaCrops {

	public CropariaModdedCrops(Crops crop) {
		super(crop);
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> drop = new ArrayList<>();
		drop.add(this.getCrop().getSeeds().get().getDefaultInstance());
		if(this.isMaxAge(state)) {
			int fruit = RANDOM.nextInt(2);
			if(fruit == 0){
				fruit++;
			}
			drop.add(new ItemStack(this.getCrop().getFruit().get(), fruit));

			int extra = RANDOM.nextInt(100);
			if(extra < 57){
				int seeds = RANDOM.nextInt(3);
				drop.add(new ItemStack(this.getCrop().getSeeds().get(), seeds));
			}
		}
		return drop;
	}
}
