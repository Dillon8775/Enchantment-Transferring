package net.dillon.enchantmenttransferring.screen;

import net.dillon.enchantmenttransferring.menu.ModMenus;
import net.minecraft.client.gui.screens.MenuScreens;

public class ModScreens {

    public static void registerModScreens() {
        MenuScreens.register(ModMenus.ENCHANTMENT_TRANSFERRER, EnchantmentTransferrerScreen::new);
    }
}