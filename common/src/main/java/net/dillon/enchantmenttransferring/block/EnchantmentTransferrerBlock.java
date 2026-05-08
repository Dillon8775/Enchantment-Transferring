package net.dillon.enchantmenttransferring.block;

import net.dillon.enchantmenttransferring.screen.EnchantmentTransferrerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SmithingTableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EnchantmentTransferrerBlock extends SmithingTableBlock {
    private static final VoxelShape SHAPE = Block.column(16.0, 0.0, 12.0);

    public EnchantmentTransferrerBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected MenuProvider getMenuProvider(BlockState state, Level world, BlockPos pos) {
        return new SimpleMenuProvider(
                (syncId, inventory, player) -> new EnchantmentTransferrerMenu(syncId, inventory, ContainerLevelAccess.create(world, pos)), Component.translatable("block.enchantmenttransferring.enchantment_transferrer")
        );
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (!world.isClientSide()) {
            player.openMenu(state.getMenuProvider(world, pos));
        }

        return InteractionResult.SUCCESS;
    }
}