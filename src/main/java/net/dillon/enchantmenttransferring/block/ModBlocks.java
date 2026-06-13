package net.dillon.enchantmenttransferring.block;

import net.dillon.enchantmenttransferring.mixin.accessor.ItemsAccessor;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

import java.util.function.Function;

import static net.dillon.enchantmenttransferring.util.ModUtil.ofEnchantmentTransferring;

public class ModBlocks {

    public static final Block ENCHANTMENT_TRANSFERRER = register(registerEnchantmentTransferrer(), EnchantmentTransferrerBlock::new, BlockBehaviour.Properties.of()
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .lightLevel((state) -> 8)
            .sound(SoundType.STONE)
            .strength(6.5F, 1600.0F));

    private static Block register(ResourceKey<Block> id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        Block block = factory.apply(properties.setId(id));
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    private static ResourceKey<Block> registerEnchantmentTransferrer() {
        return ResourceKey.create(Registries.BLOCK, ofEnchantmentTransferring("enchantment_transferrer"));
    }

    public static void registerBlocks() {
        ItemsAccessor.invokeRegisterBlock(ModBlockIds.ENCHANTMENT_TRANSFERRER, ModBlocks.ENCHANTMENT_TRANSFERRER, new Item.Properties());
    }
}