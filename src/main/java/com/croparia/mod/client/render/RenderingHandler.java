package com.croparia.mod.client.render;

import com.croparia.mod.common.blocks.Greenhouse;
import com.croparia.mod.core.init.BlockInit;
import com.croparia.mod.core.init.CropsInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;

public class RenderingHandler
{
    public static void init() {

    	//Crops
    	CropsInit.crops.forEach(crop -> {
			ItemBlockRenderTypes.setRenderLayer(crop.getCrop().get(), RenderType.cutoutMipped());
    	});
		CropsInit.moddedCrops.forEach(crop -> {
			ItemBlockRenderTypes.setRenderLayer(crop.getCrop().get(), RenderType.cutoutMipped());
		});
    	CropsInit.fruits.forEach(fruit -> {
			ItemBlockRenderTypes.setRenderLayer(fruit.getCrop().get(), RenderType.cutoutMipped());
    	});

    	//Greenhouses
    	Greenhouse.blockGreenhouse.forEach(block -> {
    		ItemBlockRenderTypes.setRenderLayer(block, RenderType.translucent());
    	});
    	//Empty array to free RAM (I suppose)
		Greenhouse.blockGreenhouse.clear();

		//Blocks
    	ItemBlockRenderTypes.setRenderLayer(BlockInit.RITUAL_STAND.get(), RenderType.cutoutMipped());



    }
}
