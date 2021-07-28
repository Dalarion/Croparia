package com.croparia.mod.world.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class PlantsConfig implements FeatureConfiguration {
	
	public static final Codec<PlantsConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
			Codec.INT.fieldOf("patch_radius").forGetter(PlantsConfig::getPatchRadius),
			Codec.INT.fieldOf("patch_count").forGetter(PlantsConfig::getPatchCount),
			Codec.INT.fieldOf("patch_density").forGetter(PlantsConfig::getPatchDensity),
			Codec.INT.fieldOf("patch_chance").forGetter(PlantsConfig::getPatchChance)
	).apply(instance, PlantsConfig::new));

	private final int patchRadius;
	private final int patchCount;
	private final int patchDensity;
	private final int patchChance;

	public PlantsConfig(int patchRadius, int patchCount, int patchDensity, int patchChance) {
		this.patchRadius = patchRadius;
		this.patchCount = patchCount;
		this.patchDensity = patchDensity;
		this.patchChance = patchChance;
	}

	public int getPatchRadius() {
		return patchRadius;
	}

	public int getPatchCount() {
		return patchCount;
	}

	public int getPatchDensity() {
		return patchDensity;
	}

	public int getPatchChance() {
		return patchChance;
	}
}