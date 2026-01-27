package net.dillon.enchantmenttransferring.item;

import net.dillon.enchantmenttransferring.block.ETBlocks;
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

import static net.dillon.enchantmenttransferring.main.ET.ofEnchantmentTransferring;

/**
 * The Enchantment Transferring {@code item group.}
 */
public class ETItemGroups {

    public static ItemGroup ENCHANTMENT_TRANSFERRING = Registry.register(Registries.ITEM_GROUP, ofEnchantmentTransferring("enchantment_transferring_item_group"),
            FabricItemGroup.builder()
                    .displayName(Text.literal("Enchantment Transferring"))
                    .icon(() -> new ItemStack(ETBlocks.ENCHANTMENT_TRANSFERRER)).entries((displayContext, entries) -> {
                        entries.add(ETBlocks.ENCHANTMENT_TRANSFERRER);
                    }).build());

    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModifiedItemGroups() {
        addToItemGroup(ItemGroups.BUILDING_BLOCKS, ETBlocks.ENCHANTMENT_TRANSFERRER.asItem());
    }
}