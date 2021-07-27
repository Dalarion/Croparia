package com.croparia.mod.common.blocks;

import com.croparia.mod.common.blockEntity.TransformerBE;
import com.croparia.mod.core.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

import javax.annotation.Nullable;

public class SeedRecycler extends BaseEntityBlock {

    public SeedRecycler() {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(10F).randomTicks());
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult rayTrace) {
        if(!world.isClientSide) {
            if(world.getBlockEntity(pos) instanceof TransformerBE)
            {
                if (player instanceof ServerPlayer)
                {
                    NetworkHooks.openGui((ServerPlayer) player, (TransformerBE) world.getBlockEntity(pos), pos);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public void onRemove(BlockState p_196243_1_, Level level, BlockPos blockpos, BlockState p_196243_4_, boolean p_196243_5_) {
        if (!p_196243_1_.is(p_196243_4_.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(blockpos);
            if (blockEntity instanceof TransformerBE) {
                Containers.dropContents(level, blockpos, (TransformerBE)blockEntity);
                level.updateNeighbourForOutputSignal(blockpos, this);
            }

            super.onRemove(p_196243_1_, level, blockpos, p_196243_4_, p_196243_5_);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityInit.TRANSFORMER_BE.get().create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, BlockEntityInit.TRANSFORMER_BE.get(), TransformerBE::tick);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }
}
