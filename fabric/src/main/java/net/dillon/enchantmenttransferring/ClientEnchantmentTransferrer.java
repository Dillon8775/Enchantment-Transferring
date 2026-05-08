package net.dillon.enchantmenttransferring;

import net.blay09.mods.balm.Balm;
import net.blay09.mods.balm.fabric.platform.runtime.FabricLoadContext;
import net.dillon.enchantmenttransferring.event.FabricClientEvents;
import net.dillon.enchantmenttransferring.main.ClientMain;
import net.dillon.enchantmenttransferring.util.ModConstants;
import net.fabricmc.api.ClientModInitializer;

public class ClientEnchantmentTransferrer implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FabricClientEvents.registerModScreens();

        Balm.initializeMod(ModConstants.MOD_ID, FabricLoadContext.INSTANCE, ClientMain::cInitialize);
    }
}