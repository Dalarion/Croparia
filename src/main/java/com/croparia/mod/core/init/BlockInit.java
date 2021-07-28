package com.croparia.mod.core.init;

import com.croparia.mod.CropariaMod;
import com.croparia.mod.common.blocks.*;
import com.croparia.mod.core.Crops;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CropariaMod.mod_id);

    //Blocks
    public static final RegistryObject<Block> ELEMENTAL_STONE = BLOCKS.register("elemental_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Accelerator> ACCELERATOR = BLOCKS.register("accelerator", () -> new Accelerator(5));

    //Technical
    public static final RegistryObject<CropGenerator> GENERATOR = BLOCKS.register("crop_generator", () -> new CropGenerator());
    public static final RegistryObject<Collector> COLLECTOR = BLOCKS.register("collector", () -> new Collector());
    public static final RegistryObject<Battery> BATTERY = BLOCKS.register("battery", () -> new Battery());
    public static final RegistryObject<SeedRecycler> SEED_RECYCLER = BLOCKS.register("seed_recycler", () -> new SeedRecycler());

    //Recipes Blocks
    public static final RegistryObject<Infusor> INFUSOR = BLOCKS.register("infusor", () -> new Infusor());
    public static final RegistryObject<RitualStand> RITUAL_STAND = BLOCKS.register("ritual_stand", () -> new RitualStand());

    //Greenhouses
    public static final RegistryObject<Greenhouse> GREENHOUSE = BLOCKS.register("greenhouse", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_WHITE = BLOCKS.register("greenhouse_white", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_ORANGE = BLOCKS.register("greenhouse_orange", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_MAGENTA = BLOCKS.register("greenhouse_magenta", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_LIGHT_BLUE = BLOCKS.register("greenhouse_light_blue", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_YELLOW = BLOCKS.register("greenhouse_yellow", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_LIME = BLOCKS.register("greenhouse_lime", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_PINK = BLOCKS.register("greenhouse_pink", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_GRAY = BLOCKS.register("greenhouse_gray", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_LIGHT_GRAY = BLOCKS.register("greenhouse_light_gray", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_CYAN = BLOCKS.register("greenhouse_cyan", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_PURPLE = BLOCKS.register("greenhouse_purple", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_BLUE = BLOCKS.register("greenhouse_blue", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_BROWN = BLOCKS.register("greenhouse_brown", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_GREEN = BLOCKS.register("greenhouse_green", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_RED = BLOCKS.register("greenhouse_red", () -> new Greenhouse());
    public static final RegistryObject<Greenhouse> GREENHOUSE_BLACK = BLOCKS.register("greenhouse_black", () -> new Greenhouse());

    public static void registerCrop(Crops crop){
        crop.setCrop(BLOCKS.register("block_crop_" + crop.getName(), () -> new CropariaCrops(crop)));
    }
    public static void registerModdedCrop(Crops crop){
        crop.setCrop(BLOCKS.register("block_crop_" + crop.getName(), () -> new CropariaModdedCrops(crop)));
    }
}
