package jedio.spacemod.util;

import jedio.spacemod.SpaceMod;
import jedio.spacemod.blocks.BlockItemBase;
import jedio.spacemod.blocks.BubbiumBlock;
import jedio.spacemod.blocks.BubbiumOre;
import jedio.spacemod.items.ItemBase;
import jedio.spacemod.items.TestingItem;
import jedio.spacemod.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.item.*;
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

    // Tools
    public static final RegistryObject<SwordItem> BUBBIUM_SWORD = ITEMS.register("bubbium_sword", () ->
            new SwordItem(ModItemTier.BUBBIUM, 1, -2.0f, new Item.Properties().group(SpaceMod.TAB)));
    public static final RegistryObject<PickaxeItem> BUBBIUM_PICKAXE = ITEMS.register("bubbium_pickaxe", () ->
            new PickaxeItem(ModItemTier.BUBBIUM, -1, -2.4f, new Item.Properties().group(SpaceMod.TAB)));
    public static final RegistryObject<PickaxeItem> BUBBIUM_AXE = ITEMS.register("bubbium_axe", () ->
            new PickaxeItem(ModItemTier.BUBBIUM, 3, -2.9f, new Item.Properties().group(SpaceMod.TAB)));
    public static final RegistryObject<PickaxeItem> BUBBIUM_SHOVEL = ITEMS.register("bubbium_shovel", () ->
            new PickaxeItem(ModItemTier.BUBBIUM, 0, -2.0f, new Item.Properties().group(SpaceMod.TAB)));
    public static final RegistryObject<PickaxeItem> BUBBIUM_HOE = ITEMS.register("bubbium_hoe", () ->
            new PickaxeItem(ModItemTier.BUBBIUM, -5, -0.0f, new Item.Properties().group(SpaceMod.TAB)));

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, SpaceMod.MODID);
    // Blocks
    public static final RegistryObject<Block> BUBBIUM_BLOCK = BLOCKS.register("bubbium_block", BubbiumBlock::new);
    public static final RegistryObject<Block> BUBBIUM_BLOCK_ALT = BLOCKS.register("bubbium_block_alt", BubbiumBlock::new);
    public static final RegistryObject<Block> BUBBIUM_ORE = BLOCKS.register("bubbium_ore", BubbiumOre::new);
    // Block Items
    public static final RegistryObject<Item> BUBBIUM_BLOCK_ITEM = ITEMS.register("bubbium_block", () -> new BlockItemBase(BUBBIUM_BLOCK.get()));
    public static final RegistryObject<Item> BUBBIUM_BLOCK_ALT_ITEM = ITEMS.register("bubbium_block_alt", () -> new BlockItemBase(BUBBIUM_BLOCK_ALT.get()));
    public static final RegistryObject<Item> BUBBIUM_ORE_ITEM = ITEMS.register("bubbium_ore", () -> new BlockItemBase(BUBBIUM_ORE.get()));

}
