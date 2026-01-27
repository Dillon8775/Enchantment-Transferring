package net.dillon.enchantmenttransferring;

import net.dillon.enchantmenttransferring.screen.ETHandledScreens;
import net.fabricmc.api.ClientModInitializer;

public class ETClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ETHandledScreens.registerScreens();
    }
}