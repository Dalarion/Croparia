package com.croparia.mod.common.blocks;

import com.croparia.mod.core.recipes.RitualRecipe;
import com.croparia.mod.core.recipes.rituals.FirstRitual;
import com.croparia.mod.core.recipes.rituals.SecondRitual;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RitualStand extends Block {

	protected final VoxelShape SHAPE = Block.box(0.0D, 0.3D, 0.0D, 16.0D, 6.0D, 16.0D);

	public RitualStand() {
		super(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 1200.0F).sound(SoundType.ANVIL));
	}

	@Override
	public void stepOn(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
		if(entityIn instanceof ItemEntity && !worldIn.isClientSide) {
			if(((ItemEntity) entityIn).getItem().getItem() == Items.DRAGON_HEAD) {
				if(FirstRitual.checkRitual(null, worldIn, pos, true)) {
					SecondRitual.placeRitual(worldIn, pos);
				}
				else {
					FirstRitual.placeRitual(worldIn, pos);
				}
				((ItemEntity) entityIn).getItem().shrink(1);
			}
			ItemStack stack = ((ItemEntity) entityIn).getItem();
			RitualRecipe.craft(stack, worldIn, pos);
		}
	}

	@Override
	public VoxelShape getShape(BlockState p_56390_, BlockGetter p_56391_, BlockPos p_56392_, CollisionContext p_56393_) {
		return SHAPE;
	}
}
