package net.remclean.mapleforest.item;

import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.remclean.mapleforest.MapleForest;
import net.remclean.mapleforest.block.ModBlocks;
import net.remclean.mapleforest.entity.ModBoats;
import net.remclean.mapleforest.item.custom.HatchetItem;
import net.remclean.mapleforest.item.custom.ModArmorItem;
import net.remclean.mapleforest.item.custom.OreDetectorItem;

public class ModItems {
    public static final Item MAPLE_SYRUP = registerItem("maplesyrup",
            new Item(new FabricItemSettings().food(ModFoodCompontents.MAPLE_SYRUP)));
    public static final Item MAPLE_SAP = registerItem("maplesap",
            new Item(new FabricItemSettings().food(ModFoodCompontents.MAPLE_SAP)));

    public static final Item PELT = registerItem("pelt",
            new Item(new FabricItemSettings()));
    public static final Item ARMOR_PAD = registerItem("armorpad",
            new Item(new FabricItemSettings()));
    public static final Item BARK = registerItem("bark",
            new Item(new FabricItemSettings().recipeRemainder(ModItems.PELT)));

    public static final Item ORE_DETECTOR = registerItem("oredetector",
            new OreDetectorItem(new FabricItemSettings().maxDamage(64)));

    public static final Item HATCHET = registerItem("hatchet",
            new HatchetItem(ToolMaterials.IRON, 2.5f, 0f, new FabricItemSettings().maxDamage(64)));

    public static final Item MAPLE_SIGN = registerItem("maplesign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.MAPLE_STANDING_SIGN, ModBlocks.WALL_MAPLE_SIGN));
    public static final Item HANGING_MAPLE_SIGN = registerItem("maplehangingsign",
            new HangingSignItem(ModBlocks.HANGING_MAPLE_SIGN, ModBlocks.WALL_HANGING_MAPLE_SIGN, new FabricItemSettings().maxCount(16)));

    public static final Item ARMOR_PAD_HELMET = registerItem("armorpadhelmet",
            new ModArmorItem(ModArmorMaterials.ARMOR_PAD, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ARMOR_PAD_CHESTPLATE = registerItem("armorpadchestplate",
            new ArmorItem(ModArmorMaterials.ARMOR_PAD, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ARMOR_PAD_LEGGINGS = registerItem("armorpadleggings",
            new ArmorItem(ModArmorMaterials.ARMOR_PAD, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ARMOR_PAD_BOOTS = registerItem("armorpadboots",
            new ArmorItem(ModArmorMaterials.ARMOR_PAD, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item MAPLE_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.MAPLE_BOAT_ID, ModBoats.MAPLE_BOAT_KEY, false);
    public static final Item MAPLE_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.MAPLE_CHEST_BOAT_ID, ModBoats.MAPLE_BOAT_KEY, true);

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
