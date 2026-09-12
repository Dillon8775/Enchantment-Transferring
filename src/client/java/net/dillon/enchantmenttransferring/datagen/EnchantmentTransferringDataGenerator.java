package net.dillon.enchantmenttransferring.datagen;

import net.dillon.enchantmenttransferring.loot.ModBlockLoot;
import net.dillon.enchantmenttransferring.render.ModModelProviders;
import net.dillon.enchantmenttransferring.tag.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;

public class EnchantmentTransferringDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        // Basic Pack Providers
        pack.addProvider(ModBlockLoot::new);
        pack.addProvider(ModBlockTags::new);
        pack.addProvider(ModModelProviders::new);

        // Dynamic Providers
        pack.addProvider(DynamicModRegistryProvider::new);
	}

    /**
     * Builds all {@code final} registries for Datagen.
     */
    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
    }

    /**
     * Builds all {@code reloadable} registries for Datagen.
     */
    @Override
    public void buildReloadableRegistry(RegistrySetBuilder registryBuilder) {
    }
}