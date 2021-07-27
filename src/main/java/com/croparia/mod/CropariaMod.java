package com.croparia.mod;

import com.croparia.mod.client.render.RenderingHandler;
import com.croparia.mod.core.init.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("croparia")
public class CropariaMod
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String mod_id = "croparia";
    public static final CreativeModeTab MAIN = new CropariaGroup("main");
    public static final CreativeModeTab CROP = new CropariaCropGroup("crop");

    public static VoxelShape NULL_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);

    public CropariaMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::doClientStuff);

        CropsInit.register();
		ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);

        BlockEntityInit.BLOCK_ENTITIES.register(bus);
     /*
        bus.addGenericListener(Feature.class, PlantsGenerations::registerFeatures);


		ContainersInit.CONTAINERS_TYPES.register(bus);
		
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, PlantsGenerations::generatePlants);
		
		bus.register(new ModRecipeSerializers());
		*/
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	RecipesInit.registerRecipes();
     // RecipesInit.registerRitualRecipe();
   // 	ModDispenserBehavior.registerBehavior();
    }
    
    private void doClientStuff(final FMLClientSetupEvent event) 
    {
    	RenderingHandler.init();
    }
    
    public static class CropariaGroup extends CreativeModeTab{
		public CropariaGroup(String label) {
			super(label);
		}
		@Override
		public ItemStack makeIcon() {
			return ItemInit.ELEMATILIUS.get().getDefaultInstance();
		}
    }

    public static class CropariaCropGroup extends CreativeModeTab{
        public CropariaCropGroup(String label) {
            super(label);
        }
        @Override
        public ItemStack makeIcon() {
            return CropsInit.ELEMENTAL.getSeeds().get().getDefaultInstance();
        }
    }

	public static int getTickRate() {
		double rand = Math.random() * (1.1 - 0.9) + 0.9;
		return (int) ((3 * rand) * 20);
	}
}
