package net.dillon.enchantmenttransferring.event;

import net.dillon.enchantmenttransferring.screen.EnchantmentTransferrerScreen;
import net.dillon.enchantmenttransferring.util.ModConstants;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = ModConstants.MOD_ID, value = Dist.CLIENT)
public class NeoForgedClientEvents {

    @SubscribeEvent
    public static void registerModScreens(RegisterMenuScreensEvent event) {
        event.register(NeoForgedCommonEvents.ENCHANTMENT_TRANSFERRER, EnchantmentTransferrerScreen::new);
    }
}