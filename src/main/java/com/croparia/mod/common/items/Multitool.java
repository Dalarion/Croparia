package com.croparia.mod.common.items;

import com.croparia.mod.CropariaMod;
import com.croparia.mod.core.init.ItemInit;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.Map;


public class Multitool extends DiggerItem {

	protected static final Map<Block, BlockState> HOE_LOOKUP = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.FARMLAND.defaultBlockState(), Blocks.DIRT_PATH, Blocks.FARMLAND.defaultBlockState(), Blocks.DIRT, Blocks.FARMLAND.defaultBlockState(), Blocks.COARSE_DIRT, Blocks.DIRT.defaultBlockState()));

	public Multitool(float attackDamageIn, float attackSpeedIn, Tier tier) {
		super(attackDamageIn, attackSpeedIn, tier, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(CropariaMod.MAIN));
	}

	@Override
	public boolean canHarvestBlock(ItemStack stack, BlockState state) {
		return state != Blocks.AIR.defaultBlockState() && state != Blocks.BARRIER.defaultBlockState() && state != Blocks.BEDROCK.defaultBlockState();
	}
	
	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) 
	{
		if (canHarvestBlock(stack, state)) 
			return speed;
		else
			return 1.0F;
	}
	
	
	@Override
   public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) 
   {
		if(toRepair.getItem() == ItemInit.WOOD_MULTITOOL.get() && repair.getItem() == Items.OAK_PLANKS)
	        return true;
		else if(toRepair.getItem() == ItemInit.STONE_MULTITOOL.get() && repair.getItem() == Items.COBBLESTONE)
	        return true;
		else if(toRepair.getItem() == ItemInit.IRON_MULTITOOL.get() && repair.getItem() == Items.IRON_INGOT)
	        return true;
		else if(toRepair.getItem() == ItemInit.GOLD_MULTITOOL.get() && repair.getItem() == Items.GOLD_INGOT)
	        return true;
		else if(toRepair.getItem() == ItemInit.DIAMOND_MULTITOOL.get() && repair.getItem() == Items.DIAMOND)
	        return true;
		else if(toRepair.getItem() == ItemInit.OBSIDIAN_MULTITOOL.get() && repair.getItem() == Items.OBSIDIAN)
	        return true;
		else if(toRepair.getItem() == ItemInit.RENFORCED_MULTITOOL.get() && repair.getItem() == Items.DIAMOND)
			return true;
		else if(toRepair.getItem() == ItemInit.NETHERITE_MULTITOOL.get() && repair.getItem() == Items.NETHERITE_INGOT)
			return true;
	   	else
	   		return false;
   }

	@Override
	public InteractionResult useOn(UseOnContext context) {
		 final Level world = context.getLevel();
	        final BlockPos blockpos = context.getClickedPos();
	        final int hook = ForgeEventFactory.onHoeUse(context);
	        if (hook != 0) {
	            return (hook > 0) ? InteractionResult.SUCCESS : InteractionResult.FAIL;
	        }
	        if (context.getClickedFace() != Direction.DOWN && world.isEmptyBlock(blockpos.above())) {
				final BlockState blockstate = Multitool.HOE_LOOKUP.get(world.getBlockState(blockpos).getBlock());
	            if (blockstate != null) {
	                final Player playerentity = context.getPlayer();
	                world.playSound(playerentity, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0f, 1.0f);
	                if (!world.isClientSide) {
	                    world.setBlock(blockpos, blockstate, 11);
	                    if (playerentity != null) {
	                    	context.getItemInHand().hurtAndBreak(1, playerentity, (player) -> {
	                            player.broadcastBreakEvent(context.getHand());
	                         });
	                    }
	                }
	                return InteractionResult.SUCCESS;
	            }
	        }
	        return InteractionResult.PASS;
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.hurtAndBreak(1, attacker, (player) -> {
            player.broadcastBreakEvent(attacker.getUsedItemHand());
         });
		return true;
	}	
}
