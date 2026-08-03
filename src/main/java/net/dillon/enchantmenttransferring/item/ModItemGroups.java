package net.dillon.enchantmenttransferring.item;

import net.dillon.dillonlib.factory.Factories;
import net.dillon.enchantmenttransferring.block.ModBlocks;

import java.util.List;

import static net.dillon.enchantmenttransferring.helper.ModHelper.ofEnchantmentTransferring;

public class ModItemGroups {

    public static void initModItemGroups() {
        Factories.registerSimpleItemGroupFactory(ofEnchantmentTransferring("enchantment_transferring_item_group"), ModBlocks.ENCHANTMENT_TRANSFERRER,
                List.of(
                        ModBlocks.ENCHANTMENT_TRANSFERRER
                )
        );
    }
}