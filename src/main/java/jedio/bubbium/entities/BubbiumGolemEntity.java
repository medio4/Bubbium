package jedio.bubbium.entities;

import jedio.bubbium.Bubbium;
import jedio.bubbium.entities.ai.MoveThroughVillageGoalFixed;
import jedio.bubbium.init.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("EntityConstructor")
public class BubbiumGolemEntity extends IronGolemEntity {

    protected static final DataParameter<Boolean> CHILD = EntityDataManager.createKey(jedio.bubbium.entities.BubbiumGolemEntity.class, DataSerializers.BOOLEAN);

    public BubbiumGolemEntity(EntityType<? extends BubbiumGolemEntity> type, final World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute func_234200_m_() {
        IronGolemEntity.func_234200_m_();
        return MobEntity
                 .func_233666_p_(
                ).func_233815_a_(
                        Attributes.field_233818_a_, //max health
                        1.0D
                ).func_233815_a_(
                        Attributes.field_233821_d_, //movement speed
                        0.5D
                ).func_233815_a_(
                        Attributes.field_233820_c_, //knockback resistance
                        1.5D
                ).func_233815_a_(
                        Attributes.field_233823_f_, //attack damage
                        20.0D
                );
    }

    protected void registerData() {
        super.registerData();
        this.getDataManager().register(CHILD, Boolean.FALSE);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        // find and list erroring goals that will be removed
        final List<Goal> erroringGoals = new ArrayList<>();
        this.goalSelector.getRunningGoals().forEach(g -> {
            if(g.getGoal().getClass() == MoveThroughVillageGoal.class) {
                erroringGoals.add(g.getGoal());
            }
        });
        // remove the erroring goals
        erroringGoals.forEach(g -> {
            this.goalSelector.removeGoal(g);
            Bubbium.LOGGER.debug("Removed erroring goal inherited from IronGolemEntity");
        });
        // add in custom implementation of erroring goal
        this.goalSelector.addGoal(3, new MoveThroughVillageGoalFixed(this, 0.6D, false, 4, () -> {
            return false;
        }));
    }

    /**
     * Decrements the entity's air supply when underwater
     */
    protected int decreaseAirSupply(int air) {
        return air;
    }

    protected void collideWithEntity(Entity entityIn) {
        if (entityIn instanceof IMob && !(entityIn instanceof CreeperEntity) && this.getRNG().nextInt(20) == 0) {
            this.setAttackTarget((LivingEntity)entityIn);
        }

        super.collideWithEntity(entityIn);
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_IRON_GOLEM_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_IRON_GOLEM_DEATH;
    }

    protected ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
        Item item = itemstack.getItem();
        if (item != ModItems.BUBBIUM_INGOT.get()) {
            return ActionResultType.PASS;
        } else {
            float f = this.getHealth();
            this.heal(25.0F);
            if (this.getHealth() == f) {
                return ActionResultType.PASS;
            } else {
                float f1 = 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F;
                this.playSound(SoundEvents.field_226143_fP_, 1.0F, f1);
                if (!p_230254_1_.abilities.isCreativeMode) {
                    itemstack.shrink(1);
                }

                return ActionResultType.func_233537_a_(this.world.isRemote);
            }
        }
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_IRON_GOLEM_STEP, 1.0F, 1.0F);
    }

    @Override
    public void onStruckByLightning(LightningBoltEntity boltEntity) {
        this.setGlowing(true);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
