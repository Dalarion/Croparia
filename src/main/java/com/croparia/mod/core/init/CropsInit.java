package com.croparia.mod.core.init;

import com.croparia.mod.core.Crops;
import com.croparia.mod.core.util.FruitsEnum;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.ModList;

import java.util.ArrayList;
import java.util.List;

public class CropsInit {

    public static List<Crops> crops = new ArrayList<Crops>();
    public static List<Crops> moddedCrops = new ArrayList<Crops>();
    public static List<Crops> fruits = new ArrayList<Crops>();

    public static final Crops ORANGE1 = new Crops("orange1");
    public static final Crops PEAR = new Crops("pear");
    public static final Crops CHERRY = new Crops("cherry");
    public static final Crops LEMON = new Crops("lemon");
    public static final Crops KIWI = new Crops("kiwi");
    public static final Crops APRICOT = new Crops("apricot");
    public static final Crops BANANA = new Crops("banana");

    public static final Crops ELEMENTAL = new Crops("elemental", 4);
    public static final Crops COAL = new Crops("coal", 1, Items.COAL);
    public static final Crops IRON = new Crops("iron", 2, Items.IRON_INGOT);
    public static final Crops GOLD = new Crops("gold", 2, Items.GOLD_INGOT);
    public static final Crops REDSTONE = new Crops("redstone", 3, Items.REDSTONE);
    public static final Crops LAPIS = new Crops("lapis", 3, Items.LAPIS_LAZULI);
    public static final Crops DIAMOND = new Crops("diamond", 4, Items.DIAMOND);
    public static final Crops EMERALD = new Crops("emerald", 4, Items.EMERALD);
    public static final Crops CLAY = new Crops("clay", 1, Items.CLAY);
    public static final Crops GLOWSTONE = new Crops("glowstone", 3, Items.GLOWSTONE_DUST);
    public static final Crops QUARTZ = new Crops("quartz", 3, Items.QUARTZ);
    public static final Crops SHARD = new Crops("shard", 2, Items.PRISMARINE_SHARD);
    public static final Crops CRYSTAL = new Crops("crystal", 2, Items.PRISMARINE_CRYSTALS);
    public static final Crops ENDER = new Crops("ender", 3, Items.ENDER_PEARL);
    public static final Crops BONE = new Crops("bone", 2, Items.BONE);
    public static final Crops EYE = new Crops("eye", 2, Items.SPIDER_EYE);
    public static final Crops POWDER = new Crops("powder", 2, Items.GUNPOWDER);
    public static final Crops PAPER = new Crops("paper", 1, Items.PAPER);
    public static final Crops SUGAR = new Crops("sugar", 1, Items.SUGAR);
    public static final Crops CHARCOAL = new Crops("charcoal", 1, Items.CHARCOAL);
    public static final Crops FLINT = new Crops("flint", 1, Items.FLINT);
    public static final Crops SNOWBALL = new Crops("snowball", 1, Items.SNOWBALL);
    public static final Crops FIREWORK = new Crops("firework", 1, Items.FIREWORK_STAR);
    public static final Crops NETHER = new Crops("nether", 3, Items.NETHER_BRICK);
    public static final Crops BOTTLE = new Crops("bottle", 1, Items.GLASS_BOTTLE);
    public static final Crops FOOT = new Crops("foot", 1, Items.RABBIT_FOOT);
    public static final Crops HIDE = new Crops("hide", 1, Items.RABBIT_HIDE);
    public static final Crops LEATHER = new Crops("leather", 1, Items.LEATHER);
    public static final Crops FEATHER = new Crops("feather", 1, Items.FEATHER);
    public static final Crops BLAZE = new Crops("blaze", 3, Items.BLAZE_ROD);
    public static final Crops GHAST = new Crops("ghast", 4, Items.GHAST_TEAR);
    public static final Crops MAGMA = new Crops("magma", 3, Items.MAGMA_CREAM);
    public static final Crops SHELL = new Crops("shell", 4, Items.SHULKER_SHELL);
    public static final Crops STAR = new Crops("star", 6, Items.NETHER_STAR);
    public static final Crops STRING = new Crops("string", 2, Items.STRING);
    public static final Crops SLIME = new Crops("slime", 2, Items.SLIME_BALL);
    public static final Crops ZOMBIE = new Crops("zombie", 2, Items.ROTTEN_FLESH);
    public static final Crops VINE = new Crops("vine", 1, Items.VINE, "natural");
    public static final Crops LILYPAD = new Crops("lilypad", 1, Items.LILY_PAD, "natural");
    public static final Crops BUSH = new Crops("bush", 1, Items.DEAD_BUSH, "natural");
    public static final Crops GRASS = new Crops("grass", 1, Items.GRASS, "natural");
    public static final Crops LARGEFERN = new Crops("largefern", 1, Items.LARGE_FERN, "natural");
    public static final Crops TALLGRASS = new Crops("tallgrass", 1, Items.TALL_GRASS, "natural");
    public static final Crops FERN = new Crops("fern", 1, Items.FERN, "natural");
    public static final Crops OAK = new Crops("oak", 1, Items.OAK_SAPLING, "natural");
    public static final Crops SPRUCE = new Crops("spruce", 1, Items.SPRUCE_SAPLING, "natural");
    public static final Crops BIRCH = new Crops("birch", 1, Items.BIRCH_SAPLING, "natural");
    public static final Crops JUNGLE = new Crops("jungle", 1, Items.JUNGLE_SAPLING, "natural");
    public static final Crops ACACIA = new Crops("acacia", 1, Items.ACACIA_SAPLING, "natural");
    public static final Crops DARKOAK = new Crops("darkoak", 1, Items.DARK_OAK_SAPLING, "natural");
    public static final Crops APPLE = new Crops("apple", 1, Items.APPLE);
    public static final Crops GOLDENAPPLE = new Crops("goldenapple", 3, Items.GOLDEN_APPLE);
    public static final Crops BREAD = new Crops("bread", 1, Items.BREAD);
    public static final Crops EGG = new Crops("egg", 1, Items.EGG);
    public static final Crops CLOWNFISH = new Crops("clownfish", 1, Items.TROPICAL_FISH);
    public static final Crops PUFFERFISH = new Crops("pufferfish", 1, Items.PUFFERFISH);
    public static final Crops COOKIE = new Crops("cookie", 1, Items.COOKIE);
    public static final Crops CHORUS = new Crops("chorus", 3, Items.CHORUS_FRUIT);
    public static final Crops RAWBEEF = new Crops("rawbeef", 1, Items.BEEF);
    public static final Crops RAWPORC = new Crops("rawporc", 1, Items.PORKCHOP);
    public static final Crops FISH = new Crops("fish", 1, Items.COD);
    public static final Crops SALMON = new Crops("salmon", 1, Items.SALMON);
    public static final Crops RAWCHICKEN = new Crops("rawchicken", 1, Items.CHICKEN);
    public static final Crops RAWRABBIT = new Crops("rawrabbit", 1, Items.RABBIT);
    public static final Crops RAWMUTTON = new Crops("rawmutton", 1, Items.MUTTON);
    public static final Crops ORANGE = new Crops("orange", 1, Items.ORANGE_DYE);
    public static final Crops MAGENTA = new Crops("magenta", 1, Items.MAGENTA_DYE);
    public static final Crops LIGHTBLUE = new Crops("lightblue", 1, Items.LIGHT_BLUE_DYE);
    public static final Crops YELLOW = new Crops("yellow", 1, Items.YELLOW_DYE);
    public static final Crops LIME = new Crops("lime", 1, Items.LIME_DYE);
    public static final Crops PINK = new Crops("pink", 1, Items.PINK_DYE);
    public static final Crops GRAY = new Crops("gray", 1, Items.GRAY_DYE);
    public static final Crops SILVER = new Crops("silver", 1, Items.LIGHT_GRAY_DYE);
    public static final Crops CYAN = new Crops("cyan", 1, Items.CYAN_DYE);
    public static final Crops PURPLE = new Crops("purple", 1, Items.PURPLE_DYE);
    public static final Crops BROWN = new Crops("brown", 1, Items.BROWN_DYE);
    public static final Crops GREEN = new Crops("green", 1, Items.GREEN_DYE);
    public static final Crops RED = new Crops("red", 1, Items.RED_DYE);
    public static final Crops BLACK = new Crops("black", 1, Items.BLACK_DYE);
    public static final Crops TOTEM = new Crops("totem", 6, Items.TOTEM_OF_UNDYING);
    public static final Crops LEAD2 = new Crops("lead2", 1, Items.LEAD);
    public static final Crops NAMETAG = new Crops("nametag", 1, Items.NAME_TAG);
    public static final Crops XP = new Crops("xp", 4, Items.EXPERIENCE_BOTTLE);
    public static final Crops SEA = new Crops("sea", 4, Items.HEART_OF_THE_SEA);
    public static final Crops SCUTE = new Crops("scute", 2, Items.SCUTE);
    public static final Crops NAUTILUS = new Crops("nautilus", 3, Items.NAUTILUS_SHELL);
    public static final Crops PHANTOM = new Crops("phantom", 2, Items.PHANTOM_MEMBRANE);
    public static final Crops WITHER = new Crops("wither", 5, Items.WITHER_ROSE);
    public static final Crops DRAGON = new Crops("dragon", 7, Items.DRAGON_EGG);
    public static final Crops BLUE = new Crops("blue", 1, Items.BLUE_DYE);
    public static final Crops INK = new Crops("ink", 1, Items.INK_SAC);
    public static final Crops WHITE = new Crops("white", 1, Items.WHITE_DYE);
    public static final Crops HONEYCOMB = new Crops("honeycomb", 1, Items.HONEYCOMB);
    public static final Crops NETHERITE = new Crops("netherite", 5, Items.NETHERITE_INGOT);
    public static final Crops GLOWINK = new Crops("glowink", 2);
    public static final Crops COPPER = new Crops("copper", 2);
    public static final Crops AMETHYST = new Crops("amethyst", 3);
    public static final Crops GOAT = new Crops("goat", 1);

    public static final Crops BRONZE = new Crops("bronze", 2);
    public static final Crops REFINED_OBSIDIAN = new Crops("refined_obsidian", 2);
    public static final Crops REFINED_GLOWSTONE = new Crops("refined_glowstone", 2);
    public static final Crops STEEL = new Crops("steel", 2);
    public static final Crops OSMIUM = new Crops("osmium", 2);
    public static final Crops TIN = new Crops("tin", 2);
    public static final Crops LEAD = new Crops("lead", 2);
    public static final Crops URANIUM = new Crops("uranium", 2);
    public static final Crops ALUMINIUM = new Crops("aluminium", 2);
    public static final Crops SILVER1 = new Crops("silver1", 2);
    public static final Crops NICKEL = new Crops("nickel", 2);
    public static final Crops CONSTANTAN = new Crops("constantan", 2);
    public static final Crops ELECTRUM = new Crops("electrum", 2);
    public static final Crops HOP_GRAPHITE = new Crops("hop_graphite", 2);
    public static final Crops INVAR = new Crops("invar", 2);
    public static final Crops SIGNALUM = new Crops("signalum", 3);
    public static final Crops LUMIUM = new Crops("lumium", 3);
    public static final Crops ENDERIUM = new Crops("enderium", 3);
    public static final Crops KNIGHTMETAL = new Crops("knightmetal", 3);
    public static final Crops IRONWOOD = new Crops("ironwood", 3);
    public static final Crops FIERY = new Crops("fiery", 3);
    public static final Crops STEELEAF = new Crops("steeleaf", 3);
    public static final Crops AQUAMARINE = new Crops("aquamarine", 2);
    public static final Crops STARMETAL = new Crops("starmetal", 2);
    public static final Crops MANASTEEL = new Crops("manasteel", 2);
    public static final Crops TERRASTEEL = new Crops("terrasteel", 3);
    public static final Crops ELEMENTIUM = new Crops("elementium", 3);
    public static final Crops DRAGONSTONE = new Crops("dragonstone", 3);
    public static final Crops COBALT = new Crops("cobalt", 3);
    public static final Crops HEPATIZON = new Crops("hepatizon", 3);
    public static final Crops KNIGHTSLIME = new Crops("knightslime", 3);
    public static final Crops MANYULLYN = new Crops("manyullyn", 3);
    public static final Crops PIG_IRON = new Crops("pigiron", 3);
    public static final Crops QUEENS_SLIME = new Crops("queens_slime", 3);
    public static final Crops ROSE_GOLD = new Crops("rose_gold", 3);
    public static final Crops SILICON_BRONZE = new Crops("tinkers_bronze", 3);
    public static final Crops SLIMESTEEL = new Crops("slimesteel", 3);
    public static final Crops SOULSTEEL = new Crops("soulsteel", 3);
    public static final Crops ENDERBALL = new Crops("enderball", 2);
    public static final Crops ICHORBALL = new Crops("ichorball", 2);
    public static final Crops SKYBALL = new Crops("skyball", 2);

    public static void register() {

        //Fruits
        registryFruit(ORANGE1);
        registryFruit(PEAR);
        registryFruit(LEMON);
        registryFruit(CHERRY);
        registryFruit(KIWI);
        registryFruit(APRICOT);
        registryFruit(BANANA);

        //MINECRAFT
        registry(ELEMENTAL);
        registry(COAL);
        registry(IRON);
        registry(GOLD);
        registry(REDSTONE);
        registry(LAPIS);
        registry(DIAMOND);
        registry(EMERALD);
        registry(CLAY);
        registry(GLOWSTONE);
        registry(QUARTZ);
        registry(SHARD);
        registry(CRYSTAL);
        registry(ENDER);
        registry(BONE);
        registry(EYE);
        registry(POWDER);
        registry(PAPER);
        registry(SUGAR);
        registry(CHARCOAL);
        registry(FLINT);
        registry(SNOWBALL);
        registry(FIREWORK);
        registry(NETHER);
        registry(BOTTLE);
        registry(FOOT);
        registry(HIDE);
        registry(LEATHER);
        registry(FEATHER);
        registry(BLAZE);
        registry(GHAST);
        registry(MAGMA);
        registry(SHELL);
        registry(STAR);
        registry(STRING);
        registry(SLIME);
        registry(ZOMBIE);
        registry(VINE);
        registry(LILYPAD);
        registry(BUSH);
        registry(GRASS);
        registry(LARGEFERN);
        registry(TALLGRASS);
        registry(FERN);
        registry(OAK);
        registry(SPRUCE);
        registry(BIRCH);
        registry(JUNGLE);
        registry(ACACIA);
        registry(DARKOAK);
        registry(APPLE);
        registry(GOLDENAPPLE);
        registry(BREAD);
        registry(EGG);
        registry(CLOWNFISH);
        registry(PUFFERFISH);
        registry(COOKIE);
        registry(CHORUS);
        registry(RAWBEEF);
        registry(RAWPORC);
        registry(FISH);
        registry(SALMON);
        registry(RAWCHICKEN);
        registry(RAWRABBIT);
        registry(RAWMUTTON);
        registry(ORANGE);
        registry(MAGENTA);
        registry(LIGHTBLUE);
        registry(YELLOW);
        registry(LIME);
        registry(PINK);
        registry(GRAY);
        registry(SILVER);
        registry(CYAN);
        registry(PURPLE);
        registry(BROWN);
        registry(GREEN);
        registry(RED);
        registry(BLACK);
        registry(TOTEM);
        registry(LEAD2);
        registry(NAMETAG);
        registry(XP);
        registry(SEA);
        registry(SCUTE);
        registry(NAUTILUS);
        registry(PHANTOM);
        registry(WITHER);
        registry(DRAGON);
        registry(BLUE);
        registry(INK);
        registry(WHITE);
        registry(HONEYCOMB);
        registry(NETHERITE);
        registry(GLOWINK);
        registry(COPPER);
        registry(AMETHYST);

        // Not 1.17 ... 1.18 ?
        // registry(GOAT);

        //Mekanism update
        registryWithMod(BRONZE, "mekanism", "thermal");
        registryWithMod(REFINED_OBSIDIAN, "mekanism");
        registryWithMod(REFINED_GLOWSTONE, "mekanism");
        registryWithMod(STEEL, "mekanism", "immersiveengineering");
        registryWithMod(OSMIUM, "mekanism");
        registryWithMod(TIN, "mekanism", "thermal");
        registryWithMod(LEAD, "mekanism", "immersiveengineering", "thermal");
        registryWithMod(URANIUM, "mekanism", "immersiveengineering");

        //Immersive Engineering update
        registryWithMod(ALUMINIUM, "immersiveengineering");
        registryWithMod(SILVER1, "immersiveengineering", "thermal");
        registryWithMod(NICKEL, "immersiveengineering", "thermal");
        registryWithMod(CONSTANTAN, "immersiveengineering", "thermal");
        registryWithMod(ELECTRUM, "immersiveengineering", "thermal");
        registryWithMod(HOP_GRAPHITE, "immersiveengineering");

        //Thermal update
        registryWithMod(INVAR, "thermal");
        registryWithMod(SIGNALUM, "thermal");
        registryWithMod(LUMIUM, "thermal");
        registryWithMod(ENDERIUM, "thermal");

        //Twilight Forest
        registryWithMod(KNIGHTMETAL, "twilightforest");
        registryWithMod(IRONWOOD, "twilightforest");
        registryWithMod(FIERY, "twilightforest");
        registryWithMod(STEELEAF, "twilightforest");

        //Astral Sorcery
        registryWithMod(AQUAMARINE, "astralsorcery");
        registryWithMod(STARMETAL, "astralsorcery");

        //Botania
        registryWithMod(MANASTEEL, "botania");
        registryWithMod(TERRASTEEL, "botania");
        registryWithMod(ELEMENTIUM, "botania");
        registryWithMod(DRAGONSTONE, "botania");

        //Tinker
        registryWithMod(COBALT, "tconstruct");
        registryWithMod(HEPATIZON, "tconstruct");
        registryWithMod(KNIGHTSLIME, "tconstruct");
        registryWithMod(MANYULLYN, "tconstruct");
        registryWithMod(PIG_IRON, "tconstruct");
        registryWithMod(QUEENS_SLIME, "tconstruct");
        registryWithMod(ROSE_GOLD, "tconstruct");
        registryWithMod(SILICON_BRONZE, "tconstruct");
        registryWithMod(SLIMESTEEL, "tconstruct");
        registryWithMod(SOULSTEEL, "tconstruct");
        registryWithMod(ENDERBALL, "tconstruct");
        registryWithMod(ICHORBALL, "tconstruct");
        registryWithMod(SKYBALL, "tconstruct");
    }
    public static void registry(Crops crop) {
        if(!crops.contains(crop)) {
            crops.add(crop);
            BlockInit.registerCrop(crop);
            ItemInit.registerFruitAndSeed(crop);
        }
    }

    public static void registryWithMod(Crops crop, String... modName){
        if(!moddedCrops.contains(crop)){
            boolean load = false;
            int i = 0;
            while(i < modName.length && !load) {
                if(ModList.get().isLoaded(modName[i])) {
                    load = true;
                }
                i++;
            }
            if(load) {
                moddedCrops.add(crop);
                BlockInit.registerModdedCrop(crop);
                ItemInit.registerFruitAndSeed(crop);
            }
        }
    }

    public static void registryFruit(Crops crop) {
        if(!fruits.contains(crop)) {
            fruits.add(crop);
            BlockInit.registerCrop(crop);
            ItemInit.registerSeed(crop);
        }
    }

    public static Crops getFruit(FruitsEnum fruit) {
        switch(fruit) {
            default:
            case ORANGE :
                return ORANGE1;
            case PEAR :
                return PEAR;
            case CHERRY :
                return CHERRY;
            case LEMON :
                return LEMON;
            case KIWI :
                return KIWI;
            case APRICOT :
                return APRICOT;
            case BANANA :
                return BANANA;
        }
    }
}
