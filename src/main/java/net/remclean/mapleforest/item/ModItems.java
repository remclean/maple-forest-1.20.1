package net.remclean.mapleforest.item;

import net.remclean.mapleforest.MapleForest;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item MAPLE_SYRUP = registerItem("maplesyrup", new Item(new FabricItemSettings()));

    public static void addItemsToIngredientItemsGroup(FabricItemGroupEntries entries) {
        entries.add(MAPLE_SYRUP)
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MapleForest.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MapleForest.LOGGER.info("Registering mod items for " + MapleForest.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToIngredientsItemsGroup)
    } 

}
