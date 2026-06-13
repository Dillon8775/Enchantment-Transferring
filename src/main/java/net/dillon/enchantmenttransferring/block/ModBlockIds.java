package net.dillon.enchantmenttransferring.block;

import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

import static net.dillon.enchantmenttransferring.util.ModUtil.ofEnchantmentTransferring;

/**
 * All enchantment transferring block ids.
 */
public class ModBlockIds {
    public static final BlockItemId ENCHANTMENT_TRANSFERRER = create("enchantment_transferrer");

    /**
     * Creates an {@code block item id.}
     */
    private static BlockItemId create(final String name) {
        Identifier id = ofEnchantmentTransferring(name);
        return BlockItemId.create(id, id);
    }
}