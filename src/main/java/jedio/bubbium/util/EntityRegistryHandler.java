package jedio.bubbium.util;

import jedio.bubbium.Bubbium;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityRegistryHandler {
    public static void init() {
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, Bubbium.MOD_ID);
}
