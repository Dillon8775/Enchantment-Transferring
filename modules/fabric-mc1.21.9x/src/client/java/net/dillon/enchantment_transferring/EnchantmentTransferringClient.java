package net.dillon.enchantment_transferring;

import net.dillon.enchantment_transferring.screen.ModHandledScreens;
import net.fabricmc.api.ClientModInitializer;

/**
 * Client-side initialization for the Enchantment Transferring mod.
 */
public class EnchantmentTransferringClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModHandledScreens.registerScreens();
    }
}