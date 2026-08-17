package net.dillon.enchantmenttransferring.block;

import net.dillon.enchantmenttransferring.entity.EtBlockEntity;
import net.dillon.enchantmenttransferring.entity.ModBlockEntityTypes;
import net.dillon.enchantmenttransferring.menu.EtMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class EtBlock extends BaseEntityBlock {
    private static final VoxelShape SHAPE = Block.column(16.0, 0.0, 12.0);

    public EtBlock(Properties settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
        return new EtBlockEntity(worldPosition, blockState);
    }

    @Override
    protected @NonNull MenuProvider getMenuProvider(@NonNull BlockState state, @NonNull Level world, @NonNull BlockPos pos) {
        return new SimpleMenuProvider(
                (syncId, inventory, player) -> new EtMenu(syncId, inventory, ContainerLevelAccess.create(world, pos)), Component.translatable("block.enchantmenttransferring.enchantment_transferrer")
        );
    }

    @Override
    protected @NonNull VoxelShape getShape(@NonNull BlockState state, @NonNull BlockGetter world, @NonNull BlockPos pos, @NonNull CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(final Level level, final BlockState blockState, final BlockEntityType<T> type) {
        return level.isClientSide() ? createTickerHelper(type, ModBlockEntityTypes.ENCHANTMENT_TRANSFERRER, EtBlockEntity::bookAnimationTick) : null;
    }

    @Override
    public @NonNull InteractionResult useWithoutItem(@NonNull BlockState state, Level world, @NonNull BlockPos pos, @NonNull Player player, @NonNull BlockHitResult hit) {
        if (!world.isClientSide()) {
            player.openMenu(state.getMenuProvider(world, pos));
        }

        return InteractionResult.SUCCESS;
    }
}