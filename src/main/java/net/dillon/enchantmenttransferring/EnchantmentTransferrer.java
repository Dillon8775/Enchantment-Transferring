package net.dillon.enchantmenttransferring;

import net.dillon.enchantmenttransferring.block.ModBlocks;
import net.dillon.enchantmenttransferring.item.ModItemGroups;
import net.dillon.enchantmenttransferring.menu.ModMenus;
import net.dillon.enchantmenttransferring.util.ModConstants;
import net.fabricmc.api.ModInitializer;

import static net.dillon.enchantmenttransferring.util.ModUtil.info;

public class EnchantmentTransferrer implements ModInitializer {

    @Override
    public void onInitialize() {
        ModBlocks.registerBlocks();

        ModMenus.initModMenus();
        ModItemGroups.initModItemGroups();

        info("Enchantment Transferring version " + ModConstants.VERSION + " (for fabric) loaded successfully!");
    }
}