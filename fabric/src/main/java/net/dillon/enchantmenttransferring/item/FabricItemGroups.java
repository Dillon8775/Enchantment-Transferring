package net.dillon.enchantmenttransferring.item;

import net.dillon.enchantmenttransferring.block.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import static net.dillon.enchantmenttransferring.util.ModUtil.ofEnchantmentTransferring;

public class FabricItemGroups {

    public static CreativeModeTab ENCHANTMENT_TRANSFERRING = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ofEnchantmentTransferring("enchantment_transferring_item_group"),
            FabricCreativeModeTab.builder()
                    .title(Component.literal("Enchantment Transferring"))
                    .icon(() -> new ItemStack(ModBlocks.ENCHANTMENT_TRANSFERRER))
                    .displayItems((displayContext, entries) -> {
                        for (ItemLike itemLike : ModItemGroups.ENCHANTMENT_TRANSFERRER_ITEMS) {
                            entries.accept(itemLike);
                        }
                    }).build());

    public static void initModItemGroups() {
    }
}