package com.croparia.mod.core.recipes;

import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;

public interface IInfusorRecipe extends Recipe<Container> {
    @SuppressWarnings("unchecked")
	default <T extends IInfusorRecipe> T cast() {
        return (T) this;
    }
}