package net.remclean.mapleforest.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.remclean.mapleforest.MapleForest;
import net.remclean.mapleforest.block.ModBlocks;
import net.remclean.mapleforest.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
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



        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_PLANKS, 4).input(ModBlocks.MAPLE_LOG).criterion(FabricRecipeProvider.hasItem(ModBlocks.MAPLE_LOG),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.MAPLE_LOG)).offerTo(exporter);


//    ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, SIMPLE_ITEM).input(SIMPLE_BLOCK).criterion(FabricRecipeProvider.hasItem(SIMPLE_ITEM),
//          FabricRecipeProvider.conditionsFromItem(SIMPLE_ITEM)).criterion(FabricRecipeProvider.hasItem(SIMPLE_BLOCK),
//          FabricRecipeProvider.conditionsFromItem(SIMPLE_BLOCK)).offerTo(exporter);
    }

}
