package net.dillon.enchantmenttransferring.data.generator;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class EnchantmentTransferringDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModBlockLootTableGenerator::new);
        pack.addProvider(ModBlockTagGenerator::new);
        pack.addProvider(ModModelGenerator::new);
        pack.addProvider(ModRecipeGenerator::new);
	}
}