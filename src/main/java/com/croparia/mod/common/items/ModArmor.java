package com.croparia.mod.common.items;

import com.croparia.mod.CropariaMod;
import com.croparia.mod.core.init.ItemInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ModArmor extends ArmorItem
{
	public ModArmor(ArmorMaterial materialIn, EquipmentSlot slot) {
		super(materialIn, slot, new Item.Properties().tab(CropariaMod.MAIN));
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		if(this == ItemInit.OBSIDIAN_LEGS.get())
        {
            return CropariaMod.mod_id + ":textures/models/armor/obsidian_layer_2.png";
        }
        else if (this == ItemInit.OBSIDIAN_HELMET.get() || this == ItemInit.OBSIDIAN_CHEST.get() || this == ItemInit.OBSIDIAN_FEET.get())
        {
            return CropariaMod.mod_id + ":textures/models/armor/obsidian_layer_1.png";
        }
        else if(this == ItemInit.RENFORCED_LEGS.get())
        {
            return CropariaMod.mod_id + ":textures/models/armor/renforced_layer_2.png";
        }
        else if (this == ItemInit.RENFORCED_HELMET.get() || this == ItemInit.RENFORCED_CHEST.get() || this == ItemInit.RENFORCED_FEET.get())
        {
            return CropariaMod.mod_id + ":textures/models/armor/renforced_layer_1.png";
        }
        else if(this == ItemInit.WATER_LEGS.get())
        {
            return CropariaMod.mod_id + ":textures/models/armor/water_layer_2.png";
        }
        else if (this == ItemInit.WATER_HELMET.get() || this == ItemInit.WATER_CHEST.get() || this == ItemInit.WATER_FEET.get())
        {
            return CropariaMod.mod_id + ":textures/models/armor/water_layer_1.png";
        }
        else if(this == ItemInit.FIRE_LEGS.get())
        {
            return CropariaMod.mod_id + ":textures/models/armor/fire_layer_2.png";
        }
        else if (this == ItemInit.FIRE_HELMET.get() || this == ItemInit.FIRE_CHEST.get() || this == ItemInit.FIRE_FEET.get())
        {
            return CropariaMod.mod_id + ":textures/models/armor/fire_layer_1.png";
        }
        else if(this == ItemInit.EARTH_LEGS.get())
        {
            return CropariaMod.mod_id + ":textures/models/armor/earth_layer_2.png";
        }
        else if (this == ItemInit.EARTH_HELMET.get() || this == ItemInit.EARTH_CHEST.get() || this == ItemInit.EARTH_FEET.get())
        {
            return CropariaMod.mod_id + ":textures/models/armor/earth_layer_1.png";
        }
        else if(this == ItemInit.AIR_LEGS.get())
        {
            return CropariaMod.mod_id + ":textures/models/armor/air_layer_2.png";
        }
        else if (this == ItemInit.AIR_HELMET.get() || this == ItemInit.AIR_CHEST.get() || this == ItemInit.AIR_FEET.get())
        {
            return CropariaMod.mod_id + ":textures/models/armor/air_layer_1.png";
        }
		return null;
	}

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {

		if(isFullStuf(ItemInit.WATER_HELMET.get(), ItemInit.WATER_CHEST.get(), ItemInit.WATER_LEGS.get(), ItemInit.WATER_FEET.get(), player))
		{
			player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER));
			player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 0, 1));
			player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING));
		}
		else if(isFullStuf(ItemInit.FIRE_HELMET.get(), ItemInit.FIRE_CHEST.get(), ItemInit.FIRE_LEGS.get(), ItemInit.FIRE_FEET.get(), player))
		{
			player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 0, 1));
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 0, 1));
		}
		else if(isFullStuf(ItemInit.EARTH_HELMET.get(), ItemInit.EARTH_CHEST.get(), ItemInit.EARTH_LEGS.get(), ItemInit.EARTH_FEET.get(), player))
		{
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE));
			player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 5, 1));
			player.addEffect(new MobEffectInstance(MobEffects.JUMP, 0, 1));
		}
		else if(isFullStuf(ItemInit.AIR_HELMET.get(), ItemInit.AIR_CHEST.get(), ItemInit.AIR_LEGS.get(), ItemInit.AIR_FEET.get(), player))
		{
			if(!player.getAbilities().flying){
				player.getAbilities().flying = true;
			}
		}
		else if(player.getAbilities().flying) {
			player.getAbilities().flying = false;
		}
	}
	
	private boolean isFullStuf(Item head, Item chest, Item legs, Item feet, Player player) {
		return (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == chest
				&& player.getItemBySlot(EquipmentSlot.HEAD).getItem() == head
				&& player.getItemBySlot(EquipmentSlot.LEGS).getItem() == legs
				&& player.getItemBySlot(EquipmentSlot.FEET).getItem() == feet);
			
	}
	
}