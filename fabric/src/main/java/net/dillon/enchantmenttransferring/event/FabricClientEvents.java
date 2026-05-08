package net.dillon.enchantmenttransferring.event;

import net.dillon.enchantmenttransferring.screen.EnchantmentTransferrerScreen;
import net.minecraft.client.gui.screens.MenuScreens;

public class FabricClientEvents {

    public static void registerModScreens() {
        MenuScreens.register(FabricCommonEvents.ENCHANTMENT_TRANSFERRER, EnchantmentTransferrerScreen::new);
    }
}