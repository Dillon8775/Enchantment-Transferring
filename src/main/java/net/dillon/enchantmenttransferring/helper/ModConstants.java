package net.dillon.enchantmenttransferring.helper;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModConstants {
    public static final String MOD_ID = "enchantmenttransferring";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final String VERSION = FabricLoader.getInstance()
            .getModContainer(MOD_ID)
            .map(c -> c.getMetadata().getVersion().getFriendlyString().split("\\+", 2)[0])
            .orElse("unknown");
}