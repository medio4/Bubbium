package jedio.bubbium.world.gen;

import jedio.bubbium.Bubbium;
import jedio.bubbium.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Bubbium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGenHandler {
    @SubscribeEvent
    public static void GenerateModOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            GenOres(biome, 9, 7, 5, 20,
                    // count=rarity,bO=minimum y val, max-tO=max y val, size=orevein size
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    ModBlocks.BUBBIUM_ORE.get().getDefaultState(), 6);
        }
    }

    private static void GenOres(Biome biome, int count, int bottomOffset, int topOffset,
                                int max, OreFeatureConfig.FillerBlockType filler,
                                BlockState defaultBlockState, int size)
    {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockState, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.withConfiguration(feature).withPlacement(config));
    }
}
