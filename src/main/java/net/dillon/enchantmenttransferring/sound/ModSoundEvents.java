package net.dillon.enchantmenttransferring.sound;

import net.dillon.dillonlib.factory.Factories;
import net.minecraft.sounds.SoundEvent;

import static net.dillon.enchantmenttransferring.helper.ModHelper.ofEnchantmentTransferring;

public class ModSoundEvents {
    public static final SoundEvent ENCHANTMENT_TRANSFERRER_USE_BOOK = Factories.registerSoundEvent(ofEnchantmentTransferring("enchantmenttransferring.use_book"));
    public static final SoundEvent ENCHANTMENT_TRANSFERRER_USE_TRANSFER = Factories.registerSoundEvent(ofEnchantmentTransferring("enchantmenttransferring.use_transfer"));

    public static void initSounds() {
    }
}