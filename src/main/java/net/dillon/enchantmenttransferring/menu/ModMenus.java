package net.dillon.enchantmenttransferring.menu;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

public class ModMenus {
    public static final MenuType<EtMenu> ENCHANTMENT_TRANSFERRER = Registry.register(
            BuiltInRegistries.MENU, "enchantment_transferrer", new MenuType<>(EtMenu::new, FeatureFlags.VANILLA_SET));

    public static void initMenus() {
    }
}