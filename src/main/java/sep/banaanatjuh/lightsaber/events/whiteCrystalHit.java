package sep.banaanatjuh.lightsaber.events;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import sep.banaanatjuh.lightsaber.item.ModItems;

import static sep.banaanatjuh.lightsaber.LightsaberMod.LOGGER;

public class whiteCrystalHit {
    public static void whiteCrystalHit () {

        ServerLivingEntityEvents.AFTER_DEATH.register((entity, source) -> {
            if (source.getAttacker() instanceof PlayerEntity player) {


                ItemStack offHand = player.getStackInHand(Hand.OFF_HAND);

                int count = offHand.getCount();

                ItemStack redCrystal = new ItemStack(ModItems.RED_CRYSTAL);
                redCrystal.setCount(count);

                if (offHand.getItem() == ModItems.WHITE_CRYSTAL) {

                    LOGGER.info("Killed an entity while holding white crystal");
                    player.setStackInHand(Hand.OFF_HAND, redCrystal);

                }
            }
        });
    }
}
