package jedio.bubbium.tools;

/*                     _,-----.
         _,------.__,-'        `.  .            .
      .-'                        `//__          \\
     |                           ((___`-_____    ))
     |                            \_alf)     \`=:'
     |                               `=|      |=,'
    /                                  | O   (|
   /  /\                               |      |
  /  /  \    .                          \     |
 |  /   /|  / `--.   ___            __,,-.    |
 | /   //  /      `-'   \  ,_    /''     |  o o|
/ |   | |  |             \ \ `.  |        ``--'
mmm   | |  |              \ \ |  |
      | |\ |              |  ||  |
      | | ||              / / `. )
       \ \ \\            / /   | |
        |_| ||          / /    | |
            |_\         \_|    |  \
                                \__\                                                             */


import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;

import java.util.Set;

public class HammerItem extends ToolItem {
    private static final Set<Block> EFFECTIVE_ON =
            Sets.newHashSet(Blocks.GRAVEL, Blocks.SAND, Blocks.CLAY);

    public HammerItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Item.Properties builder) {
        super
                (
                        attackDamageIn,
                        attackSpeedIn,
                        tier,
                        EFFECTIVE_ON,
                        builder.addToolType
                                (
                                        HammerType.HAMMER,
                                        tier.getHarvestLevel()
                                )
                );
    }

    /**
     * Check whether this Item can harvest the given Block
     */
    public boolean canHarvestBlock(BlockState blockIn) {
        return blockIn.isIn(Blocks.CLAY)  || // or
               blockIn.isIn(Blocks.SAND)  || // or
               blockIn.isIn(Blocks.GRAVEL);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        //int[] loop = {1,2,3,4,5,6,7,8,9,10};
        //for(int i : loop) {
            //System.out.println(stack.hasContainerItem());
            //System.out.println(stack.getDamage());
        //}
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        int damage = itemStack.getDamage();
        if (itemStack.isDamageable()) {
            ItemStack newStack = new ItemStack(itemStack.getItem(), 1);
            newStack.setDamage(damage + 1);
            return newStack;
        } else {
            return itemStack;
        }
    }
}
