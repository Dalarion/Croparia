package com.croparia.mod.common.blocks;

import com.croparia.mod.common.blockEntity.CollectorBE;
import com.croparia.mod.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

public class Collector extends BaseEntityBlock {

	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

	public Collector() {
		super(BlockBehaviour.Properties.of(Material.STONE).strength(10F).randomTicks());
	}
	
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		if (!worldIn.isClientSide) {
	        BlockEntity blockEntity = worldIn.getBlockEntity(pos);
	        if (blockEntity instanceof CollectorBE) {
				if (player instanceof ServerPlayer) {
					NetworkHooks.openGui((ServerPlayer) player, (CollectorBE) blockEntity, pos);
					return InteractionResult.SUCCESS;
				}
	        }
	     }
		return InteractionResult.FAIL;
	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos blockPos, BlockState state2, boolean p_60519_) {
		if(!state.is(state2.getBlock())){
			BlockEntity blockEntity = level.getBlockEntity(blockPos);
			if(blockEntity instanceof CollectorBE){
				Containers.dropContents(level, blockPos, (CollectorBE)blockEntity);
				level.updateNeighbourForOutputSignal(blockPos, this);
			}
		}
		super.onRemove(state, level, blockPos, state2, p_60519_);
	}

	
	private boolean connectedToPower(Level worldIn, BlockPos pos, Direction facing) {
	      for(Direction direction : Direction.values()) {
	         if (direction != facing && worldIn.hasSignal(pos.relative(direction), direction)) {
	            return true;
	         }
	      }
		return false;
	}
	
	@Override
	public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		boolean powered = state.getValue(POWERED);
		boolean powerConnected = this.connectedToPower(worldIn, pos, state.getValue(FACING));
		AtomicBoolean energy = new AtomicBoolean(false);
		((CollectorBE)worldIn.getBlockEntity(pos)).getCapability(CapabilityEnergy.ENERGY).ifPresent(cap -> {
				if(cap.getEnergyStored() > 0)
					energy.set(true);
		});
		if(!powered && powerConnected && energy.get()) {
			worldIn.setBlockAndUpdate(pos, this.defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(POWERED, true));
		} else if(powered) {
			if(!powerConnected || !energy.get()){
				worldIn.setBlockAndUpdate(pos, this.defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(POWERED, false));
			}
		}
	}

	@Override
	public boolean shouldCheckWeakPower(BlockState state, LevelReader world, BlockPos pos, Direction side) {
		return side != Direction.NORTH ? true : false;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(POWERED, false);
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, POWERED);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return BlockEntityInit.COLLECTOR_BE.get().create(pos, state);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
		return createTickerHelper(blockEntityType, BlockEntityInit.COLLECTOR_BE.get(), CollectorBE::tick);
	}

	@Override
	public RenderShape getRenderShape(BlockState p_49232_) {
		return RenderShape.MODEL;
	}
}
