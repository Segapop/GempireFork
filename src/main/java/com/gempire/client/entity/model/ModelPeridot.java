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
 * Peridot - Segapop
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelPeridot<T extends EntityGem> extends ModelGem<T> {
    public ModelRenderer Head;
    public ModelRenderer Body;
    public ModelRenderer LArm;
    public ModelRenderer RArm;
    public ModelRenderer LLeg;
    public ModelRenderer RLeg;
    public ModelRenderer Triangleleft;
    public ModelRenderer Triangleright;
    public ModelRenderer Trianglecenter;
    public ModelRenderer Trianglebase;
    public ModelRenderer Squaredown;
    public ModelRenderer shape21;
    public ModelRenderer shape22;

    public ModelPeridot() {
        this.textureWidth = 64;
        this.textureHeight = 128;
        this.LArm = new ModelRenderer(this, 32, 0);
        this.LArm.setRotationPoint(-3.0F, 5.0F, 0.0F);
        this.LArm.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.shape21 = new ModelRenderer(this, 0, 32);
        this.shape21.setRotationPoint(-2.5F, -1.0F, -1.5F);
        this.shape21.addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Triangleleft = new ModelRenderer(this, 0, 84);
        this.Triangleleft.setRotationPoint(-10.5F, -7.2F, -3.5F);
        this.Triangleleft.addBox(0.0F, 0.0F, 0.0F, 5.0F, 10.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Triangleleft, 0.0F, 0.0F, -0.7853981633974483F);
        this.LLeg = new ModelRenderer(this, 48, 0);
        this.LLeg.setRotationPoint(-2.0F, 14.0F, 0.0F);
        this.LLeg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Trianglebase = new ModelRenderer(this, 0, 117);
        this.Trianglebase.setRotationPoint(0.0F, 4.9F, 7.5F);
        this.Trianglebase.addBox(-3.5F, -9.0F, -4.0F, 7.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Trianglecenter = new ModelRenderer(this, 0, 64);
        this.Trianglecenter.setRotationPoint(-7.0F, -10.7F, -3.5F);
        this.Trianglecenter.addBox(0.0F, 0.0F, 0.0F, 10.0F, 11.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Trianglecenter, 0.0F, 0.0F, -0.7853981633974483F);
        this.Squaredown = new ModelRenderer(this, 0, 43);
        this.Squaredown.setRotationPoint(-4.0F, -4.5F, 0.5F);
        this.Squaredown.addBox(-4.0F, -8.0F, -4.0F, 16.0F, 12.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Triangleright = new ModelRenderer(this, 0, 103);
        this.Triangleright.setRotationPoint(0.0F, -3.7F, -3.5F);
        this.Triangleright.addBox(0.0F, 0.0F, 0.0F, 10.0F, 5.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Triangleright, 0.0F, 0.0F, -0.7853981633974483F);
        this.Body = new ModelRenderer(this, 0, 16);
        this.Body.setRotationPoint(-3.0F, 4.0F, -2.0F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.RArm = new ModelRenderer(this, 40, 0);
        this.RArm.setRotationPoint(3.0F, 5.0F, 0.0F);
        this.RArm.addBox(0.0F, -1.0F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.shape22 = new ModelRenderer(this, 0, 32);
        this.shape22.setRotationPoint(-0.5F, -1.0F, -1.5F);
        this.shape22.addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.RLeg = new ModelRenderer(this, 56, 0);
        this.RLeg.setRotationPoint(1.9F, 14.0F, 0.0F);
        this.RLeg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.LArm.addChild(this.shape21);
        this.Head.addChild(this.Triangleleft);
        this.Head.addChild(this.Trianglebase);
        this.Head.addChild(this.Trianglecenter);
        this.Head.addChild(this.Squaredown);
        this.Head.addChild(this.Triangleright);
        this.RArm.addChild(this.shape22);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LArm, this.LLeg, this.Body, this.RArm, this.Head, this.RLeg).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(this.Head, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.LArm, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.RArm, MathHelper.cos(limbSwing * 0.5F)  * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.LLeg, MathHelper.cos(limbSwing * 0.5F) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.RLeg, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
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
