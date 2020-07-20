package jedio.bubbium.init;

import jedio.bubbium.Bubbium;
import jedio.bubbium.items.ItemBase;
import jedio.bubbium.tools.HammerItem;
import jedio.bubbium.tools.ModItemTier;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static void init() { ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus()); }
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Bubbium.MOD_ID);

//  Items
    public static final RegistryObject<Item> BUBBIUM_INGOT = ITEMS.register("bubbium_ingot", ItemBase::new);
    public static final RegistryObject<Item> BUBBIUM_DUST = ITEMS.register("bubbium_dust", ItemBase::new);
    public static final RegistryObject<Item> BUBBIUM_NUGGET = ITEMS.register("bubbium_nugget", ItemBase::new);
    public static final RegistryObject<Item> BUBBIUM_PLATE = ITEMS.register("bubbium_plate", ItemBase::new);
    public static final RegistryObject<Item> ADVANCED_ITEM_TEST = ITEMS.register("test_item", ItemBase::new);

//  Tools
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
    public static final RegistryObject<HammerItem> IRON_HAMMER = ITEMS.register("iron_hammer", () ->
            new HammerItem(ItemTier.IRON, 0, -3.0f, new Item.Properties().group(Bubbium.TAB)));
    public static final RegistryObject<HammerItem> DIAMOND_HAMMER = ITEMS.register("diamond_hammer", () ->
            new HammerItem(ItemTier.DIAMOND, 2, -3.0f, new Item.Properties().group(Bubbium.TAB)));


}
