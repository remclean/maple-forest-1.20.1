package net.remclean.mapleforest.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.remclean.mapleforest.block.ModBlocks;
import net.remclean.mapleforest.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool maple_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MAPLE_PLANKS);
        maple_pool.family(ModBlocks.MAPLE_FAMILY);

        maple_pool.stairs(ModBlocks.MAPLE_STAIRS);
        maple_pool.slab(ModBlocks.MAPLE_SLAB);
        maple_pool.button(ModBlocks.MAPLE_BUTTON);
        maple_pool.pressurePlate(ModBlocks.MAPLE_PRESSURE_PLATE);
        maple_pool.fence(ModBlocks.MAPLE_FENCE);
        maple_pool.fenceGate(ModBlocks.MAPLE_FENCE_GATE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAPLE_LEAVES);

        blockStateModelGenerator.registerTintableCross(ModBlocks.MAPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CLUSTER_DIAMOND_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CLUSTER_DIAMOND_ORE);

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
        itemModelGenerator.register(ModItems.PELT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARMOR_PAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.HATCHET, Models.GENERATED);

        itemModelGenerator.register(ModItems.MAPLE_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAPLE_CHEST_BOAT, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARMOR_PAD_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARMOR_PAD_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARMOR_PAD_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARMOR_PAD_BOOTS));

        itemModelGenerator.register(ModItems.HANGING_MAPLE_SIGN, Models.GENERATED);
    }
}
