package net.dillon.enchantment_transferring.data.generator;

import net.dillon.enchantment_transferring.main.EnchantmentTransferring;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

/**
 * Data generation for the enchantment transferring mod.
 */
public class EnchantmentTransferringDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        EnchantmentTransferring.info("Initializing enchantment transferring data generator!");

        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModBlockLootTableGenerator::new);
        pack.addProvider(ModBlockTagGenerator::new);
        pack.addProvider(ModModelGenerator::new);
        pack.addProvider(ModRecipeGenerator::new);

        EnchantmentTransferring.info("Finished running through data generator.");
	}
}