package net.dillon.enchantmenttransferring.util;

import net.fabricmc.loader.api.FabricLoader;

public class ModConstants {
    public static final String MOD_ID = "enchantmenttransferring";
    public static final String VERSION = FabricLoader.getInstance()
            .getModContainer(MOD_ID)
            .map(c -> c.getMetadata().getVersion().getFriendlyString().split("\\+", 2)[0])
            .orElse("unknown");
}