package com.croparia.mod.common.blockEntity;

import com.croparia.mod.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.DispenserMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.concurrent.atomic.AtomicBoolean;

public class GreenHouseBE extends BaseContainerBlockEntity {

	public GreenHouseBE(BlockPos pos, BlockState state) {
		super(BlockEntityInit.GREENHOUSE_BE.get(), pos, state);
	}

	private NonNullList<ItemStack> inventory = NonNullList.withSize(9, ItemStack.EMPTY);

	public static void tick(Level level, BlockPos worldPosition, BlockState state, GreenHouseBE greenHouseBE) {
		if(!level.isClientSide)
		{
			if(level.getBlockState(worldPosition.below()).getBlock() instanceof CropBlock)
			{
				BlockState belowState = level.getBlockState(worldPosition.below());
				CropBlock block = (CropBlock)belowState.getBlock();
				if(block.isMaxAge(belowState))
				{
					for(ItemStack stack : Block.getDrops(belowState, level.getServer().getLevel(level.dimension()), worldPosition.below(), level.getBlockEntity(worldPosition.below()))) {
						addItemStackInInventory(stack, greenHouseBE);
					}
					if(level.getBlockState(worldPosition.below()).getBlock() instanceof BeetrootBlock) {
						level.setBlockAndUpdate(worldPosition.below(), block.defaultBlockState().setValue(BeetrootBlock.AGE, 1));
					}
					else {
						level.setBlockAndUpdate(worldPosition.below(), block.defaultBlockState().setValue(CropBlock.AGE, 4));
					}
				}
			}
			else if(level.getBlockState(worldPosition.below()).getBlock() instanceof StemBlock)
			{
				BlockState belowState = level.getBlockState(worldPosition.below());
				if(belowState.getValue(StemBlock.AGE) == 7)
				{
					BlockState dropState = ((StemBlock) belowState.getBlock()).getFruit().defaultBlockState();
					for(ItemStack stack : Block.getDrops(dropState, level.getServer().getLevel(level.dimension()), worldPosition.below(), level.getBlockEntity(worldPosition.below()))) {
						addItemStackInInventory(stack, greenHouseBE);
					}
					level.setBlockAndUpdate(worldPosition.below(), belowState.setValue(StemBlock.AGE, 4));
				}
			}
		}
	}

	public static void addItemStackInInventory(ItemStack itemstack, GreenHouseBE greenHouseBE) {
		int i = greenHouseBE.getContainerSize();
		ItemStack stack = itemstack;
		for (int j = 0; j < i && !stack.isEmpty(); ++j) {
			if (greenHouseBE.getItem(j).getCount() < 64 && greenHouseBE.getItem(j).getItem() == stack.getItem() || greenHouseBE.getItem(j).isEmpty()) {
				greenHouseBE.setItem(j, new ItemStack(stack.getItem(), stack.getCount() + greenHouseBE.getItem(j).getCount()));
				stack = new ItemStack(stack.getItem(), stack.getCount() - greenHouseBE.getItem(j).getCount());
			}
		}

	}

	@Override
	protected Component getDefaultName() {
		return new TranslatableComponent("container.greenhouse");
	}

	@Override
	protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
		return new DispenserMenu(id, inventory, this);
	}

	@Override
	public int getContainerSize() {
		return this.inventory.size();
	}

	@Override
	public boolean isEmpty() {
		AtomicBoolean empty = new AtomicBoolean(true);
		this.inventory.stream().forEach(itemStack -> {
			if(!itemStack.isEmpty()){
				empty.set(false);
			}
		});
		return empty.get();
	}

	@Override
	public ItemStack getItem(int index) {
		return inventory.get(index);
	}

	public ItemStack removeItem(int p_58330_, int p_58331_) {
		return ContainerHelper.removeItem(this.inventory, p_58330_, p_58331_);
	}

	public ItemStack removeItemNoUpdate(int p_58387_) {
		return ContainerHelper.takeItem(this.inventory, p_58387_);
	}

	@Override
	public void setItem(int index, ItemStack stack) {
		this.inventory.set(index, stack);
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.level.getBlockEntity(this.worldPosition) != this) {
			return false;
		} else {
			return player.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) <= 64.0D;
		}
	}

	@Override
	public void clearContent() {
		this.inventory.clear();
	}

	@Override
	public void load(CompoundTag compoundTag) {
		super.load(compoundTag);
		this.inventory = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compoundTag, this.inventory);
	}

	@Override
	public CompoundTag save(CompoundTag compoundTag) {
		super.save(compoundTag);
		ContainerHelper.saveAllItems(compoundTag, this.inventory);
		return compoundTag;
	}
}



