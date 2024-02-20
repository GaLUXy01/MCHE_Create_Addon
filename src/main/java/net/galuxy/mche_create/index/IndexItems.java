package net.galuxy.mche_create.index;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.galuxy.mche_create.MCHE_Create;
import net.galuxy.mche_create.item.radioactive.RadioactiveBlockItem;
import net.galuxy.mche_create.item.radioactive.RadioactiveItem;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.simibubi.create.AllTags.AllItemTags.CREATE_INGOTS;
import static com.simibubi.create.AllTags.AllItemTags.CRUSHED_RAW_MATERIALS;
import static com.simibubi.create.AllTags.forgeItemTag;
import static net.galuxy.mche_create.MCHE_Create.REGISTRATE;

public class IndexItems {
//    public static final DeferredRegister<Item> ITEMS =
//            DeferredRegister.create(ForgeRegistries.ITEMS, MCHE_Create.MODID);
    static {
        REGISTRATE.creativeModeTab(() -> IndexCreativeModeTabs.MCHE_CREATE_TAB);
    }


    public static final ItemEntry<Item> SULFUR =
            taggedIngredient("sulfur", forgeItemTag("raw_materials/sulfur"), forgeItemTag("raw_materials"));

    public static final ItemEntry<Item> ALUMINUM_INGOT =
            taggedIngredient("aluminum_ingot", forgeItemTag("ingots/aluminum"), forgeItemTag("ingots"));

   // public static final ItemEntry<Item>
        //RAW_URANIUM = taggedIngredient("raw_uranium", forgeItemTag("raw_materials/uranium"), forgeItemTag("raw_materials")),
        // CRUSHED_URANIUM = taggedIngredient("crushed_raw_uranium", CRUSHED_RAW_MATERIALS.tag), //usare quello della Create
        //URANIUM_INGOT = taggedIngredient("uranium_ingot", forgeItemTag("ingots/uranium"), CREATE_INGOTS.tag);

    public static final ItemEntry<RadioactiveBlockItem> URANIUM_ORE = REGISTRATE
            .item("uranium_ore", properties -> new RadioactiveBlockItem(IndexBlocks.URANIUM_ORE.get(), properties,
                    1F, 1.5F, 0))
            .register();

    public static final ItemEntry<RadioactiveBlockItem> DEEPSLATE_URANIUM_ORE = REGISTRATE
            .item("deepslate_uranium_ore", properties -> new RadioactiveBlockItem(IndexBlocks.DEEPSLATE_URANIUM_ORE.get(), properties,
                    1F, 1.7F, 0))
            .register();

    public static final ItemEntry<RadioactiveBlockItem> RAW_URANIUM_BLOCK = REGISTRATE
            .item("raw_uranium_block", properties -> new RadioactiveBlockItem(IndexBlocks.RAW_URANIUM_BLOCK.get(), properties,
                    0.9F, 2F, 0))
            .register();

    public static final ItemEntry<RadioactiveBlockItem> URANIUM_BLOCK = REGISTRATE
            .item("uranium_block", properties -> new RadioactiveBlockItem(IndexBlocks.URANIUM_BLOCK.get(), properties,
                    0.5F, 3F, 1))
            .register();

    public static final ItemEntry<RadioactiveItem> RAW_URANIUM = REGISTRATE
            .item("raw_uranium", properties -> new RadioactiveItem(properties,
                    1.2F, 1F, 0))
            .register();
    public static final ItemEntry<RadioactiveItem> URANIUM_INGOT = REGISTRATE
            .item("uranium_ingot", properties -> new RadioactiveItem(properties,
                    0.5F, 1.2F, 1))
            .register();


//    public static final DeferredRegister<Item> ITEMS =
//            DeferredRegister.create(ForgeRegistries.ITEMS, MCHE_Create.MOD_ID);
//
//    public static final RegistryObject<Item> URANIUM_ORE = ITEMS.register("uranium_ore",
//            () -> new ItemNameBlockItem(IndexBlocks.URANIUM_ORE.get(),
//                    new Item.Properties().tab(IndexCreativeModeTabs.MCHE_CREATE_TAB)));

    /**
     * /// -  HAZMAT ARMOR  - ///
     *<p></p>
     * <p>
     *     Hazmat Mask = 2 Armor; 209 Durability
     * </p>
     * <p>
     *     Hazmat Gown = 6 Armor; 304 Durability
     * </p>
     * <p>
     *     Hazmat Pants = 5 Armor; 285 Durability
     * </p>
     * <p>
     *     Hazmat Boots = 2 Armor; 247 Durability
     * </p>
     *
     */

    public static final ItemEntry<ArmorItem> HAZMAT_MASK = REGISTRATE
            .item("hazmat_mask", properties -> new ArmorItem(IndexArmorMaterials.HAZMAT, EquipmentSlot.HEAD, properties))
            //.recipe(RecipeUtils.Smithing.steelItemRecipe(Items.CHAINMAIL_HELMET))
            .register();
    public static final ItemEntry<ArmorItem> HAZMAT_GOWN = REGISTRATE
            .item("hazmat_gown", properties -> new ArmorItem(IndexArmorMaterials.HAZMAT, EquipmentSlot.CHEST, properties))
            //.recipe(RecipeUtils.Smithing.steelItemRecipe(Items.CHAINMAIL_CHESTPLATE))
            .register();
    public static final ItemEntry<ArmorItem> HAZMAT_PANTS = REGISTRATE
            .item("hazmat_pants", properties -> new ArmorItem(IndexArmorMaterials.HAZMAT, EquipmentSlot.LEGS, properties))
            //.recipe(RecipeUtils.Smithing.steelItemRecipe(Items.CHAINMAIL_LEGGINGS))
            .register();
    public static final ItemEntry<ArmorItem> HAZMAT_BOOTS = REGISTRATE
            .item("hazmat_boots", properties -> new ArmorItem(IndexArmorMaterials.HAZMAT, EquipmentSlot.FEET, properties))
            //.recipe(RecipeUtils.Smithing.steelItemRecipe(Items.CHAINMAIL_BOOTS))
            .register();













    /**
     * /// -  COPPER TIER  - ///
     *<p></p>
     * <p>
     *     # Copper Sword = 6 Damage; 1.6 Speed; 250 Durability
     * </p>
     * <p>
     *     # Copper Shovel = 4.5 Damage; 1 Speed; 250 Durability
     * </p>
     * <p>
     *     # Copper Pickaxe = 4 Damage; 1.2 Speed; 250 Durability
     * </p>
     * <p>
     *     # Copper Axe = 9 Damage; 0.9 Speed; 250 Durability
     * </p>
     * <p>
     *     # Copper Hoe = 3 Damage; 3 Speed; 250 Durability
     * </p>
     * <p>
     *     # Copper Fishing Rod = 250 Durability
     * </p>
     * <p>
     *     # Copper Shears = 238 Durability
     * </p>
     * <p>
     *     # Copper Helmet = 2 Armor; 165 Durability
     * </p>
     * <p>
     *     # Copper Chestplate = 6 Armor; 240 Durability
     * </p>
     * <p>
     *     # Copper Leggings = 5 Armor; 225 Durability
     * </p>
     * <p>
     *     # Copper Boots = 2 Armor; 195 Durability
     * </p>
     *
     */


//    public static final ItemEntry<SwordItem> COPPER_SWORD = REGISTRATE
//            .item("copper_sword", properties -> new SwordItem(IndexTiers.COPPER,
//                    3, -2.4F, properties))
//            .register();
//
//    public static final ItemEntry<ShovelItem> COPPER_SHOVEL = REGISTRATE
//            .item("copper_shovel", properties -> new ShovelItem(IndexTiers.COPPER,
//                    1.5F, -3.0F, properties))
//            .register();
//    public static final ItemEntry<PickaxeItem> COPPER_PICKAXE = REGISTRATE
//            .item("copper_pickaxe", properties -> new PickaxeItem(IndexTiers.COPPER,
//                    1, -2.8F, properties))
//            .register();
//    public static final ItemEntry<AxeItem> COPPER_AXE = REGISTRATE
//            .item("copper_axe", properties -> new AxeItem(IndexTiers.COPPER,
//                    6.0F, -3.1F, properties))
//            .register();
//    public static final ItemEntry<HoeItem> COPPER_HOE = REGISTRATE
//            .item("copper_hoe", properties -> new HoeItem(IndexTiers.COPPER,
//                    -2, -1.0F, properties))
//            .register();
//
//    public static final ItemEntry<FishingRodItem> COPPER_FISHING_ROD = REGISTRATE
//            .item("copper_fishing_rod", properties -> new FishingRodItem(properties.durability(220)))
//            //.model((ctx, prov) -> prov.getExistingFile(prov.modLoc("item/copper_fishing_rod")))
//            .register();
//    public static final ItemEntry<ShearsItem> COPPER_SHEARS = REGISTRATE
//            .item("copper_shears", properties -> new ShearsItem(properties.durability(238)))
//            .register();
//
//    public static final ItemEntry<ArmorItem> COPPER_HELMET = REGISTRATE
//            .item("copper_helmet", properties -> new ArmorItem(IndexArmorMaterials.COPPER, EquipmentSlot.HEAD, properties))
//            .recipe(RecipeUtils.Smithing.steelItemRecipe(Items.COPPER_INGOT))
//            .register();
//    public static final ItemEntry<ArmorItem> COPPER_CHESTPLATE = REGISTRATE
//            .item("copper_chestplate", properties -> new ArmorItem(IndexArmorMaterials.COPPER, EquipmentSlot.CHEST, properties))
//            .recipe(RecipeUtils.Smithing.steelItemRecipe(Items.COPPER_INGOT))
//            .register();
//    public static final ItemEntry<ArmorItem> COPPER_LEGGINGS = REGISTRATE
//            .item("copper_leggings", properties -> new ArmorItem(IndexArmorMaterials.COPPER, EquipmentSlot.LEGS, properties))
//            .recipe(RecipeUtils.Smithing.steelItemRecipe(Items.COPPER_INGOT))
//            .register();
//    public static final ItemEntry<ArmorItem> COPPER_BOOTS = REGISTRATE
//            .item("copper_boots", properties -> new ArmorItem(IndexArmorMaterials.COPPER, EquipmentSlot.FEET, properties))
//            .recipe(RecipeUtils.Smithing.steelItemRecipe(Items.COPPER_INGOT))
//            .register();













//    public static final ItemEntry<Item>
//            DOUGH = taggedIngredient("dough", forgeItemTag("dough"), forgeItemTag("dough/wheat"));

//    public static final RegistryObject<Item> IRON_KNIFE = ITEMS.register("iron_knife",
//            () -> new KnifeItem(IndexTiers.IRON, 0.5F, -2.0F, basicItem()));




    // Shortcuts

    @SafeVarargs
    private static ItemEntry<Item> taggedIngredient(String name, TagKey<Item>... tags) {
        return REGISTRATE.item(name, Item::new)
                .tag(tags)
                .register();
    }

    // Load this class
    public static void register() {}

}
