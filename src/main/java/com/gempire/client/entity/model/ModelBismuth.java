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
 * Bismuth - TheBetaZeta
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelBismuth<T extends EntityGem> extends ModelGem<T> {
    public ModelRenderer Body;
    public ModelRenderer Head;
    public ModelRenderer Hips;
    public ModelRenderer rightarm;
    public ModelRenderer rightleg;
    public ModelRenderer chestgem;
    public ModelRenderer leftleg;
    public ModelRenderer leftarm;
    public ModelRenderer ShortHair;
    public ModelRenderer HairBun;
    public ModelRenderer navalgem;
    public ModelRenderer LongHair;

    public ModelBismuth() {
        this.textureWidth = 64;
        this.textureHeight = 128;
        this.ShortHair = new ModelRenderer(this, 0, 0);
        this.ShortHair.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.ShortHair.setTextureOffset(0, 61).addBox(-5.0F, -9.2F, -7.0F, 10.0F, 10.0F, 10.0F, -0.7F, -0.6F, -0.7F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.Body.addBox(-8.0F, 0.0F, -5.5F, 16.0F, 13.0F, 11.0F, 0.0F, 0.0F, -0.1F);
        this.leftarm = new ModelRenderer(this, 0, 0);
        this.leftarm.mirror = true;
        this.leftarm.setRotationPoint(-8.0F, -0.5F, 0.0F);
        this.leftarm.setTextureOffset(32, 38).addBox(-6.5F, -3.0F, -3.0F, 6.0F, 20.0F, 6.0F, 0.5F, 0.5F, 0.5F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.Head.setTextureOffset(0, 45).addBox(-4.0F, -8.2F, -6.0F, 8.0F, 8.0F, 8.0F, 0.2F, 0.2F, 0.2F);
        this.leftleg = new ModelRenderer(this, 0, 0);
        this.leftleg.setRotationPoint(-3.5F, 15.0F, 0.0F);
        this.leftleg.setTextureOffset(0, 30).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, -0.5F, 0.0F, -0.5F);
        this.navalgem = new ModelRenderer(this, 0, 0);
        this.navalgem.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.navalgem.setTextureOffset(12, 26).addBox(-2.0F, 14.0F, -4.0F, 4.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Hips = new ModelRenderer(this, 0, 0);
        this.Hips.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.Hips.setTextureOffset(24, 24).addBox(-6.0F, 13.0F, -4.0F, 12.0F, 6.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.chestgem = new ModelRenderer(this, 0, 0);
        this.chestgem.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.chestgem.setTextureOffset(0, 26).addBox(-2.0F, 3.0F, -5.5F, 4.0F, 2.0F, 2.0F, 0.0F, 0.0F, -0.1F);
        this.LongHair = new ModelRenderer(this, 0, 0);
        this.LongHair.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.LongHair.setTextureOffset(0, 100).addBox(-5.0F, -8.5F, -7.0F, 10.0F, 15.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.HairBun = new ModelRenderer(this, 0, 0);
        this.HairBun.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.HairBun.setTextureOffset(40, 69).addBox(-3.0F, -7.0F, 1.5F, 6.0F, 6.0F, 6.0F, -0.5F, -0.5F, -1.0F);
        this.rightarm = new ModelRenderer(this, 0, 0);
        this.rightarm.setRotationPoint(8.0F, -0.5F, 0.0F);
        this.rightarm.setTextureOffset(35, 81).addBox(0.5F, -3.0F, -3.0F, 6.0F, 20.0F, 6.0F, 0.5F, 0.5F, 0.5F);
        this.rightleg = new ModelRenderer(this, 0, 0);
        this.rightleg.setRotationPoint(3.5F, 15.0F, 0.0F);
        this.rightleg.setTextureOffset(0, 85).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, -0.5F, 0.0F, -0.5F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.ShortHair, this.Body, this.leftarm, this.Head, this.leftleg, this.navalgem, this.Hips, this.chestgem, this.LongHair, this.HairBun, this.rightarm, this.rightleg).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(this.Head, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.ShortHair, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.LongHair, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.HairBun, headPitch * 0.5f * ((float)Math.PI / 180F), netHeadYaw * .5f * ((float)Math.PI / 180F), 0);
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
