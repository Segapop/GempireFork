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
 * Spinel - TheMoon
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelSpinel<T extends EntityGem> extends ModelGem<T> {
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer leftarm;
    public ModelRenderer rightarm;
    public ModelRenderer leftleg;
    public ModelRenderer rightleg;
    public ModelRenderer flathair;
    public ModelRenderer leftpigtail;
    public ModelRenderer rightpigtail;
    public ModelRenderer flathair2;
    public ModelRenderer sail1;
    public ModelRenderer sail2;
    public ModelRenderer sail3;
    public ModelRenderer pants;
    public ModelRenderer leftshoulder;
    public ModelRenderer lefthand;
    public ModelRenderer rightshoulder;
    public ModelRenderer righthand;
    public ModelRenderer leftfoot;
    public ModelRenderer rightfoot;

    public ModelSpinel() {
        this.textureWidth = 64;
        this.textureHeight = 128;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.setTextureOffset(8, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, -1.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.righthand = new ModelRenderer(this, 0, 0);
        this.righthand.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.righthand.setTextureOffset(22, 32).addBox(0.5F, 10.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.rightleg = new ModelRenderer(this, 0, 0);
        this.rightleg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.rightleg.setTextureOffset(36, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, -0.1F, 0.0F, -0.1F);
        this.rightpigtail = new ModelRenderer(this, 0, 0);
        this.rightpigtail.mirror = true;
        this.rightpigtail.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightpigtail.setTextureOffset(0, 81).addBox(8.0F, -5.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rightpigtail, 0.0F, 0.0F, -0.7853981633974483F);
        this.sail3 = new ModelRenderer(this, 0, 0);
        this.sail3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sail3.setTextureOffset(0, 92).addBox(-3.0F, -17.0F, -1.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.flathair2 = new ModelRenderer(this, 0, 0);
        this.flathair2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.flathair2.setTextureOffset(0, 37).addBox(0.0F, -20.0F, -12.0F, 0.0F, 20.0F, 24.0F, 0.0F, 0.0F, 0.0F);
        this.pants = new ModelRenderer(this, 0, 0);
        this.pants.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pants.setTextureOffset(32, 0).addBox(-4.0F, 7.0F, -3.0F, 8.0F, 7.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.leftpigtail = new ModelRenderer(this, 0, 0);
        this.leftpigtail.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftpigtail.setTextureOffset(0, 81).addBox(-16.0F, -5.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leftpigtail, 0.0F, 0.0F, 0.7853981633974483F);
        this.leftleg = new ModelRenderer(this, 0, 0);
        this.leftleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.leftleg.setTextureOffset(0, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, -0.1F, 0.0F, -0.1F);
        this.leftshoulder = new ModelRenderer(this, 0, 0);
        this.leftshoulder.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftshoulder.setTextureOffset(44, 27).addBox(-4.0F, -1.5F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.rightfoot = new ModelRenderer(this, 0, 0);
        this.rightfoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightfoot.setTextureOffset(40, 20).addBox(-1.5F, 9.8F, -3.5F, 3.0F, 2.0F, 5.0F, 0.2F, 0.2F, 0.2F);
        this.leftarm = new ModelRenderer(this, 0, 0);
        this.leftarm.setRotationPoint(-3.0F, 1.0F, 0.0F);
        this.leftarm.setTextureOffset(0, 16).addBox(-3.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, -0.1F, 0.0F, -0.1F);
        this.rightshoulder = new ModelRenderer(this, 0, 0);
        this.rightshoulder.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightshoulder.setTextureOffset(44, 35).addBox(0.0F, -1.5F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.leftfoot = new ModelRenderer(this, 0, 0);
        this.leftfoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftfoot.setTextureOffset(40, 13).addBox(-1.5F, 9.8F, -3.5F, 3.0F, 2.0F, 5.0F, 0.2F, 0.2F, 0.2F);
        this.flathair = new ModelRenderer(this, 0, 0);
        this.flathair.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.flathair.setTextureOffset(0, 43).addBox(-12.0F, -18.0F, 0.0F, 24.0F, 18.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.lefthand = new ModelRenderer(this, 0, 0);
        this.lefthand.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lefthand.setTextureOffset(8, 32).addBox(-3.5F, 10.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.sail1 = new ModelRenderer(this, 0, 0);
        this.sail1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sail1.setTextureOffset(0, 89).addBox(-2.0F, -16.0F, -5.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.rightarm = new ModelRenderer(this, 0, 0);
        this.rightarm.setRotationPoint(3.0F, 1.0F, 0.0F);
        this.rightarm.setTextureOffset(32, 16).addBox(1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, -0.1F, 0.0F, -0.1F);
        this.sail2 = new ModelRenderer(this, 0, 0);
        this.sail2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sail2.setTextureOffset(0, 89).addBox(-2.0F, -16.0F, 2.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.rightarm.addChild(this.righthand);
        this.head.addChild(this.rightpigtail);
        this.head.addChild(this.sail3);
        this.head.addChild(this.flathair2);
        this.body.addChild(this.pants);
        this.head.addChild(this.leftpigtail);
        this.leftarm.addChild(this.leftshoulder);
        this.rightleg.addChild(this.rightfoot);
        this.rightarm.addChild(this.rightshoulder);
        this.leftleg.addChild(this.leftfoot);
        this.head.addChild(this.flathair);
        this.leftarm.addChild(this.lefthand);
        this.head.addChild(this.sail1);
        this.head.addChild(this.sail2);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.body, this.head, this.rightleg, this.leftleg, this.leftarm, this.rightarm).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(this.head, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
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
