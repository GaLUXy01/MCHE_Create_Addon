package net.galuxy.mche_create.infrastructure.worldgen;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import net.galuxy.mche_create.MCHE_Create;
import net.galuxy.mche_create.index.IndexBlocks;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static net.minecraft.data.worldgen.features.OreFeatures.NATURAL_STONE;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, MCHE_Create.MOD_ID);
    /**
     *  BAUXITE
     */
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_BAUXITE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(NATURAL_STONE, IndexBlocks.BAUXITE.get().defaultBlockState())
    ));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BAUXITE = CONFIGURED_FEATURES.register("bauxite",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_BAUXITE.get(), 36))); //dimensione del giacimento. molto rari se < 3

    /**
     *  SULFUR
     */
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SULFUR_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, IndexBlocks.SULFUR_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, IndexBlocks.DEEPSLATE_SULFUR_ORE.get().defaultBlockState())
    ));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SULFUR_ORE = CONFIGURED_FEATURES.register("sulfur_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_SULFUR_ORES.get(), 12))); //dimensione del giacimento. molto rari se < 3

    /**
     *  URANIUM
     */
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_URANIUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, IndexBlocks.URANIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, IndexBlocks.DEEPSLATE_URANIUM_ORE.get().defaultBlockState())
    ));
    public static final RegistryObject<ConfiguredFeature<?, ?>> URANIUM_ORE = CONFIGURED_FEATURES.register("uranium_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_URANIUM_ORES.get(), 7))); //dimensione del giacimento. molto rari se < 3


    public static void register(IEventBus eventBus){
        CONFIGURED_FEATURES.register(eventBus);
    }
}
