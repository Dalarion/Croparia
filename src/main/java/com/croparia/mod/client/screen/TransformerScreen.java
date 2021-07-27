package com.croparia.mod.client.screen;

import com.croparia.mod.CropariaMod;
import com.croparia.mod.common.menu.TransformerMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.network.chat.Component;

@OnlyIn(Dist.CLIENT)
public class TransformerScreen extends AbstractContainerScreen<TransformerMenu> {

	private static final ResourceLocation GUI = new ResourceLocation(CropariaMod.mod_id, "textures/gui/transformer.png");
	
	public TransformerScreen(TransformerMenu screenContainer, Inventory inv, Component titleIn) {
		super(screenContainer, inv, titleIn);
		
		this.leftPos = 0;
		this.topPos = 0;
	}

	@Override
	public void render(PoseStack poseStack, int p_97796_, int p_97797_, float p_97798_) {
		this.renderBackground(poseStack);
		super.render(poseStack, p_97796_, p_97797_, p_97798_);
	}

	@Override
	protected void renderBg(PoseStack poseStack, float p_97788_, int p_97789_, int p_97790_) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
		RenderSystem.setShaderTexture(0, GUI);
		this.minecraft.textureManager.bindForSetup(GUI);
		int x = (this.width - this.getXSize()) / 2;
		int y = (this.height - this.getYSize()) / 2;
		this.blit(poseStack, x, y, 0, 0, this.getXSize(), this.getYSize());

		int i = this.leftPos;
		int j = this.topPos;
		int l = this.menu.getBurnProgress();
		this.blit(poseStack, i + 79, j + 34, 176, 14, l + 1, 16);
	}


}
