package net.remclean.mapleforest.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.remclean.mapleforest.block.ModBlocks;
import net.remclean.mapleforest.item.ModItems;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    private static final List<ItemConvertible> SAP = List.of(ModItems.MAPLE_SAP);

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ORE_DETECTOR, 1)
                .pattern(" II")
                .pattern(" D ")
                .pattern("IRI")
                .input('I', Items.IRON_INGOT)
                .input('D', Items.DIAMOND)
                .input('R', Items.REDSTONE_BLOCK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.REDSTONE_BLOCK), conditionsFromItem(Items.REDSTONE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ORE_DETECTOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ARMOR_PAD_HELMET, 1)
                .pattern("SPS")
                .pattern("AWA")
                .input('S', Items.STRING)
                .input('P', ModItems.PELT)
                .input('A', ModItems.ARMOR_PAD)
                .input('W', ItemTags.WOOL)
                .criterion(hasItem(ModItems.ARMOR_PAD), conditionsFromItem(ModItems.ARMOR_PAD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ARMOR_PAD_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ARMOR_PAD_CHESTPLATE, 1)
                .pattern("BSB")
                .pattern("AWA")
                .pattern("APA")
                .input('S', Items.STRING)
                .input('P', ModItems.PELT)
                .input('A', ModItems.ARMOR_PAD)
                .input('W', ItemTags.WOOL)
                .input('B', ModItems.BARK)
                .criterion(hasItem(ModItems.ARMOR_PAD), conditionsFromItem(ModItems.ARMOR_PAD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ARMOR_PAD_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ARMOR_PAD_LEGGINGS, 1)
                .pattern("AWA")
                .pattern("B B")
                .pattern("P P")
                .input('P', ModItems.PELT)
                .input('A', ModItems.ARMOR_PAD)
                .input('W', ItemTags.WOOL)
                .input('B', ModItems.BARK)
                .criterion(hasItem(ModItems.ARMOR_PAD), conditionsFromItem(ModItems.ARMOR_PAD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ARMOR_PAD_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ARMOR_PAD_BOOTS, 1)
                .pattern("AWA")
                .pattern("P P")
                .input('P', ModItems.PELT)
                .input('A', ModItems.ARMOR_PAD)
                .input('W', ItemTags.WOOL)
                .criterion(hasItem(ModItems.ARMOR_PAD), conditionsFromItem(ModItems.ARMOR_PAD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ARMOR_PAD_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.HATCHET, 1)
                .pattern(" IS")
                .pattern(" SM")
                .pattern("S  ")
                .input('I', Items.IRON_INGOT)
                .input('M', Items.IRON_NUGGET)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HATCHET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModBlocks.TAP, 1)
                .pattern("IM")
                .input('I', Items.IRON_INGOT)
                .input('M', Items.IRON_NUGGET)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.TAP)));

        offerSmelting(exporter, SAP, RecipeCategory.MISC, ModItems.MAPLE_SYRUP,
                0.7f, 800, "mapleforest");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ARMOR_PAD, 1).input(ModItems.PELT).input(Items.STRING).input(ModItems.BARK).criterion(FabricRecipeProvider.hasItem(ModBlocks.MAPLE_LOG),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.MAPLE_LOG)).offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_PLANKS, 4).input(ModBlocks.MAPLE_LOG).criterion(FabricRecipeProvider.hasItem(ModBlocks.MAPLE_LOG),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.MAPLE_LOG)).offerTo(exporter);

        createStairsRecipe(ModBlocks.MAPLE_STAIRS, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.MAPLE_PLANKS),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.MAPLE_PLANKS)).offerTo(exporter);
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_SLAB, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.MAPLE_PLANKS),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.MAPLE_PLANKS)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MAPLE_BUTTON, 1).input(ModBlocks.MAPLE_PLANKS).criterion(FabricRecipeProvider.hasItem(ModBlocks.MAPLE_PLANKS),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.MAPLE_PLANKS)).offerTo(exporter);
        createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.MAPLE_PRESSURE_PLATE, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.MAPLE_PLANKS),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.MAPLE_PLANKS)).offerTo(exporter);
        createFenceRecipe(ModBlocks.MAPLE_FENCE, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.MAPLE_PLANKS),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.MAPLE_PLANKS)).offerTo(exporter);
        createFenceGateRecipe(ModBlocks.MAPLE_FENCE_GATE, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.MAPLE_PLANKS),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.MAPLE_PLANKS)).offerTo(exporter);
        createDoorRecipe(ModBlocks.MAPLE_DOOR, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.MAPLE_PLANKS),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.MAPLE_PLANKS)).offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.MAPLE_TRAPDOOR, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.MAPLE_PLANKS),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.MAPLE_PLANKS)).offerTo(exporter);
    }

}
