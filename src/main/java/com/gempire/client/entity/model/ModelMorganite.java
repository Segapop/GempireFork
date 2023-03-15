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
 * Morganite - Segapop
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelMorganite<T extends EntityGem> extends ModelGem<T> {
    public ModelRenderer Hair;
    public ModelRenderer Head;
    public ModelRenderer Skirt;
    public ModelRenderer LegL;
    public ModelRenderer LegR;
    public ModelRenderer ArmL;
    public ModelRenderer ArmR;
    public ModelRenderer Body;
    public ModelRenderer LSleeve;
    public ModelRenderer RSleeve;
    public ModelRenderer Train;
    public ModelRenderer Bow;
    public ModelRenderer HairTails;
    public ModelRenderer Bow_1;

    public ModelMorganite() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.HairTails = new ModelRenderer(this, 24, 32);
        this.HairTails.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.HairTails.addBox(-5.0F, 8.5F, -3.7F, 10.0F, 6.0F, 8.0F, -0.5F, 0.5F, 0.5F);
        this.RSleeve = new ModelRenderer(this, 0, 53);
        this.RSleeve.setRotationPoint(3.5F, 10.0F, 0.0F);
        this.RSleeve.addBox(-1.0F, 3.0F, -2.0F, 4.0F, 7.0F, 4.0F, -0.3F, 0.0F, -0.3F);
        this.ArmL = new ModelRenderer(this, 16, 42);
        this.ArmL.setRotationPoint(-3.5F, 10.0F, 0.0F);
        this.ArmL.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Hair = new ModelRenderer(this, 24, 8);
        this.Hair.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.Hair.addBox(-5.0F, -8.5F, -3.7F, 10.0F, 16.0F, 8.0F, -0.5F, 0.5F, 0.5F);
        this.Train = new ModelRenderer(this, 20, 2);
        this.Train.setRotationPoint(1.0F, 24.0F, 6.0F);
        this.Train.addBox(-4.0F, 0.0F, -1.5F, 6.0F, 0.0F, 6.0F, 0.5F, 0.0F, 0.5F);
        this.Skirt = new ModelRenderer(this, 0, 29);
        this.Skirt.setRotationPoint(1.0F, 17.0F, 0.0F);
        this.Skirt.addBox(-4.0F, 0.0F, -2.2F, 6.0F, 7.0F, 6.0F, 0.5F, 0.0F, 0.2F);
        this.LegR = new ModelRenderer(this, 40, 46);
        this.LegR.setRotationPoint(1.5F, 17.0F, 1.0F);
        this.LegR.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.LSleeve = new ModelRenderer(this, 0, 42);
        this.LSleeve.setRotationPoint(-3.5F, 10.0F, 0.0F);
        this.LSleeve.addBox(-3.0F, 3.0F, -2.0F, 4.0F, 7.0F, 4.0F, -0.3F, 0.0F, -0.3F);
        this.Bow = new ModelRenderer(this, 38, 0);
        this.Bow.setRotationPoint(0.0F, 13.0F, 4.5F);
        this.Bow.addBox(-3.5F, 0.0F, -2.0F, 7.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.ArmR = new ModelRenderer(this, 24, 46);
        this.ArmR.setRotationPoint(3.5F, 10.0F, 0.0F);
        this.ArmR.addBox(0.0F, -1.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.Head.addBox(-4.0F, -7.7F, -4.0F, 8.0F, 8.0F, 8.0F, -0.3F, -0.3F, -0.3F);
        this.LegL = new ModelRenderer(this, 32, 46);
        this.LegL.setRotationPoint(-1.5F, 17.0F, 1.0F);
        this.LegL.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Bow_1 = new ModelRenderer(this, 16, 58);
        this.Bow_1.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.Bow_1.addBox(-4.0F, -14.0F, 0.0F, 8.0F, 6.0F, 0.0F, -1.0F, -1.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 16);
        this.Body.setRotationPoint(0.0F, 9.0F, -0.5F);
        this.Body.addBox(-3.0F, 0.0F, -2.5F, 6.0F, 8.0F, 5.0F, 0.5F, 0.0F, 0.0F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.HairTails, this.RSleeve, this.ArmL, this.Hair, this.Train, this.Skirt, this.LegR, this.LSleeve, this.Bow, this.ArmR, this.Head, this.LegL, this.Bow_1, this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(this.Head, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.Hair, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.HairTails, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.ArmL, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.LSleeve, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.ArmR, MathHelper.cos(limbSwing * 0.5F)  * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.RSleeve, MathHelper.cos(limbSwing * 0.5F)  * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.LegL, MathHelper.cos(limbSwing * 0.5F) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.LegR, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
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
