package net.dillon.enchantmenttransferring.block;

import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

import static net.dillon.enchantmenttransferring.helper.ModHelper.ofEnchantmentTransferring;

public class ModBlockIds {
    public static final BlockItemId ENCHANTMENT_TRANSFERRER = create("enchantment_transferrer");

    private static BlockItemId create(final String name) {
        Identifier id = ofEnchantmentTransferring(name);
        return BlockItemId.create(id, id);
    }
}