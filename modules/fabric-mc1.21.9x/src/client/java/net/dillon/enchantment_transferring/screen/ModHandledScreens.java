package net.dillon.enchantment_transferring.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

/**
 * All mod handled screens.
 */
@Environment(EnvType.CLIENT)
public class ModHandledScreens {

    /**
     * Registers all screens.
     */
    public static void registerScreens() {
        HandledScreens.register(ModScreenHandlerTypes.ENCHANTMENT_TRANSFERRER, EnchantmentTransferringScreen::new);
    }
}