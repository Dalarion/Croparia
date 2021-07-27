package com.croparia.mod.common.items;

import com.croparia.mod.core.Crops;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;

public class CropsSeed extends ItemNameBlockItem {

    private Crops crop;

    public CropsSeed(Crops crop, Block p_i50041_1_, Properties p_i50041_2_) {
        super(p_i50041_1_, p_i50041_2_);
        this.setCrop(crop);
    }

    public Crops getCrop() {
        return crop;
    }

    public void setCrop(Crops crop) {
        this.crop = crop;
    }
}