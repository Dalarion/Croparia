package com.croparia.mod.core;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;

public class Crops {

    private String name;
    private String type;
    private RegistryObject<Block> crop;
    private RegistryObject<ItemNameBlockItem> seeds;
    private RegistryObject<Item> fruit;
    private Item ingredient;
    private int tier;

    public Crops(String name, int tier, Item ingredient, String type) {
        this.name = name;
        this.tier = tier;
        this.ingredient = ingredient;
        this.type = type;
    }

    public Crops(String name, int tier, String type) {
        this.name = name;
        this.tier = tier;
        this.ingredient = null;
        this.type = type;
    }

    public Crops(String name, int tier, Item ingredient) {
        this.name = name;
        this.tier = tier;
        this.ingredient = ingredient;
        this.type = null;
    }

    public Crops(String name, int tier) {
        this.name = name;
        this.tier = tier;
        this.ingredient = null;
        this.type = null;
    }

    public Crops(String name) {
        this.name = name;
        this.tier = 0;
        this.ingredient = null;
        this.type = null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RegistryObject<Block> getCrop() {
        return crop;
    }

    public void setCrop(RegistryObject<Block> crop) {
        this.crop = crop;
    }

    public RegistryObject<ItemNameBlockItem> getSeeds() {
        return seeds;
    }

    public void setSeeds(RegistryObject<ItemNameBlockItem> seeds) {
        this.seeds = seeds;
    }

    public RegistryObject<Item> getFruit() {
        return fruit;
    }

    public void setFruit(RegistryObject<Item> fruit) {
        this.fruit = fruit;
    }

    public Item getIngredient() {
        return ingredient;
    }

    public void setIngredient(Item ingredient) {
        this.ingredient = ingredient;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }
}
