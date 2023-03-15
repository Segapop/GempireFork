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
 * ModelLapis - TheBetaZeta
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelLapis<T extends EntityGem> extends ModelGem<T> {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer left_arm;
    public ModelRenderer right_arm;
    public ModelRenderer dress;
    public ModelRenderer left_leg;
    public ModelRenderer right_leg;
    public ModelRenderer hair;
    public ModelRenderer hair2;
    public ModelRenderer hair3;
    public ModelRenderer hair4;
    public ModelRenderer right_arm_puff;
    public ModelRenderer left_arm_puff;
    public ModelRenderer right_leg_puff;
    public ModelRenderer left_leg_puff;
    public ModelRenderer bow1;
    public ModelRenderer bow2;
    public ModelRenderer right_wing;
    public ModelRenderer left_wing;
    public ModelRenderer frontbow2;
    public ModelRenderer frontbow1;

    public ModelLapis() {
        this.textureWidth = 64;
        this.textureHeight = 128;
        this.right_arm = new ModelRenderer(this, 0, 0);
        this.right_arm.setRotationPoint(3.0F, 1.0F, 0.0F);
        this.right_arm.setTextureOffset(28, 16).addBox(0.0F, -1.0F, -1.0F, 2.0F, 13.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.left_leg_puff = new ModelRenderer(this, 0, 0);
        this.left_leg_puff.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.left_leg_puff.setTextureOffset(36, 28).addBox(-1.5F, 4.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.hair3 = new ModelRenderer(this, 0, 0);
        this.hair3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hair3.setTextureOffset(0, 37).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 12.0F, 8.0F, 0.5F, 0.5F, 0.5F);
        this.right_wing = new ModelRenderer(this, 0, 0);
        this.right_wing.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.right_wing.setTextureOffset(8, 68).addBox(1.0F, -15.5F, 3.0F, 19.0F, 16.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(right_wing, 0.0F, 0.0F, 1.0035643198967394F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.setTextureOffset(8, 16).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.left_arm_puff = new ModelRenderer(this, 0, 0);
        this.left_arm_puff.setRotationPoint(-3.0F, 1.0F, 0.0F);
        this.left_arm_puff.setTextureOffset(36, 20).addBox(-2.5F, 4.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.frontbow1 = new ModelRenderer(this, 0, 0);
        this.frontbow1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.frontbow1.setTextureOffset(0, 71).addBox(-1.0F, 7.0F, -4.6F, 0.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(frontbow1, 0.0F, -0.5235987755982988F, 0.0F);
        this.hair2 = new ModelRenderer(this, 0, 0);
        this.hair2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hair2.setTextureOffset(0, 57).addBox(-6.0F, -3.0F, -4.0F, 12.0F, 3.0F, 8.0F, 0.5F, 0.5F, 0.5F);
        this.left_leg = new ModelRenderer(this, 0, 0);
        this.left_leg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.left_leg.setTextureOffset(0, 31).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.dress = new ModelRenderer(this, 0, 0);
        this.dress.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dress.setTextureOffset(36, 0).addBox(-4.0F, 9.0F, -2.5F, 8.0F, 15.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.bow1 = new ModelRenderer(this, 0, 0);
        this.bow1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bow1.setTextureOffset(0, 65).addBox(-1.0F, -1.0F, 1.5F, 0.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(bow1, 0.0F, 0.5235987755982988F, 0.0F);
        this.left_arm = new ModelRenderer(this, 0, 0);
        this.left_arm.setRotationPoint(-3.0F, 1.0F, 0.0F);
        this.left_arm.setTextureOffset(0, 16).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 13.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.right_leg = new ModelRenderer(this, 0, 0);
        this.right_leg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.right_leg.setTextureOffset(28, 31).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.hair = new ModelRenderer(this, 0, 0);
        this.hair.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hair.setTextureOffset(32, 37).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, 0.5F, 0.5F);
        this.right_arm_puff = new ModelRenderer(this, 0, 0);
        this.right_arm_puff.setRotationPoint(3.0F, 1.0F, 0.0F);
        this.right_arm_puff.setTextureOffset(48, 20).addBox(-0.5F, 4.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.hair4 = new ModelRenderer(this, 0, 0);
        this.hair4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hair4.setTextureOffset(0, 59).addBox(-1.0F, 0.5F, 4.0F, 2.0F, 4.0F, 2.0F, 0.5F, 0.5F, 0.5F);
        this.setRotateAngle(hair4, 0.4363323129985824F, 0.0F, 0.0F);
        this.right_leg_puff = new ModelRenderer(this, 0, 0);
        this.right_leg_puff.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.right_leg_puff.setTextureOffset(48, 28).addBox(-1.5F, 4.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.left_wing = new ModelRenderer(this, 0, 0);
        this.left_wing.mirror = true;
        this.left_wing.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.left_wing.setTextureOffset(0, 94).addBox(-20.0F, -16.5F, 3.0F, 19.0F, 16.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(left_wing, 0.0F, 0.0F, -1.0035643198967394F);
        this.frontbow2 = new ModelRenderer(this, 0, 0);
        this.frontbow2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.frontbow2.setTextureOffset(0, 71).addBox(1.0F, 7.0F, -4.6F, 0.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(frontbow2, 0.0F, 0.5235987755982988F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.bow2 = new ModelRenderer(this, 0, 0);
        this.bow2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bow2.setTextureOffset(0, 65).addBox(1.0F, -1.0F, 1.5F, 0.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(bow2, 0.0F, -0.5235987755982988F, 0.0F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.right_arm, this.left_leg_puff, this.hair3, this.right_wing, this.body, this.left_arm_puff, this.frontbow1, this.hair2, this.left_leg, this.dress, this.bow1, this.left_arm, this.right_leg, this.hair, this.right_arm_puff, this.hair4, this.right_leg_puff, this.left_wing, this.frontbow2, this.head, this.bow2).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(this.head, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.hair, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.hair2, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.hair3, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.hair4, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.left_arm, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.right_arm, MathHelper.cos(limbSwing * 0.5F)  * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.left_arm_puff, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.right_arm_puff, MathHelper.cos(limbSwing * 0.5F)  * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.left_leg, MathHelper.cos(limbSwing * 0.5F) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.right_leg, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.left_leg_puff, MathHelper.cos(limbSwing * 0.5F) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.right_leg_puff, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
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
