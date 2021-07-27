package com.croparia.mod.core.recipes;

import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;

public interface IRitualRecipe extends Recipe<Container> {
    @SuppressWarnings("unchecked")
	default <T extends IRitualRecipe> T cast() {
        return (T) this;
    }
}