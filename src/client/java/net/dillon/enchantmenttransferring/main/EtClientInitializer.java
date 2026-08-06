package net.dillon.enchantmenttransferring.main;

import net.dillon.enchantmenttransferring.entity.ModBlockEntityTypes;
import net.dillon.enchantmenttransferring.event.ClientEvents;
import net.dillon.enchantmenttransferring.menu.ModMenus;
import net.dillon.enchantmenttransferring.render.EtRenderer;
import net.dillon.enchantmenttransferring.screen.EtScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class EtClientInitializer implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientEvents.registerClientEvents();

        MenuScreens.register(ModMenus.ENCHANTMENT_TRANSFERRER, EtScreen::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.ENCHANTMENT_TRANSFERRER, EtRenderer::new);
    }
}