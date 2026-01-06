package net.dillon.enchantment_transferring.main;

import net.dillon.enchantment_transferring.block.ModBlocks;
import net.dillon.enchantment_transferring.item.ModItemGroups;
import net.dillon.enchantment_transferring.screen.ModScreenHandlerTypes;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main entrypoint for the enchantment transferring mod.
 */
public class EnchantmentTransferring implements ModInitializer {
	public static final String MOD_ID = "enchantment_transferring";
	private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModBlocks.registerBlocks();
        ModItemGroups.registerModifiedItemGroups();

        ModScreenHandlerTypes.initializeScreenHandlers();

        info("Enchantment Transferring has successfully loaded!");
	}

    public static Identifier ofEnchantmentTransferring(String id) {
        return Identifier.of(MOD_ID, id);
    }

    /**
     * Sends an {@code info} message to the console.
     */
    public static void info(String message) {
        LOGGER.info(message);
    }

    /**
     * Sends an {@code debug} message to the console.
     */
    public static void debug(String message) {
        LOGGER.debug(message);
    }
}