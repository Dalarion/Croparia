package com.croparia.mod.core.init;

import com.croparia.mod.CropariaMod;
import com.croparia.mod.common.menu.TransformerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MenuInit {
	public static final DeferredRegister<MenuType<?>> CONTAINERS_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, CropariaMod.mod_id);

	public static final RegistryObject<MenuType<TransformerMenu>> TRANSFORMER_MENU = CONTAINERS_TYPES
			.register("transformer_menu", () -> new MenuType<>(TransformerMenu::new));
}
