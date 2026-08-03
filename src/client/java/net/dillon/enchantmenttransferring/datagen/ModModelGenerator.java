package net.dillon.enchantmenttransferring.datagen;

import net.dillon.enchantmenttransferring.block.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import org.jspecify.annotations.NonNull;

public class ModModelGenerator extends FabricModelProvider {

    public ModModelGenerator(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createNonTemplateModelBlock(ModBlocks.ENCHANTMENT_TRANSFERRER);
    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {
    }
}