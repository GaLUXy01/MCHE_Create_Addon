package net.galuxy.mche_create.compat.create;

import com.simibubi.create.AllCreativeModeTabs;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.galuxy.mche_create.item.radioactive.RadioactiveItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SnowballItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.galuxy.mche_create.MCHE_Create.REGISTRATE;

public class CreateItems {
    private static final DeferredRegister<Item> CREATE_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "create");

    // Override property

//    public static final RegistryObject<Item> CRUSHED_URANIUM = CREATE_ITEMS.register("crushed_raw_uranium",
//            () -> new SnowballItem( new Item.Properties().tab(AllCreativeModeTabs.BASE_CREATIVE_TAB))); // test

    public static final RegistryObject<RadioactiveItem> CRUSHED_URANIUM = CREATE_ITEMS.register("crushed_raw_uranium",
            () -> new RadioactiveItem( new Item.Properties().tab(AllCreativeModeTabs.BASE_CREATIVE_TAB), 1.5F, 1F, 0));


    public static void register(IEventBus eventBus) {
        CREATE_ITEMS.register(eventBus);
    }
}
