package net.remclean.mapleforest.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.remclean.mapleforest.block.ModBlocks;
import net.remclean.mapleforest.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAPLE_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAPLE_LEAVES);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MAPLE_SYRUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAPLE_SAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORE_DETECTOR, Models.GENERATED);
    }
}
