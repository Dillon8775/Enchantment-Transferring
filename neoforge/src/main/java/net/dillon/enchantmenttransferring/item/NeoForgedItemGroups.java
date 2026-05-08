package net.dillon.enchantmenttransferring.item;

import net.dillon.enchantmenttransferring.block.ModBlocks;
import net.dillon.enchantmenttransferring.util.ModConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NeoForgedItemGroups {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModConstants.MOD_ID);

    public static final Supplier<CreativeModeTab> ENCHANTMENT_TRANSFERRER_ITEM_GROUP = CREATIVE_MODE_TABS.register("enchantment_transferring_item_group",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ENCHANTMENT_TRANSFERRER))
                    .title(Component.translatable("enchantment_transferring_item_group"))
                    .displayItems((itemDisplayParameters, output) -> {
                        for (ItemLike itemLike : ModItemGroups.ENCHANTMENT_TRANSFERRER_ITEMS) {
                            output.accept(itemLike);
                        }
                    })
                    .build());

    public static void registerNeoForgedItemGroups(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}