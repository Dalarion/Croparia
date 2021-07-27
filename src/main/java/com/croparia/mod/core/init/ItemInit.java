package com.croparia.mod.core.init;

import com.croparia.mod.CropariaMod;
import com.croparia.mod.common.items.*;
import com.croparia.mod.common.items.relics.HornPlenty;
import com.croparia.mod.common.items.relics.InfiniteApple;
import com.croparia.mod.common.items.relics.MidasHand;
import com.croparia.mod.common.items.util.ModArmorMaterial;
import com.croparia.mod.common.items.util.ModTiers;
import com.croparia.mod.core.Crops;
import com.croparia.mod.core.util.ElementsEnum;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CropariaMod.mod_id);

    //Relics
    public static final RegistryObject<MidasHand> MIDAS_HAND = ITEMS.register("midas_hand", () -> new MidasHand());
    public static final RegistryObject<InfiniteApple> INFINITE_APPLE = ITEMS.register("infinite_apple", () -> new InfiniteApple());
    public static final RegistryObject<HornPlenty> HORN_PLENTY = ITEMS.register("horn_plenty", () -> new HornPlenty());

    //Elements
    public static final RegistryObject<Item> ELEMATILIUS = ITEMS.register("elematilius", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> ELEMENTAL_AIR = ITEMS.register("elemental_air", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> ELEMENTAL_FIRE = ITEMS.register("elemental_fire", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> ELEMENTAL_WATER = ITEMS.register("elemental_water", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> ELEMENTAL_EARTH = ITEMS.register("elemental_earth", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<ElementalTime> ELEMENTAL_TIME = ITEMS.register("elemental_time", () -> new ElementalTime(new Item.Properties().tab(CropariaMod.MAIN)));

    //Croparias
    public static final RegistryObject<Item> CROPARIA = ITEMS.register("croparia", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> CROPARIA2 = ITEMS.register("croparia2", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> CROPARIA3 = ITEMS.register("croparia3", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> CROPARIA4 = ITEMS.register("croparia4", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> CROPARIA5 = ITEMS.register("croparia5", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> CROPARIA6 = ITEMS.register("croparia6", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> CROPARIA7 = ITEMS.register("croparia7", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));

    //Potions
    public static final RegistryObject<Item> POTION_ELEMATILIUS = ITEMS.register("potion_elematilius", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> POTION_WATER = ITEMS.register("potion_water", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> POTION_FIRE = ITEMS.register("potion_fire", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> POTION_EARTH = ITEMS.register("potion_earth", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> POTION_AIR = ITEMS.register("potion_air", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));

    //Pies
    public static final RegistryObject<Item> APRICOT_PIE = ITEMS.register("apricot_pie", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN).food(Foods.PUMPKIN_PIE)));
    public static final RegistryObject<Item> BANANA_PIE = ITEMS.register("banana_pie", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN).food(Foods.PUMPKIN_PIE)));
    public static final RegistryObject<Item> CHERRY_PIE = ITEMS.register("cherry_pie", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN).food(Foods.PUMPKIN_PIE)));
    public static final RegistryObject<Item> KIWI_PIE = ITEMS.register("kiwi_pie", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN).food(Foods.PUMPKIN_PIE)));
    public static final RegistryObject<Item> LEMON_PIE = ITEMS.register("lemon_pie", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN).food(Foods.PUMPKIN_PIE)));
    public static final RegistryObject<Item> ORANGE_PIE = ITEMS.register("orange_pie", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN).food(Foods.PUMPKIN_PIE)));
    public static final RegistryObject<Item> PEAR_PIE = ITEMS.register("pear_pie", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN).food(Foods.PUMPKIN_PIE)));

    //Knifes
    public static final RegistryObject<Knife> WOOD_KNIFE = ITEMS.register("wood_knife", () -> new Knife(Tiers.WOOD));
    public static final RegistryObject<Knife> STONE_KNIFE = ITEMS.register("stone_knife", () -> new Knife(Tiers.STONE));
    public static final RegistryObject<Knife> IRON_KNIFE = ITEMS.register("iron_knife", () -> new Knife(Tiers.IRON));
    public static final RegistryObject<Knife> GOLD_KNIFE = ITEMS.register("gold_knife", () -> new Knife(Tiers.GOLD));
    public static final RegistryObject<Knife> DIAMOND_KNIFE = ITEMS.register("diamond_knife", () -> new Knife(Tiers.DIAMOND));
    public static final RegistryObject<Knife> NETHERITE_KNIFE = ITEMS.register("netherite_knife", () -> new Knife(Tiers.NETHERITE));
    public static final RegistryObject<Knife> OBSIDIAN_KNIFE = ITEMS.register("obsidian_knife", () -> new Knife(ModTiers.OBSIDIAN));
    public static final RegistryObject<Knife> RENFORCED_KNIFE = ITEMS.register("renforced_knife", () -> new Knife(ModTiers.RENFORCED));

    //Pestles and Flour
    public static final RegistryObject<Pestle> WOOD_PESTLE = ITEMS.register("wood_pestle", () -> new Pestle());
    public static final RegistryObject<Pestle> STONE_PESTLE = ITEMS.register("stone_pestle", () -> new Pestle());
    public static final RegistryObject<Pestle> IRON_PESTLE = ITEMS.register("iron_pestle", () -> new Pestle());
    public static final RegistryObject<Pestle> GOLD_PESTLE = ITEMS.register("gold_pestle", () -> new Pestle());
    public static final RegistryObject<Pestle> DIAMOND_PESTLE = ITEMS.register("diamond_pestle", () -> new Pestle());
    public static final RegistryObject<Pestle> NETHERITE_PESTLE = ITEMS.register("netherite_pestle", () -> new Pestle());
    public static final RegistryObject<Pestle> OBSIDIAN_PESTLE = ITEMS.register("obsidian_pestle", () -> new Pestle());
    public static final RegistryObject<Pestle> RENFORCED_PESTLE = ITEMS.register("renforced_pestle", () -> new Pestle());
    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));

    //Armors
    public static final RegistryObject<ModArmor> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet", () -> new ModArmor(ModArmorMaterial.OBSIDIAN, EquipmentSlot.HEAD));
    public static final RegistryObject<ModArmor> OBSIDIAN_CHEST = ITEMS.register("obsidian_chestplate", () -> new ModArmor(ModArmorMaterial.OBSIDIAN, EquipmentSlot.CHEST));
    public static final RegistryObject<ModArmor> OBSIDIAN_LEGS = ITEMS.register("obsidian_leggings", () -> new ModArmor(ModArmorMaterial.OBSIDIAN, EquipmentSlot.LEGS));
    public static final RegistryObject<ModArmor> OBSIDIAN_FEET = ITEMS.register("obsidian_boots", () -> new ModArmor(ModArmorMaterial.OBSIDIAN, EquipmentSlot.FEET));
    public static final RegistryObject<ModArmor> RENFORCED_HELMET = ITEMS.register("renforced_helmet", () -> new ModArmor(ModArmorMaterial.OBSIDIAN, EquipmentSlot.HEAD));
    public static final RegistryObject<ModArmor> RENFORCED_CHEST = ITEMS.register("renforced_chestplate", () -> new ModArmor(ModArmorMaterial.OBSIDIAN, EquipmentSlot.CHEST));
    public static final RegistryObject<ModArmor> RENFORCED_LEGS = ITEMS.register("renforced_leggings", () -> new ModArmor(ModArmorMaterial.OBSIDIAN, EquipmentSlot.LEGS));
    public static final RegistryObject<ModArmor> RENFORCED_FEET = ITEMS.register("renforced_boots", () -> new ModArmor(ModArmorMaterial.OBSIDIAN, EquipmentSlot.FEET));
    public static final RegistryObject<ModArmor> WATER_HELMET = ITEMS.register("elemental_water_helmet", () -> new ModArmor(ModArmorMaterial.WATER, EquipmentSlot.HEAD));
    public static final RegistryObject<ModArmor> WATER_CHEST = ITEMS.register("elemental_water_chestplate", () -> new ModArmor(ModArmorMaterial.WATER, EquipmentSlot.CHEST));
    public static final RegistryObject<ModArmor> WATER_LEGS = ITEMS.register("elemental_water_leggings", () -> new ModArmor(ModArmorMaterial.WATER, EquipmentSlot.LEGS));
    public static final RegistryObject<ModArmor> WATER_FEET = ITEMS.register("elemental_water_boots", () -> new ModArmor(ModArmorMaterial.WATER, EquipmentSlot.FEET));
    public static final RegistryObject<ModArmor> FIRE_HELMET = ITEMS.register("elemental_fire_helmet", () -> new ModArmor(ModArmorMaterial.FIRE, EquipmentSlot.HEAD));
    public static final RegistryObject<ModArmor> FIRE_CHEST = ITEMS.register("elemental_fire_chestplate", () -> new ModArmor(ModArmorMaterial.FIRE, EquipmentSlot.CHEST));
    public static final RegistryObject<ModArmor> FIRE_LEGS = ITEMS.register("elemental_fire_leggings", () -> new ModArmor(ModArmorMaterial.FIRE, EquipmentSlot.LEGS));
    public static final RegistryObject<ModArmor> FIRE_FEET = ITEMS.register("elemental_fire_boots", () -> new ModArmor(ModArmorMaterial.FIRE, EquipmentSlot.FEET));
    public static final RegistryObject<ModArmor> EARTH_HELMET = ITEMS.register("elemental_earth_helmet", () -> new ModArmor(ModArmorMaterial.EARTH, EquipmentSlot.HEAD));
    public static final RegistryObject<ModArmor> EARTH_CHEST = ITEMS.register("elemental_earth_chestplate", () -> new ModArmor(ModArmorMaterial.EARTH, EquipmentSlot.CHEST));
    public static final RegistryObject<ModArmor> EARTH_LEGS = ITEMS.register("elemental_earth_leggings", () -> new ModArmor(ModArmorMaterial.EARTH, EquipmentSlot.LEGS));
    public static final RegistryObject<ModArmor> EARTH_FEET = ITEMS.register("elemental_earth_boots", () -> new ModArmor(ModArmorMaterial.EARTH, EquipmentSlot.FEET));
    public static final RegistryObject<ModArmor> AIR_HELMET = ITEMS.register("elemental_air_helmet", () -> new ModArmor(ModArmorMaterial.AIR, EquipmentSlot.HEAD));
    public static final RegistryObject<ModArmor> AIR_CHEST = ITEMS.register("elemental_air_chestplate", () -> new ModArmor(ModArmorMaterial.AIR, EquipmentSlot.CHEST));
    public static final RegistryObject<ModArmor> AIR_LEGS = ITEMS.register("elemental_air_leggings", () -> new ModArmor(ModArmorMaterial.AIR, EquipmentSlot.LEGS));
    public static final RegistryObject<ModArmor> AIR_FEET = ITEMS.register("elemental_air_boots", () -> new ModArmor(ModArmorMaterial.AIR, EquipmentSlot.FEET));

    //Tools
    public static final RegistryObject<SwordItem> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", () -> new SwordItem(ModTiers.OBSIDIAN, 3, -2.4F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<ShovelItem> OBSIDIAN_SHOVEL = ITEMS.register("obsidian_shovel", () -> new ShovelItem(ModTiers.OBSIDIAN, 1.5F, -3.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<PickaxeItem> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", () -> new PickaxeItem(ModTiers.OBSIDIAN, 1, -2.8F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<AxeItem> OBSIDIAN_AXE = ITEMS.register("obsidian_axe", () -> new AxeItem(ModTiers.OBSIDIAN, 5.0F, -3.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<HoeItem> OBSIDIAN_HOE = ITEMS.register("obsidian_hoe", () -> new HoeItem(ModTiers.OBSIDIAN, -3, 0.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<SwordItem> RENFORCED_SWORD = ITEMS.register("renforced_sword", () -> new SwordItem(ModTiers.RENFORCED, 3, -2.4F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<ShovelItem> RENFORCED_SHOVEL = ITEMS.register("renforced_shovel", () -> new ShovelItem(ModTiers.RENFORCED, 1.5F, -3.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<PickaxeItem> RENFORCED_PICKAXE = ITEMS.register("renforced_pickaxe", () -> new PickaxeItem(ModTiers.RENFORCED, 1, -2.8F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<AxeItem> RENFORCED_AXE = ITEMS.register("renforced_axe", () -> new AxeItem(ModTiers.RENFORCED, 5.0F, -3.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<HoeItem> RENFORCED_HOE = ITEMS.register("renforced_hoe", () -> new HoeItem(ModTiers.RENFORCED, -3, 0.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<SwordItem> WATER_SWORD = ITEMS.register("water_sword", () -> new SwordItem(ModTiers.WATER, 3, -2.4F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<ShovelItem> WATER_SHOVEL = ITEMS.register("water_shovel", () -> new ShovelItem(ModTiers.WATER, 1.5F, -3.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<PickaxeItem> WATER_PICKAXE = ITEMS.register("water_pickaxe", () -> new PickaxeItem(ModTiers.WATER, 1, -2.8F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<AxeItem> WATER_AXE = ITEMS.register("water_axe", () -> new AxeItem(ModTiers.WATER, 5.0F, -3.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<HoeItem> WATER_HOE = ITEMS.register("water_hoe", () -> new HoeItem(ModTiers.WATER, -3, 0.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<SwordItem> FIRE_SWORD = ITEMS.register("fire_sword", () -> new SwordItem(ModTiers.FIRE, 3, -2.4F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<ShovelItem> FIRE_SHOVEL = ITEMS.register("fire_shovel", () -> new ShovelItem(ModTiers.FIRE, 1.5F, -3.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<PickaxeItem> FIRE_PICKAXE = ITEMS.register("fire_pickaxe", () -> new PickaxeItem(ModTiers.FIRE, 1, -2.8F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<AxeItem> FIRE_AXE = ITEMS.register("fire_axe", () -> new AxeItem(ModTiers.FIRE, 5.0F, -3.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<HoeItem> FIRE_HOE = ITEMS.register("fire_hoe", () -> new HoeItem(ModTiers.FIRE, -3, 0.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<SwordItem> EARTH_SWORD = ITEMS.register("earth_sword", () -> new SwordItem(ModTiers.EARTH, 3, -2.4F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<ShovelItem> EARTH_SHOVEL = ITEMS.register("earth_shovel", () -> new ShovelItem(ModTiers.EARTH, 1.5F, -3.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<PickaxeItem> EARTH_PICKAXE = ITEMS.register("earth_pickaxe", () -> new PickaxeItem(ModTiers.EARTH, 1, -2.8F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<AxeItem> EARTH_AXE = ITEMS.register("earth_axe", () -> new AxeItem(ModTiers.EARTH, 5.0F, -3.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<HoeItem> EARTH_HOE = ITEMS.register("earth_hoe", () -> new HoeItem(ModTiers.EARTH, -3, 0.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<SwordItem> AIR_SWORD = ITEMS.register("air_sword", () -> new SwordItem(ModTiers.AIR, 3, -2.4F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<ShovelItem> AIR_SHOVEL = ITEMS.register("air_shovel", () -> new ShovelItem(ModTiers.AIR, 1.5F, -3.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<PickaxeItem> AIR_PICKAXE = ITEMS.register("air_pickaxe", () -> new PickaxeItem(ModTiers.AIR, 1, -2.8F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<AxeItem> AIR_AXE = ITEMS.register("air_axe", () -> new AxeItem(ModTiers.AIR, 5.0F, -3.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<HoeItem> AIR_HOE = ITEMS.register("air_hoe", () -> new HoeItem(ModTiers.AIR, -3, 0.0F, new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Multitool> WOOD_MULTITOOL = ITEMS.register("wood_multitool", () -> new Multitool(0, 0, ModTiers.WOOD_MULTI));
    public static final RegistryObject<Multitool> STONE_MULTITOOL = ITEMS.register("stone_multitool", () -> new Multitool(0, 0, ModTiers.STONE_MULTI));
    public static final RegistryObject<Multitool> IRON_MULTITOOL = ITEMS.register("iron_multitool", () -> new Multitool(0, 0, ModTiers.IRON_MULTI));
    public static final RegistryObject<Multitool> GOLD_MULTITOOL = ITEMS.register("gold_multitool", () -> new Multitool(0, 0, ModTiers.GOLD_MULTI));
    public static final RegistryObject<Multitool> DIAMOND_MULTITOOL = ITEMS.register("diamond_multitool", () -> new Multitool(0, 0, ModTiers.DIAMOND_MULTI));
    public static final RegistryObject<Multitool> NETHERITE_MULTITOOL = ITEMS.register("netherite_multitool", () -> new Multitool(0, 0, ModTiers.NETHERITE_MULTI));
    public static final RegistryObject<Multitool> OBSIDIAN_MULTITOOL = ITEMS.register("obsidian_multitool", () -> new Multitool(0, 0, ModTiers.OBSIDIAN_MULTI));
    public static final RegistryObject<Multitool> RENFORCED_MULTITOOL = ITEMS.register("renforced_multitool", () -> new Multitool(0, 0, ModTiers.RENFORCED_MULTI));
    public static final RegistryObject<CropariaTool> TOOL = ITEMS.register("rf_meter", () -> new CropariaTool());

    //BlockItem
    public static final RegistryObject<ItemNameBlockItem> ELEMENTAL_STONE = ITEMS.register("elemental_stone", () -> new ItemNameBlockItem(BlockInit.ELEMENTAL_STONE.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE = ITEMS.register("greenhouse", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_WHITE = ITEMS.register("greenhouse_white", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_WHITE.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_ORANGE = ITEMS.register("greenhouse_orange", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_ORANGE.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_MAGENTA = ITEMS.register("greenhouse_magenta", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_MAGENTA.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_LIGHT_BLUE = ITEMS.register("greenhouse_light_blue", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_LIGHT_BLUE.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_YELLOW = ITEMS.register("greenhouse_yellow", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_YELLOW.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_LIME = ITEMS.register("greenhouse_lime", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_LIME.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_PINK = ITEMS.register("greenhouse_pink", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_PINK.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_GRAY = ITEMS.register("greenhouse_gray", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_GRAY.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_LIGHT_GRAY = ITEMS.register("greenhouse_light_gray", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_LIGHT_GRAY.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_CYAN = ITEMS.register("greenhouse_cyan", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_CYAN.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_PURPLE = ITEMS.register("greenhouse_purple", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_PURPLE.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_BLUE = ITEMS.register("greenhouse_blue", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_BLUE.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_BROWN = ITEMS.register("greenhouse_brown", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_BROWN.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_GREEN = ITEMS.register("greenhouse_green", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_GREEN.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_RED = ITEMS.register("greenhouse_red", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_RED.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<GreenHouseBlockItem> GREENHOUSE_BLACK = ITEMS.register("greenhouse_black", () -> new GreenHouseBlockItem(BlockInit.GREENHOUSE_BLACK.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<ItemNameBlockItem> INFUSOR = ITEMS.register("infusor", () -> new ItemNameBlockItem(BlockInit.INFUSOR.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<ItemNameBlockItem> RITUAL_STAND = ITEMS.register("ritual_stand", () -> new ItemNameBlockItem(BlockInit.RITUAL_STAND.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<ItemNameBlockItem> ACCELERATOR = ITEMS.register("accelerator", () -> new ItemNameBlockItem(BlockInit.ACCELERATOR.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<ItemNameBlockItem> COLLECTOR = ITEMS.register("collector", () -> new ItemNameBlockItem(BlockInit.COLLECTOR.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<ItemNameBlockItem> GENERATOR = ITEMS.register("crop_generator", () -> new ItemNameBlockItem(BlockInit.GENERATOR.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<ItemNameBlockItem> SEED_RECYCLER = ITEMS.register("seed_recycler", () -> new ItemNameBlockItem(BlockInit.SEED_RECYCLER.get(), new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<ItemNameBlockItem> BATTERY = ITEMS.register("battery", () -> new ItemNameBlockItem(BlockInit.BATTERY.get(), new Item.Properties().tab(CropariaMod.MAIN)));

    //Ritual Tier Icon
    public static final RegistryObject<Item> TIER_ICON_1 = ITEMS.register("tier_icon_1", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIER_ICON_2 = ITEMS.register("tier_icon_2", () -> new Item(new Item.Properties()));

    public static Item getPotionFromElement(ElementsEnum element) {
        switch(element) {
            case ELEMENTAL :
                return POTION_ELEMATILIUS.get();
            case WATER :
                return POTION_WATER.get();
            case FIRE :
                return POTION_FIRE.get();
            case AIR :
                return POTION_AIR.get();
            case EARTH :
                return POTION_EARTH.get();
            case EMPTY :
                return Items.GLASS_BOTTLE;
            default:
                return Items.AIR;
        }
    }

    public static ElementsEnum getElementFromPotion(Item item) {
        if(item == POTION_ELEMATILIUS.get()) {
            return ElementsEnum.ELEMENTAL;
        }
        else if(item == POTION_WATER.get()) {
            return ElementsEnum.WATER;
        }
        else if(item == POTION_FIRE.get()) {
            return ElementsEnum.FIRE;
        }
        else if(item == POTION_AIR.get()) {
            return ElementsEnum.AIR;
        }
        else if(item == POTION_EARTH.get()) {
            return ElementsEnum.EARTH;
        }
        else{
            return ElementsEnum.EMPTY;
        }
    }

    public static void registerSeed(Crops crop) {
        crop.setSeeds(ITEMS.register("seed_crop_" + crop.getName(), () -> new CropsSeed(crop, crop.getCrop().get(), new Item.Properties().tab(CropariaMod.CROP))));
    }

    public static void registerFruitAndSeed(Crops crop) {
        registerSeed(crop);
        crop.setFruit(ITEMS.register("fruit_" + crop.getName(), () -> new Item(new Item.Properties().tab(CropariaMod.CROP))));
    }
}
