package com.croparia.mod.core.recipes;

import com.croparia.mod.CropariaMod;
import com.croparia.mod.core.init.ModRecipeSerializers;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class ShapelessTagRecipe extends ShapelessRecipe {

	public ShapelessTagRecipe(ResourceLocation id, String group, ItemStack output,
                              NonNullList<Ingredient> inputs) {
		super(id, group, output, inputs);
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ModRecipeSerializers.SHAPELESS_TAG;
	}
	
	public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<ShapelessTagRecipe> {

        @Override
		public ShapelessTagRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
			String group = GsonHelper.getAsString(json, "group", "");
			
			JsonArray array = GsonHelper.getAsJsonArray(json, "ingredients");
			NonNullList<Ingredient> inputs = NonNullList.create();
			
			for (int i = 0; i < array.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(array.get(i));
                if (!ingredient.isEmpty()) {
                	inputs.add(ingredient);
                }
            }

            if (inputs.isEmpty()) {
                throw new JsonParseException("No ingredients");
            } else if (inputs.size() > 9) {
                throw new JsonParseException("Max ingredients' count is 9");
            }

            JsonObject result = GsonHelper.getAsJsonObject(json, "result");
            String tag = GsonHelper.getAsString(result, "tag");
            int count = GsonHelper.getAsInt(result, "count", 1);

            Item item = null;

            try {
                item = CropariaMod.getItemFromTag(tag);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            if(item == Items.AIR) {
            	System.out.print("no item with the tag :" + tag);
            	return null;
            }

            ItemStack output = new ItemStack(item, count);
            
            return new ShapelessTagRecipe(recipeId, group, output, inputs);
        }

        @Override
		public ShapelessTagRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
			String group = buffer.readUtf(32767);
            int size = buffer.readVarInt();
            NonNullList<Ingredient> inputs = NonNullList.withSize(size, Ingredient.EMPTY);

            for (int j = 0; j < inputs.size(); j++) {
                inputs.set(j, Ingredient.fromNetwork(buffer));
            }

            ItemStack output = buffer.readItem();

            return new ShapelessTagRecipe(recipeId, group, output, inputs);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buffer, ShapelessTagRecipe recipe) {
			buffer.writeUtf(recipe.getGroup());
            buffer.writeVarInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buffer);
            }

            buffer.writeItem(recipe.getResultItem());
		}	
	}
}
