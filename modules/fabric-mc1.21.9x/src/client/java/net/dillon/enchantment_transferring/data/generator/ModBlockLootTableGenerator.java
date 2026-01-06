package net.dillon.enchantment_transferring.data.generator;

import net.dillon.enchantment_transferring.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

/**
 * Generates loot tables.
 */
public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {

    protected ModBlockLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ENCHANTMENT_TRANSFERRER);
    }
}