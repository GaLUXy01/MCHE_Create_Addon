package net.galuxy.mche_create;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipHelper;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.galuxy.mche_create.compat.vanilla.VanillaItems;
import net.galuxy.mche_create.index.*;
import net.galuxy.mche_create.infrastructure.worldgen.ModConfiguredFeatures;
import net.galuxy.mche_create.infrastructure.worldgen.ModPlacedFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
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
//
//        IndexPartialModels.init();
        IndexBlocks.register();
        IndexTileEntities.register();
        IndexItems.register();
        IndexEffects.register(eventBus);
//        IndexRecipes.register(eventBus);
//
//        MaterialBlocks.register();
//
        VanillaItems.register(eventBus);
//
//        OreGeneration_ERROR.init();
        ModConfiguredFeatures.register(eventBus);
        ModPlacedFeatures.register(eventBus);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT,
                () -> () -> MCHE_Create_Client.onClientInit(eventBus));

    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

}
