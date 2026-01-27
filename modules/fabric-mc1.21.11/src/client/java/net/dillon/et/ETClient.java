package net.dillon.et;

import net.dillon.et.screen.ETHandledScreens;
import net.fabricmc.api.ClientModInitializer;

public class ETClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ETHandledScreens.registerScreens();
    }
}