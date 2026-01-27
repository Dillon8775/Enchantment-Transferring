package net.dillon.et.main;

import net.dillon.et.block.ETBlocks;
import net.dillon.et.item.ETItemGroups;
import net.dillon.et.screen.ETScreenHandlerTypes;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ET implements ModInitializer {
	public static final String MOD_ID = "et";
	private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ETBlocks.registerBlocks();
        ETItemGroups.registerModifiedItemGroups();

        ETScreenHandlerTypes.initializeScreenHandlers();

        info("Enchantment Transferring has successfully loaded!");
	}

    public static Identifier ofEnchantmentTransferring(String id) {
        return Identifier.of(MOD_ID, id);
    }

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void debug(String message) {
        LOGGER.debug(message);
    }
}