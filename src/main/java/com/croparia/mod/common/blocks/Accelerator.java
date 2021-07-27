package com.croparia.mod.common.blocks;

import com.croparia.mod.CropariaMod;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.Random;

public class Accelerator extends Block {
    private final int range;

    public Accelerator(int range) {
        super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(10F));
        this.range = range;
    }
    
    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
        world.getBlockTicks().scheduleTick(pos, this, CropariaMod.getTickRate());
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        BlockPos.betweenClosedStream(pos.above(2), pos.above(this.range + 2))
                .filter(pos2 -> world.getBlockState(pos2).getBlock() instanceof BonemealableBlock)
                .findFirst()
                .ifPresent(pos2 -> world.getBlockState(pos2).randomTick(world, pos2, random));

        world.getBlockTicks().scheduleTick(pos, this, CropariaMod.getTickRate());
    }


}
