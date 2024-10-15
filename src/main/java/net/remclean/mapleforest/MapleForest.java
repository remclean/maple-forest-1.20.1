package net.remclean.mapleforest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;

public class MapleForest implements ModInitializer {
	public static final String MOD_ID = "maple-forest";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		
		ModItems.registerModItems();
	}
}