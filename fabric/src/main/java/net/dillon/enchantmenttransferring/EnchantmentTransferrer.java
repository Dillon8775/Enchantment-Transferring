package net.dillon.enchantmenttransferring;

import net.blay09.mods.balm.Balm;
import net.blay09.mods.balm.fabric.platform.runtime.FabricLoadContext;
import net.dillon.enchantmenttransferring.event.FabricCommonEvents;
import net.dillon.enchantmenttransferring.item.FabricItemGroups;
import net.dillon.enchantmenttransferring.main.CommonMain;
import net.dillon.enchantmenttransferring.util.ModConstants;
import net.fabricmc.api.ModInitializer;

public class EnchantmentTransferrer implements ModInitializer {

    @Override
    public void onInitialize() {
        FabricCommonEvents.initModMenus();
        FabricItemGroups.initModItemGroups();

        Balm.initializeMod(ModConstants.MOD_ID, FabricLoadContext.INSTANCE, CommonMain::initialize);
    }
}