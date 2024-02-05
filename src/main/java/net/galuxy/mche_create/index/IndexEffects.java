package net.galuxy.mche_create.index;

import net.galuxy.mche_create.MCHE_Create;
import net.galuxy.mche_create.mobeffect.RadiationEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IndexEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MCHE_Create.MOD_ID);

    public static final RegistryObject<MobEffect> RADIATION = MOB_EFFECTS.register("radiation",
            () -> new RadiationEffect(MobEffectCategory.HARMFUL, 10878720));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
