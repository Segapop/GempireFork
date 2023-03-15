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
 * Emerald_model - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelEmerald<T extends EntityGem> extends ModelGem<T> {
    public ModelRenderer LeftLeg;
    public ModelRenderer RightArm;
    public ModelRenderer Head;
    public ModelRenderer Hips;
    public ModelRenderer RightLeg;
    public ModelRenderer LeftArm;
    public ModelRenderer Waist;
    public ModelRenderer Neck;
    public ModelRenderer Body;
    public ModelRenderer RightArmBangle;
    public ModelRenderer RightShoulderPad;
    public ModelRenderer LargeHair;
    public ModelRenderer Tiara;
    public ModelRenderer BackBun;
    public ModelRenderer ShortHair;
    public ModelRenderer RightPigtail;
    public ModelRenderer PuffyHair;
    public ModelRenderer LeftPigtail;
    public ModelRenderer LeftArmBangle;
    public ModelRenderer LeftShoulderPad;

    public ModelEmerald() {
        this.textureWidth = 94;
        this.textureHeight = 82;
        this.LeftPigtail = new ModelRenderer(this, 48, 20);
        this.LeftPigtail.mirror = true;
        this.LeftPigtail.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LeftPigtail.addBox(7.0F, -6.0F, -2.5F, 8.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftPigtail, 0.0F, 0.0F, -0.6632251157578453F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Waist = new ModelRenderer(this, 39, 41);
        this.Waist.setRotationPoint(-3.0F, 2.0F, -2.0F);
        this.Waist.addBox(0.0F, 0.0F, 0.0F, 6.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 52, 50);
        this.Body.setRotationPoint(-4.0F, -4.0F, -3.0F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 8.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 16);
        this.Neck.setRotationPoint(-1.0F, -5.0F, -1.0F);
        this.Neck.addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 72, 36);
        this.LeftArm.setRotationPoint(-4.0F, -1.0F, 0.0F);
        this.LeftArm.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 60, 34);
        this.LeftLeg.setRotationPoint(-2.5F, 11.0F, 0.0F);
        this.LeftLeg.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.RightPigtail = new ModelRenderer(this, 48, 20);
        this.RightPigtail.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RightPigtail.addBox(-15.0F, -6.0F, -2.0F, 8.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightPigtail, 0.0F, 0.0F, 0.6632251157578453F);
        this.RightArmBangle = new ModelRenderer(this, 76, 50);
        this.RightArmBangle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RightArmBangle.addBox(-0.5F, 7.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LargeHair = new ModelRenderer(this, 0, 41);
        this.LargeHair.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LargeHair.addBox(-12.5F, -4.8F, -0.5F, 13.0F, 8.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LargeHair, 1.2217304763960306F, 0.3141592653589793F, 0.6981317007977318F);
        this.Hips = new ModelRenderer(this, 36, 31);
        this.Hips.setRotationPoint(-4.0F, 7.0F, -2.0F);
        this.Hips.addBox(0.0F, 0.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg = new ModelRenderer(this, 60, 62);
        this.RightLeg.setRotationPoint(2.5F, 11.0F, 0.0F);
        this.RightLeg.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.ShortHair = new ModelRenderer(this, 0, 23);
        this.ShortHair.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ShortHair.addBox(-4.5F, -8.5F, -4.5F, 9.0F, 9.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.BackBun = new ModelRenderer(this, 72, 26);
        this.BackBun.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackBun.addBox(-2.6F, -6.5F, 4F, 5.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.RightShoulderPad = new ModelRenderer(this, 28, 24);
        this.RightShoulderPad.mirror = true;
        this.RightShoulderPad.setRotationPoint(-1.1F, -2.7F, -2.0F);
        this.RightShoulderPad.addBox(0.0F, 0.0F, 0.0F, 6.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightShoulderPad, 0.0F, 0.0F, -0.2617993877991494F);
        this.PuffyHair = new ModelRenderer(this, 32, 0);
        this.PuffyHair.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.PuffyHair.addBox(-8.0F, -10.0F, -4.0F, 16.0F, 10.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.LeftShoulderPad = new ModelRenderer(this, 28, 24);
        this.LeftShoulderPad.setRotationPoint(-4.8F, -4.2F, -2.0F);
        this.LeftShoulderPad.addBox(0.0F, 0.0F, 0.0F, 6.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftShoulderPad, 0.0F, 0.0F, 0.2617993877991494F);
        this.Tiara = new ModelRenderer(this, 11, 18);
        this.Tiara.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tiara.addBox(-5.0F, -9.0F, -4.6F, 10.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 80, 36);
        this.RightArm.setRotationPoint(4.0F, -1.0F, 0.0F);
        this.RightArm.addBox(0.0F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.LeftArmBangle = new ModelRenderer(this, 76, 50);
        this.LeftArmBangle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LeftArmBangle.addBox(-2.5F, 7.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Head.addChild(this.LeftPigtail);
        this.Head.addChild(this.RightPigtail);
        this.RightArm.addChild(this.RightArmBangle);
        this.Head.addChild(this.LargeHair);
        this.Head.addChild(this.ShortHair);
        this.Head.addChild(this.BackBun);
        this.RightArm.addChild(this.RightShoulderPad);
        this.Head.addChild(this.PuffyHair);
        this.LeftArm.addChild(this.LeftShoulderPad);
        this.Head.addChild(this.Tiara);
        this.LeftArm.addChild(this.LeftArmBangle);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.Head, this.Waist, this.Body, this.Neck, this.LeftArm, this.LeftLeg, this.Hips, this.RightLeg, this.RightArm).forEach((modelRenderer) -> {
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(this.Head, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.LeftArm, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.RightArm, MathHelper.cos(limbSwing * 0.5F)  * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.LeftLeg, MathHelper.cos(limbSwing * 0.5F) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.RightLeg, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
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
