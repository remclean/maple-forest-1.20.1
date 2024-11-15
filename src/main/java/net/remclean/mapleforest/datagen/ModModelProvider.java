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
    public void generateBlockStateModels(BlockStateModelGenerator bsmg) {
        BlockStateModelGenerator.BlockTexturePool maplePool = bsmg.registerCubeAllModelTexturePool(ModBlocks.MAPLE_PLANKS);
        bsmg.registerSimpleCubeAll(ModBlocks.MAPLE_LEAVES);

        maplePool.stairs(ModBlocks.MAPLE_STAIRS);
        maplePool.slab(ModBlocks.MAPLE_SLAB);
        maplePool.button(ModBlocks.MAPLE_BUTTON);
        maplePool.pressurePlate(ModBlocks.MAPLE_PRESSURE_PLATE);
        maplePool.fence(ModBlocks.MAPLE_FENCE);
        maplePool.fenceGate(ModBlocks.MAPLE_FENCE_GATE);

        bsmg.registerDoor(ModBlocks.MAPLE_DOOR);
        bsmg.registerTrapdoor(ModBlocks.MAPLE_TRAPDOOR);

        bsmg.registerLog(ModBlocks.MAPLE_LOG).log(ModBlocks.MAPLE_LOG).wood(ModBlocks.MAPLE_WOOD);
        bsmg.registerLog(ModBlocks.STRIPPED_MAPLE_LOG).log(ModBlocks.STRIPPED_MAPLE_LOG).wood(ModBlocks.STRIPPED_MAPLE_WOOD);

        //Not in kaupenjoe's but made console stop throwing a bunch of warnings
        bsmg.registerHangingSign(ModBlocks.STRIPPED_MAPLE_LOG, ModBlocks.HANGING_MAPLE_SIGN, ModBlocks.WALL_HANGING_MAPLE_SIGN);


        maplePool.family(ModBlocks.MAPLE_FAMILY);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MAPLE_SYRUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAPLE_SAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORE_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PELT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARMOR_PAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BARK, Models.GENERATED);
        
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARMOR_PAD_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARMOR_PAD_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARMOR_PAD_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARMOR_PAD_BOOTS));

        //itemModelGenerator.register(ModItems.HANGING_MAPLE_SIGN, Models.GENERATED);
        //itemModelGenerator.register(ModItems.MAPLE_SIGN, Models.GENERATED);
    }
}
