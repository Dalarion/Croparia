package com.croparia.mod.core.init;

import com.croparia.mod.CropariaMod;
import com.croparia.mod.common.blockEntity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockEntityInit {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, CropariaMod.mod_id);
	
	public static final RegistryObject<BlockEntityType<GreenHouseBE>> GREENHOUSE_BE = BLOCK_ENTITIES.register("greenhouse_be", () -> BlockEntityType.Builder.of(GreenHouseBE::new, BlockInit.GREENHOUSE.get(), BlockInit.GREENHOUSE_WHITE.get(),  BlockInit.GREENHOUSE_ORANGE.get(), BlockInit.GREENHOUSE_MAGENTA.get(),  BlockInit.GREENHOUSE_LIGHT_BLUE.get(),  BlockInit.GREENHOUSE_YELLOW.get(),  BlockInit.GREENHOUSE_LIME.get(),  BlockInit.GREENHOUSE_PINK.get(),  BlockInit.GREENHOUSE_GRAY.get(),  BlockInit.GREENHOUSE_LIGHT_GRAY.get(),  BlockInit.GREENHOUSE_CYAN.get(),  BlockInit.GREENHOUSE_PURPLE.get(),  BlockInit.GREENHOUSE_BLUE.get(),  BlockInit.GREENHOUSE_BROWN.get(),  BlockInit.GREENHOUSE_GREEN.get(),  BlockInit.GREENHOUSE_RED.get(),  BlockInit.GREENHOUSE_BLACK.get()).build(null));
	public static final RegistryObject<BlockEntityType<CollectorBE>> COLLECTOR_BE = BLOCK_ENTITIES.register("collector_be", () -> BlockEntityType.Builder.of(CollectorBE::new, BlockInit.COLLECTOR.get()).build(null));
	public static final RegistryObject<BlockEntityType<TransformerBE>> TRANSFORMER_BE = BLOCK_ENTITIES.register("transformer_be", () -> BlockEntityType.Builder.of(TransformerBE::new, BlockInit.SEED_RECYCLER.get()).build(null));
	public static final RegistryObject<BlockEntityType<GeneratorBE>> GENERATOR_BE = BLOCK_ENTITIES.register("generator_be", () -> BlockEntityType.Builder.of(GeneratorBE::new, BlockInit.GENERATOR.get()).build(null));
	public static final RegistryObject<BlockEntityType<BatteryBE>> BATTERY_BE = BLOCK_ENTITIES.register("battery_be", ()-> BlockEntityType.Builder.of(BatteryBE::new, BlockInit.BATTERY.get()).build(null));
}

