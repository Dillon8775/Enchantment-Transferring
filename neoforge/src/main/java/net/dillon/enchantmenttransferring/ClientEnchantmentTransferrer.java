package net.dillon.enchantmenttransferring;

import net.blay09.mods.balm.Balm;
import net.blay09.mods.balm.neoforge.platform.runtime.NeoForgeLoadContext;
import net.dillon.enchantmenttransferring.main.ClientMain;
import net.dillon.enchantmenttransferring.util.ModConstants;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(value = ModConstants.MOD_ID, dist = Dist.CLIENT)
public final class ClientEnchantmentTransferrer {

    public ClientEnchantmentTransferrer(ModContainer container, IEventBus modEventBus) {
        final var context = new NeoForgeLoadContext(container, modEventBus);
        Balm.initializeMod(ModConstants.MOD_ID, context, ClientMain::cInitialize);
    }
}