package jedio.bubbium.util;

import jedio.bubbium.items.BucketItem;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class AbstractBucketItem extends BucketItem {
    /**
     * @param container The container itemStack, data is stored on it directly as NBT.
     * @param capacity  The maximum capacity of this fluid tank.
     */
    public AbstractBucketItem(@Nonnull ItemStack container, int capacity) {
        super(container, capacity);
    }
}
