package net.galuxy.mche_create.compat.createaddition;

import com.mrh0.createaddition.CreateAddition;
import com.mrh0.createaddition.groups.ModGroup;
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

public class CAItems {
//    private static final DeferredRegister<Item> CA_ITEMS =
//            DeferredRegister.create(ForgeRegistries.ITEMS, "createaddition");

    static {
        CreateAddition.REGISTRATE.creativeModeTab(() -> ModGroup.MAIN);
    }

    public static final ItemEntry<Item> BIOMASS =
            CreateAddition.REGISTRATE.item("biomass", Item::new)
                    .properties(p -> p.stacksTo(64))
                    .register();

//    public static final RegistryObject<Item> BIOMASS = CA_ITEMS.register("biomass",
//            () -> new Item( new Item.Properties().stacksTo(64).tab(ModGroup.MAIN)));

//    public static final RegistryObject<Item> BIOMASS = CA_ITEMS.register("biomass",
//            () -> new SnowballItem( new Item.Properties().tab(ModGroup.MAIN)));

//    public static void register(IEventBus eventBus) {
//        CA_ITEMS.register(eventBus);
//    }

    public static void register() {
    }
}
