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
 * Larimar - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelLarimar<T extends EntityGem> extends ModelGem<T> {
    public ModelRenderer leftarm;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer leftfoot;
    public ModelRenderer rightfoot;
    public ModelRenderer rightleg;
    public ModelRenderer leftleg;
    public ModelRenderer leftarm2;
    public ModelRenderer rightarm;
    public ModelRenderer rightarm2;
    public ModelRenderer topofhead;
    public ModelRenderer scarf;

    public ModelLarimar() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.leftarm2 = new ModelRenderer(this, 40, 0);
        this.leftarm2.setRotationPoint(-2.6F, 8.3F, 0.0F);
        this.leftarm2.addBox(-2.5F, 3.7F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, -0.1F, 0.0F);
        this.setRotateAngle(leftarm2, 0.0F, 0.0F, 0.17453292519943295F);
        this.rightfoot = new ModelRenderer(this, 46, 15);
        this.rightfoot.setRotationPoint(1.5F, 16.5F, 0.0F);
        this.rightfoot.addBox(-1.5F, 2.5F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.topofhead = new ModelRenderer(this, 22, 18);
        this.topofhead.setRotationPoint(0.0F, 7.5F, 0.0F);
        this.topofhead.addBox(-4.0F, -9.7F, -4.0F, 8.0F, 2.0F, 8.0F, -0.1F, -0.1F, -0.1F);
        this.leftarm = new ModelRenderer(this, 24, 0);
        this.leftarm.setRotationPoint(-2.6F, 8.3F, 0.0F);
        this.leftarm.addBox(-2.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leftarm, 0.0F, 0.0F, 0.17453292519943295F);
        this.leftfoot = new ModelRenderer(this, 32, 10);
        this.leftfoot.setRotationPoint(-1.5F, 16.5F, 0.0F);
        this.leftfoot.addBox(-1.5F, 2.5F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 18);
        this.body.setRotationPoint(0.0F, 7.5F, 0.0F);
        this.body.addBox(-3.0F, 0.0F, -2.5F, 6.0F, 9.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.rightleg = new ModelRenderer(this, 32, 5);
        this.rightleg.setRotationPoint(1.5F, 16.5F, 0.0F);
        this.rightleg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.leftleg = new ModelRenderer(this, 32, 0);
        this.leftleg.setRotationPoint(-1.5F, 16.5F, 0.0F);
        this.leftleg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 7.5F, 0.0F);
        this.head.addBox(-4.0F, -7.9F, -4.0F, 8.0F, 8.0F, 8.0F, -0.1F, -0.1F, -0.1F);
        this.rightarm = new ModelRenderer(this, 56, 9);
        this.rightarm.setRotationPoint(2.5F, 8.3F, 0.0F);
        this.rightarm.addBox(0.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rightarm, 0.0F, 0.0F, -0.17453292519943295F);
        this.rightarm2 = new ModelRenderer(this, 52, 0);
        this.rightarm2.mirror = true;
        this.rightarm2.setRotationPoint(2.5F, 8.3F, 0.0F);
        this.rightarm2.addBox(-0.5F, 3.7F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, -0.1F, 0.0F);
        this.setRotateAngle(rightarm2, 0.0F, 0.0F, -0.17453292519943295F);
        this.scarf = new ModelRenderer(this, 44, 9);
        this.scarf.setRotationPoint(0.0F, 7.5F, 0.0F);
        this.scarf.addBox(-3.0F, 3.2F, -2.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(scarf, -0.17453292519943295F, 0.0F, 0.0F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.leftarm2, this.rightfoot, this.topofhead, this.leftarm, this.leftfoot, this.body, this.rightleg, this.leftleg, this.head, this.rightarm, this.rightarm2, this.scarf).forEach((modelRenderer) -> {
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(this.head, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.topofhead, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.leftarm, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.leftarm2, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.rightarm, MathHelper.cos(limbSwing * 0.5F)  * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.rightarm2, MathHelper.cos(limbSwing * 0.5F)  * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.leftleg, MathHelper.cos(limbSwing * 0.5F) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.leftfoot, MathHelper.cos(limbSwing * 0.5F) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.rightleg, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.rightfoot, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * limbSwingAmount * 0.8f, 0, 0);
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
