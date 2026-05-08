package net.dillon.enchantmenttransferring.screen;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.ItemCombinerScreen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.lwjgl.glfw.GLFW;

import java.util.Optional;

import static net.dillon.enchantmenttransferring.util.ModUtil.ofEnchantmentTransferring;

public class EnchantmentTransferrerScreen extends ItemCombinerScreen<net.dillon.enchantmenttransferring.menu.EnchantmentTransferrerMenu> {
    private static final Identifier ERROR_TEXTURE = Identifier.withDefaultNamespace("container/anvil/error");
    private static final Identifier TEXTURE = ofEnchantmentTransferring("textures/gui/container/enchantment_transferrer.png");
    private final Player player;

    public EnchantmentTransferrerScreen(net.dillon.enchantmenttransferring.menu.EnchantmentTransferrerMenu handler, Inventory inventory, Component title) {
        super(handler, inventory, title, TEXTURE);
        this.titleLabelX = 40;
        this.titleLabelY = 20;
        this.player = inventory.player;
    }

    private void renderSlotTooltip(GuiGraphicsExtractor context, int mouseX, int mouseY) {
        Optional<Component> optional = Optional.empty();

        if (this.hoveredSlot != null) {
            ItemStack focusedSlotStack = this.hoveredSlot.getItem();
            if (focusedSlotStack.isEmpty()) {
                switch (this.hoveredSlot.index) {
                    case 0 -> optional = Optional.of(Component.translatable("block.enchantmenttransferring.enchantment_transferrer.enchanted_tool").withStyle(ChatFormatting.AQUA));
                    case 1 -> optional = Optional.of(Component.translatable("block.enchantmenttransferring.enchantment_transferrer.unenchanted_tool").withStyle(ChatFormatting.LIGHT_PURPLE));
                }
            }
        }

        optional.ifPresent(text -> context.setTooltipForNextFrame(this.font, this.font.split(text, 115), mouseX, mouseY));
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor context, int mouseX, int mouseY, float delta) {
        super.extractRenderState(context, mouseX, mouseY, delta);
        this.renderSlotTooltip(context, mouseX, mouseY);
    }

    @Override
    public boolean keyPressed(KeyEvent input) {
        if (input.key() == GLFW.GLFW_KEY_ESCAPE) {
            this.minecraft.player.closeContainer();
        }

        return super.keyPressed(input);
    }

    @Override
    protected void extractLabels(GuiGraphicsExtractor context, int mouseX, int mouseY) {
        super.extractLabels(context, mouseX, mouseY);
        int i = this.menu.getLevelCost();
        if (i > 0) {
            int j = -8323296; // green
            Component text;
            if (!this.menu.getSlot(2).hasItem()) {
                text = null;
            } else {
                text = Component.translatable("block.enchantmenttransferring.enchantment_transferrer.cost", i);
                if (!this.menu.getSlot(2).mayPickup(this.player)) {
                    j = -40864; // red
                }
            }

            if (text != null) {
                int k = this.imageWidth - 8 - this.font.width(text) - 2;
                context.fill(k - 2, 67, this.imageWidth - 8, 79, 1325400064);
                context.text(this.font, text, k, 69, j);
            }
        }
    }

    @Override
    protected void extractErrorIcon(GuiGraphicsExtractor context, int x, int y) {
        if ((this.menu.getSlot(0).hasItem() || this.menu.getSlot(1).hasItem()) && !this.menu.getSlot(this.menu.getResultSlot()).hasItem()) {
            context.blitSprite(RenderPipelines.GUI_TEXTURED, ERROR_TEXTURE, x + 99, y + 45, 28, 21);
        }
    }

    @Override
    public void resize(int width, int height) {
        this.init(width, height);
    }
}