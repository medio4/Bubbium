package jedio.bubbium;

import jedio.bubbium.blocks.CarvedPumpkinOverride;
import jedio.bubbium.client.renderer.entity.BubbiumGolemRenderer;
import jedio.bubbium.init.ModBlocks;
import jedio.bubbium.init.ModEntityTypes;
import jedio.bubbium.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// TODO:
//      update forge
//      jei integration
//      add block drops for hammers
//      add golem ai
//      give golems cool job
//      begin work on The Space Mod


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Bubbium.MOD_ID)
public class Bubbium {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "bubbium";

    public static final ItemGroup TAB = new ItemGroup("bubbiumTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.BUBBIUM_INGOT.get());
        }
    };

    public Bubbium() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onPlacePumpkin);

        ModItems.init();
        ModBlocks.init();
        ModEntityTypes.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Checks if a Carved Pumpkin was placed and, if so, attempts to spawn a golem
     * at that location where enabled by the config.
     **/
    @SubscribeEvent
    public void onPlacePumpkin(final BlockEvent.EntityPlaceEvent event) {
        // if the config allows it, and the block is a CARVED pumpkin...
        if (!event.isCanceled() && event.getPlacedBlock().getBlock() == Blocks.CARVED_PUMPKIN
                && event.getWorld() instanceof World) {
            // try to spawn a golem!
            CarvedPumpkinOverride.trySpawnGolem((World) event.getWorld(), event.getPos());
        }
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BUBBIUM_GOLEM.get(), BubbiumGolemRenderer::new);
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        GlobalEntityTypeAttributes.put(ModEntityTypes.BUBBIUM_GOLEM.get(), MobEntity.func_233666_p_().func_233813_a_());

        InterModComms.sendTo("bubbium", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    public static ResourceLocation location(String name)
    {
        return new ResourceLocation(MOD_ID, name);
    }
}
