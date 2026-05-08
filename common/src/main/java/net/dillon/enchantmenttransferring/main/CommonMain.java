package net.dillon.enchantmenttransferring.main;

import net.blay09.mods.balm.Balm;
import net.blay09.mods.balm.core.BalmRegistrars;
import net.dillon.enchantmenttransferring.block.ModBlocks;
import net.dillon.enchantmenttransferring.platform.MultiLoader;

import static net.dillon.enchantmenttransferring.util.ModUtil.info;

public class CommonMain {

	public static void initialize(BalmRegistrars registrars) {
        ModBlocks.registerBlocks();

        info("Enchantment Transferring version " + MultiLoader.getPlatform().getModVersion() + " (for " + Balm.platform().name() + ") loaded successfully!");
	}
}