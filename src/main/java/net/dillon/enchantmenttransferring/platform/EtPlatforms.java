package net.dillon.enchantmenttransferring.platform;

import net.dillon.dillonlib.platform.ModPlatform;
import net.dillon.dillonlib.platform.PlatformLoader;
import net.dillon.enchantmenttransferring.helper.ModConstants;

public class EtPlatforms {
    private static final ModPlatform PLATFORM = PlatformLoader.load(ModPlatform.class, ModConstants.MOD_ID);

    public static ModPlatform getPlatform() {
        return PLATFORM;
    }
}