package net.dillon.enchantment_transferring.data.generator;

import net.dillon.enchantment_transferring.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

/**
 * Generates recipes.
 */
public class ModRecipeGenerator extends FabricRecipeProvider {

    public ModRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENCHANTMENT_TRANSFERRER)
                        .input('E', Blocks.ENCHANTING_TABLE)
                        .input('L', Blocks.LAPIS_BLOCK)
                        .input('B', Items.BOOK)
                        .pattern(" B ")
                        .pattern(" L ")
                        .pattern(" E ")
                        .criterion("has_lapis_block", this.conditionsFromItem(Blocks.LAPIS_BLOCK))
                        .offerTo(this.exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Enchantment Transferring Recipe Generator";
    }
}