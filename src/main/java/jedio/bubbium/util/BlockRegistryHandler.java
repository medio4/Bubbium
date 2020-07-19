package jedio.bubbium.util;

import jedio.bubbium.Bubbium;
import jedio.bubbium.blocks.BubbiumBlock;
import jedio.bubbium.blocks.BubbiumOre;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistryHandler {
    public static void init() { BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus()); }
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Bubbium.MOD_ID);

    //  Blocks
    public static final RegistryObject<Block> BUBBIUM_BLOCK = BLOCKS.register("bubbium_block", BubbiumBlock::new);
    public static final RegistryObject<Block> BUBBIUM_BLOCK_ALT = BLOCKS.register("bubbium_block_alt", BubbiumBlock::new);
    public static final RegistryObject<Block> BUBBIUM_ORE = BLOCKS.register("bubbium_ore", BubbiumOre::new);

}
