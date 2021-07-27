package com.croparia.mod.common.blocks;

import com.croparia.mod.CropariaMod;
import com.croparia.mod.common.blockEntity.GreenHouseBE;
import com.croparia.mod.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Greenhouse extends BaseEntityBlock {

	//For render purpose only
	public static List<Greenhouse> blockGreenhouse = new ArrayList<Greenhouse>();

	protected final VoxelShape SHAPE = Block.box(1.0D, 1.0D, 0.0D, 15.0D, 3.0D, 15.0D);

	public Greenhouse() {
		super(BlockBehaviour.Properties.of(Material.GLASS).randomTicks().lightLevel(param -> {
			return 9;
		}));
		blockGreenhouse.add(this);
	}

	@Override
	public VoxelShape getShape(BlockState p_56390_, BlockGetter p_56391_, BlockPos p_56392_, CollisionContext p_56393_) {
		return SHAPE;
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		if (worldIn.isClientSide) {
	        return InteractionResult.SUCCESS;
	     } else {
	        BlockEntity blockEntity = worldIn.getBlockEntity(pos);
	        if (blockEntity instanceof GreenHouseBE) {
	           player.openMenu((GreenHouseBE)blockEntity);
	        }
	        return InteractionResult.CONSUME;
	     }
	}

	@Override
	public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
		if(level.getBlockState(pos.below()).getBlock() instanceof CropBlock){
			level.getBlockState(pos.below()).randomTick(level, pos.below(), random);
		}
		level.getBlockTicks().scheduleTick(pos, this, CropariaMod.getTickRate());
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new GreenHouseBE(pos, state);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
		return createTickerHelper(blockEntityType, BlockEntityInit.GREENHOUSE_BE.get(), GreenHouseBE::tick);
	}

	@Override
	public RenderShape getRenderShape(BlockState p_49232_) {
		return RenderShape.MODEL;
	}
}
