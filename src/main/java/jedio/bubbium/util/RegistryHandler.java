package jedio.bubbium.util;

import jedio.bubbium.Bubbium;
import jedio.bubbium.blocks.BlockItemBase;
import jedio.bubbium.blocks.BubbiumBlock;
import jedio.bubbium.blocks.BubbiumOre;
import jedio.bubbium.items.Hammer;
import jedio.bubbium.items.ItemBase;
import jedio.bubbium.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Bubbium.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Bubbium.MOD_ID);
    // Items
    public static final RegistryObject<Item> BUBBIUM_INGOT = ITEMS.register("bubbium_ingot", ItemBase::new);
    public static final RegistryObject<Item> BUBBIUM_DUST = ITEMS.register("bubbium_dust", ItemBase::new);
    public static final RegistryObject<Item> BUBBIUM_NUGGET = ITEMS.register("bubbium_nugget", ItemBase::new);
    public static final RegistryObject<Item> BUBBIUM_PLATE = ITEMS.register("bubbium_plate", ItemBase::new);
    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer", Hammer::new);
    public static final RegistryObject<Item> ADVANCED_ITEM_TEST = ITEMS.register("test_item", ItemBase::new);
    // Tools
    public static final RegistryObject<SwordItem> BUBBIUM_SWORD = ITEMS.register("bubbium_sword", () ->
            new SwordItem(ModItemTier.BUBBIUM, 1, -2.0f, new Item.Properties().group(Bubbium.TAB)));
    public static final RegistryObject<PickaxeItem> BUBBIUM_PICKAXE = ITEMS.register("bubbium_pickaxe", () ->
            new PickaxeItem(ModItemTier.BUBBIUM, -1, -2.4f, new Item.Properties().group(Bubbium.TAB)));
    public static final RegistryObject<AxeItem> BUBBIUM_AXE = ITEMS.register("bubbium_axe", () ->
            new AxeItem(ModItemTier.BUBBIUM, 3, -2.9f, new Item.Properties().group(Bubbium.TAB)));
    public static final RegistryObject<ShovelItem> BUBBIUM_SHOVEL = ITEMS.register("bubbium_shovel", () ->
            new ShovelItem(ModItemTier.BUBBIUM, 0, -2.0f, new Item.Properties().group(Bubbium.TAB)));
    public static final RegistryObject<HoeItem> BUBBIUM_HOE = ITEMS.register("bubbium_hoe", () ->
            new HoeItem(ModItemTier.BUBBIUM, 0, 0.0f, new Item.Properties().group(Bubbium.TAB)));
    public static final RegistryObject<ShearsItem> BUBBIUM_SHEARS = ITEMS.register("bubbium_shears", () ->
            new ShearsItem(new Item.Properties().group(Bubbium.TAB)));
    // Blocks
    public static final RegistryObject<Block> BUBBIUM_BLOCK = BLOCKS.register("bubbium_block", BubbiumBlock::new);
    public static final RegistryObject<Block> BUBBIUM_BLOCK_ALT = BLOCKS.register("bubbium_block_alt", BubbiumBlock::new);
    public static final RegistryObject<Block> BUBBIUM_ORE = BLOCKS.register("bubbium_ore", BubbiumOre::new);
    // Block Items
    public static final RegistryObject<Item> BUBBIUM_BLOCK_ITEM = ITEMS.register("bubbium_block", () -> new BlockItemBase(BUBBIUM_BLOCK.get()));
    public static final RegistryObject<Item> BUBBIUM_BLOCK_ALT_ITEM = ITEMS.register("bubbium_block_alt", () -> new BlockItemBase(BUBBIUM_BLOCK_ALT.get()));
    public static final RegistryObject<Item> BUBBIUM_ORE_ITEM = ITEMS.register("bubbium_ore", () -> new BlockItemBase(BUBBIUM_ORE.get()));


}
