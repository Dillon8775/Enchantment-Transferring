package net.dillon.enchantmenttransferring;

import net.dillon.enchantmenttransferring.screen.ModScreens;
import net.fabricmc.api.ClientModInitializer;

public class ClientEnchantmentTransferrer implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModScreens.registerModScreens();
    }
}