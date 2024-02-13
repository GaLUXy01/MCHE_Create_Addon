package net.galuxy.mche_create.fluids;

import net.galuxy.mche_create.MCHE_Create;
import net.galuxy.mche_create.index.IndexCreativeModeTabs;
import net.galuxy.mche_create.index.IndexFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MCHE_Create.MOD_ID);

    public static final RegistryObject<Item> SULFURIC_ACID_BUCKET = ITEMS.register("sulfuric_acid_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SULFURIC_ACID,
                    new Item.Properties().tab(IndexCreativeModeTabs.MCHE_CREATE_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
