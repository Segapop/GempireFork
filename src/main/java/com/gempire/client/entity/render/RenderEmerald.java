package com.gempire.client.entity.render;

import com.gempire.Gempire;
import com.gempire.client.entity.model.ModelEmerald;
import com.gempire.client.entity.model.ModelRuby;
import com.gempire.client.entity.render.layers.*;
import com.gempire.entities.gems.EntityAquamarine;
import com.gempire.entities.gems.EntityEmerald;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class RenderEmerald extends MobRenderer<EntityEmerald, ModelEmerald<EntityEmerald>> {

    public RenderEmerald(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelEmerald<>(), .25f);
        this.addLayer(new SkinLayer(this));
        this.addLayer(new FaceLayer(this));
        this.addLayer(new OutfitLayer(this));
        this.addLayer(new InsigniaLayer(this));
        this.addLayer(new HairLayer(this));
        this.addLayer(new VisorLayer(this));
        this.addLayer(new GemPlacementLayer(this));
    }

    @Override
    protected void preRenderCallback(EntityEmerald entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.25F, 1.35F, 1.25F);
        super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityEmerald entity) {
        return new ResourceLocation(Gempire.MODID+":textures/entity/emerald/blank.png");
    }
    @Override
    protected void renderName(EntityEmerald entityIn, ITextComponent displayNameIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.renderName(entityIn, displayNameIn, matrixStackIn, bufferIn, packedLightIn);
    }
}