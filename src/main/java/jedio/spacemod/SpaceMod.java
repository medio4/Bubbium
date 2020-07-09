package jedio.spacemod;

import jedio.spacemod.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

        //todo
        // -
        //fixme
        // -


@Mod.EventBusSubscriber(modid="spacemod", bus=Mod.EventBusSubscriber.Bus.FORGE)
public class SpaceMod {

    public static final ResourceLocation DIMENSION_TYPE_RL = new ResourceLocation("spacemod", "space");

    public SpaceMod() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientActions);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);

    }

    @SubscribeEvent
    public static void onRegisterDimensionsEvent(RegisterDimensionsEvent event) {

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
