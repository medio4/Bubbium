package jedio.bubbium.client.renderer.entity.layers;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.matrix.MatrixStack;
import jedio.bubbium.client.model.entity.BubbiumGolemModel;
import jedio.bubbium.entities.BubbiumGolemEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class BubbiumGolemCracksLayer extends LayerRenderer<BubbiumGolemEntity, BubbiumGolemModel<BubbiumGolemEntity>> {
    private static final Map<BubbiumGolemEntity.Cracks, ResourceLocation> field_229134_a_ = ImmutableMap.of(BubbiumGolemEntity.Cracks.LOW, new ResourceLocation("textures/entity/iron_golem/iron_golem_crackiness_low.png"), BubbiumGolemEntity.Cracks.MEDIUM, new ResourceLocation("textures/entity/iron_golem/iron_golem_crackiness_medium.png"), BubbiumGolemEntity.Cracks.HIGH, new ResourceLocation("textures/entity/iron_golem/iron_golem_crackiness_high.png"));

    public BubbiumGolemCracksLayer(IEntityRenderer<BubbiumGolemEntity, BubbiumGolemModel<BubbiumGolemEntity>> p_i226040_1_) {
        super(p_i226040_1_);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, BubbiumGolemEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entitylivingbaseIn.isInvisible()) {
            BubbiumGolemEntity.Cracks bubbiumgolementity$cracks = entitylivingbaseIn.func_226512_l_();
            if (bubbiumgolementity$cracks != BubbiumGolemEntity.Cracks.NONE) {
                ResourceLocation resourcelocation = field_229134_a_.get(bubbiumgolementity$cracks);
                renderCutoutModel(this.getEntityModel(), resourcelocation, matrixStackIn, bufferIn, packedLightIn, entitylivingbaseIn, 1.0F, 1.0F, 1.0F);
            }
        }
    }
}