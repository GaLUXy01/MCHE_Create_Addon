package net.galuxy.mche_create.compat.create;

import com.simibubi.create.AllCreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SnowballItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreateItems {
    private static final DeferredRegister<Item> CREATE_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "create");

    // Override property

    public static final RegistryObject<Item> CRUSHED_URANIUM = CREATE_ITEMS.register("crushed_raw_uranium",
            () -> new SnowballItem( new Item.Properties().tab(AllCreativeModeTabs.BASE_CREATIVE_TAB)));

    public static void register(IEventBus eventBus) {
        CREATE_ITEMS.register(eventBus);
    }
}
