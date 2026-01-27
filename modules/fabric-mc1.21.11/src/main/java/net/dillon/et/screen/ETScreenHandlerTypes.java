package net.dillon.et.screen;

import net.dillon.et.main.ET;
import net.minecraft.screen.ScreenHandlerType;

public class ETScreenHandlerTypes {
    public static final ScreenHandlerType<ETScreenHandler> ENCHANTMENT_TRANSFERRER = ScreenHandlerType.register("enchantment_transferrer", ETScreenHandler::new);

    public static void initializeScreenHandlers() {
        ET.debug("Initialized screen handlers.");
    }
}