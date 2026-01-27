package net.dillon.enchantmenttransferring.data.generator;

import net.dillon.enchantmenttransferring.block.ETBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class ModModelGenerator extends FabricModelProvider {

    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleState(ETBlocks.ENCHANTMENT_TRANSFERRER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}