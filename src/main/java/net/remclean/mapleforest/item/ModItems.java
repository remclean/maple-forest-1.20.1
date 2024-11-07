package net.remclean.mapleforest.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SignItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.remclean.mapleforest.MapleForest;
import net.remclean.mapleforest.block.ModBlocks;
import net.remclean.mapleforest.item.custom.OreDetectorItem;

public class ModItems {
    public static final Item MAPLE_SYRUP = registerItem("maplesyrup",
            new Item(new FabricItemSettings().food(ModFoodCompontents.MAPLE_SYRUP)));
    public static final Item MAPLE_SAP = registerItem("maplesap",
            new Item(new FabricItemSettings().food(ModFoodCompontents.MAPLE_SAP)));

    public static final Item ORE_DETECTOR = registerItem("oredetector",
            new OreDetectorItem(new FabricItemSettings().maxDamage(64)));

    public static final Item MAPLE_SIGN = registerItem("maple_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.MAPLE_STANDING_SIGN, ModBlocks.WALL_MAPLE_SIGN));
    public static final Item HANGING_MAPLE_SIGN = registerItem("maple_hanging_sign",
            new HangingSignItem(ModBlocks.HANGING_MAPLE_SIGN, ModBlocks.WALL_HANGING_MAPLE_SIGN, new FabricItemSettings().maxCount(16)));


    public static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(MAPLE_SYRUP);
        entries.add(MAPLE_SAP);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MapleForest.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MapleForest.LOGGER.info("Registering mod items for " + MapleForest.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToIngredientItemGroup);
    } 
}
