package net.dillon.enchantmenttransferring;

import net.blay09.mods.balm.Balm;
import net.blay09.mods.balm.neoforge.platform.runtime.NeoForgeLoadContext;
import net.dillon.enchantmenttransferring.event.NeoForgedCommonEvents;
import net.dillon.enchantmenttransferring.item.ModItemGroups;
import net.dillon.enchantmenttransferring.item.NeoForgedItemGroups;
import net.dillon.enchantmenttransferring.main.CommonMain;
import net.dillon.enchantmenttransferring.util.ModConstants;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(ModConstants.MOD_ID)
public final class EnchantmentTransferrer {

    public EnchantmentTransferrer(ModContainer container, IEventBus modEventBus) {
        NeoForgedItemGroups.registerNeoForgedItemGroups(modEventBus);

        modEventBus.addListener(this::addCreative);

        final var context = new NeoForgeLoadContext(container, modEventBus);
        Balm.initializeMod(ModConstants.MOD_ID, context, CommonMain::initialize);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            for (ItemLike itemLike : ModItemGroups.FUNCTIONAL_ITEMS) {
                event.accept(itemLike);
            }
        }
    }
}