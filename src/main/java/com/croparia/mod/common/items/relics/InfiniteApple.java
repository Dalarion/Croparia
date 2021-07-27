package com.croparia.mod.common.items.relics;

import com.croparia.mod.CropariaMod;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class InfiniteApple extends Item {
	
	public InfiniteApple()
	{
		super(new Item.Properties().tab(CropariaMod.MAIN).food(Foods.GOLDEN_CARROT).stacksTo(1));
	}
	
	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving)
	{
       if (entityLiving instanceof Player)
       {
		   Player entityplayer = (Player)entityLiving;
           worldIn.playSound((Player)null, entityplayer.getX(), entityplayer.getY(), entityplayer.getZ(), SoundEvents.PLAYER_BURP, SoundSource.PLAYERS, 0.5F, worldIn.random.nextFloat() * 0.1F + 0.9F);
       }
       return stack;
	}
}