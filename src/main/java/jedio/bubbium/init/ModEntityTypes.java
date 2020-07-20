package jedio.bubbium.init;

import jedio.bubbium.Bubbium;
import jedio.bubbium.entities.BubbiumGolemEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static void init() {
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        EGGS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Bubbium.MOD_ID);
    public static final DeferredRegister<Item> EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, Bubbium.MOD_ID);

//  Entity Names
    public static final String BUBBIUM_GOLEM_NAME = "bubbium_golem";

//  Entities
    public static final RegistryObject<EntityType<BubbiumGolemEntity>> BUBBIUM_GOLEM = ENTITY_TYPES.register(BUBBIUM_GOLEM_NAME, () ->
        EntityType.Builder.<BubbiumGolemEntity>create(BubbiumGolemEntity::new, EntityClassification.MISC)
                .size(EntityType.IRON_GOLEM.getWidth(), EntityType.IRON_GOLEM.getHeight())
                .build(new ResourceLocation(Bubbium.MOD_ID, BUBBIUM_GOLEM_NAME).toString())
    );

    /*
[11:40:03] [Server thread/WARN] [minecraft/EntityType]: Exception loading entity:
java.lang.NullPointerException: null
	at net.minecraft.entity.ai.attributes.AttributeModifierManager.func_233795_c_(AttributeModifierManager.java:67) ~[forge-1.16.1-32.0.63_mapped_snapshot_20200514-1.16-recomp.jar:?] {re:classloading}
	at net.minecraft.entity.LivingEntity.func_233637_b_(LivingEntity.java:1848) ~[forge-1.16.1-32.0.63_mapped_snapshot_20200514-1.16-recomp.jar:?] {re:classloading}
	at net.minecraft.entity.LivingEntity.getMaxHealth(LivingEntity.java:1609) ~[forge-1.16.1-32.0.63_mapped_snapshot_20200514-1.16-recomp.jar:?] {re:classloading}
	at net.minecraft.entity.LivingEntity.<init>(LivingEntity.java:208) ~[forge-1.16.1-32.0.63_mapped_snapshot_20200514-1.16-recomp.jar:?] {re:classloading}
	at net.minecraft.entity.MobEntity.<init>(MobEntity.java:107) ~[forge-1.16.1-32.0.63_mapped_snapshot_20200514-1.16-recomp.jar:?] {re:classloading,pl:accesstransformer:B}
	at net.minecraft.entity.CreatureEntity.<init>(CreatureEntity.java:13) ~[forge-1.16.1-32.0.63_mapped_snapshot_20200514-1.16-recomp.jar:?] {re:classloading}
	at net.minecraft.entity.passive.GolemEntity.<init>(GolemEntity.java:12) ~[forge-1.16.1-32.0.63_mapped_snapshot_20200514-1.16-recomp.jar:?] {re:classloading}
	at net.minecraft.entity.passive.IronGolemEntity.<init>(IronGolemEntity.java:67) ~[forge-1.16.1-32.0.63_mapped_snapshot_20200514-1.16-recomp.jar:?] {re:classloading}
	at jedio.bubbium.entities.BubbiumGolemEntity.<init>(BubbiumGolemEntity.java:11) ~[main/:?] {re:classloading}
	at net.minecraft.entity.EntityType.create(EntityType.java:442) ~[forge-1.16.1-32.0.63_mapped_snapshot_20200514-1.16-recomp.jar:?] {re:classloading}
	at net.minecraft.entity.EntityType.lambda$loadEntityUnchecked$1(EntityType.java:453) ~[forge-1.16.1-32.0.63_mapped_snapshot_20200514-1.16-recomp.jar:?] {re:classloading}
	at java.util.Optional.map(Optional.java:258) ~[?:?] {}
	at net.minecraft.entity.EntityType.loadEntityUnchecked(EntityType.java:452) ~[forge-1.16.1-32.0.63_mapped_snapshot_20200514-1.16-recomp.jar:?] {re:classloading}
	at net.minecraft.entity.EntityType.loadEntity(EntityType.java:510) ~[forge-1.16.1-32.0.63_mapped_snapshot_20200514-1.16-recomp.jar:?] {re:classloading}
	at net.minecraft.entity.EntityType.func_220335_a(EntityType.java:492) ~[forge-1.16.1-32.0.63_mapped_snapshot_20200514-1.16-recomp.jar:?] {re:classloading}
	at net.minecraft.command.impl.SummonCommand.summonEntity(SummonCommand.java:49) ~[forge-1.16.1-32.0.63_mapped_snapshot_20200514-1.16-recomp.jar:?] {re:classloading}
	at net.minecraft.command.impl.SummonCommand.lambda$register$1(SummonCommand.java:33) ~[forge-1.16.1-32.0.63_mapped_snapshot_20200514-1.16-recomp.jar:?] {re:classloading}
	at com.mojang.brigadier.CommandDispatcher.execute(CommandDispatcher.java:262) ~[brigadier-1.0.17.jar:?] {}
	at com.mojang.brigadier.CommandDispatcher.execute(CommandDispatcher.java:176) ~[brigadier-1.0.17.jar:?] {}
	at net.minecraft.command.Commands.handleCommand(Commands.java:218) ~[?:?] {re:classloading}
	at net.minecraft.network.play.ServerPlayNetHandler.handleSlashCommand(ServerPlayNetHandler.java:1085) ~[?:?] {re:classloading}
	at net.minecraft.network.play.ServerPlayNetHandler.processChatMessage(ServerPlayNetHandler.java:1065) ~[?:?] {re:classloading}
	at net.minecraft.network.play.client.CChatMessagePacket.processPacket(CChatMessagePacket.java:40) ~[?:?] {re:classloading}
	at net.minecraft.network.play.client.CChatMessagePacket.processPacket(CChatMessagePacket.java:8) ~[?:?] {re:classloading}
	at net.minecraft.network.PacketThreadUtil.lambda$checkThreadAndEnqueue$0(PacketThreadUtil.java:19) ~[?:?] {re:classloading}
	at net.minecraft.util.concurrent.TickDelayedTask.run(TickDelayedTask.java:20) ~[?:?] {re:classloading}
	at net.minecraft.util.concurrent.ThreadTaskExecutor.run(ThreadTaskExecutor.java:139) ~[?:?] {re:classloading,pl:accesstransformer:B}
	at net.minecraft.util.concurrent.RecursiveEventLoop.run(RecursiveEventLoop.java:22) ~[?:?] {re:classloading}
	at net.minecraft.server.MinecraftServer.run(MinecraftServer.java:763) ~[?:?] {re:classloading,pl:accesstransformer:B}
	at net.minecraft.server.MinecraftServer.run(MinecraftServer.java:157) ~[?:?] {re:classloading,pl:accesstransformer:B}
	at net.minecraft.util.concurrent.ThreadTaskExecutor.driveOne(ThreadTaskExecutor.java:109) ~[?:?] {re:classloading,pl:accesstransformer:B}
	at net.minecraft.server.MinecraftServer.driveOneInternal(MinecraftServer.java:746) ~[?:?] {re:classloading,pl:accesstransformer:B}
	at net.minecraft.server.MinecraftServer.driveOne(MinecraftServer.java:740) ~[?:?] {re:classloading,pl:accesstransformer:B}
	at net.minecraft.util.concurrent.ThreadTaskExecutor.drainTasks(ThreadTaskExecutor.java:97) ~[?:?] {re:classloading,pl:accesstransformer:B}
	at net.minecraft.server.MinecraftServer.runScheduledTasks(MinecraftServer.java:725) ~[?:?] {re:classloading,pl:accesstransformer:B}
	at net.minecraft.server.MinecraftServer.func_240802_v_(MinecraftServer.java:669) ~[?:?] {re:classloading,pl:accesstransformer:B}
	at net.minecraft.server.MinecraftServer.lambda$func_240784_a_$0(MinecraftServer.java:231) ~[?:?] {re:classloading,pl:accesstransformer:B}
	at java.lang.Thread.run(Thread.java:832) [?:?] {}
[11:40:03] [Render thread/INFO] [minecraft/NewChatGui]: [CHAT] Unable to summon entity
     */


/*  Spawn Egg Items
    public static final RegistryObject<SpawnEggItem> BUBBIUM_GOLEM_EGG = EGGS.register(BUBBIUM_GOLEM_NAME + "_spawn_egg", () ->
        new SpawnEggItem(BUBBIUM_GOLEM, 0xF0A5A2, 0xA9672B, new Item.Properties().group(Bubbium.TAB)));
*/
}
