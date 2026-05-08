package net.dillon.enchantmenttransferring.platform;

import net.dillon.enchantmenttransferring.event.FabricCommonEvents;
import net.dillon.enchantmenttransferring.screen.EnchantmentTransferrerMenu;
import net.minecraft.world.inventory.MenuType;

public class FabricPlatformHelper implements PlatformHelper {

    @Override
    public MenuType<EnchantmentTransferrerMenu> getModMenuType() {
        return FabricCommonEvents.ENCHANTMENT_TRANSFERRER;
    }
}