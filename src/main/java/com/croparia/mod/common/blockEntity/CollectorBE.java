package com.croparia.mod.common.blockEntity;

import com.croparia.mod.common.blocks.Collector;
import com.croparia.mod.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;

import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

public class CollectorBE extends BaseContainerBlockEntity
{

	public CollectorBE(BlockPos pos, BlockState state) {
		super(BlockEntityInit.COLLECTOR_BE.get(), pos, state);
	}

	private NonNullList<ItemStack> inventory = NonNullList.withSize(27, ItemStack.EMPTY);

	public NonNullList<ItemStack> getInventory(){
		return this.inventory;
	}


	public static void tick(Level level, BlockPos worldPosition, BlockState state, CollectorBE collectorBE) {
		int area = 5;
		int range = (area - 1)/2;

		if(!level.isClientSide && level.getBlockState(worldPosition).getBlock() instanceof Collector) {
			if(level.getBlockState(worldPosition).getValue(Collector.POWERED)) {
				AtomicBoolean cond = new AtomicBoolean(false);
				collectorBE.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(cap -> {
					int energy = cap.extractEnergy(10, true);
					if(energy >= 0){
						cond.set(true);
					}
					if(cond.get()) {
						cap.extractEnergy(10, false);
						Direction direction = level.getBlockState(worldPosition).getValue(Collector.FACING);
						BlockPos start = worldPosition.relative(direction).relative(direction.getClockWise(), range);
						BlockPos end = worldPosition.relative(direction, area).relative(direction.getClockWise(), -range);
						BlockPos.betweenClosedStream(start, end).forEach(position -> {
							if (level.getBlockState(position).getBlock() instanceof CropBlock) {
								BlockState blockState = level.getBlockState(position);
								CropBlock block = (CropBlock) blockState.getBlock();
								if (block.isMaxAge(blockState)) {
									for (ItemStack stack : Block.getDrops(blockState, level.getServer().getLevel(level.dimension()), position, level.getBlockEntity(position))) {
										collectorBE.addItemStackInInventory(stack, collectorBE);
									}
									if (level.getBlockState(position).getBlock() instanceof BeetrootBlock) {
										level.setBlockAndUpdate(position, block.defaultBlockState().setValue(BeetrootBlock.AGE, 1));
										System.out.println("deja là ?!");
									} else {
										level.setBlockAndUpdate(position, block.defaultBlockState().setValue(CropBlock.AGE, 4));
									}
								}
							}
						});
					}
				});
			}
		}
	}

	private final EnergyStorage energyStorage = new EnergyStorage(40000, 350, 350, 10000){

		@Override
		public boolean canExtract() {
			return true;
		}

		@Override
		public boolean canReceive() {
			return true;
		}
	};

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
		if(capability == CapabilityEnergy.ENERGY && facing != Direction.NORTH){
			return LazyOptional.of(() -> energyStorage).cast();
		}
		return super.getCapability(capability, facing);
	}
	
	@Override
	public void load(CompoundTag compoundTag) {
		super.load(compoundTag);
		this.inventory = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compoundTag, this.inventory);
		if(compoundTag.contains("energyStorage")){
			this.energyStorage.deserializeNBT(compoundTag.get("energyStorage"));
		}
	}

	@Override
	public CompoundTag save(CompoundTag compoundTag) {
		super.save(compoundTag);
		ContainerHelper.saveAllItems(compoundTag, this.inventory);
		compoundTag.put("energyStorage", energyStorage.serializeNBT());
      	return compoundTag;
	}

	@Override
	protected Component getDefaultName() {
		return new TranslatableComponent("container.collector");
	}

	@Override
	protected AbstractContainerMenu createMenu(int id, Inventory player) {
		return new ChestMenu(MenuType.GENERIC_9x3, id, player, this, 3);
	}

	public static void addItemStackInInventory(ItemStack itemstack, CollectorBE collectorBE) {
		int i = collectorBE.getContainerSize();
		ItemStack stack = itemstack;
        for(int j = 0; j < i && !stack.isEmpty(); ++j) {
           if(collectorBE.getItem(j).getCount() < 64 && collectorBE.getItem(j).getItem() == stack.getItem() || collectorBE.getItem(j).isEmpty()) {
			   collectorBE.setItem(j, new ItemStack(stack.getItem(), stack.getCount() + collectorBE.getItem(j).getCount()));
        	   stack = new ItemStack(stack.getItem(), stack.getCount() - collectorBE.getItem(j).getCount());
           }
        }
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
}