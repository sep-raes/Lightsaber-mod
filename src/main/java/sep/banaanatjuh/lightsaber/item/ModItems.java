package sep.banaanatjuh.lightsaber.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.MinecartItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import sep.banaanatjuh.lightsaber.LightsaberMod;

public class ModItems {

    public static Item LIGHTSABER_BLUE;
    public static Item LANDERBUBU;

    public static Item PURPLE_CRYSTAL;
    public static Item RED_CRYSTAL;
    public static Item BLUE_CRYSTAL;
    public static Item BLACK_CRYSTAL;
    public static Item WHITE_CRYSTAL;

    private static Item registerItem(String name, Item.Settings settings) {
        return Registry.register(Registries.ITEM, Identifier.of(LightsaberMod.MOD_ID, name),
                new Item(settings.registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LightsaberMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        LightsaberMod.LOGGER.info("Registering all Light sabers");

        LIGHTSABER_BLUE = registerItem("lightsaber_blue", new Item.Settings().maxCount(1));
        LANDERBUBU = registerItem("landerbubu", new Item.Settings().maxCount(1).rarity(Rarity.RARE));

        PURPLE_CRYSTAL = registerItem("purple_crystal", new Item.Settings().maxCount(16).rarity(Rarity.RARE));
        RED_CRYSTAL = registerItem("red_crystal", new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON));
        BLUE_CRYSTAL = registerItem("blue_crystal", new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON));
        BLACK_CRYSTAL = registerItem("black_crystal", new Item.Settings().maxCount(16).rarity(Rarity.EPIC));
        WHITE_CRYSTAL = registerItem("white_crystal", new Item.Settings().maxCount(16).rarity(Rarity.COMMON));


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(LIGHTSABER_BLUE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(LANDERBUBU);
        });



        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PURPLE_CRYSTAL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RED_CRYSTAL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BLUE_CRYSTAL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BLACK_CRYSTAL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(WHITE_CRYSTAL);
        });
    }
}