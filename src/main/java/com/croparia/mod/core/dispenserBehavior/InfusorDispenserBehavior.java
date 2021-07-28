package com.croparia.mod.core.dispenserBehavior;

import com.croparia.mod.common.blocks.Infusor;
import com.croparia.mod.core.init.BlockInit;
import com.croparia.mod.core.init.ItemInit;
import com.croparia.mod.core.util.ElementsEnum;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.BottleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class InfusorDispenserBehavior extends DefaultDispenseItemBehavior
{

	@Override
	protected ItemStack execute(BlockSource source, ItemStack stack) {
		Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
	    Level world = source.getLevel();
	    BlockPos blockpos = source.getPos().relative(direction);
	    if(world.getBlockState(blockpos).getBlock() instanceof Infusor) {
	    	double d0 = source.x() + (double)((float)direction.getStepX() * 1.125F);
	        double d1 = source.y() + (double)((float)direction.getStepY() * 1.125F);
	        double d2 = source.z() + (double)((float)direction.getStepZ() * 1.125F);
	        if(world.getBlockState(blockpos).getBlock() instanceof Infusor) {
		    	if(world.getBlockState(blockpos).getValue(Infusor.TYPE) != ElementsEnum.EMPTY && stack.getItem() instanceof BottleItem) {
					world.setBlockAndUpdate(new BlockPos(d0, d1, d2), BlockInit.INFUSOR.get().defaultBlockState().setValue(Infusor.TYPE, ElementsEnum.EMPTY));
					spawnItem(world, ItemInit.getPotionFromElement(world.getBlockState(blockpos).getValue(Infusor.TYPE)).getDefaultInstance(), 1, direction, source);
					stack.shrink(1);
		    	}
		    	else if(ItemInit.getElementFromPotion(stack.getItem()) != ElementsEnum.EMPTY && world.getBlockState(blockpos).getValue(Infusor.TYPE) == ElementsEnum.EMPTY) {
		    		world.setBlockAndUpdate(new BlockPos(d0, d1, d2), BlockInit.INFUSOR.get().defaultBlockState().setValue(Infusor.TYPE, ItemInit.getElementFromPotion(stack.getItem())));
					spawnItem(world, Items.GLASS_BOTTLE.getDefaultInstance(), 1, direction, source);
		    		stack.shrink(1);
		    	}
	    	}
	    	else {
	    		dispense(source, stack);
	    	}
	    }
		return stack;
	}
}
