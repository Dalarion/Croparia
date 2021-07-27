package com.croparia.mod.common.items.util;

import com.croparia.mod.core.init.ItemInit;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import javax.swing.*;
import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {
	
	OBSIDIAN("obsidian", 40, new int[] { 5, 8, 10, 5 }, 12, SoundEvents.ARMOR_EQUIP_NETHERITE , 2.0f, () -> Ingredient.of(Items.OBSIDIAN)),
    RENFORCED("renforced", 80, new int[] { 10, 16, 20, 10 }, 24, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0f, () -> Ingredient.of(Items.DIAMOND)),
    WATER("elemental", 120, new int[] { 15, 24, 30, 15 }, 36, SoundEvents.ARMOR_EQUIP_NETHERITE, 6.0f, () -> Ingredient.of(ItemInit.ELEMENTAL_WATER.get())),
    EARTH("elemental", 120, new int[] { 15, 24, 30, 15 }, 36, SoundEvents.ARMOR_EQUIP_NETHERITE, 6.0f, () -> Ingredient.of(ItemInit.ELEMENTAL_EARTH.get())),
    FIRE("elemental", 120, new int[] { 15, 24, 30, 15 }, 36, SoundEvents.ARMOR_EQUIP_NETHERITE, 6.0f, () -> Ingredient.of(ItemInit.ELEMENTAL_FIRE.get())),
    AIR("elemental", 120, new int[] { 15, 24, 30, 15 }, 36, SoundEvents.ARMOR_EQUIP_NETHERITE, 6.0f, () -> Ingredient.of(ItemInit.ELEMENTAL_AIR.get()));
   
    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Ingredient repairMaterial;
    
    private ModArmorMaterial(final String nameIn, final int maxDamageFactorIn, final int[] damageReductionAmountsIn, final int enchantabilityIn, final SoundEvent equipSoundIn, final float p_i48533_8_, final Supplier<Ingredient> repairMaterialSupplier) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountsIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = equipSoundIn;
        this.toughness = p_i48533_8_;
        this.repairMaterial = repairMaterialSupplier.get();
    }

	@Override
	public int getDurabilityForSlot(EquipmentSlot slotIn) {
		return ModArmorMaterial.MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlot slotIn) {
		return damageReductionAmountArray[slotIn.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return soundEvent;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return repairMaterial;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getToughness() {
		return toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return 0;
	}
}
