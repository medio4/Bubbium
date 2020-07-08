package jedio.spacemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BubbiumBlock extends Block {
    public BubbiumBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.METAL)
                .harvestLevel(2) // 2 = iron level
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
