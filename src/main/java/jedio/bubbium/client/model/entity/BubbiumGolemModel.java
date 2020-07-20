package jedio.bubbium.client.model.entity;

import com.google.common.collect.ImmutableList;
import jedio.bubbium.entities.BubbiumGolemEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class BubbiumGolemModel<T extends BubbiumGolemEntity> extends SegmentedModel<T> {
    private final ModelRenderer BUBBIUM_GOLEM_Head;
    private final ModelRenderer BUBBIUM_GOLEM_Body;
    private final ModelRenderer BUBBIUM_GOLEM_RightArm;
    private final ModelRenderer BUBBIUM_GOLEM_LeftArm;
    private final ModelRenderer BUBBIUM_GOLEM_LeftLeg;
    private final ModelRenderer BUBBIUM_GOLEM_RightLeg;

    public BubbiumGolemModel() {
        int i = 128;
        int j = 128;
        this.BUBBIUM_GOLEM_Head = (new ModelRenderer(this)).setTextureSize(128, 128);
        this.BUBBIUM_GOLEM_Head.setRotationPoint(0.0F, -7.0F, -2.0F);
        this.BUBBIUM_GOLEM_Head.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, -5.5F, 8.0F, 10.0F, 8.0F, 0.0F);
        this.BUBBIUM_GOLEM_Head.setTextureOffset(24, 0).addBox(-1.0F, -5.0F, -7.5F, 2.0F, 4.0F, 2.0F, 0.0F);
        this.BUBBIUM_GOLEM_Body = (new ModelRenderer(this)).setTextureSize(128, 128);
        this.BUBBIUM_GOLEM_Body.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.BUBBIUM_GOLEM_Body.setTextureOffset(0, 40).addBox(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F, 0.0F);
        this.BUBBIUM_GOLEM_Body.setTextureOffset(0, 70).addBox(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, 0.5F);
        this.BUBBIUM_GOLEM_RightArm = (new ModelRenderer(this)).setTextureSize(128, 128);
        this.BUBBIUM_GOLEM_RightArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.BUBBIUM_GOLEM_RightArm.setTextureOffset(60, 21).addBox(-13.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F);
        this.BUBBIUM_GOLEM_LeftArm = (new ModelRenderer(this)).setTextureSize(128, 128);
        this.BUBBIUM_GOLEM_LeftArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.BUBBIUM_GOLEM_LeftArm.setTextureOffset(60, 58).addBox(9.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F);
        this.BUBBIUM_GOLEM_LeftLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(128, 128);
        this.BUBBIUM_GOLEM_LeftLeg.setRotationPoint(-4.0F, 11.0F, 0.0F);
        this.BUBBIUM_GOLEM_LeftLeg.setTextureOffset(37, 0).addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F);
        this.BUBBIUM_GOLEM_RightLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(128, 128);
        this.BUBBIUM_GOLEM_RightLeg.mirror = true;
        this.BUBBIUM_GOLEM_RightLeg.setTextureOffset(60, 0).setRotationPoint(5.0F, 11.0F, 0.0F);
        this.BUBBIUM_GOLEM_RightLeg.addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F);
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(
                        this.BUBBIUM_GOLEM_Head,
                        this.BUBBIUM_GOLEM_Body,
                        this.BUBBIUM_GOLEM_LeftLeg,
                        this.BUBBIUM_GOLEM_RightLeg,
                        this.BUBBIUM_GOLEM_RightArm,
                        this.BUBBIUM_GOLEM_LeftArm
        );
    }

    /**
     * Sets this entity's model rotation angles
     *
     * @param entityIn
     * @param limbSwing
     * @param limbSwingAmount
     * @param ageInTicks
     * @param netHeadYaw
     * @param headPitch
     */
    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.BUBBIUM_GOLEM_Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.BUBBIUM_GOLEM_Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.BUBBIUM_GOLEM_LeftLeg.rotateAngleX = -1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F) * limbSwingAmount;
        this.BUBBIUM_GOLEM_RightLeg.rotateAngleX = 1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F) * limbSwingAmount;
        this.BUBBIUM_GOLEM_LeftLeg.rotateAngleY = 0.0F;
        this.BUBBIUM_GOLEM_RightLeg.rotateAngleY = 0.0F;
    }

    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        int i = entityIn.getAttackTimer();
        if (i > 0) {
            this.BUBBIUM_GOLEM_RightArm.rotateAngleX = -2.0F + 1.5F * MathHelper.func_233021_e_((float)i - partialTick, 10.0F);
            this.BUBBIUM_GOLEM_LeftArm.rotateAngleX = -2.0F + 1.5F * MathHelper.func_233021_e_((float)i - partialTick, 10.0F);
        } else {
            int j = entityIn.getHoldRoseTick();
            if (j > 0) {
                this.BUBBIUM_GOLEM_RightArm.rotateAngleX = -0.8F + 0.025F * MathHelper.func_233021_e_((float)j, 70.0F);
                this.BUBBIUM_GOLEM_LeftArm.rotateAngleX = 0.0F;
            } else {
                this.BUBBIUM_GOLEM_RightArm.rotateAngleX = (-0.2F + 1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F)) * limbSwingAmount;
                this.BUBBIUM_GOLEM_LeftArm.rotateAngleX = (-0.2F - 1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F)) * limbSwingAmount;
            }
        }

    }

    public ModelRenderer getArmHoldingRose() {
        return this.BUBBIUM_GOLEM_RightArm;
    }
}