package net.galuxy.mche_create.index;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum IndexTiers implements Tier {
    COPPER(2, 250, 6.0F, 2.0F, 9, () -> {
        return Ingredient.of(Items.COPPER_INGOT);
    }),
    IRON(2, 550, 6.0F, 3.0F, 14, () -> {
        return Ingredient.of(Items.IRON_INGOT);
    });

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private IndexTiers(int level, int uses, float speed, float damage, int enchantmentValue, Supplier repairIngredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public @NotNull Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}







//public class IndexTiers {
//    public static Tier COPPER;
//    public static Tier IRON;
//    public static Tier AMETHYST;
//
//    static {

//        COPPER = TierSortingRegistry.registerTier(
//                new ForgeTier(1, 250, 5.0f, 2.0f, 11,
//                        BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.COPPER_INGOT)),
//                new ResourceLocation(MCHE_Create.MODID, "copper"), List.of(Tiers.STONE), List.of(Tiers.IRON));

//        IRON = TierSortingRegistry.registerTier(
//                new ForgeTier(2, 550, 6.0f, 3.0f, 14,
//                        BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.IRON_INGOT)),
//                new ResourceLocation(MCHE_Create.MODID, "iron"), List.of(Tiers.STONE), List.of(Tiers.DIAMOND));

//        AMETHYST = TierSortingRegistry.registerTier(
//                new ForgeTier(3, 850, 11f, 3.0f, 16,
//                        ModTags.Blocks.NEEDS_AMETHYST_TOOL, () -> Ingredient.of(Items.AMETHYST_SHARD)),
//                new ResourceLocation(MCHE_Create.MODID, "amethyst"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
//    }
//
//}



/*
public class ModTiers {
    public static final ForgeTier AMETHYST = new ForgeTier(3, 1400, 1.5f,
            2f, 22, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(Items.AMETHYST_SHARD));
}*/

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//public enum ModItemTiers implements Tier {
//    STEEL(2, 1000, 7.0F, 3.0F, 11, () -> {
//        return Ingredient.of(new ItemLike[]{(ItemLike) ModItems.STEEL_INGOT.get()});
//    });
//
//    private final int level;
//    private final int uses;
//    private final float speed;
//    private final float damage;
//    private final int enchantmentValue;
//    private final Supplier<Ingredient> repairIngredient;
//
//    private ModItemTiers(int level, int uses, float speed, float damage, int enchantmentValue, Supplier repairIngredient) {
//        this.level = level;
//        this.uses = uses;
//        this.speed = speed;
//        this.damage = damage;
//        this.enchantmentValue = enchantmentValue;
//        Objects.requireNonNull(repairIngredient);
//        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
//    }
//
//    public int getUses() {
//        return this.uses;
//    }
//
//    public float getSpeed() {
//        return this.speed;
//    }
//
//    public float getAttackDamageBonus() {
//        return this.damage;
//    }
//
//    public int getLevel() {
//        return this.level;
//    }
//
//    public int getEnchantmentValue() {
//        return this.enchantmentValue;
//    }
//
//    public @NotNull Ingredient getRepairIngredient() {
//        return (Ingredient)this.repairIngredient.get();
//    }
//}
