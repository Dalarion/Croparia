package com.croparia.mod.core.init;

import com.croparia.mod.client.screen.TransformerScreen;
import net.minecraft.client.gui.screens.MenuScreens;

public class ScreenInit {
    public static void init(){
        MenuScreens.register(MenuInit.TRANSFORMER_MENU.get(), TransformerScreen::new);
    }
}
