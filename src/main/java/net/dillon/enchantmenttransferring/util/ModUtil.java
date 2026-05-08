package net.dillon.enchantmenttransferring.util;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.dillon.enchantmenttransferring.util.ModConstants.MOD_ID;

public class ModUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier ofEnchantmentTransferring(String id) {
        return Identifier.fromNamespaceAndPath(MOD_ID, id);
    }

    public static void info(String message) {
        LOGGER.info(message);
    }
}