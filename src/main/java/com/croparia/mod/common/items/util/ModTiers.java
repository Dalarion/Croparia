package com.croparia.mod.common.items.util;

import com.croparia.mod.core.init.ItemInit;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModTiers implements Tier {

    OBSIDIAN(3, 3000, 12.0f, 5.0f, 12, () -> {
        return Ingredient.of(Items.OBSIDIAN);
    }),

    RENFORCED(3,6000,24.0f,10.0f,24,() -> {
        return Ingredient.of(Items.DIAMOND);
    }),

    WATER(3,7500,27.0f,15.0f,27,() -> {
        return Ingredient.of(ItemInit.ELEMENTAL_WATER.get());
    }),

    FIRE(3,7500,27.0f,15.0f,27,() -> {
        return Ingredient.of(ItemInit.ELEMENTAL_FIRE.get());
    }),

    EARTH(3,7500,27.0f,15.0f,27,() -> {
        return Ingredient.of(ItemInit.ELEMENTAL_EARTH.get());
    }),

    AIR(3,7500,27.0f,15.0f,27,() ->{
        return Ingredient.of(ItemInit.ELEMENTAL_AIR.get());
    }),

    WOOD_MULTI(0,236,2.0f,0.0f,15,() ->{
        return Ingredient.of(Items.OAK_PLANKS);
    }),

    STONE_MULTI(1,524,4.0f,1.0f,5,() ->{
        return Ingredient.of(Items.STONE);
    }),

    IRON_MULTI(2,1000,6.0f,2.0f,14,() ->{
        return Ingredient.of(Items.IRON_BLOCK);
    }),

    GOLD_MULTI(2,128,12.0f,0.0f,22,() ->{
        return Ingredient.of(Items.GOLD_BLOCK);
    }),

    DIAMOND_MULTI(3,6244,8.0f,3.0f,10,() ->{
        return Ingredient.of(Items.DIAMOND);
    }),

    NETHERITE_MULTI(3,9000,10.0f,4.0f,11,() ->{
        return Ingredient.of(Items.NETHERITE_INGOT);
    }),

    OBSIDIAN_MULTI(3,12000,12.0f,5.0f,12,() ->{
        return Ingredient.of(Items.OBSIDIAN);
    }),

    RENFORCED_MULTI(3,24000,24.0f,10.0f,24,() ->{
        return Ingredient.of(Items.DIAMOND);
    }),

    ELEMENTAL_MULTI(3,30000,48.0f,15.0f,32,() ->{
        return Ingredient.of(ItemInit.ELEMATILIUS.get());
    });

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private ModTiers(int p_43332_, int p_43333_, float p_43334_, float p_43335_, int p_43336_, Supplier<Ingredient> p_43337_) {
        this.level = p_43332_;
        this.uses = p_43333_;
        this.speed = p_43334_;
        this.damage = p_43335_;
        this.enchantmentValue = p_43336_;
        this.repairIngredient = new LazyLoadedValue<>(p_43337_);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}