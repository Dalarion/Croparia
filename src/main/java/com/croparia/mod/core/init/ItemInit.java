package com.croparia.mod.core.init;

import com.croparia.mod.CropariaMod;
import com.croparia.mod.common.items.CropsSeed;
import com.croparia.mod.common.items.GreenHouseBlockItem;
import com.croparia.mod.common.items.Knife;
import com.croparia.mod.common.items.Pestle;
import com.croparia.mod.common.items.util.ModTiers;
import com.croparia.mod.core.Crops;
import com.croparia.mod.core.util.ElementsEnum;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CropariaMod.mod_id);

    public static final RegistryObject<Item> ELEMATILIUS = ITEMS.register("elematilius", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> ELEMENTAL_AIR = ITEMS.register("elemental_air", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> ELEMENTAL_FIRE = ITEMS.register("elemental_fire", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> ELEMENTAL_WATER = ITEMS.register("elemental_water", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> ELEMENTAL_EARTH = ITEMS.register("elemental_earth", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));

    public static final RegistryObject<Item> CROPARIA = ITEMS.register("croparia", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> CROPARIA2 = ITEMS.register("croparia2", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> CROPARIA3 = ITEMS.register("croparia3", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> CROPARIA4 = ITEMS.register("croparia4", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> CROPARIA5 = ITEMS.register("croparia5", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> CROPARIA6 = ITEMS.register("croparia6", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> CROPARIA7 = ITEMS.register("croparia7", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));

    public static final RegistryObject<Item> POTION_ELEMATILIUS = ITEMS.register("potion_elematilius", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> POTION_WATER = ITEMS.register("potion_water", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> POTION_FIRE = ITEMS.register("potion_fire", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> POTION_EARTH = ITEMS.register("potion_earth", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));
    public static final RegistryObject<Item> POTION_AIR = ITEMS.register("potion_air", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));

    public static final RegistryObject<Item> APRICOT_PIE = ITEMS.register("apricot_pie", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN).food(Foods.PUMPKIN_PIE)));
    public static final RegistryObject<Item> BANANA_PIE = ITEMS.register("banana_pie", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN).food(Foods.PUMPKIN_PIE)));
    public static final RegistryObject<Item> CHERRY_PIE = ITEMS.register("cherry_pie", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN).food(Foods.PUMPKIN_PIE)));
    public static final RegistryObject<Item> KIWI_PIE = ITEMS.register("kiwi_pie", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN).food(Foods.PUMPKIN_PIE)));
    public static final RegistryObject<Item> LEMON_PIE = ITEMS.register("lemon_pie", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN).food(Foods.PUMPKIN_PIE)));
    public static final RegistryObject<Item> ORANGE_PIE = ITEMS.register("orange_pie", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN).food(Foods.PUMPKIN_PIE)));
    public static final RegistryObject<Item> PEAR_PIE = ITEMS.register("pear_pie", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN).food(Foods.PUMPKIN_PIE)));

    public static final RegistryObject<Knife> WOOD_KNIFE = ITEMS.register("wood_knife", () -> new Knife(Tiers.WOOD));
    public static final RegistryObject<Knife> STONE_KNIFE = ITEMS.register("stone_knife", () -> new Knife(Tiers.STONE));
    public static final RegistryObject<Knife> IRON_KNIFE = ITEMS.register("iron_knife", () -> new Knife(Tiers.IRON));
    public static final RegistryObject<Knife> GOLD_KNIFE = ITEMS.register("gold_knife", () -> new Knife(Tiers.GOLD));
    public static final RegistryObject<Knife> DIAMOND_KNIFE = ITEMS.register("diamond_knife", () -> new Knife(Tiers.DIAMOND));
    public static final RegistryObject<Knife> NETHERITE_KNIFE = ITEMS.register("netherite_knife", () -> new Knife(Tiers.NETHERITE));
    public static final RegistryObject<Knife> OBSIDIAN_KNIFE = ITEMS.register("obsidian_knife", () -> new Knife(ModTiers.OBSIDIAN));
    public static final RegistryObject<Knife> RENFORCED_KNIFE = ITEMS.register("renforced_knife", () -> new Knife(ModTiers.RENFORCED));

    public static final RegistryObject<Pestle> WOOD_PESTLE = ITEMS.register("wood_pestle", () -> new Pestle());
    public static final RegistryObject<Pestle> STONE_PESTLE = ITEMS.register("stone_pestle", () -> new Pestle());
    public static final RegistryObject<Pestle> IRON_PESTLE = ITEMS.register("iron_pestle", () -> new Pestle());
    public static final RegistryObject<Pestle> GOLD_PESTLE = ITEMS.register("gold_pestle", () -> new Pestle());
    public static final RegistryObject<Pestle> DIAMOND_PESTLE = ITEMS.register("diamond_pestle", () -> new Pestle());
    public static final RegistryObject<Pestle> NETHERITE_PESTLE = ITEMS.register("netherite_pestle", () -> new Pestle());
    public static final RegistryObject<Pestle> OBSIDIAN_PESTLE = ITEMS.register("obsidian_pestle", () -> new Pestle());
    public static final RegistryObject<Pestle> RENFORCED_PESTLE = ITEMS.register("renforced_pestle", () -> new Pestle());
    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour", () -> new Item(new Item.Properties().tab(CropariaMod.MAIN)));

    public static final RegistryObject<ItemNameBlockItem> INFUSOR = ITEMS.register("infusor", () -> new ItemNameBlockItem(BlockInit.INFUSOR.get(), new Item.Properties().tab(CropariaMod.MAIN)));
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
