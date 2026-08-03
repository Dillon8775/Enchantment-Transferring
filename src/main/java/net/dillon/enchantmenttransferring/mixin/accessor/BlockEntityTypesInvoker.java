package net.dillon.enchantmenttransferring.mixin.accessor;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockEntityTypes.class)
public interface BlockEntityTypesInvoker {
    @Invoker("register")
    static <T extends BlockEntity> BlockEntityType<T> invokeRegister(final ResourceKey<BlockEntityType<?>> key, final BlockEntityType.BlockEntitySupplier<? extends T> factory, final Block... validBlocks) {
        throw new AssertionError();
    }
}