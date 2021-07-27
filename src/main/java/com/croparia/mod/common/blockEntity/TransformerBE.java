package com.croparia.mod.common.blockEntity;

import com.croparia.mod.common.items.CropsSeed;
import com.croparia.mod.common.menu.TransformerMenu;
import com.croparia.mod.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class TransformerBE extends BaseContainerBlockEntity implements WorldlyContainer
{
	private static final int[] SLOTS_FOR_UP = new int[]{0};
	private static final int[] SLOTS_FOR_SIDES = new int[]{0};
	private static final int[] SLOTS_FOR_DOWN = new int[]{1};
	protected NonNullList<ItemStack> items = NonNullList.withSize(2, ItemStack.EMPTY);
	int recipeTime;
	int recipeProgress;
	ItemStackHandler handler = new ItemStackHandler(2);
	int dropRate = 33;

	public ItemStackHandler getHandler(){
		return this.handler;
	}

	public final ContainerData dataAccess = new ContainerData() {
	      public int get(int a) {
	         switch(a) {
	         case 0:
	            return TransformerBE.this.recipeProgress;
	         case 1:
	            return TransformerBE.this.recipeTime;
	         default:
	            return 0;
	         }
	      }

	      public void set(int index, int value) {
	         switch(index) {
	         case 0:
				 TransformerBE.this.recipeProgress = value;
	            break;
	         case 1:
				 TransformerBE.this.recipeTime = value;
				 break;
	         }

	      }

	      public int getCount() {
	         return 2;
	      }
	   };

    public TransformerBE(BlockPos pos, BlockState state) {
		super(BlockEntityInit.TRANSFORMER_BE.get(), pos, state);
	}
    public ContainerData getData() {
    	return this.dataAccess;
    }

	@Override
	public void load(CompoundTag compoundTag) {
		super.load(compoundTag);
		this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compoundTag, this.items);
		this.recipeProgress = compoundTag.getInt("RecipeProgress");
		this.recipeTime = compoundTag.getInt("RecipeTime");
		if(compoundTag.contains("energyStorage")){
			this.energyStorage.deserializeNBT(compoundTag.get("energyStorage"));
		}
	}

	@Override
	public CompoundTag save(CompoundTag compoundTag) {
		super.save(compoundTag);
		ContainerHelper.saveAllItems(compoundTag, this.items);
		compoundTag.putInt("RecipeProgress", this.recipeProgress);
		compoundTag.putInt("RecipeTime", this.recipeTime);
		compoundTag.put("energyStorage", energyStorage.serializeNBT());
		return compoundTag;
	}
    
    public Item getFruit(CropsSeed seed) {
    	return seed.getCrop().getFruit().get();
    }
    
    public boolean transform(ItemStack stack) {
    	if(stack.getItem() instanceof CropsSeed) {
    		CropsSeed seed = (CropsSeed) stack.getItem();
	    	int dropRate = 50 / seed.getCrop().getTier();
	    	int random = level.random.nextInt(100);
	    	int cond = random  - dropRate;
	    	if(cond < 0) {
				level.addFreshEntity(new ItemEntity(level,  worldPosition.getX()+0.5, worldPosition.getY()+0.5, worldPosition.getZ()+0.5, new ItemStack(getFruit(seed))));
	    	}
			stack.shrink(1);
			return true;
    	}
    	return false;
    }

	public static void tick(Level level, BlockPos worldPosition, BlockState state, TransformerBE transformerBE) {
		if(!level.isClientSide) {
			if(transformerBE.getItem(0).getItem() instanceof CropsSeed) {
				int tier = ((CropsSeed) transformerBE.getItem(0).getItem()).getCrop().getTier();

				AtomicBoolean enoughEnergy = new AtomicBoolean(false);
				transformerBE.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(cap -> {
					if(cap.getEnergyStored() >= 10){
						enoughEnergy.set(true);
					}
				});
				if(enoughEnergy.get()) {
					transformerBE.recipeProgress++;
					transformerBE.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(cap -> cap.extractEnergy(10, false));
					transformerBE.recipeTime = 100 * tier;
					if (transformerBE.recipeProgress >= transformerBE.recipeTime) {
						Item fruit = ((CropsSeed) transformerBE.getItem(0).getItem()).getCrop().getFruit().get();
						if (transformerBE.canAddItem(1, fruit)) {
							Random rand = transformerBE.level.random;

							int lim = transformerBE.dropRate / tier;
							int a = rand.nextInt(100);
							if (a < lim) {
								transformerBE.addItem(1, fruit, 1);
							}
							transformerBE.getItem(0).shrink(1);
							transformerBE.recipeProgress = 0;
						}
					}
				}
				else{
					transformerBE.recipeProgress = 0;
				}
			}
		}
	}
	
	LazyOptional<?>[] handlers = net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
	private final EnergyStorage energyStorage = new EnergyStorage(40000, 350, 350, 0){

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
	      if (!this.remove && facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
	         if (facing == Direction.DOWN)
	            return handlers[1].cast();
	         else
	            return handlers[0].cast();
	      }
		 if(capability == CapabilityEnergy.ENERGY){
			 return LazyOptional.of(() -> energyStorage).cast();
		 }
	      return super.getCapability(capability, facing);
	   }
	
	public boolean canAddItem(int slot, Item input) {
		ItemStack actualStack = getItem(slot);
		if(actualStack.getItem() == input) {
			if(actualStack.getCount() + 1 <= actualStack.getMaxStackSize()) {
				return true;
			}
		}
		else if (actualStack.getItem() == Items.AIR){
			return true;
		}
		return false;
	}
	
	public void addItem(int slot, Item input, int count) {	
		if(getItem(slot).getItem() != Items.AIR) {
			count = count + getItem(slot).getCount();
		}
		setItem(slot, new ItemStack(input, count));
	}

	@Override
	public int getContainerSize() {
		return this.items.size();
	}

	@Override
	public boolean isEmpty() {
		for(ItemStack itemstack : this.items) {
	         if (!itemstack.isEmpty()) {
	            return false;
	         }
	     }
	     return true;
	}

	@Override
	public ItemStack getItem(int id) {
		return this.items.get(id);
	}

	@Override
	public ItemStack removeItem(int p_70298_1_, int p_70298_2_) {
		return ContainerHelper.removeItem(items, p_70298_1_, p_70298_2_);
	}

	@Override
	public ItemStack removeItemNoUpdate(int slot) {
		return ContainerHelper.takeItem(items, slot);
	}

	@Override
	public void setItem(int slot, ItemStack stack) {
		ItemStack slotStack = this.items.get(slot);
		boolean flag = !stack.isEmpty() && stack.sameItem(slotStack) && ItemStack.tagMatches(stack, slotStack);
		this.items.set(slot, stack);
		if(stack.getCount() > this.getMaxStackSize()) {
			stack.setCount(this.getMaxStackSize());
		}
		if(slot == 0 && !flag) {
			this.recipeProgress = 0;
		}
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
		this.items.clear();
	}

	@Override
	public int[] getSlotsForFace(Direction dir) {
		if (dir == Direction.DOWN) {
	         return SLOTS_FOR_DOWN;
	    } else {
	         return dir == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
	    }
	}

	@Override
	public boolean canPlaceItemThroughFace(int slot, ItemStack stack, Direction dir) {
		if(dir != Direction.DOWN && slot == 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean canTakeItemThroughFace(int slot, ItemStack stack, Direction dir) {
		 if (dir == Direction.DOWN && slot == 1) {
	         return true;
	      }
	      return false;
	}

	@Override
	protected Component getDefaultName() {
		return new TranslatableComponent("container.seed_recycler");
	}

	@Override
	protected AbstractContainerMenu createMenu(int a, Inventory inventory) {
		this.handler.setStackInSlot(0, this.items.get(0));
		this.handler.setStackInSlot(1, this.items.get(1));
		return new TransformerMenu(a, inventory, this, this.dataAccess);
	}
}