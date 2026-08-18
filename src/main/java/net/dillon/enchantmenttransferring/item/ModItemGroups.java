package net.dillon.enchantmenttransferring.item;

import net.dillon.dillonlib.factory.Factories;
import net.dillon.enchantmenttransferring.block.ModBlocks;

import java.util.List;

import static net.dillon.enchantmenttransferring.helper.ModHelper.etIdentifier;

public class ModItemGroups {

    public static void initModItemGroups() {
        Factories.registerSimpleItemGroupFactory(etIdentifier("enchantment_transferring_item_group"), ModBlocks.ENCHANTMENT_TRANSFERRER,
                List.of(
                        ModBlocks.ENCHANTMENT_TRANSFERRER
                )
        );
    }
}