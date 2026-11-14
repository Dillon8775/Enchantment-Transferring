package net.dillon.enchantmenttransferring.helper;

import net.dillon.dillonlib.platform.info.ModInfo;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModConstants {
    public static final String MOD_ID = "enchantmenttransferring";
    public static final ModInfo MOD_INFO = ModInfo.create(
            MOD_ID,
            "enchantment-transferring",
            Component.translatable("enchantmenttransferring"),
            ChatFormatting.GOLD
    );
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
}