package com.croparia.mod.common.blocks;

import com.croparia.mod.common.blockEntity.CollectorBE;
import com.croparia.mod.common.blockEntity.GeneratorBE;
import com.croparia.mod.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import javax.annotation.Nullable;

public class CropGenerator extends BaseEntityBlock {

	public CropGenerator() {
		super(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(10F));
	}

	@Override
	public void onPlace(BlockState state, Level world, BlockPos pos, BlockState p_220082_4_, boolean p_220082_5_) {
		if(!world.isClientSide){
			if(world.getBlockEntity(pos) instanceof GeneratorBE){
				GeneratorBE be = (GeneratorBE) world.getBlockEntity(pos);
				be.initAges();
			}
		}
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return BlockEntityInit.GENERATOR_BE.get().create(pos, state);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153212_, BlockState p_153213_, BlockEntityType<T> blockEntityType) {
		return createTickerHelper(blockEntityType, BlockEntityInit.GENERATOR_BE.get(), GeneratorBE::tick);
	}

	@Override
	public RenderShape getRenderShape(BlockState p_49232_) {
		return RenderShape.MODEL;
	}
}
