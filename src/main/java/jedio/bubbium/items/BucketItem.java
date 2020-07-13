package jedio.bubbium.items;

import jedio.bubbium.util.AbstractBucketItem;
import jedio.bubbium.util.RegistryHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack;

import javax.annotation.Nonnull;

public class BucketItem extends AbstractBucketItem {

    protected final ItemStack filledContainer = new ItemStack(RegistryHandler.FILLED_CERAMIC_BUCKET);
    protected final ItemStack filledMilkContainer = new ItemStack(RegistryHandler.CERAMIC_MILK_BUCKET);
    /**
     * @param container The container itemStack, data is stored on it directly as NBT.
     * @param capacity  The maximum capacity of this fluid tank.
     */
    public BucketItem(@Nonnull ItemStack container, int capacity) {
        super(container, capacity);
    }
}
