package net.dillon.enchantmenttransferring.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

/**
 * Creates all dynamic registry providers.
 */
public class DynamicModRegistryProvider extends FabricDynamicRegistryProvider {

    public DynamicModRegistryProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
    }

    @Override
    public String getName() {
        return "Dynamic Enchantment Transferring Registry Provider";
    }
}