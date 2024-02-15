package net.galuxy.mche_create.fluids;

import net.galuxy.mche_create.MCHE_Create;
import net.galuxy.mche_create.index.IndexFluids;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, MCHE_Create.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_SULFURIC_ACID = FLUIDS.register("sulfuric_acid",
            () -> new ForgeFlowingFluid.Source(ModFluids.SULFURIC_ACID_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SULFURIC_ACID = FLUIDS.register("flowing_sulfuric_acid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.SULFURIC_ACID_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties SULFURIC_ACID_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            FluidTypes.SULFURIC_ACID_FLUID_TYPE, SOURCE_SULFURIC_ACID, FLOWING_SULFURIC_ACID)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModFluidBlocks.SULFURIC_ACID)
            .bucket(ModFluidItems.SULFURIC_ACID_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
