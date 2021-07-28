package com.croparia.mod.common.items;

import com.croparia.mod.CropariaMod;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.energy.CapabilityEnergy;

public class CropariaTool extends Item {

	public CropariaTool() {
		super(new Item.Properties().tab(CropariaMod.MAIN)); 
	}

	@Override
	public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context)
	{
		Level level = context.getLevel();
		if(!level.isClientSide) {
			BlockPos pos = context.getClickedPos();
			BlockEntity be = level.getBlockEntity(pos);
			if(be != null) {
				if (be.getCapability(CapabilityEnergy.ENERGY).isPresent()) {
					be.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(cap -> {
						context.getPlayer().displayClientMessage(new TextComponent(cap.getEnergyStored() + " / " + cap.getMaxEnergyStored() + " RF"), true);
					});
				}
			}
		}
		return InteractionResult.SUCCESS;
	}
}
