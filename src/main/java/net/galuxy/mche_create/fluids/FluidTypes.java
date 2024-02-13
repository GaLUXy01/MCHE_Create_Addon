package net.galuxy.mche_create.fluids;

import com.mojang.math.Vector3f;

import net.galuxy.mche_create.MCHE_Create;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation SULFURIC_ACID_OVERLAY_RL = new ResourceLocation(MCHE_Create.MOD_ID, "misc/in_sulfuric_acid");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MCHE_Create.MOD_ID);

    public static final RegistryObject<FluidType> SULFURIC_ACID_FLUID_TYPE = register("sulfuric_acid_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK));



    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, SULFURIC_ACID_OVERLAY_RL,
                0xC0EBED25, //0xA1EBED25, // colore del layer aggiuntivo per la texture del blocco
                new Vector3f(235f / 255f, 237f / 255f, 37f / 255f), // colore della nebbia quando immerso nel fluido
                properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
