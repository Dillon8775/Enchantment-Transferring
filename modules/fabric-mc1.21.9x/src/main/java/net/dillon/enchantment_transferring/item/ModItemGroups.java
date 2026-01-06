package net.dillon.enchantment_transferring.item;

import net.dillon.enchantment_transferring.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;

import static net.dillon.enchantment_transferring.main.EnchantmentTransferring.ofEnchantmentTransferring;

/**
 * The Enchantment Transferring {@code item group.}
 */
public class ModItemGroups {

    /**
     * This field is never used, but the {@code init} method inside this class takes care of that, and initializes this item group.
     */
    public static ItemGroup ENCHANTMENT_TRANSFERRING = Registry.register(Registries.ITEM_GROUP, ofEnchantmentTransferring("enchantment_transferring_item_group"),
            FabricItemGroup.builder()
                    .displayName(Text.literal("Enchantment Transferring"))
                    .icon(() -> new ItemStack(ModBlocks.ENCHANTMENT_TRANSFERRER)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ENCHANTMENT_TRANSFERRER);
                    }).build());

    /**
     * Adds an item to an item group.
     */
    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    /**
     * The method to register the modified and new item groups.
     */
    public static void registerModifiedItemGroups() {
        addToItemGroup(ItemGroups.BUILDING_BLOCKS, ModBlocks.ENCHANTMENT_TRANSFERRER.asItem());
    }
}