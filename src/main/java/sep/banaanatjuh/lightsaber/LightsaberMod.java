package sep.banaanatjuh.lightsaber;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sep.banaanatjuh.lightsaber.item.ModItems;
import sep.banaanatjuh.lightsaber.utils.giveGoldenHearts;

public class LightsaberMod implements ModInitializer {
	public static final String MOD_ID = "lightsaber";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Enabling Lightsaber Mod");


		//Enabling all methods needed to start the mod
		ModItems.registerModItems();


		AttackEntityCallback.EVENT.register((playerEntity, world, hand, entity, entityHitResult) -> {

			if (world.isClient()) {
				return ActionResult.PASS;
			}

			ItemStack mainHand = playerEntity.getStackInHand(Hand.MAIN_HAND);
			ItemStack offHand = playerEntity.getStackInHand(Hand.OFF_HAND);

			if (mainHand.getItem() == ModItems.WHITE_CRYSTAL || offHand.getItem() == ModItems.WHITE_CRYSTAL) {

				LOGGER.info("Hit an entity with white crystal");

			}

			return ActionResult.PASS;


		});
		ServerPlayerEvents.ALLOW_DEATH.register((player, damageSource, damage) -> {

			ItemStack mainHand = player.getStackInHand(Hand.MAIN_HAND);
			ItemStack offHand = player.getStackInHand(Hand.OFF_HAND);

			if (mainHand.getItem() == ModItems.LANDERBUBU || offHand.getItem() == ModItems.LANDERBUBU) {
				LOGGER.info("Player tried to die while holding UWU item!");
				player.setHealth(1.0f);
				giveGoldenHearts.giveGoldenHearts(player, 10, 6);
				player.setHealth(3.0f);
				return false;
			}

			return true;
		});


	}
}