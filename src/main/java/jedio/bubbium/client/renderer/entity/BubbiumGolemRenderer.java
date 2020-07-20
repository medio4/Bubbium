package jedio.bubbium.client.renderer.entity;

import jedio.bubbium.Bubbium;
import jedio.bubbium.client.model.entity.BubbiumGolemModel;
import jedio.bubbium.client.renderer.entity.layers.BubbiumGolemCracksLayer;
import jedio.bubbium.client.renderer.entity.layers.BubbiumGolemFlowerLayer;
import jedio.bubbium.entities.BubbiumGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.IronGolemCracksLayer;
import net.minecraft.client.renderer.entity.layers.IronGolenFlowerLayer;
import net.minecraft.client.renderer.entity.model.IronGolemModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BubbiumGolemRenderer extends MobRenderer<BubbiumGolemEntity, BubbiumGolemModel<BubbiumGolemEntity>> {
    private static final ResourceLocation BUBBIUM_GOLEM_TEXTURE = new ResourceLocation(Bubbium.MOD_ID, "textures/entity/bubbium_golem/bubbium_golem.png");

    public BubbiumGolemRenderer(final EntityRendererManager manager) {
        super(manager, new BubbiumGolemModel<BubbiumGolemEntity>(), 0.7F);
        this.addLayer(new BubbiumGolemCracksLayer(this));
        this.addLayer(new BubbiumGolemFlowerLayer(this));
    }

    @Override
    public ResourceLocation getEntityTexture(BubbiumGolemEntity entity) {
        return BUBBIUM_GOLEM_TEXTURE;
    }
}
