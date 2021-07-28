package com.croparia.mod.event;

import com.croparia.mod.common.blocks.Infusor;
import com.croparia.mod.core.init.BlockInit;
import com.croparia.mod.core.init.ItemInit;
import com.croparia.mod.core.util.ElementsEnum;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;


@EventBusSubscriber(modid = "croparia")
public class EventHandler {
		
	@SubscribeEvent
	public static void onDeathEvent(LivingDeathEvent event) {
		
		//Blood Infuor Creation from chicken death with netherite knife
 		if(event.getEntity() instanceof Chicken && event.getSource().getEntity() instanceof Player) {
 			Level world = event.getEntity().level;
 			BlockPos pos = event.getEntity().blockPosition();
 			Player player = (Player) event.getSource().getEntity();
 			if(player.getMainHandItem().getItem() == ItemInit.NETHERITE_KNIFE.get()) {
 				if(world.getBlockState(pos) == BlockInit.INFUSOR.get().defaultBlockState().setValue(Infusor.TYPE, ElementsEnum.EMPTY)) {
 					world.setBlockAndUpdate(pos, BlockInit.INFUSOR.get().defaultBlockState().setValue(Infusor.TYPE, ElementsEnum.BLOOD));
 				}
 			}
 		}
 	}
}
