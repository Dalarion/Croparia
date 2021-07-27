package com.croparia.mod.common.blocks;

import com.croparia.mod.core.Crops;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.HitResult;

public class CropariaCrops extends CropBlock {
	
	private Crops crop;
	
	public CropariaCrops(Crops crop) 
	{
		super(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
		this.crop = crop;
	}

	@Override
	public ItemStack getPickBlock(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		return this.crop.getSeeds().get().getDefaultInstance();
	}

	public Crops getCrop() {
		return this.crop;
	}

}
