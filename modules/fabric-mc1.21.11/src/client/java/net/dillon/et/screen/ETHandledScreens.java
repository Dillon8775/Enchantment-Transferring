package net.dillon.et.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class ETHandledScreens {

    public static void registerScreens() {
        HandledScreens.register(ETScreenHandlerTypes.ENCHANTMENT_TRANSFERRER, ETScreen::new);
    }
}