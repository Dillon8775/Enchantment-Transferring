package net.dillon.enchantmenttransferring.platform;

import net.dillon.dillonlib.platform.ModPlatform;
import net.dillon.dillonlib.platform.Platforms;
import net.dillon.dillonlib.platform.info.Platform;
import net.dillon.dillonlib.platform.info.Release;
import net.dillon.enchantmenttransferring.helper.ModConstants;

public class EtPlatform extends ModPlatform {

    @Override
    public String modId() {
        return ModConstants.MOD_ID;
    }

    @Override
    public String modVersion() {
        return Platforms.getCommonPlatform().commonModVersion(ModConstants.MOD_ID);
    }

    @Override
    public Release release() {
        return Release.STABLE;
    }

    @Override
    public Platform platform() {
        return Platform.FABRIC;
    }
}