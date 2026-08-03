package net.dillon.enchantmenttransferring.item;

import net.dillon.dillonlib.mixin.accessor.ItemsInvoker;
import net.dillon.enchantmenttransferring.block.ModBlockIds;
import net.dillon.enchantmenttransferring.block.ModBlocks;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item ENCHANTMENT_TRANSFERRER = ItemsInvoker.registerModBlock(ModBlockIds.ENCHANTMENT_TRANSFERRER, ModBlocks.ENCHANTMENT_TRANSFERRER);

    public static void initItems() {
    }
}