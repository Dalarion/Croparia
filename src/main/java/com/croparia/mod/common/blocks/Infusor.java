package com.croparia.mod.common.blocks;

import com.croparia.mod.core.init.ItemInit;
import com.croparia.mod.core.recipes.InfusorRecipe;
import com.croparia.mod.core.util.ElementsEnum;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolType;

public class Infusor extends Block{

	protected final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	public static final EnumProperty<ElementsEnum> TYPE = EnumProperty.create("infusor_type", ElementsEnum.class);

	public Infusor() {
		super(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().harvestLevel(1).harvestTool(ToolType.PICKAXE).strength(5F));
		this.registerDefaultState(this.defaultBlockState().setValue(TYPE, ElementsEnum.EMPTY));
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player,
								   InteractionHand handIn, BlockHitResult hit)
	{
		if(!worldIn.isClientSide){
			if(state.getValue(TYPE) == ElementsEnum.EMPTY && ItemInit.getElementFromPotion(player.getMainHandItem().getItem()) != ElementsEnum.EMPTY)
			{
				worldIn.setBlockAndUpdate(pos, this.defaultBlockState().setValue(TYPE, ItemInit.getElementFromPotion(player.getMainHandItem().getItem())));
				player.getMainHandItem().shrink(1);
				worldIn.addFreshEntity(new ItemEntity(worldIn, pos.getX()+0.5, pos.getY()+0.5, pos.getZ()+0.5, new ItemStack(Items.GLASS_BOTTLE)));
			}
			else if(state.getValue(TYPE) != ElementsEnum.EMPTY && player.getMainHandItem().getItem() == Items.GLASS_BOTTLE) 
			{
				worldIn.setBlockAndUpdate(pos, this.defaultBlockState().setValue(TYPE, ElementsEnum.EMPTY));
				player.getMainHandItem().shrink(1);
				worldIn.addFreshEntity(new ItemEntity(worldIn, pos.getX()+0.5, pos.getY()+0.5, pos.getZ()+0.5, new ItemStack(ItemInit.getPotionFromElement(state.getValue(TYPE)))));
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.FAIL;
	}

	@Override
	public void stepOn(Level level, BlockPos pos, BlockState state, Entity entityIn) {
		if(entityIn instanceof ItemEntity && !level.isClientSide) {
			ItemEntity entity = (ItemEntity) entityIn;
			InfusorRecipe.craft(entity.getItem(), level, pos);
		}
	}

	@Override
	public VoxelShape getShape(BlockState p_56390_, BlockGetter p_56391_, BlockPos p_56392_, CollisionContext p_56393_) {
		return SHAPE;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(TYPE);
	}
}
