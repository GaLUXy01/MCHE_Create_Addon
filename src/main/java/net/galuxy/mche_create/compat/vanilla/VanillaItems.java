package net.galuxy.mche_create.compat.vanilla;

import net.galuxy.mche_create.index.IndexTiers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VanillaItems {

    private static final DeferredRegister<Item> VANILLA_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

    // Override ItemStack. Priorità sulle altre mod di espansione

    public static final RegistryObject<Item> SNOWBALL = VANILLA_ITEMS.register("snowball",
            () -> new SnowballItem( new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> EGG = VANILLA_ITEMS.register("egg",
            () -> new EggItem( new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> ENDER_PEARL = VANILLA_ITEMS.register("ender_pearl",
            () -> new EnderpearlItem( new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_MISC)));

    /**
     * /// -  IRON TIER Override  - ///
     *<p></p>
     * <p>
     *     # Iron Sword = 6 Damage; 1.6 Speed; 250 Durability >>> 7 Damage; 1.6 Speed; 550 Durability
     * </p>
     * <p>
     *     # Iron Shovel = 4.5 Damage; 1 Speed; 250 Durability >>> 5.5 Damage; 1 Speed; 550 Durability
     * </p>
     * <p>
     *     # Iron Pickaxe = 4 Damage; 1.2 Speed; 250 Durability >>> 5 Damage; 1.2 Speed; 550 Durability
     * </p>
     * <p>
     *     # Iron Axe = 9 Damage; 0.9 Speed; 250 Durability >>> 10 Damage; 0.9 Speed; 550 Durability
     * </p>
     * <p>
     *     # Iron Hoe = 3 Damage; 3 Speed; 250 Durability >>> 2 Damage; 3 Speed; 550 Durability
     * </p>
     * <p>
     *     # Shears = 238 Durability >>> 450 Durability
     * </p>
     * <p>
     *     # Iron Helmet = 2 Armor; 165 Durability >>> 2 Armor; 264 Durability
     * </p>
     * <p>
     *     # Iron Chestplate = 6 Armor; 240 Durability >>> 6 Armor; 384 Durability
     * </p>
     * <p>
     *     # Iron Leggings = 5 Armor; 225 Durability >>> 5 Armor; 360 Durability
     * </p>
     * <p>
     *     # Iron Boots = 2 Armor; 195 Durability >>> 2 Armor; 312 Durability
     * </p>
     *
     */

    public static final RegistryObject<Item> IRON_SWORD = VANILLA_ITEMS.register("iron_sword",
            () -> new SwordItem(IndexTiers.IRON, 3, -2.4f,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> IRON_SHOVEL = VANILLA_ITEMS.register("iron_shovel",
            () -> new ShovelItem(IndexTiers.IRON, 1.5f, -3.0f,
                    new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> IRON_PICKAXE = VANILLA_ITEMS.register("iron_pickaxe",
            () -> new PickaxeItem(IndexTiers.IRON, 1, -2.8f,
                    new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> IRON_AXE = VANILLA_ITEMS.register("iron_axe",
            () -> new AxeItem(IndexTiers.IRON, 6, -3.1f,
                    new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> IRON_HOE = VANILLA_ITEMS.register("iron_hoe",
            () -> new HoeItem(IndexTiers.IRON, -2, -1.0f,
                    new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<Item> SHEARS = VANILLA_ITEMS.register("shears",
            () -> new ShearsItem((new Item.Properties().durability(450)
                    .tab(CreativeModeTab.TAB_TOOLS))));

    public static final RegistryObject<Item> IRON_HELMET = VANILLA_ITEMS.register("iron_helmet",
            () -> new ArmorItem(VanillaArmorMaterials.IRON, EquipmentSlot.HEAD,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_CHESTPLATE = VANILLA_ITEMS.register("iron_chestplate",
            () -> new ArmorItem(VanillaArmorMaterials.IRON, EquipmentSlot.CHEST,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_LEGGINGS = VANILLA_ITEMS.register("iron_leggings",
            () -> new ArmorItem(VanillaArmorMaterials.IRON, EquipmentSlot.LEGS,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_BOOTS = VANILLA_ITEMS.register("iron_boots",
            () -> new ArmorItem(VanillaArmorMaterials.IRON, EquipmentSlot.FEET,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static void register(IEventBus eventBus) {
        VANILLA_ITEMS.register(eventBus);
    }
}


