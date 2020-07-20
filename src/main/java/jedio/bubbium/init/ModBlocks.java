package jedio.bubbium.init;

import jedio.bubbium.Bubbium;
import jedio.bubbium.blocks.BlockItemBase;
import jedio.bubbium.blocks.BubbiumBlock;
import jedio.bubbium.blocks.BubbiumOre;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCK_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Bubbium.MOD_ID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Bubbium.MOD_ID);

//  Blocks
    public static final RegistryObject<Block> BUBBIUM_BLOCK = BLOCKS.register("bubbium_block", BubbiumBlock::new);
    public static final RegistryObject<Block> BUBBIUM_BLOCK_ALT = BLOCKS.register("bubbium_block_alt", BubbiumBlock::new);
    public static final RegistryObject<Block> BUBBIUM_ORE = BLOCKS.register("bubbium_ore", BubbiumOre::new);

//  Block Items
    public static final RegistryObject<Item> BUBBIUM_BLOCK_ITEM = BLOCK_ITEMS.register("bubbium_block", () -> new BlockItemBase(BUBBIUM_BLOCK.get()));
    public static final RegistryObject<Item> BUBBIUM_BLOCK_ALT_ITEM = BLOCK_ITEMS.register("bubbium_block_alt", () -> new BlockItemBase(BUBBIUM_BLOCK_ALT.get()));
    public static final RegistryObject<Item> BUBBIUM_ORE_ITEM = BLOCK_ITEMS.register("bubbium_ore", () -> new BlockItemBase(BUBBIUM_ORE.get()));

}
