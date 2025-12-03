package sep.banaanatjuh.lightsaber.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import sep.banaanatjuh.lightsaber.LightsaberMod;

public class ModItems {

    public static Item LIGHTSABER_BLUE;

    private static Item registerItem(String name) {
        return Registry.register(Registries.ITEM, Identifier.of(LightsaberMod.MOD_ID, name),
                new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LightsaberMod.MOD_ID, name)))));


    }

    public static void registerModItems() {
        LightsaberMod.LOGGER.info("Registering all Light sabers");


        LIGHTSABER_BLUE = registerItem("lightsaber_blue");


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(LIGHTSABER_BLUE);
        });
    }
}