package net.galuxy.mche_create;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class MCHE_Create_Client {
    public static void onClientInit(IEventBus modEventBus) {
        modEventBus.addListener(MCHE_Create_Client::clientSetup);
    }

    public static void clientSetup(final FMLClientSetupEvent event) {

        // Set up copper fishing rod
        //IndexItemProperties.register();

        // Register ponders
        //ModPonders.register();
    }
}
