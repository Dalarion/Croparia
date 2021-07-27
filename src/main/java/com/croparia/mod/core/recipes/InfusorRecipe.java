package com.croparia.mod.core.recipes;

import com.croparia.mod.common.blocks.Infusor;
import com.croparia.mod.core.init.BlockInit;
import com.croparia.mod.core.util.ElementsEnum;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;;

import java.util.ArrayList;
import java.util.List;

public class InfusorRecipe implements IInfusorRecipe {

	public static List<InfusorRecipe> recipes = new ArrayList<InfusorRecipe>();
	
	private final Item base;
	private final ElementsEnum type;
	private final ItemStack result;
	private final ResourceLocation id;
	
	public InfusorRecipe(ResourceLocation id, Item base, ElementsEnum type, ItemStack result) {
	      this.base = base;
	      this.type = type;
	      this.result = result;
	      this.id = id;
	}
	
	public static void craft(ItemStack input, Level world, BlockPos pos) {
		boolean ret = false;
		int index = 0;
		while(ret == false && index < recipes.size()) {
			if(recipes.get(index).base == input.getItem() && world.getBlockState(pos).getValue(Infusor.TYPE) == recipes.get(index).type) {
				ret = true;
			}
			else{
				index++;
			}
		}
		if(ret){
			world.addFreshEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, recipes.get(index).result));
			world.setBlockAndUpdate(pos, BlockInit.INFUSOR.get().defaultBlockState().setValue(Infusor.TYPE, ElementsEnum.EMPTY));
			input.shrink(1);
		}
	}
	
	public static void addRecipe(String id, Item input, ElementsEnum type, Item output) {
		recipes.add(new InfusorRecipe(new ResourceLocation(id), input, type, new ItemStack(output)));
	}
	
	public static void addRecipe(String id, Item input, ElementsEnum type, ItemStack output) {
		recipes.add(new InfusorRecipe(new ResourceLocation(id), input, type, output));
	}

	@Override
	public ItemStack getResultItem() {
		return this.result;
	}
	
	public ElementsEnum getElement() {
		return this.type;
	}

	@Override
	public NonNullList<Ingredient> getIngredients()
	{
		NonNullList<Ingredient> list = NonNullList.create();
		list.add(Ingredient.of(this.base));
		return list;
	}

	@Override
	public boolean matches(Container p_44002_, Level p_44003_) {
		return true;
	}

	@Override
	public ItemStack assemble(Container p_44001_) {
		return this.result.copy();
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) 
	{
		return true;
	}

	@Override
	public ResourceLocation getId() 
	{
		return id;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return null;
	}

	@Override
	public RecipeType<?> getType() {
		return RecipeTypes.INFUSOR;
	}
}
