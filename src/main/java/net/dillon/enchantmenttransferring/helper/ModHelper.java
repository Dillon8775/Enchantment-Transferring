package net.dillon.enchantmenttransferring.helper;

import net.minecraft.resources.Identifier;

import static net.dillon.enchantmenttransferring.helper.ModConstants.MOD_ID;

public class ModHelper {

    public static Identifier ofEnchantmentTransferring(String id) {
        return Identifier.fromNamespaceAndPath(MOD_ID, id);
    }
}