package net.dillon.enchantment_transferring.block;

import net.dillon.enchantment_transferring.main.EnchantmentTransferring;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;

import static net.dillon.enchantment_transferring.main.EnchantmentTransferring.ofEnchantmentTransferring;

/**
 * All the mod blocks.
 */
public class ModBlocks {

    public static final Block ENCHANTMENT_TRANSFERRER = Blocks.register(registerEnchantmentTransferrer(), EnchantmentTransferrerBlock::new, AbstractBlock.Settings.create()
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresTool()
            .luminance((state) -> 8)
            .sounds(BlockSoundGroup.STONE)
            .strength(6.5F, 1600.0F));

    /**
     * Creates and registers a {@code block.}
     */
    private static RegistryKey<Block> registerEnchantmentTransferrer() {
        return RegistryKey.of(RegistryKeys.BLOCK, ofEnchantmentTransferring("enchantment_transferrer"));
    }

    /**
     * Registers all blocks.
     */
    public static void registerBlocks() {
        EnchantmentTransferring.debug("Registered blocks.");
        Items.register(ModBlocks.ENCHANTMENT_TRANSFERRER, (block, settings) -> new BlockItem(ModBlocks.ENCHANTMENT_TRANSFERRER, settings));
    }
}