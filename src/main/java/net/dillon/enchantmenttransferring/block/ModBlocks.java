package net.dillon.enchantmenttransferring.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class ModBlocks {

    public static final Block ENCHANTMENT_TRANSFERRER = Blocks.register(ModBlockIds.ENCHANTMENT_TRANSFERRER.block(), EtBlock::new, Block.Properties.of()
            .noOcclusion()
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .lightLevel((state) -> 8)
            .sound(SoundType.STONE)
            .strength(6.5F, 1600.0F)
    );

    public static void initBlocks() {
    }
}