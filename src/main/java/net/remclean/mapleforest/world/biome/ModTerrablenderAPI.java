package net.remclean.mapleforest.world.biome;

import net.minecraft.util.Identifier;
import net.remclean.mapleforest.MapleForest;
import net.remclean.mapleforest.world.biome.surface.ModMaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(MapleForest.MOD_ID, "overworld"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MapleForest.MOD_ID, ModMaterialRules.makeRules());
    }
}
