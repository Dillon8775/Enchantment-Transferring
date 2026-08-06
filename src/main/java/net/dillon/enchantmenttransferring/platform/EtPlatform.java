package net.dillon.enchantmenttransferring.platform;

import net.dillon.dillonlib.platform.ModPlatform;
import net.dillon.dillonlib.platform.Platforms;
import net.dillon.dillonlib.platform.info.LogoWidth;
import net.dillon.dillonlib.platform.info.PlatformName;
import net.dillon.dillonlib.platform.info.PlatformRelease;
import net.dillon.enchantmenttransferring.helper.ModConstants;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

public class EtPlatform extends ModPlatform {

    @Override
    public String modId() {
        return ModConstants.MOD_ID;
    }

    @Override
    public @NotNull Logger logger() {
        return ModConstants.LOGGER;
    }

    @Override
    public String modVersion() {
        return Platforms.getCommonPlatform().commonModVersion(ModConstants.MOD_ID);
    }

    @Override
    public @NotNull PlatformName platformName() {
        return PlatformName.FABRIC;
    }

    @Override
    public @NotNull PlatformRelease platformRelease() {
        return PlatformRelease.STABLE;
    }

    @Override
    public @NotNull LogoWidth logoWidth() {
        return LogoWidth.DEFAULT;
    }
}