package com.croparia.mod.common.items.relics;

import com.croparia.mod.CropariaMod;
import com.croparia.mod.core.init.CropsInit;
import com.croparia.mod.core.init.ItemInit;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;

public class HornPlenty extends Item
{
	public HornPlenty()
	{
		super(new Item.Properties().tab(CropariaMod.MAIN).stacksTo(1));
	}
	
	@Override
	public InteractionResult useOn(UseOnContext context)
	{
		ItemStack[] food = {new ItemStack(Items.CAKE),
							new ItemStack(Items.RABBIT_STEW),
							new ItemStack(Items.COOKED_PORKCHOP),
							new ItemStack(Items.COOKED_BEEF),
							new ItemStack(Items.PUMPKIN_PIE),
							new ItemStack(Items.GOLDEN_CARROT),
							new ItemStack(Items.COOKED_MUTTON),
							new ItemStack(Items.COOKED_COD),
							new ItemStack(Items.MUSHROOM_STEW),
							new ItemStack(Items.COOKED_CHICKEN),
							new ItemStack(Items.BAKED_POTATO),
							new ItemStack(Items.COOKED_RABBIT),
							new ItemStack(Items.BREAD),
							new ItemStack(Items.COOKED_SALMON),
							new ItemStack(Items.CARROT),
							new ItemStack(Items.APPLE),
							new ItemStack(Items.CHORUS_FRUIT),
							new ItemStack(Items.ROTTEN_FLESH),
							new ItemStack(Items.PORKCHOP),
							new ItemStack(Items.BEEF),
							new ItemStack(Items.SPIDER_EYE),
							new ItemStack(Items.RABBIT),
							new ItemStack(Items.MUTTON),
							new ItemStack(Items.COD),
							new ItemStack(Items.MELON),
							new ItemStack(Items.CHICKEN),
							new ItemStack(Items.POISONOUS_POTATO),
							new ItemStack(Items.SALMON),
							new ItemStack(Items.COOKIE),
							new ItemStack(Items.BEETROOT),
							new ItemStack(Items.BEETROOT_SOUP),
							new ItemStack(Items.POTATO),
							new ItemStack(Items.PUFFERFISH),
							new ItemStack(Items.TROPICAL_FISH),
							new ItemStack(CropsInit.APRICOT.getSeeds().get()),
							new ItemStack(CropsInit.CHERRY.getSeeds().get()),
							new ItemStack(CropsInit.LEMON.getSeeds().get()),
							new ItemStack(CropsInit.ORANGE1.getSeeds().get()),
							new ItemStack(CropsInit.KIWI.getSeeds().get()),
							new ItemStack(CropsInit.PEAR.getSeeds().get()),
							new ItemStack(CropsInit.BANANA.getSeeds().get()),
							new ItemStack(ItemInit.APRICOT_PIE.get()),
							new ItemStack(ItemInit.CHERRY_PIE.get()),
							new ItemStack(ItemInit.LEMON_PIE.get()),
							new ItemStack(ItemInit.ORANGE_PIE.get()),
							new ItemStack(ItemInit.KIWI_PIE.get()),
							new ItemStack(ItemInit.PEAR_PIE.get()),
							new ItemStack(ItemInit.BANANA_PIE.get())};
		
		int random = context.getLevel().random.nextInt(food.length - 1);
		
		context.getLevel().addFreshEntity(new ItemEntity(context.getLevel(), context.getClickedPos().getX() + 0.5, context.getClickedPos().getY() + 1, context.getClickedPos().getZ() + 0.5, food[random]));
		return InteractionResult.SUCCESS;
	}
}