package com.croparia.mod.core.init;

import com.croparia.mod.CropariaMod;
import com.croparia.mod.core.recipes.ShapelessTagRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModRecipeSerializers {
    public static final RecipeSerializer<?> SHAPELESS_TAG = new ShapelessTagRecipe.Serializer();
    
    @SubscribeEvent
    public void onRegisterSerializers(RegistryEvent.Register<RecipeSerializer<?>> event) {
        IForgeRegistry<RecipeSerializer<?>> registry = event.getRegistry();

        registry.register(SHAPELESS_TAG.setRegistryName(new ResourceLocation(CropariaMod.mod_id, "shapeless_tag")));
    }
}
