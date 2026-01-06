package net.dillon.enchantment_transferring.block;

import net.dillon.enchantment_transferring.screen.EnchantmentTransferrerScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.SmithingTableBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * A block that allows transferring of enchantments to other items.
 */
public class EnchantmentTransferrerBlock extends SmithingTableBlock {

    public EnchantmentTransferrerBlock(Settings settings) {
        super(settings);
    }

    /**
     * Create the handled screen factory so the game knows what screen to open.
     */
    @Override
    protected NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory(
                (syncId, inventory, player) -> new EnchantmentTransferrerScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), Text.translatable("block.enchantment_transferring.enchantment_transferrer")
        );
    }

    /**
     * The method to open the screen for the {@code Enchantment Transferrer.}
     */
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
        }

        return ActionResult.SUCCESS;
    }
}