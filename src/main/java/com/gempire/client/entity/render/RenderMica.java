package com.gempire.client.entity.render;

import com.gempire.Gempire;
import com.gempire.client.entity.model.ModelMica;
import com.gempire.client.entity.model.ModelPebble;
import com.gempire.client.entity.render.layers.SkinLayer;
import com.gempire.entities.gems.EntityMica;
import com.gempire.entities.gems.EntityPebble;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderMica extends MobRenderer<EntityMica, ModelMica<EntityMica>> {

    public RenderMica(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelMica<>(), .25f);
        this.addLayer(new SkinLayer(this));
    }

    @Override
    protected void preRenderCallback(EntityMica entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityMica entity) {
        return new ResourceLocation(Gempire.MODID+":textures/entity/mica/mica.png");
    }
}