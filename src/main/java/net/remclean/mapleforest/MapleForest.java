package net.remclean.mapleforest;

import net.remclean.mapleforest.block.ModBlocks;
import net.remclean.mapleforest.item.ModItemGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.api.ModInitializer;
import net.remclean.mapleforest.item.ModItems;

public class MapleForest implements ModInitializer {
	public static final String MOD_ID = "maple-forest";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
