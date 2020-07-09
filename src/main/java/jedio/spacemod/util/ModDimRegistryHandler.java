package jedio.spacemod.util;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ObjectHolder;

public class ModDimRegistryHandler {
    @ObjectHolder("spacemod:space")
    public static final ModDimension SPACE_DIM = null;

 @SubscribeEvent
    public static void onDimRegistryEvent(RegistryEvent.Register<ModDimension> event)
    { event.getRegistry().register(new SpaceModDim().setRegistryName("spacemod:space")); }
}
