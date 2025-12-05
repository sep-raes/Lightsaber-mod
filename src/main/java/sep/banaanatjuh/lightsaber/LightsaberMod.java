package sep.banaanatjuh.lightsaber;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sep.banaanatjuh.lightsaber.events.landerbubuTotem;
import sep.banaanatjuh.lightsaber.events.whiteCrystalHit;
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



		landerbubuTotem.landerbubuTotem();

		whiteCrystalHit.whiteCrystalHit();

	}
}