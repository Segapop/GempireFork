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
 * ModelGarnet - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelGarnet<T extends EntityGem> extends ModelGem<T> {
    public ModelRenderer Chest;
    public ModelRenderer Head;
    public ModelRenderer ArmLeft;
    public ModelRenderer CapeTop;
    public ModelRenderer Dress;
    public ModelRenderer Hips;
    public ModelRenderer ArmRight;
    public ModelRenderer LegLeft;
    public ModelRenderer Cape;
    public ModelRenderer LegRight;
    public ModelRenderer Hair5;
    public ModelRenderer Neck;
    public ModelRenderer Body;
    public ModelRenderer ArmPuffLeft;
    public ModelRenderer ShoulderPuffLeft;
    public ModelRenderer ArmPuffRight;
    public ModelRenderer ShoulderPuffRight;
    public ModelRenderer LegPuffLeft;
    public ModelRenderer LegPuffRight;
    public ModelRenderer Hair4;
    public ModelRenderer Hair3;
    public ModelRenderer Hair2;
    public ModelRenderer Hair1;

    public ModelGarnet() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Hair3 = new ModelRenderer(this, 0, 73);
        this.Hair3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hair3.addBox(-3.5F, -9.0F, 6.5F, 7.0F, 7.0F, 7.0F, -0.70000005F, -0.6999998F, -0.6999998F);
        this.setRotateAngle(Hair3, 0.5235987755982988F, 0.0F, 0.0F);
        this.ArmPuffLeft = new ModelRenderer(this, 116, 6);
        this.ArmPuffLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ArmPuffLeft.addBox(-2.9F, 6.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.29999995F, 0.3000002F, 0.29999995F);
        this.Hair4 = new ModelRenderer(this, 68, 43);
        this.Hair4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hair4.addBox(-6.0F, -11.1F, -4.9F, 12.0F, 16.0F, 10.0F, -0.4000001F, -0.39999962F, -0.4000001F);
        this.Chest = new ModelRenderer(this, 0, 16);
        this.Chest.setRotationPoint(0.0F, -4.5F, 0.0F);
        this.Chest.addBox(-4.0F, 0.0F, -2.5F, 8.0F, 5.0F, 5.0F, 0.3000002F, 0.3000002F, 0.29999995F);
        this.LegRight = new ModelRenderer(this, 44, 43);
        this.LegRight.setRotationPoint(-2.5F, 8.7F, 0.0F);
        this.LegRight.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 15.0F, 3.0F, 0.20000005F, 0.3000002F, 0.20000005F);
        this.Dress = new ModelRenderer(this, 44, 15);
        this.Dress.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.Dress.addBox(-5.5F, 9.9F, -5.5F, 11.0F, 17.0F, 11.0F, 0.3000002F, 0.29999924F, 0.3000002F);
        this.Cape = new ModelRenderer(this, 1, 108);
        this.Cape.setRotationPoint(0.0F, -4.5F, 3.0F);
        this.Cape.addBox(-10.0F, 0.0F, 0.0F, 20.0F, 18.0F, 0.0F, 0.3000002F, 0.29999924F, 0.0F);
        this.setRotateAngle(Cape, 0.10471975511965977F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.ArmRight = new ModelRenderer(this, 108, 0);
        this.ArmRight.mirror = true;
        this.ArmRight.setRotationPoint(4.5F, -3.0F, 0.0F);
        this.ArmRight.addBox(0.0F, -1.3F, -1.0F, 2.0F, 13.0F, 2.0F, 0.29999995F, 0.3000002F, 0.29999995F);
        this.ShoulderPuffLeft = new ModelRenderer(this, 27, 15);
        this.ShoulderPuffLeft.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.ShoulderPuffLeft.addBox(-4.5F, -2.0F, -2.5F, 5.0F, 5.0F, 5.0F, -0.19999981F, -0.20000005F, -0.20000005F);
        this.ArmPuffRight = new ModelRenderer(this, 113, 13);
        this.ArmPuffRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ArmPuffRight.addBox(-0.4F, 6.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.29999995F, 0.3000002F, 0.29999995F);
        this.LegLeft = new ModelRenderer(this, 56, 43);
        this.LegLeft.mirror = true;
        this.LegLeft.setRotationPoint(2.5F, 8.7F, 0.0F);
        this.LegLeft.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 15.0F, 3.0F, 0.20000005F, 0.3000002F, 0.20000005F);
        this.Hair1 = new ModelRenderer(this, 0, 26);
        this.Hair1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hair1.addBox(-6.0F, -12.0F, -4.0F, 12.0F, 12.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Hair5 = new ModelRenderer(this, 0, 48);
        this.Hair5.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.Hair5.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.19999981F, 0.19999981F, 0.19999981F);
        this.LegPuffRight = new ModelRenderer(this, 108, 20);
        this.LegPuffRight.mirror = true;
        this.LegPuffRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegPuffRight.addBox(-2.7F, -3.2F, -2.5F, 5.0F, 7.0F, 5.0F, 0.099999905F, 0.099999905F, 0.099999905F);
        this.ShoulderPuffRight = new ModelRenderer(this, 88, 32);
        this.ShoulderPuffRight.mirror = true;
        this.ShoulderPuffRight.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.ShoulderPuffRight.addBox(-0.5F, -2.0F, -2.5F, 5.0F, 5.0F, 5.0F, -0.19999981F, -0.20000005F, -0.20000005F);
        this.ArmLeft = new ModelRenderer(this, 80, 0);
        this.ArmLeft.setRotationPoint(-4.5F, -3.0F, 0.0F);
        this.ArmLeft.addBox(-2.0F, -1.3F, -1.0F, 2.0F, 13.0F, 2.0F, 0.29999995F, 0.3000002F, 0.29999995F);
        this.LegPuffLeft = new ModelRenderer(this, 88, 20);
        this.LegPuffLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LegPuffLeft.addBox(-2.3F, -3.2F, -2.5F, 5.0F, 7.0F, 5.0F, 0.1F, 0.1F, 0.1F);
        this.Body = new ModelRenderer(this, 88, 0);
        this.Body.setRotationPoint(0.0F, -4.5F, 0.0F);
        this.Body.addBox(-3.0F, 0.0F, -2.0F, 6.0F, 9.0F, 4.0F, 0.29999995F, 0.3000002F, 0.29999995F);
        this.Hips = new ModelRenderer(this, 84, 13);
        this.Hips.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.Hips.addBox(-4.0F, 9.0F, -2.0F, 8.0F, 3.0F, 4.0F, 0.3F, 0.3F, 0.3F);
        this.Neck = new ModelRenderer(this, 0, 0);
        this.Neck.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.Neck.addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.29999995F, 0.3000002F, 0.29999995F);
        this.CapeTop = new ModelRenderer(this, 32, 0);
        this.CapeTop.setRotationPoint(0.0F, -4.9F, 0.0F);
        this.CapeTop.addBox(-8.0F, -4.0F, -2.3F, 16.0F, 7.0F, 8.0F, 0.3000002F, 0.3000002F, 0.6999998F);
        this.Hair2 = new ModelRenderer(this, 28, 80);
        this.Hair2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hair2.addBox(-5.0F, -16.0F, -4.0F, 10.0F, 16.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Hair5.addChild(this.Hair3);
        this.ArmLeft.addChild(this.ArmPuffLeft);
        this.Hair5.addChild(this.Hair4);
        this.ArmLeft.addChild(this.ShoulderPuffLeft);
        this.ArmRight.addChild(this.ArmPuffRight);
        this.Hair5.addChild(this.Hair1);
        this.LegRight.addChild(this.LegPuffRight);
        this.ArmRight.addChild(this.ShoulderPuffRight);
        this.LegLeft.addChild(this.LegPuffLeft);
        this.Hair5.addChild(this.Hair2);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.Chest, this.LegRight, this.Dress, this.Cape, this.Head, this.ArmRight, this.LegLeft, this.Hair5, this.ArmLeft, this.Body, this.Hips, this.Neck, this.CapeTop).forEach((modelRenderer) -> {
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(this.Head, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.Hair5, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.ArmLeft, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.ArmRight, MathHelper.cos(limbSwing * 0.5F)  * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.LegLeft, MathHelper.cos(limbSwing * 0.5F) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.LegRight, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
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
