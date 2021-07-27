package com.croparia.mod.common.blockEntity;

import com.croparia.mod.common.blocks.CropariaCrops;
import com.croparia.mod.core.Crops;
import com.croparia.mod.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class GeneratorBE extends BlockEntity {

	public int[] ages = {0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0};

    public GeneratorBE(BlockPos pos, BlockState state) {
		super(BlockEntityInit.GENERATOR_BE.get(), pos, state);
	}

    private final EnergyStorage energyStorage = new EnergyStorage(10000, 1400, 1400, 0){
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
	public void load(CompoundTag compoundTag) {
		super.load(compoundTag);
		if(compoundTag.contains("energyStorage")){
			this.energyStorage.deserializeNBT(compoundTag.get("energyStorage"));
		}
	}

	@Override
	public CompoundTag save(CompoundTag compoundTag) {
		super.save(compoundTag);
		compoundTag.put("energyStorage", energyStorage.serializeNBT());
		return compoundTag;
	}

    public void initAges(){
		AtomicInteger i = new AtomicInteger(0);
		BlockPos.betweenClosedStream(worldPosition.north(2).east(2), worldPosition.south(2).west(2)).forEach(pos -> {
			if(level.getBlockState(pos).getBlock() instanceof CropariaCrops) {
				ages[i.get()] = level.getBlockState(pos).getValue(CropariaCrops.AGE);
			}
			i.getAndIncrement();
		});
	}

    public static void addEnergy(GeneratorBE generatorBE, Crops crops, BlockPos pos){
		if(!generatorBE.level.isClientSide) {
			CropariaCrops block = ((CropariaCrops) generatorBE.level.getBlockState(pos).getBlock());

			int createdEnergy = 100 * crops.getTier();
			if (block.isMaxAge(generatorBE.level.getBlockState(pos))) {
				createdEnergy *= 2;
				generatorBE.level.setBlock(pos, block.defaultBlockState().setValue(CropariaCrops.AGE, 0), 3);
			}
			int finalCreatedEnergy = createdEnergy;
			generatorBE.getCapability(CapabilityEnergy.ENERGY, Direction.getNearest(pos.getX(), pos.getY(), pos.getZ())).ifPresent(cap -> cap.receiveEnergy(finalCreatedEnergy, false));
		}
	}

	public static void tick(Level level, BlockPos worldPosition, BlockState state, GeneratorBE generatorBE) {
		if(!generatorBE.level.isClientSide){
			AtomicInteger i = new AtomicInteger(0);
			BlockPos.betweenClosedStream(worldPosition.north(2).east(2), worldPosition.south(2).west(2)).forEach(pos -> {
				if(level.getBlockState(pos).getBlock() instanceof CropariaCrops){
					if(generatorBE.ages[i.get()] != level.getBlockState(pos).getValue(CropariaCrops.AGE)){
						addEnergy(generatorBE, ((CropariaCrops) generatorBE.level.getBlockState(pos).getBlock()).getCrop(), pos);
					}
					if(((CropariaCrops)level.getBlockState(pos).getBlock()).isMaxAge(level.getBlockState(pos))){
						level.setBlock(pos, level.getBlockState(pos).setValue(CropariaCrops.AGE, 0), 3);
					}
					generatorBE.ages[i.get()] = level.getBlockState(pos).getValue(CropariaCrops.AGE);
					i.getAndIncrement();
				}
			});

			giveEnergy(generatorBE);
		}
	}

	private static void giveEnergy(GeneratorBE generatorBE){
		Arrays.stream(Direction.values()).forEach(direction -> {
			if(direction == Direction.UP) {
				BlockPos pos = generatorBE.worldPosition.relative(direction);
				BlockEntity be = generatorBE.level.getBlockEntity(pos);
				if (canReceiveEnergyFromFace(be, direction.getOpposite())) {
					generatorBE.getCapability(CapabilityEnergy.ENERGY, direction).ifPresent(cap -> {
						AtomicInteger energy = new AtomicInteger(1400);
						energy.set(cap.extractEnergy(energy.get(), true));
						be.getCapability(CapabilityEnergy.ENERGY, direction.getOpposite()).ifPresent(cap2 -> {
							energy.set(cap2.receiveEnergy(energy.get(), true));
							cap.extractEnergy(energy.get(), false);
							cap2.receiveEnergy(energy.get(), false);
						});
					});
				}
			}
		});
	}

	private static boolean canReceiveEnergyFromFace(BlockEntity be, Direction side){
		AtomicBoolean cond = new AtomicBoolean(false);
		if(be != null){
			be.getCapability(CapabilityEnergy.ENERGY, side).ifPresent(cap -> cond.set(cap.canReceive()));
		}
		return cond.get();
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if(cap == CapabilityEnergy.ENERGY){
			return LazyOptional.of(() -> energyStorage).cast();
		}
		return super.getCapability(cap, side);
	}
}