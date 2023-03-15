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
 * Aquamarine - Segapop
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelAquamarine<T extends EntityGem> extends ModelGem<T> {
    public ModelRenderer HairPoof;
    public ModelRenderer Head;
    public ModelRenderer Body;
    public ModelRenderer Skirt;
    public ModelRenderer LArm;
    public ModelRenderer RArm;
    public ModelRenderer LLeg;
    public ModelRenderer RLeg;
    public ModelRenderer LWing;
    public ModelRenderer RWing;
    public ModelRenderer Ribbon;
    public ModelRenderer Hair;

    public ModelAquamarine() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Skirt = new ModelRenderer(this, 0, 28);
        this.Skirt.setRotationPoint(-4.5F, 15.0F, -4.5F);
        this.Skirt.addBox(0.0F, -1.0F, 0.0F, 9.0F, 6.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.LArm = new ModelRenderer(this, 30, 16);
        this.LArm.setRotationPoint(3.0F, 11.0F, 0.0F);
        this.LArm.addBox(0.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Ribbon = new ModelRenderer(this, 24, 0);
        this.Ribbon.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.Ribbon.addBox(-3.5F, -13.5F, 0.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.LLeg = new ModelRenderer(this, 30, 26);
        this.LLeg.setRotationPoint(1.5F, 17.0F, 0.0F);
        this.LLeg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.RArm = new ModelRenderer(this, 0, 16);
        this.RArm.setRotationPoint(-3.0F, 11.0F, 0.0F);
        this.RArm.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 8, 16);
        this.Body.setRotationPoint(-3.0F, 10.0F, -2.5F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 6.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.RWing = new ModelRenderer(this, 44, 16);
        this.RWing.setRotationPoint(0.0F, 11.5F, 2.6F);
        this.RWing.addBox(-10.0F, -8.0F, 0.0F, 10.0F, 16.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.HairPoof = new ModelRenderer(this, 26, 52);
        this.HairPoof.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.HairPoof.addBox(-5.0F, -3.9F, -3.6F, 10.0F, 3.0F, 9.0F, 1.0F, 0.5F, 0.5F);
        this.Hair = new ModelRenderer(this, 32, 0);
        this.Hair.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.Hair.addBox(-4.0F, -8.0F, -3.6F, 8.0F, 8.0F, 8.0F, 0.8F, 0.5F, 0.5F);
        this.LWing = new ModelRenderer(this, 44, 16);
        this.LWing.mirror = true;
        this.LWing.setRotationPoint(0.0F, 11.5F, 2.6F);
        this.LWing.addBox(0.0F, -8.0F, 0.0F, 10.0F, 16.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.RLeg = new ModelRenderer(this, 0, 26);
        this.RLeg.setRotationPoint(-1.5F, 17.0F, 0.0F);
        this.RLeg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Skirt, this.LArm, this.Ribbon, this.Head, this.LLeg, this.RArm, this.Body, this.RWing, this.HairPoof, this.Hair, this.LWing, this.RLeg).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(this.Head, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.Hair, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.HairPoof, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.Ribbon, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
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
