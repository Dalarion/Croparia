package com.croparia.mod.core.recipes;

import com.croparia.mod.CropariaMod;
import com.croparia.mod.core.recipes.rituals.FirstRitual;
import com.croparia.mod.core.recipes.rituals.RitualUtils;
import com.croparia.mod.core.recipes.rituals.SecondRitual;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public class RitualRecipe implements IRitualRecipe {

	public static List<RitualRecipe> recipes = new ArrayList<RitualRecipe>();
	
	private final Item base;
	private final BlockState blockNeed;
	private final ItemStack result;
	private final int ritualTier;
	private final ResourceLocation id;
	
	public RitualRecipe(ResourceLocation id, Item base, BlockState blockNeed, ItemStack result, int ritualTier) {
	      this.base = base;
	      this.blockNeed = blockNeed;
	      this.result = result;
	      this.ritualTier = ritualTier;
	      this.id = id;
	}
	
	public static void craft(ItemStack input, Level world, BlockPos pos) {
		boolean ret = false;
		int index = 0;
		while(ret == false && index < recipes.size()) {
			if(recipes.get(index).base == input.getItem()) {
				switch(recipes.get(index).ritualTier) {
					case 1 : {
						if(FirstRitual.checkRitual(recipes.get(index).blockNeed, world, pos, false)) {
							ret = true;
						}
						break;
					}
					case 2 : {
						if(SecondRitual.checkRitual(recipes.get(index).blockNeed, world, pos, false)) {
						ret = true;
						}
						break;
					}
				}
			}
			if(!ret) {
				index++;
			}
		}
		
		if(ret){
			RitualUtils.endFirst(recipes.get(index).result, input, pos, world);
		}
	}
	
	public static void addRecipe(String id, Item input, BlockState blockNeed, Item output, int ritualTier) {
		recipes.add(new RitualRecipe(new ResourceLocation(CropariaMod.mod_id + id), input, blockNeed, new ItemStack(output), ritualTier));
	}
	
	public static void addRecipe(String id, Item input, BlockState blockNeed, ItemStack output, int ritualTier) {
		recipes.add(new RitualRecipe(new ResourceLocation(CropariaMod.mod_id + id), input, blockNeed, output, ritualTier));
	}

	@Override
	public ItemStack getResultItem() {
		return this.result;
	}
	
	public ItemStack getBlockNeed() {
		return new ItemStack(this.blockNeed.getBlock());
	}
	
	public int getRitualTier() {
		return this.ritualTier;
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
	public RecipeSerializer<?> getSerializer()
	{
		return null;
	}

	@Override
	public RecipeType<?> getType()
	{
		return RecipeTypes.RITUAL;
	}

}
