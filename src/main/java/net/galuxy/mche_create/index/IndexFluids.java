package net.galuxy.mche_create.index;

import com.tterrag.registrate.util.entry.FluidEntry;
import net.galuxy.mche_create.MCHE_Create;
import net.galuxy.mche_create.fluids.FluidTypes;
import net.galuxy.mche_create.fluids.ModFluidBlocks;
import net.galuxy.mche_create.fluids.ModFluidItems;
import net.galuxy.mche_create.fluids.acid.SulfuricAcidFluidBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Consumer;

import static net.galuxy.mche_create.MCHE_Create.REGISTRATE;

public class IndexFluids {
//    public static final DeferredRegister<Fluid> FLUIDS =
//            DeferredRegister.create(ForgeRegistries.FLUIDS, MCHE_Create.MOD_ID);
//
//    public static final RegistryObject<FlowingFluid> SOURCE_SULFURIC_ACID = FLUIDS.register("sulfuric_acid_fluid",
//            () -> new ForgeFlowingFluid.Source(IndexFluids.SULFURIC_ACID_FLUID_PROPERTIES));
//    public static final RegistryObject<FlowingFluid> FLOWING_SULFURIC_ACID = FLUIDS.register("flowing_sulfuric_acid",
//            () -> new ForgeFlowingFluid.Flowing(IndexFluids.SULFURIC_ACID_FLUID_PROPERTIES));
//
//
//    public static final ForgeFlowingFluid.Properties SULFURIC_ACID_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
//            FluidTypes.SULFURIC_ACID_FLUID_TYPE, SOURCE_SULFURIC_ACID, FLOWING_SULFURIC_ACID)
//            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModFluidBlocks.SULFURIC_ACID)
//            .bucket(ModFluidItems.SULFURIC_ACID_BUCKET);
//
//    public static void register(IEventBus eventBus) {
//        FLUIDS.register(eventBus);
//    }

//    public static final FluidEntry<ForgeFlowingFluid.Flowing> SULFURIC_ACID =
//            REGISTRATE.standardFluid("sulfuric_acid", new SulfuricAcidFluidBlock::new)
//                    .lang("Sulfuric Acid")
//                    .properties(b -> b.viscosity(1500)
//                            .density(1400))
//                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
//                            .tickRate(25)
//                            .slopeFindDistance(3)
//                            .explosionResistance(100f))
//                    .register();

//    public static final DeferredRegister<Block> FLUIDS =
//            DeferredRegister.create(ForgeRegistries.BLOCKS, MCHE_Create.MOD_ID);
//
//    public static final RegistryObject<LiquidBlock> SULFURIC_ACID = FLUIDS.register("sulfuric_acid",
//            () -> new SulfuricAcidFluidBlock(ACFluidRegistry.ACID_FLUID_SOURCE //,
//                    //BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN)
//                            .noCollission()
//                            .strength(100.0F)
//                            .lightLevel(state -> 7)
//                            .emissiveRendering((state, world, pos) -> false)
//                            .noLootTable()
//                            .replaceable()
//            ));


    public static final FluidEntry<ForgeFlowingFluid.Flowing> BASALTIC_LAVA =
            REGISTRATE.standardFluid("basaltic_lava", NoColorFluidAttributes::new)
                    .lang("Basaltic Lava")
                    .properties(b -> b.viscosity(6000)
                            .canSwim(false)
                            .canDrown(false)
                            .pathType(BlockPathTypes.LAVA)
                            .adjacentPathType(null)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                            .lightLevel(15)
                            .density(3000)
                            .temperature(1500)
                    )
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .register();


    public static void registerFluidInteractions() {
        FluidInteractionRegistry.addInteraction(ForgeMod.WATER_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                BASALTIC_LAVA.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return Blocks.COBBLED_DEEPSLATE.defaultBlockState();
                    }
                }
        ));
        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                BASALTIC_LAVA.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return Blocks.NETHERRACK.defaultBlockState();
                    }
                }
        ));
    }

//    @Nullable
//    public static BlockState getLavaInteraction(FluidState fluidState) {
//        Fluid fluid = fluidState.getType();
//        if (fluid.isSame(CHOCOLATE.get()))
//            return AllPaletteStoneTypes.SCORIA.getBaseBlock()
//                    .get()
//                    .defaultBlockState();
//        return null;
//    }

    /*------------------------------------------------------------------------------------*/

    // Load this class

    public static void register() {}

    public static abstract class TintedFluidType extends FluidType {

        protected static final int NO_TINT = 0xffffffff;
        private ResourceLocation stillTexture;
        private ResourceLocation flowingTexture;

        public TintedFluidType(Properties properties, ResourceLocation stillTexture, ResourceLocation flowingTexture) {
            super(properties);
            this.stillTexture = stillTexture;
            this.flowingTexture = flowingTexture;
        }

        @Override
        public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
            consumer.accept(new IClientFluidTypeExtensions() {

                @Override
                public ResourceLocation getStillTexture() {
                    return stillTexture;
                }

                @Override
                public ResourceLocation getFlowingTexture() {
                    return flowingTexture;
                }

                @Override
                public int getTintColor(FluidStack stack) {
                    return IndexFluids.TintedFluidType.this.getTintColor(stack);
                }

                @Override
                public int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos) {
                    return IndexFluids.TintedFluidType.this.getTintColor(state, getter, pos);
                }

            });
        }

        protected abstract int getTintColor(FluidStack stack);

        protected abstract int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos);

    }

    /**
     * Removing alpha from tint prevents optifine from forcibly applying biome
     * colors to modded fluids (Makes translucent fluids disappear)
     */
    private static class NoColorFluidAttributes extends IndexFluids.TintedFluidType {

        public NoColorFluidAttributes(Properties properties, ResourceLocation stillTexture,
                                      ResourceLocation flowingTexture) {
            super(properties, stillTexture, flowingTexture);
        }

        @Override
        protected int getTintColor(FluidStack stack) {
            return NO_TINT;
        }

        @Override
        public int getTintColor(FluidState state, BlockAndTintGetter world, BlockPos pos) {
            return 0x00ffffff;
        }

    }
}
