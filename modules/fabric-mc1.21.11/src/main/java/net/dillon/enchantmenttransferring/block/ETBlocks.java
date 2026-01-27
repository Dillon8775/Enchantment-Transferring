package net.dillon.enchantmenttransferring.block;

import net.dillon.enchantmenttransferring.main.ET;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;

import static net.dillon.enchantmenttransferring.main.ET.ofEnchantmentTransferring;

/**
 * All the mod blocks.
 */
public class ETBlocks {

    public static final Block ENCHANTMENT_TRANSFERRER = Blocks.register(registerEnchantmentTransferrer(), ETBlock::new, AbstractBlock.Settings.create()
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresTool()
            .luminance((state) -> 8)
            .sounds(BlockSoundGroup.STONE)
            .strength(6.5F, 1600.0F));

    private static RegistryKey<Block> registerEnchantmentTransferrer() {
        return RegistryKey.of(RegistryKeys.BLOCK, ofEnchantmentTransferring("enchantment_transferrer"));
    }

    public static void registerBlocks() {
        ET.debug("Registered blocks.");
        Items.register(ETBlocks.ENCHANTMENT_TRANSFERRER, (block, settings) -> new BlockItem(ETBlocks.ENCHANTMENT_TRANSFERRER, settings));
    }
}