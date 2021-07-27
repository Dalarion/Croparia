package com.croparia.mod.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.StemBlock;

public class GreenHouseBlockItem extends ItemNameBlockItem
{
    public GreenHouseBlockItem(Block blockIn, Properties builder) {
		super(blockIn, builder);
	}

    @Override
    public InteractionResult useOn(UseOnContext context) {
        final Level level = context.getLevel();
        final Player player = context.getPlayer();
        final BlockPos pos = context.getClickedPos();
        if(!level.isClientSide) {
            if (level.isEmptyBlock(pos.above())) {
                if (level.getBlockState(pos).getBlock() instanceof CropBlock || level.getBlockState(pos).getBlock() instanceof StemBlock || level.getBlockState(pos).getBlock() instanceof AttachedStemBlock) {
                    level.setBlockAndUpdate(pos.above(), this.getBlock().defaultBlockState());
                    context.getItemInHand().shrink(1);
                    return InteractionResult.SUCCESS;
                }
            }
            if (level.isEmptyBlock(pos.above(2)) && level.isEmptyBlock(pos.above())) {
                level.setBlockAndUpdate(pos.above(2), this.getBlock().defaultBlockState());
                context.getItemInHand().shrink(1);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }
}