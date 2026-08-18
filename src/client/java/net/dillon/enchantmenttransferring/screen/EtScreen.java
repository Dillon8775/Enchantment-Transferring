package net.dillon.enchantmenttransferring.screen;

import net.dillon.dillonlib.util.CommonSprites;
import net.dillon.enchantmenttransferring.menu.EtMenu;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.CyclingSlotBackground;
import net.minecraft.client.gui.screens.inventory.ItemCombinerScreen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;
import org.lwjgl.sdl.SDLKeycode;

import java.util.List;
import java.util.Optional;

import static net.dillon.enchantmenttransferring.helper.ModHelper.etIdentifier;
import static net.minecraft.resources.Identifier.withDefaultNamespace;

public class EtScreen extends ItemCombinerScreen<EtMenu> {
    private static final Identifier ERROR_TEXTURE = withDefaultNamespace("container/anvil/error");
    private static final Identifier TEXTURE = etIdentifier("textures/gui/container/enchantment_transferrer.png");
    private static final Identifier DIAMOND = withDefaultNamespace("container/slot/diamond");
    private final Player player;
    private static final List<Identifier> SLOT_TEXTURES = List.of(
            slotTexture("axe"),
            slotTexture("boots"),
            slotTexture("chestplate"),
            slotTexture("sword"),
            slotTexture("hoe"),
            slotTexture("pickaxe"),
            slotTexture("leggings"),
            slotTexture("shovel"),
            slotTexture("spear")
    );
    private static final List<Identifier> TRANSFER_SLOT_TEXTURES = List.of(
            CommonSprites.BOOK,
            slotTexture("axe"),
            slotTexture("boots"),
            slotTexture("sword"),
            slotTexture("pickaxe")
    );
    private static final List<Identifier> OUTPUT_SLOT_TEXTURES = List.of(
            CommonSprites.ENCHANTED_BOOK
    );
    private final CyclingSlotBackground inputSlotIcon = new CyclingSlotBackground(this.menu.getInputSlot().index);
    private final CyclingSlotBackground transferToSlotIcon = new CyclingSlotBackground(this.menu.getTransferToSlot().index);
    private final CyclingSlotBackground outputSlotTextures = new CyclingSlotBackground(this.menu.getOutputSlot().index);

    public EtScreen(EtMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title, TEXTURE);
        this.titleLabelX = 40;
        this.titleLabelY = 15;
        this.player = inventory.player;
    }

    private static Identifier slotTexture(String name) {
        return withDefaultNamespace("container/slot/" + name);
    }

    @Override
    public void containerTick() {
        this.inputSlotIcon.tick(SLOT_TEXTURES);
        this.transferToSlotIcon.tick(TRANSFER_SLOT_TEXTURES);
        this.outputSlotTextures.tick(OUTPUT_SLOT_TEXTURES);
        super.containerTick();
    }

    private void renderSlotTooltip(GuiGraphicsExtractor context, int mouseX, int mouseY) {
        Optional<Component> optional = Optional.empty();

        if (this.hoveredSlot != null) {
            ItemStack focusedSlotStack = this.hoveredSlot.getItem();
            if (focusedSlotStack.isEmpty()) {
                switch (this.hoveredSlot.index) {
                    case 0 -> optional = Optional.of(Component.translatable("block.enchantmenttransferring.enchanted_tool").withStyle(ChatFormatting.AQUA));
                    case 1 -> optional = Optional.of(Component.translatable("block.enchantmenttransferring.unenchanted_tool_or_book").withStyle(ChatFormatting.LIGHT_PURPLE));
                    case 2 -> optional = Optional.of(Component.translatable("block.enchantmenttransferring.smithing_template"));
                }
            }
        }

        optional.ifPresent(text -> context.setTooltipForNextFrame(this.font, this.font.split(text, 115), mouseX, mouseY));
    }

    @Override
    public void extractRenderState(@NonNull GuiGraphicsExtractor context, int mouseX, int mouseY, float delta) {
        this.inputSlotIcon.extractRenderState(this.menu, context, delta, this.leftPos, this.topPos);
        this.outputSlotTextures.extractRenderState(this.menu, context, delta, this.leftPos, this.topPos);
        if (this.menu.getInputSlot().hasItem()) {
            this.transferToSlotIcon.extractRenderState(this.menu, context, delta, this.leftPos, this.topPos);
        }
        this.renderSlotTooltip(context, mouseX, mouseY);
        super.extractRenderState(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean keyPressed(KeyEvent input) {
        if (input.key() == SDLKeycode.SDLK_ESCAPE) {
            this.minecraft.player.closeContainer();
        }

        return super.keyPressed(input);
    }

    @Override
    protected void extractLabels(@NonNull GuiGraphicsExtractor context, int mouseX, int mouseY) {
        super.extractLabels(context, mouseX, mouseY);
        context.blitSprite(RenderPipelines.GUI_TEXTURED, DIAMOND, this.menu.getDiamondSlot().x, this.menu.getDiamondSlot().y, 16, 16);
        int i = this.menu.getLevelCost();
        if (i > 0) {
            int j = -8323296; // green
            Component text;
            if (!this.menu.getSlot(this.menu.getOutputSlot().index).hasItem()) {
                text = null;
            } else {
                text = Component.translatable("block.enchantmenttransferring.cost", i);
                if (!this.menu.getSlot(this.menu.getOutputSlot().index).mayPickup(this.player)) {
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
    protected void extractErrorIcon(@NonNull GuiGraphicsExtractor context, int x, int y) {
        if ((this.menu.getSlot(this.menu.getInputSlot().index).hasItem() && this.menu.getSlot(this.menu.getTransferToSlot().index).hasItem()) && !this.menu.getSlot(this.menu.getResultSlot()).hasItem()) {
            context.blitSprite(RenderPipelines.GUI_TEXTURED, ERROR_TEXTURE, x + 99, y + 35, 28, 21);
        }
    }

    @Override
    public void resize(int width, int height) {
        this.init(width, height);
    }
}