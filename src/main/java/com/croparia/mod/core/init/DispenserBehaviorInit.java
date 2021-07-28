package com.croparia.mod.core.init;

import com.croparia.mod.core.dispenserBehavior.InfusorDispenserBehavior;
import com.croparia.mod.core.dispenserBehavior.KnifeDispenserBehavior;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.DispenserBlock;

public class DispenserBehaviorInit {
	public static void registerBehavior() {
		DispenserBlock.registerBehavior(Items.GLASS_BOTTLE.asItem(), new InfusorDispenserBehavior());
    	DispenserBlock.registerBehavior(ItemInit.POTION_ELEMATILIUS.get().asItem(), new InfusorDispenserBehavior());
    	DispenserBlock.registerBehavior(ItemInit.POTION_WATER.get().asItem(), new InfusorDispenserBehavior());
    	DispenserBlock.registerBehavior(ItemInit.POTION_FIRE.get().asItem(), new InfusorDispenserBehavior());
    	DispenserBlock.registerBehavior(ItemInit.POTION_EARTH.get().asItem(), new InfusorDispenserBehavior());
    	DispenserBlock.registerBehavior(ItemInit.POTION_AIR.get().asItem(), new InfusorDispenserBehavior());

		DispenserBlock.registerBehavior(ItemInit.WOOD_KNIFE.get().asItem(), new KnifeDispenserBehavior());
		DispenserBlock.registerBehavior(ItemInit.STONE_KNIFE.get().asItem(), new KnifeDispenserBehavior());
		DispenserBlock.registerBehavior(ItemInit.IRON_KNIFE.get().asItem(), new KnifeDispenserBehavior());
		DispenserBlock.registerBehavior(ItemInit.GOLD_KNIFE.get().asItem(), new KnifeDispenserBehavior());
		DispenserBlock.registerBehavior(ItemInit.DIAMOND_KNIFE.get().asItem(), new KnifeDispenserBehavior());
		DispenserBlock.registerBehavior(ItemInit.OBSIDIAN_KNIFE.get().asItem(), new KnifeDispenserBehavior());
		DispenserBlock.registerBehavior(ItemInit.RENFORCED_KNIFE.get().asItem(), new KnifeDispenserBehavior());
		DispenserBlock.registerBehavior(ItemInit.NETHERITE_KNIFE.get().asItem(), new KnifeDispenserBehavior());
    	
	}
}
