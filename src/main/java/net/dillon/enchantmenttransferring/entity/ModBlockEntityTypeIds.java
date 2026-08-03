package net.dillon.enchantmenttransferring.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BlockEntityType;

import static net.dillon.enchantmenttransferring.helper.ModHelper.ofEnchantmentTransferring;

public class ModBlockEntityTypeIds {
    public static final ResourceKey<BlockEntityType<?>> ENCHANTMENT_TRANSFERRER = create("enchantment_transferrer");

    private static ResourceKey<BlockEntityType<?>> create(final String name) {
        return ResourceKey.create(Registries.BLOCK_ENTITY_TYPE, ofEnchantmentTransferring(name));
    }
}