package net.dillon.enchantmenttransferring.event;

import net.dillon.enchantmenttransferring.screen.EnchantmentTransferrerMenu;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

public class NeoForgedCommonEvents {
    public static final MenuType<EnchantmentTransferrerMenu> ENCHANTMENT_TRANSFERRER = Registry.register(
            BuiltInRegistries.MENU, "enchantment_transferrer", new MenuType<>(EnchantmentTransferrerMenu::new, FeatureFlags.VANILLA_SET));

    public static void initModMenus() {
    }
}