package jedio.bubbium;

import jedio.bubbium.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

//todo
// -
//fixme
// -


@Mod(Bubbium.MOD_ID)
public class oldBubbium {

    public static final String MOD_ID = "bubbium";
    public static final ItemGroup TAB = new ItemGroup("bubbiumTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.BUBBIUM_INGOT.get());
        }
    };

    /*@SubscribeEvent
    public static void onRegisterDimensionsEvent(RegisterDimensionsEvent event) {

    }*/

    public oldBubbium() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientActions);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void clientActions(final FMLClientSetupEvent event) {

    }
}
