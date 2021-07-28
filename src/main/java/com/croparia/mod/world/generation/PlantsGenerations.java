package com.croparia.mod.world.generation;

import com.croparia.mod.world.config.PlantsConfig;
import com.croparia.mod.world.feature.CoalCropFeature;
import com.croparia.mod.world.feature.FruitsFeature;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Set;

public class PlantsGenerations 
{
	public static final Feature<PlantsConfig> COAL_CROP = new CoalCropFeature();
	public static final Feature<PlantsConfig> FRUITS = new FruitsFeature();


	public static final ConfiguredFeature<?, ?> COAL_CROP_CONF = COAL_CROP.configured(new PlantsConfig(6, 2, 2, 6));
	public static final ConfiguredFeature<?, ?> FRUITS_CONF = FRUITS.configured(new PlantsConfig(10, 3, 2, 14));
	
	public static final Set<Biome.BiomeCategory> TYPE_BLACKLIST = ImmutableSet.of(
			Biome.BiomeCategory.NETHER,
			Biome.BiomeCategory.THEEND,
			Biome.BiomeCategory.ICY,
			Biome.BiomeCategory.MUSHROOM,
			Biome.BiomeCategory.RIVER,
			Biome.BiomeCategory.BEACH,
			Biome.BiomeCategory.DESERT,
			Biome.BiomeCategory.OCEAN
	);
	
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) { 
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, "coal_crop_conf", COAL_CROP_CONF);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, "fruits_conf", FRUITS_CONF);
	}
	
	public static void generatePlants(final BiomeLoadingEvent event) 
	{
		Biome.BiomeCategory category = event.getCategory();
		if (!TYPE_BLACKLIST.contains(category)) {
			generatePlant(event.getGeneration(), COAL_CROP_CONF);
			generatePlant(event.getGeneration(), FRUITS_CONF);
		}
	}
	
	private static void generatePlant(BiomeGenerationSettingsBuilder settings, ConfiguredFeature<?, ?> config)
	{                                                               
		settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, config);
	}
}
