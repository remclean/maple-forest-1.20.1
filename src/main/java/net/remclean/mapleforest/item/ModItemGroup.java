package net.remclean.mapleforest.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.remclean.mapleforest.MapleForest;

public class ModItemGroup {
    public static final ItemGroup MAPLEFOREST_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MapleForest.MOD_ID, "mapleforest"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mapleforest"))
                    .icon(() -> new ItemStack(ModItems.MAPLE_SYRUP)).entries((displayContext, entries) -> {
                        entries.add(ModItems.MAPLE_SYRUP);
                        entries.add(ModItems.MAPLE_SAP);
                    }).build());

    public static void registerItemGroups() {
        MapleForest.LOGGER.info("Registering item groups for: " + MapleForest.MOD_ID);
    }
}
