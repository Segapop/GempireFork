package com.gempire.client.entity.model;

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
 * WT - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelTourmaline<T extends EntityGem> extends ModelGem<T> {
    public ModelRenderer head;
    public ModelRenderer waist;
    public ModelRenderer rightleg;
    public ModelRenderer leftleg;
    public ModelRenderer body;
    public ModelRenderer leftarmbase;
    public ModelRenderer rightarmbase;
    public ModelRenderer leftarm;
    public ModelRenderer rightarm;

    public ModelTourmaline() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.leftarmbase = new ModelRenderer(this, 32, 47);
        this.leftarmbase.setRotationPoint(7.5F, 2.0F, 0.0F);
        this.leftarmbase.addBox(-1.0F, -0.5F, -2.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
        this.leftarm = new ModelRenderer(this, 32, 47);
        this.leftarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftarm.addBox(-1.0F, -0.5F, -2.0F, 4.0F, 10.0F, 4.0F, 0.3F, 0.0F, 0.3F);
        this.setRotateAngle(leftarm, 0.0F, 0.0F, -0.4363323129985824F);
        this.rightarmbase = new ModelRenderer(this, 32, 47);
        this.rightarmbase.setRotationPoint(-7.5F, 2.0F, 0.0F);
        this.rightarmbase.addBox(-1.0F, -0.5F, -2.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
        this.rightarm = new ModelRenderer(this, 48, 47);
        this.rightarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightarm.addBox(-3.0F, -0.5F, -2.0F, 4.0F, 10.0F, 4.0F, 0.29999995F, 0.0F, 0.29999995F);
        this.setRotateAngle(rightarm, 0.0F, 0.0F, 0.4363323129985824F);
        this.head = new ModelRenderer(this, 0, 29);
        this.head.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.head.addBox(-4.0F, -7.0F, -3.5F, 8.0F, 7.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.waist = new ModelRenderer(this, 24, 36);
        this.waist.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.waist.addBox(-5.5F, 16.0F, -3.5F, 11.0F, 3.0F, 8.0F, 0.19999981F, 0.0F, 0.3000002F);
        this.rightleg = new ModelRenderer(this, 16, 47);
        this.rightleg.setRotationPoint(3.6F, 17.0F, 0.5F);
        this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.099999905F, 0.0F, 0.099999905F);
        this.leftleg = new ModelRenderer(this, 0, 44);
        this.leftleg.setRotationPoint(-3.6F, 17.0F, 0.0F);
        this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.099999905F, 0.0F, 0.099999905F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.body.addBox(-8.0F, 0.0F, -6.0F, 16.0F, 16.0F, 13.0F, 0.10000038F, 0.0F, 0.5F);
        this.leftarmbase.addChild(this.leftarm);
        this.rightarmbase.addChild(this.rightarm);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.leftarmbase, this.rightarmbase, this.head, this.waist, this.rightleg, this.leftleg, this.body).forEach((modelRenderer) -> {
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(this.head, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.leftleg, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.rightarmbase, MathHelper.cos(limbSwing * 0.5F)  * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.rightleg, MathHelper.cos(limbSwing * 0.5F) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.leftarmbase, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
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
