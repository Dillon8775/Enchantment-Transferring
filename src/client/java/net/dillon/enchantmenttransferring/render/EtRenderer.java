package net.dillon.enchantmenttransferring.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.dillon.enchantmenttransferring.entity.EtBlockEntity;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.object.book.BookModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

public class EtRenderer implements BlockEntityRenderer<EtBlockEntity, EtRenderState> {
	public static final SpriteId BOOK_TEXTURE = Sheets.BLOCK_ENTITIES_MAPPER.defaultNamespaceApply("enchantment/enchanting_table_book");
	private final SpriteGetter sprites;
	private final BookModel bookModel;

	public EtRenderer(final BlockEntityRendererProvider.Context context) {
		this.sprites = context.sprites();
		this.bookModel = new BookModel(context.bakeLayer(ModelLayers.BOOK));
	}

	public EtRenderState createRenderState() {
		return new EtRenderState();
	}

	public void extractRenderState(final EtBlockEntity blockEntity, final EtRenderState state, final float partialTicks, final Vec3 cameraPosition, final ModelFeatureRenderer.CrumblingOverlay breakProgress) {
		BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
		state.flip = Mth.lerp(partialTicks, blockEntity.oFlip, blockEntity.flip);
		state.open = Mth.lerp(partialTicks, blockEntity.oOpen, blockEntity.open);
		state.time = blockEntity.time + partialTicks;
		float or = blockEntity.rot - blockEntity.oRot;

		while (or >= (float) Math.PI) {
			or -= (float) (Math.PI * 2);
		}

		while (or < (float) -Math.PI) {
			or += (float) (Math.PI * 2);
		}

		state.yRot = blockEntity.oRot + or * partialTicks;
	}

	public void submit(final EtRenderState state, final PoseStack poseStack, final SubmitNodeCollector submitNodeCollector, final CameraRenderState camera) {
		poseStack.pushPose();
		poseStack.translate(0.5F, 0.75F, 0.5F);
		poseStack.translate(0.0F, 0.1F + Mth.sin(state.time * 0.1F) * 0.01F, 0.0F);
		float yRot = state.yRot;
		poseStack.rotate(Axis.YP, -yRot);
		poseStack.rotateDegrees(Axis.ZP, 80.0F);
		float ff1 = Mth.frac(state.flip + 0.25F) * 1.6F - 0.3F;
		float ff2 = Mth.frac(state.flip + 0.75F) * 1.6F - 0.3F;
		BookModel.State bookState = BookModel.State.forAnimation(state.time, Mth.clamp(ff1, 0.0F, 1.0F), Mth.clamp(ff2, 0.0F, 1.0F), state.open);
		submitNodeCollector.submitModel(this.bookModel, bookState, poseStack, state.lightCoords, OverlayTexture.NO_OVERLAY, -1, BOOK_TEXTURE, this.sprites, 0);

		if (state.breakProgress != null) {
			submitNodeCollector.order(1).submitCrumblingOverlay(this.bookModel, bookState, poseStack, BOOK_TEXTURE.renderType(this.bookModel.renderType()), state.lightCoords, OverlayTexture.NO_OVERLAY, -1, state.breakProgress);
		}

		poseStack.popPose();
	}
}