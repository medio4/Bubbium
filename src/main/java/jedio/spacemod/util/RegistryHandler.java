package jedio.spacemod.util;

import jedio.spacemod.SpaceMod;
import jedio.spacemod.blocks.BlockItemBase;
import jedio.spacemod.blocks.BubbiumBlock;
import jedio.spacemod.items.ItemBase;
import jedio.spacemod.items.TestingItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, SpaceMod.MODID);
    // Items
    public static final RegistryObject<Item> BUBBIUM_INGOT = ITEMS.register("bubbium_ingot", ItemBase::new);
    public static final RegistryObject<Item> ADVANCED_ITEM_TEST = ITEMS.register("test_item", ItemBase::new);

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, SpaceMod.MODID);
    // Blocks
    public static final RegistryObject<Block> BUBBIUM_BLOCK = BLOCKS.register("bubbium_block", BubbiumBlock::new);
    // Block Items
    public static final RegistryObject<Item> BUBBIUM_BLOCK_ITEM = ITEMS.register("bubbium_block", () -> new BlockItemBase(BUBBIUM_BLOCK.get()));

}
