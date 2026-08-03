package net.dillon.enchantmenttransferring.entity;

import net.dillon.enchantmenttransferring.block.ModBlocks;
import net.dillon.enchantmenttransferring.mixin.accessor.BlockEntityTypesInvoker;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntityTypes {
    public static final BlockEntityType<EtBlockEntity> ENCHANTMENT_TRANSFERRER = BlockEntityTypesInvoker.invokeRegister(
            ModBlockEntityTypeIds.ENCHANTMENT_TRANSFERRER, EtBlockEntity::new, ModBlocks.ENCHANTMENT_TRANSFERRER
    );
}