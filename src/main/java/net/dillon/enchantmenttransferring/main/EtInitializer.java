package net.dillon.enchantmenttransferring.main;

import net.dillon.enchantmenttransferring.block.ModBlocks;
import net.dillon.enchantmenttransferring.helper.ModConstants;
import net.dillon.enchantmenttransferring.item.ModItemGroups;
import net.dillon.enchantmenttransferring.item.ModItems;
import net.dillon.enchantmenttransferring.menu.ModMenus;
import net.dillon.enchantmenttransferring.sound.ModSoundEvents;
import net.fabricmc.api.ModInitializer;

import static net.dillon.enchantmenttransferring.helper.ModConstants.MOD_INFO;

public class EtInitializer implements ModInitializer {

    @Override
    public void onInitialize() {
        ModSoundEvents.initSounds();
        ModMenus.initMenus();

        ModBlocks.initBlocks();
        ModItems.initItems();
        ModItemGroups.initModItemGroups();

        ModConstants.LOGGER.info("Enchantment Transferring version {} (for fabric) loaded successfully!", MOD_INFO.version().getString());
    }
}