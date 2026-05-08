package net.dillon.enchantmenttransferring.platform;

import net.dillon.enchantmenttransferring.event.NeoForgedCommonEvents;
import net.dillon.enchantmenttransferring.screen.EnchantmentTransferrerMenu;
import net.minecraft.world.inventory.MenuType;

public class NeoForgedPlatformHelper implements PlatformHelper {

    @Override
    public MenuType<EnchantmentTransferrerMenu> getModMenuType() {
        return NeoForgedCommonEvents.ENCHANTMENT_TRANSFERRER;
    }
}