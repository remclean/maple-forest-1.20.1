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
        BlockStateModelGenerator.BlockTexturePool maplePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MAPLE_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAPLE_LEAVES);

        maplePool.stairs(ModBlocks.MAPLE_STAIRS);
        maplePool.slab(ModBlocks.MAPLE_SLAB);
        maplePool.button(ModBlocks.MAPLE_BUTTON);
        maplePool.pressurePlate(ModBlocks.MAPLE_PRESSURE_PLATE);
        maplePool.fence(ModBlocks.MAPLE_FENCE);
        maplePool.fenceGate(ModBlocks.MAPLE_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.MAPLE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.MAPLE_TRAPDOOR);

        blockStateModelGenerator.registerLog(ModBlocks.MAPLE_LOG).log(ModBlocks.MAPLE_LOG).wood(ModBlocks.MAPLE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MAPLE_LOG).log(ModBlocks.STRIPPED_MAPLE_LOG).wood(ModBlocks.STRIPPED_MAPLE_WOOD);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MAPLE_SYRUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAPLE_SAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORE_DETECTOR, Models.GENERATED);
    }
}
