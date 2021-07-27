package com.croparia.mod.common.items;

import com.croparia.mod.CropariaMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

public class Knife extends TieredItem {

	public Knife(Tier tier) {
		super(tier, new Item.Properties().tab(CropariaMod.MAIN));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		if(!context.getLevel().isClientSide) {
			Level world = context.getLevel();
			BlockPos pos = context.getClickedPos();
			BlockState state = world.getBlockState(pos);
			CropBlock block = (CropBlock)state.getBlock();
			Player playerentity = context.getPlayer();
			if(world.getBlockState(pos).getBlock() instanceof CropBlock) {
				if(block.isMaxAge(state))
				{
					int age = this.getTier().getLevel() * 2;
					if(age >= 7) {
						age = 6;
					}
					Block.dropResources(state, world, pos);
					if(world.getBlockState(pos).getBlock() instanceof BeetrootBlock) {
						world.setBlockAndUpdate(pos, block.defaultBlockState().setValue(BeetrootBlock.AGE, 1));
					}
					else {
						world.setBlockAndUpdate(pos, block.defaultBlockState().setValue(CropBlock.AGE, age));
					}
					context.getItemInHand().hurtAndBreak(1, playerentity, (player) -> {
						player.broadcastBreakEvent(context.getHand());
					});
					return InteractionResult.SUCCESS;
				}
			}
		}
		return InteractionResult.FAIL;
	}
}
