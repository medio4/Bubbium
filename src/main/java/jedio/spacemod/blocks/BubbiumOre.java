package jedio.spacemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BubbiumOre extends Block {
    public BubbiumOre() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(3.0f, 3.0f)
                .sound(SoundType.STONE)
                .harvestLevel(2) // 2 = iron level
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
