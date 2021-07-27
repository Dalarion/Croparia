package com.croparia.mod.core.init;

import com.croparia.mod.CropariaMod;
import com.croparia.mod.common.blockEntity.GreenHouseBE;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockEntityInit {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, CropariaMod.mod_id);
	
	public static final RegistryObject<BlockEntityType<GreenHouseBE>> GREENHOUSE_BE = BLOCK_ENTITIES.register("greenhouse_be", () -> BlockEntityType.Builder.of(GreenHouseBE::new, BlockInit.GREENHOUSE.get(), BlockInit.GREENHOUSE_WHITE.get(),  BlockInit.GREENHOUSE_ORANGE.get(), BlockInit.GREENHOUSE_MAGENTA.get(),  BlockInit.GREENHOUSE_LIGHT_BLUE.get(),  BlockInit.GREENHOUSE_YELLOW.get(),  BlockInit.GREENHOUSE_LIME.get(),  BlockInit.GREENHOUSE_PINK.get(),  BlockInit.GREENHOUSE_GRAY.get(),  BlockInit.GREENHOUSE_LIGHT_GRAY.get(),  BlockInit.GREENHOUSE_CYAN.get(),  BlockInit.GREENHOUSE_PURPLE.get(),  BlockInit.GREENHOUSE_BLUE.get(),  BlockInit.GREENHOUSE_BROWN.get(),  BlockInit.GREENHOUSE_GREEN.get(),  BlockInit.GREENHOUSE_RED.get(),  BlockInit.GREENHOUSE_BLACK.get()).build(null));
	/*	public static final RegistryObject<TileEntityType<CollectorTE>> COLLECTOR_TE = BLOCK_ENTITIES.register("collector_te", () -> BlockEntityType.Builder.of(CollectorTE::new, BlockInit.COLLECTOR.get()).build(null));
	public static final RegistryObject<TileEntityType<TransformerTE>> TRANSFORMER_TE = BLOCK_ENTITIES.register("transformer_te", () -> BlockEntityType.Builder.of(TransformerTE::new, BlockInit.SEED_RECYCLER.get()).build(null));
	public static final RegistryObject<TileEntityType<GeneratorTE>> GENERATOR_TE = BLOCK_ENTITIES.register("generator_te", () -> BlockEntityType.Builder.of(GeneratorTE::new, BlockInit.GENERATOR.get()).build(null));
	public static final RegistryObject<TileEntityType<BatteryTE>> BATTERY_TE = BLOCK_ENTITIES.register("battery_te", ()-> BlockEntityType.Builder.of(BatteryTE::new, BlockInit.BATTERY.get()).build(null));
*/
}

