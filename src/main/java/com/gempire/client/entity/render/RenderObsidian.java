package com.gempire.client.entity.render;

import com.gempire.Gempire;
import com.gempire.client.entity.model.ModelObsidian;
import com.gempire.client.entity.model.ModelTopaz;
import com.gempire.client.entity.render.layers.*;
import com.gempire.entities.gems.EntityObsidian;
import com.gempire.entities.gems.EntityTopaz;
import com.gempire.entities.gems.starter.EntityMica;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class RenderObsidian extends MobRenderer<EntityObsidian, ModelObsidian<EntityObsidian>> {

    public RenderObsidian(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelObsidian<>(), .25f);
        this.addLayer(new SkinLayer(this));
        this.addLayer(new MarkingLayer(this));
        this.addLayer(new FaceLayer(this));
        this.addLayer(new OutfitLayer(this));
        this.addLayer(new InsigniaLayer(this));
        this.addLayer(new VisorLayer(this));
        this.addLayer(new HairLayer(this));
        this.addLayer(new GemPlacementLayer(this));
    }

    @Override
    public ResourceLocation getEntityTexture(EntityObsidian entity) {
        return new ResourceLocation(Gempire.MODID+":textures/entity/obsidian/blank.png");
    }

    @Override
    protected void renderName(EntityObsidian entityIn, ITextComponent displayNameIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.renderName(entityIn, displayNameIn, matrixStackIn, bufferIn, packedLightIn);
    }
}
