package net.dillon.enchantmenttransferring.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.ForgingScreen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

import java.util.Optional;

import static net.dillon.enchantmenttransferring.main.ET.ofEnchantmentTransferring;

@Environment(EnvType.CLIENT)
public class ETScreen extends ForgingScreen<ETScreenHandler> {
    private static final Identifier ERROR_TEXTURE = Identifier.ofVanilla("container/anvil/error");
    private static final Identifier TEXTURE = ofEnchantmentTransferring("textures/gui/container/enchantment_transferrer.png");
    private final PlayerEntity player;

    public ETScreen(ETScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title, TEXTURE);
        this.titleX = 40;
        this.titleY = 20;
        this.player = inventory.player;
    }

    private void renderSlotTooltip(DrawContext context, int mouseX, int mouseY) {
        Optional<Text> optional = Optional.empty();

        if (this.focusedSlot != null) {
            ItemStack focusedSlotStack = this.focusedSlot.getStack();
            if (focusedSlotStack.isEmpty()) {
                switch (this.focusedSlot.id) {
                    case 0 -> optional = Optional.of(Text.translatable("block.enchantmenttransferring.enchantment_transferrer.enchanted_tool").formatted(Formatting.AQUA));
                    case 1 -> optional = Optional.of(Text.translatable("block.enchantmenttransferring.enchantment_transferrer.unenchanted_tool").formatted(Formatting.LIGHT_PURPLE));
                }
            }
        }

        optional.ifPresent(text -> context.drawOrderedTooltip(this.textRenderer, this.textRenderer.wrapLines(text, 115), mouseX, mouseY));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.renderSlotTooltip(context, mouseX, mouseY);
    }

    @Override
    public boolean keyPressed(KeyInput input) {
        if (input.key() == GLFW.GLFW_KEY_ESCAPE) {
            this.client.player.closeHandledScreen();
        }

        return super.keyPressed(input);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
        int i = this.handler.getLevelCost();
        if (i > 0) {
            int j = -8323296; // green
            Text text;
            if (!this.handler.getSlot(2).hasStack()) {
                text = null;
            } else {
                text = Text.translatable("block.enchantmenttransferring.enchantment_transferrer.cost", i);
                if (!this.handler.getSlot(2).canTakeItems(this.player)) {
                    j = -40864; // red
                }
            }

            if (text != null) {
                int k = this.backgroundWidth - 8 - this.textRenderer.getWidth(text) - 2;
                context.fill(k - 2, 67, this.backgroundWidth - 8, 79, 1325400064);
                context.drawTextWithShadow(this.textRenderer, text, k, 69, j);
            }
        }
    }

    @Override
    protected void drawInvalidRecipeArrow(DrawContext context, int x, int y) {
        if ((this.handler.getSlot(0).hasStack() || this.handler.getSlot(1).hasStack()) && !this.handler.getSlot(this.handler.getResultSlotIndex()).hasStack()) {
            context.drawGuiTexture(RenderPipelines.GUI_TEXTURED, ERROR_TEXTURE, x + 99, y + 45, 28, 21);
        }
    }

    @Override
    public void resize(int width, int height) {
        this.init(width, height);
    }
}