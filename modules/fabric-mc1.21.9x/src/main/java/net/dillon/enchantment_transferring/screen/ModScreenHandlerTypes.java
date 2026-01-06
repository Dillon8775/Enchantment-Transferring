package net.dillon.enchantment_transferring.screen;

import net.dillon.enchantment_transferring.main.EnchantmentTransferring;
import net.minecraft.screen.ScreenHandlerType;

/**
 * All mod screen handler types.
 */
public class ModScreenHandlerTypes {
    public static final ScreenHandlerType<EnchantmentTransferrerScreenHandler> ENCHANTMENT_TRANSFERRER = ScreenHandlerType.register("enchantment_transferrer", EnchantmentTransferrerScreenHandler::new);

    /**
     * Initializes all screen speedrunner mod handlers.
     */
    public static void initializeScreenHandlers() {
        EnchantmentTransferring.debug("Initialized screen handlers.");
    }
}