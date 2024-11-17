package net.remclean.mapleforest.world;

import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.remclean.mapleforest.MapleForest;
import net.remclean.mapleforest.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> CLUSTER_ORE_KEY = registerKey("cluster_ore");

    public static final RegistryKey<ConfiguredFeature<?,?>> MAPLE_KEY = registerKey("maple");

    public static void bootStrap(Registerable<ConfiguredFeature<?,?>> context) {
        //RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        //RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest diamondOreReplacables = new BlockMatchRuleTest(Blocks.DIAMOND_ORE);
        RuleTest deepslateDiamondOreReplacables = new BlockMatchRuleTest(Blocks.DEEPSLATE_DIAMOND_ORE);

        List<OreFeatureConfig.Target> overworldClusterOre =
        List.of(OreFeatureConfig.createTarget(diamondOreReplacables, ModBlocks.CLUSTER_DIAMOND_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateDiamondOreReplacables, ModBlocks.DEEPSLATE_CLUSTER_DIAMOND_ORE.getDefaultState()));

        register(context, CLUSTER_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldClusterOre, 3));

        register(context, MAPLE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MAPLE_LOG),
                new LargeOakTrunkPlacer(4,4,4),
                BlockStateProvider.of(ModBlocks.MAPLE_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(3), 3),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MapleForest.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
