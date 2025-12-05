package sep.banaanatjuh.lightsaber.events;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.apache.logging.log4j.Logger;
import sep.banaanatjuh.lightsaber.LightsaberMod;
import sep.banaanatjuh.lightsaber.item.ModItems;
import sep.banaanatjuh.lightsaber.utils.giveGoldenHearts;



public class landerbubuTotem {

    public static void landerbubuTotem () {
        ServerPlayerEvents.ALLOW_DEATH.register((player, damageSource, damage) -> {

            ItemStack mainHand = player.getStackInHand(Hand.MAIN_HAND);
            ItemStack offHand = player.getStackInHand(Hand.OFF_HAND);
            World world = player.getEntityWorld();

            if (mainHand.getItem() == ModItems.LANDERBUBU || offHand.getItem() == ModItems.LANDERBUBU) {

                player.setHealth(3.0f);
                giveGoldenHearts.giveGoldenHearts(player, 2400, 2);
                world.sendEntityStatus(player, (byte)35);
                if (mainHand.getItem() == ModItems.LANDERBUBU) {
                    player.setStackInHand(Hand.MAIN_HAND, ItemStack.EMPTY);
                    return false;
                }
                player.setStackInHand(Hand.OFF_HAND, ItemStack.EMPTY);
                return false;
            }

            return true;
        });
    }
}
