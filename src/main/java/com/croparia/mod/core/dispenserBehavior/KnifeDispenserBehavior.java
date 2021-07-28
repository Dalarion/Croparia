package com.croparia.mod.core.dispenserBehavior;

import com.croparia.mod.common.items.Knife;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;

public class KnifeDispenserBehavior extends DefaultDispenseItemBehavior
{
	@Override
	protected ItemStack execute(BlockSource source, ItemStack stack) {
		if(source != null && stack != null) {
			Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
			Level world = source.getLevel();
			BlockPos blockpos = source.getPos().relative(direction);
			if (world.getBlockState(blockpos).getBlock() instanceof CropBlock && stack.getItem() instanceof Knife) {
				Knife knife = (Knife) stack.getItem();
				BlockState state = world.getBlockState(blockpos);
				if(state != null) {
					CropBlock block = (CropBlock) state.getBlock();
					if (block.isMaxAge(world.getBlockState(blockpos))) {
						int age = knife.getTier().getLevel() * 2;
						if (age >= 7) {
							age = 6;
						}
						Block.dropResources(state, world, blockpos);
						if (world.getBlockState(blockpos).getBlock() instanceof BeetrootBlock) {
							world.setBlockAndUpdate(blockpos, block.defaultBlockState().setValue(BeetrootBlock.AGE, 1));
						} else {
							world.setBlockAndUpdate(blockpos, block.defaultBlockState().setValue(CropBlock.AGE, age));
						}
						if (knife.getMaxDamage() - (knife.getDamage(stack) + 1) <= 0) {
							return ItemStack.EMPTY;
						} else {
							knife.setDamage(stack, knife.getDamage(stack) + 1);
						}
					}
				}
			} else {
				dispense(source, stack);
			}
			return stack;
		}
		return super.execute(source, stack);
	}
}
