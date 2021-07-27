package com.croparia.mod.common.blockEntity;

import com.croparia.mod.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
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

public class BatteryBE extends BlockEntity {
    public BatteryBE(BlockPos pos, BlockState state) {
        super(BlockEntityInit.BATTERY_BE.get(), pos, state);
    }

    private final EnergyStorage energyStorage = new EnergyStorage(1000000, 10000, 10000, 0){
        @Override
        public boolean canExtract() {
            return true;
        }

        @Override
        public boolean canReceive() {
            return true;
        }
    };

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityEnergy.ENERGY){
            return LazyOptional.of(() -> energyStorage).cast();
        }
        return super.getCapability(cap, side);
    }

    public static void tick(Level level, BlockPos worldPosition, BlockState state, BatteryBE batteryBE) {
        if(!level.isClientSide){
            giveEnergy(batteryBE);
        }
    }

    private static void giveEnergy(BatteryBE batteryBE){
        Arrays.stream(Direction.values()).forEach(direction -> {
            if(direction != Direction.UP && direction != Direction.DOWN) {
                BlockPos pos = batteryBE.worldPosition.relative(direction);
                BlockEntity be = batteryBE.level.getBlockEntity(pos);
                if (batteryBE.canReceiveEnergyFromFace(be, direction.getOpposite())) {
                    batteryBE.getCapability(CapabilityEnergy.ENERGY, direction).ifPresent(cap -> {
                        AtomicInteger energy = new AtomicInteger(10000);
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

    private boolean canReceiveEnergyFromFace(BlockEntity be, Direction side){
        AtomicBoolean cond = new AtomicBoolean(false);
        if(be != null){
            be.getCapability(CapabilityEnergy.ENERGY, side).ifPresent(cap -> cond.set(cap.canReceive()));
        }
        return cond.get();
    }

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
}
