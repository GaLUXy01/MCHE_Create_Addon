package net.galuxy.mche_create;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipHelper;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.galuxy.mche_create.compat.create.CreateItems;
import net.galuxy.mche_create.compat.createaddition.CAItems;
import net.galuxy.mche_create.compat.vanilla.VanillaItems;
import net.galuxy.mche_create.fluids.FluidTypes;
import net.galuxy.mche_create.fluids.ModFluidBlocks;
import net.galuxy.mche_create.fluids.ModFluidItems;
import net.galuxy.mche_create.fluids.ModFluids;
import net.galuxy.mche_create.index.*;
import net.galuxy.mche_create.infrastructure.worldgen.ModConfiguredFeatures;
import net.galuxy.mche_create.infrastructure.worldgen.ModPlacedFeatures;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MCHE_Create.MOD_ID)
public class MCHE_Create {
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String NAME = "MCHE: Create AddOn";
    public static final String MOD_ID = "mche_create";

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    static {
        REGISTRATE.setTooltipModifierFactory(item ->
                new ItemDescription.Modifier(item, TooltipHelper.Palette.STANDARD_CREATE)
                        .andThen(TooltipModifier.mapNull(KineticStats.create(item)))
        );
    }

    public MCHE_Create(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        //new ModGroup("main");
        REGISTRATE.registerEventListeners(eventBus);
        IndexCreativeModeTabs.init();

//        IndexPartialModels.init();
        IndexBlocks.register();
        IndexTileEntities.register();
        IndexItems.register();
        IndexFluids.register();

        FluidTypes.register(eventBus);
        ModFluidItems.register(eventBus);
        ModFluidBlocks.register(eventBus);
        ModFluids.register(eventBus);

        IndexEffects.register(eventBus);
//        IndexRecipes.register(eventBus);

//        MaterialBlocks.register();

        VanillaItems.register(eventBus);
        CreateItems.register(eventBus);
        //CAItems.register(eventBus);
        CAItems.register();

//        OreGeneration_ERROR.init();
        ModConfiguredFeatures.register(eventBus);
        ModPlacedFeatures.register(eventBus);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT,
                () -> () -> MCHE_Create_Client.onClientInit(eventBus));

        eventBus.addListener(MCHE_Create::init);
        //eventBus.addListener(IndexSoundEvents::register);
    }

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            //AllAdvancements.register();
            //BoilerHeaters.registerDefaults();
            IndexFluids.registerFluidInteractions();
        });
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SULFURIC_ACID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SULFURIC_ACID.get(), RenderType.translucent());
        }
    }
}
