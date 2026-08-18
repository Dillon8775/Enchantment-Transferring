package net.dillon.enchantmenttransferring.sound;

import net.dillon.dillonlib.factory.Factories;
import net.minecraft.sounds.SoundEvent;

import static net.dillon.enchantmenttransferring.helper.ModHelper.etIdentifier;

public class ModSoundEvents {
    public static final SoundEvent ENCHANTMENT_TRANSFERRER_USE_BOOK = Factories.registerSoundEvent(etIdentifier("enchantmenttransferring.use_book"));
    public static final SoundEvent ENCHANTMENT_TRANSFERRER_USE_TRANSFER = Factories.registerSoundEvent(etIdentifier("enchantmenttransferring.use_transfer"));

    public static void initSounds() {
    }
}