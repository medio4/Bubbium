package jedio.spacemod;

import jedio.spacemod.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

        //todo
        // add these tools:
        // - pickaxe
        // - axe
        // - shovel
        // - hoe

        //fixme
        //


@Mod("spacemod")
public class SpaceMod {

    public static final String MODID = "spacemod";

    public SpaceMod() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientActions);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void clientActions(final FMLClientSetupEvent event) {

    }

    public static final ItemGroup TAB = new ItemGroup("spacemodTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.BUBBIUM_INGOT.get());
        }
    };

}
