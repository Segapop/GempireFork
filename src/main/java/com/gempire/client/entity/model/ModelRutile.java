package com.gempire.client.entity.model;

import com.gempire.client.entity.model.ModelGem;
import com.gempire.entities.bases.EntityGem;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * ModelRutile - TheBetaZeta
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelRutile<T extends EntityGem> extends ModelGem<T> {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer leftleg;
    public ModelRenderer rightleg;
    public ModelRenderer leftarm;
    public ModelRenderer rightarm;
    public ModelRenderer hairslab;

    public ModelRutile() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.leftleg = new ModelRenderer(this, 0, 0);
        this.leftleg.setRotationPoint(-1.7F, 12.0F, 0.0F);
        this.leftleg.setTextureOffset(32, 17).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.3F, 0.0F, 0.3F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.body.setTextureOffset(32, 0).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.head.addBox(-4.0F, -13.0F, -4.0F, 8.0F, 13.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.rightarm = new ModelRenderer(this, 0, 0);
        this.rightarm.mirror = true;
        this.rightarm.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.rightarm.setTextureOffset(52, 16).addBox(0.0F, -1.0F, -1.0F, 2.0F, 14.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.rightleg = new ModelRenderer(this, 0, 0);
        this.rightleg.setRotationPoint(1.7F, 12.0F, 0.0F);
        this.rightleg.setTextureOffset(40, 17).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.3F, 0.0F, 0.3F);
        this.leftarm = new ModelRenderer(this, 0, 0);
        this.leftarm.setRotationPoint(-3.0F, 0.0F, 0.0F);
        this.leftarm.setTextureOffset(52, 0).addBox(-2.0F, -1.0F, -0.9F, 2.0F, 14.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.hairslab = new ModelRenderer(this, 0, 0);
        this.hairslab.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.hairslab.setTextureOffset(0, 21).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.leftleg, this.body, this.head, this.rightarm, this.rightleg, this.leftarm, this.hairslab).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(this.head, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.hairslab, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.leftarm, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.rightarm, MathHelper.cos(limbSwing * 0.5F)  * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.leftleg, MathHelper.cos(limbSwing * 0.5F) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.rightleg, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
