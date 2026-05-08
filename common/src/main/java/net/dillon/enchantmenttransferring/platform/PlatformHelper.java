package net.dillon.enchantmenttransferring.platform;

import net.blay09.mods.balm.Balm;
import net.dillon.enchantmenttransferring.screen.EnchantmentTransferrerMenu;
import net.minecraft.world.inventory.MenuType;

public interface PlatformHelper {

    /**
     * @return the mod version.
     */
    default String getModVersion() {
        return "1.0";
    }

    /**
     * @return if the platform is on NeoForged.
     */
    default boolean isNeoForged() {
        return Balm.platform().name().equals("neoforge");
    }

    MenuType<EnchantmentTransferrerMenu> getModMenuType();
}