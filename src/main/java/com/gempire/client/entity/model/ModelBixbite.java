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
 * ModelBixbite - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelBixbite<T extends EntityGem> extends ModelGem<T> {
    public ModelRenderer Head;
    public ModelRenderer rightarm;
    public ModelRenderer hair1;
    public ModelRenderer leftleg;
    public ModelRenderer hips;
    public ModelRenderer rightleg;
    public ModelRenderer Shoulders;
    public ModelRenderer rightthigh;
    public ModelRenderer leftthigh;
    public ModelRenderer leftarm;
    public ModelRenderer Body;
    public ModelRenderer Shoulders_2;
    public ModelRenderer horns;
    public ModelRenderer hair4;
    public ModelRenderer hair3;
    public ModelRenderer hair2;

    public ModelBixbite() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, -2.7F, 0.0F);
        this.Head.addBox(-4.0F, -7.7F, -4.0F, 8.0F, 8.0F, 8.0F, -0.29999995F, -0.3000002F, -0.29999995F);
        this.leftarm = new ModelRenderer(this, 51, 4);
        this.leftarm.setRotationPoint(-3.0F, -0.7F, 0.0F);
        this.leftarm.addBox(-2.0F, -0.8F, -1.0F, 2.0F, 13.0F, 2.0F, 0.0F, 0.19999981F, 0.0F);
        this.leftleg = new ModelRenderer(this, 0, 54);
        this.leftleg.setRotationPoint(-2.2F, 10.0F, 0.0F);
        this.leftleg.addBox(-1.0F, 6.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.100000024F, 0.0F, 0.100000024F);
        this.hair4 = new ModelRenderer(this, 40, 50);
        this.hair4.setRotationPoint(0.0F, 0.8F, 0.0F);
        this.hair4.addBox(-5.0F, -2.2F, 5.8F, 10.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hair4, 0.5235987755982988F, 0.0F, 0.0F);
        this.rightleg = new ModelRenderer(this, 16, 45);
        this.rightleg.setRotationPoint(2.2F, 10.0F, 0.0F);
        this.rightleg.addBox(-1.0F, 6.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.100000024F, 0.0F, 0.100000024F);
        this.hair2 = new ModelRenderer(this, 40, 36);
        this.hair2.mirror = true;
        this.hair2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hair2.addBox(5.3F, -2.1F, -5.0F, 0.0F, 5.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hair2, 0.0F, 0.0F, -0.40142572795869574F);
        this.rightarm = new ModelRenderer(this, 54, 30);
        this.rightarm.setRotationPoint(3.0F, -0.7F, 0.0F);
        this.rightarm.addBox(0.0F, -0.8F, -1.0F, 2.0F, 13.0F, 2.0F, 0.0F, 0.19999981F, 0.0F);
        this.leftthigh = new ModelRenderer(this, 0, 43);
        this.leftthigh.setRotationPoint(-2.2F, 9.5F, 0.0F);
        this.leftthigh.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, -0.29999995F, -0.099999905F, -0.29999995F);
        this.Body = new ModelRenderer(this, 33, 4);
        this.Body.setRotationPoint(0.0F, -2.7F, 0.0F);
        this.Body.addBox(-3.0F, 0.0F, -1.5F, 6.0F, 12.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Shoulders_2 = new ModelRenderer(this, 0, 28);
        this.Shoulders_2.setRotationPoint(0.0F, -2.7F, 0.0F);
        this.Shoulders_2.addBox(-5.0F, -5.0F, -2.5F, 10.0F, 10.0F, 5.0F, 0.0F, 0.0F, -0.5F);
        this.setRotateAngle(Shoulders_2, 0.0F, 0.0F, 0.7853981633974483F);
        this.hair3 = new ModelRenderer(this, 40, 36);
        this.hair3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hair3.addBox(-5.8F, -2.1F, -5.0F, 0.0F, 5.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hair3, 0.0F, 0.0F, 0.5235987755982988F);
        this.hips = new ModelRenderer(this, 38, 19);
        this.hips.setRotationPoint(0.0F, -2.7F, 0.0F);
        this.hips.addBox(5.5F, 5.5F, -2.0F, 6.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hips, 0.0F, 0.0F, 0.7853981633974483F);
        this.Shoulders = new ModelRenderer(this, 0, 16);
        this.Shoulders.setRotationPoint(0.0F, -2.7F, 0.0F);
        this.Shoulders.addBox(-7.0F, 0.0F, -2.5F, 14.0F, 7.0F, 5.0F, 0.099999905F, 0.0F, -0.5F);
        this.horns = new ModelRenderer(this, 30, 29);
        this.horns.setRotationPoint(0.0F, -2.7F, 0.0F);
        this.horns.addBox(-6.0F, -11.8F, 0.0F, 12.0F, 5.0F, 0.0F, -0.19999981F, -0.19999981F, 0.0F);
        this.rightthigh = new ModelRenderer(this, 30, 34);
        this.rightthigh.setRotationPoint(2.2F, 9.5F, 0.0F);
        this.rightthigh.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, -0.29999995F, -0.099999905F, -0.29999995F);
        this.hair1 = new ModelRenderer(this, 16, 47);
        this.hair1.setRotationPoint(0.0F, -2.7F, 0.0F);
        this.hair1.addBox(-4.0F, -7.7F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.hair1.addChild(this.hair4);
        this.hair1.addChild(this.hair2);
        this.hair1.addChild(this.hair3);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.Head, this.leftarm, this.leftleg, this.rightleg, this.rightarm, this.leftthigh, this.Body, this.Shoulders_2, this.hips, this.Shoulders, this.horns, this.rightthigh, this.hair1).forEach((modelRenderer) -> {
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(this.Head, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.hair1, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.horns, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.leftarm, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.rightarm, MathHelper.cos(limbSwing * 0.5F)  * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.leftleg, MathHelper.cos(limbSwing * 0.5F) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.rightleg, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.leftthigh, MathHelper.cos(limbSwing * 0.5F) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.rightthigh, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
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
