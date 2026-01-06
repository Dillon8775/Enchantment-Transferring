package net.dillon.enchantment_transferring.data.generator;

import net.dillon.enchantment_transferring.block.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

/**
 * Generates block and item models.
 */
public class ModModelGenerator extends FabricModelProvider {

    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleState(ModBlocks.ENCHANTMENT_TRANSFERRER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}