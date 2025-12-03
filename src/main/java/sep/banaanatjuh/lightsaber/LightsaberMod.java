package sep.banaanatjuh.lightsaber;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sep.banaanatjuh.lightsaber.item.ModItems;

public class LightsaberMod implements ModInitializer {
	public static final String MOD_ID = "lightsaber";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Enabling Lightsaber Mod");


		//Enabling all methods needed to start the mod
		ModItems.registerModItems();
	}
}