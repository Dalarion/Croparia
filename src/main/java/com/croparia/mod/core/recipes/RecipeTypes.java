package com.croparia.mod.core.recipes;

import com.croparia.mod.CropariaMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class RecipeTypes {
	
	public static final RecipeType<IInfusorRecipe> INFUSOR = new RecipeType<IInfusorRecipe>() {
        @Override
        public <C extends Container> Optional<IInfusorRecipe> tryMatch(Recipe<C> recipe, Level world, C inv) {
            return recipe.matches(inv, world) ? Optional.of((IInfusorRecipe) recipe) : Optional.empty();
        }
    };


    static {
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(CropariaMod.mod_id, "infusor"), INFUSOR);
    }
}
