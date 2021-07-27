package com.croparia.mod.common.menu;

import java.util.Objects;

import com.croparia.mod.common.blockEntity.TransformerBE;

import com.croparia.mod.core.init.MenuInit;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;


public class TransformerMenu extends AbstractContainerMenu {

	public final Container thisInventory;
	private ContainerData data;

	public TransformerMenu(final int windowId, final Inventory playerInv) {
		this(windowId, playerInv, new SimpleContainer(2), new SimpleContainerData(2));
	}

	public TransformerMenu(int windowId, Inventory playerInv, Container container, ContainerData data) {
		super(MenuInit.TRANSFORMER_MENU.get(), windowId);

		thisInventory = container;
		this.data = data;
		this.addSlot(new Slot(container, 0, 56, 35));
		this.addSlot(new Slot(container, 1, 116, 35) {
			@Override
			public boolean mayPlace(ItemStack p_75214_1_) {
				return false;
			}
		});

		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(playerInv, k, 8 + k * 18, 142));
		}

		this.addDataSlots(data);
	}

	public TransformerMenu(final int windowId, final Inventory playerInv, final FriendlyByteBuf data) {
		this(windowId, playerInv, getBlockEntity(playerInv, data), new SimpleContainerData(data.readByte()));
	}

	private static TransformerBE getBlockEntity(final Inventory playerInv, final FriendlyByteBuf data) {
		Objects.requireNonNull(playerInv, "Player Inventory cannot be null.");
		Objects.requireNonNull(data, "Packet Buffer cannot be null.");
		final BlockEntity be = playerInv.player.level.getBlockEntity(data.readBlockPos());
		if (be instanceof TransformerBE) {
			return (TransformerBE) be;
		}
		throw new IllegalStateException("Block Entity Is Not Correct");
	}

	@Override
	public boolean stillValid(Player player) {
		return this.thisInventory.stillValid(player);
	}

	@Override
	public ItemStack quickMoveStack(Player player, int index) {
		ItemStack itemStack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if(slot != null && slot.hasItem()){
			ItemStack itemStack1 = slot.getItem();
			itemStack = itemStack1.copy();
			if(index < 2){
				if(!this.moveItemStackTo(itemStack1, 2, this.slots.size(), true)){
					return ItemStack.EMPTY;
				}
			} else if(!this.moveItemStackTo(itemStack1, 0, 2, false)){
				return ItemStack.EMPTY;
			}

			if(itemStack1.isEdible()){
				slot.set(ItemStack.EMPTY);
			} else{
				slot.setChanged();
			}
		}
		return itemStack;
	}

	public int getBurnProgress() {
		int i = this.data.get(0);
		int j = this.data.get(1);
		return j != 0 && i != 0 ? i * 24 / j : 0;
	}
}
