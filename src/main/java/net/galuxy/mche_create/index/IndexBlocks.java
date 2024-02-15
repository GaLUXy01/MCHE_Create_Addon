package net.galuxy.mche_create.index;

import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.galuxy.mche_create.MCHE_Create;
import net.galuxy.mche_create.block.charred_wood.BurningCharredBlock;
import net.galuxy.mche_create.block.charred_wood.BurningCharredPillar;
import net.galuxy.mche_create.block.radioactive.DeepslateUraniumOre;
import net.galuxy.mche_create.block.radioactive.RawUraniumBlock;
import net.galuxy.mche_create.block.radioactive.UraniumBlock;
import net.galuxy.mche_create.block.radioactive.UraniumOre;
import net.galuxy.mche_create.fluids.acid.SulfuricAcidFluidBlock;
import net.galuxy.mche_create.item.radioactive.RadioactiveItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.*;
import static net.galuxy.mche_create.MCHE_Create.REGISTRATE;

public class IndexBlocks {
    static {
        REGISTRATE.creativeModeTab(() -> IndexCreativeModeTabs.MCHE_CREATE_TAB);
    }

    /**
     * /// -  CHARRED WOOD  - ///
     * <p>
     *     # Fonte di charcoal rinnovabile e più efficiente.
     * </p>
     *
     */

    public static final BlockEntry<BurningCharredPillar> CHARRED_LOG_LIT =
            REGISTRATE.block("charred_log_lit", BurningCharredPillar::new)
                    .initialProperties(Material.WOOD)
                    .properties(p -> p.strength(2.0F))
                    .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
                    .properties(p -> p.color(MaterialColor.COLOR_BLACK))
                    .properties(p -> p.sound(SoundType.NETHERRACK))
                    .properties(p -> p.lightLevel(s -> 10))
                    .transform(axeOrPickaxe())
                    .item()
                    .transform(customItemModel())
                    .register();

    public static final BlockEntry<RotatedPillarBlock> CHARRED_LOG =
            REGISTRATE.block("charred_log", RotatedPillarBlock::new)
                    .initialProperties(Material.WOOD)
                    .properties(p -> p.strength(2.0F))
                    .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
                    .properties(p -> p.color(MaterialColor.COLOR_BLACK))
                    .properties(p -> p.sound(SoundType.NETHERRACK))
                    .transform(axeOrPickaxe())
                    //.tag(BlockTags.NEEDS_STONE_TOOL)
                    .item()
                    .transform(customItemModel())
                    .register();

    public static final BlockEntry<BurningCharredBlock> CHARRED_PLANKS_LIT =
            REGISTRATE.block("charred_planks_lit", BurningCharredBlock::new)
                    .initialProperties(Material.WOOD)
                    .properties(p -> p.strength(2.0F))
                    .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
                    .properties(p -> p.color(MaterialColor.COLOR_BLACK))
                    .properties(p -> p.sound(SoundType.NETHERRACK))
                    .properties(p -> p.lightLevel(s -> 10))
                    .transform(axeOrPickaxe())
                    .item()
                    .transform(customItemModel())
                    .register();

    public static final BlockEntry<Block> CHARRED_PLANKS =
            REGISTRATE.block("charred_planks", Block::new)
                    .initialProperties(Material.WOOD)
                    .properties(p -> p.strength(2.0F))
                    //.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
                    .properties(p -> p.color(MaterialColor.COLOR_BLACK))
                    .properties(p -> p.sound(SoundType.NETHERRACK))
                    .transform(axeOrPickaxe())
                    .item()
                    .transform(customItemModel())
                    .register();

    /**
     * /// -  STONES  - ///
     * <p>
     *     # Pietre che si possono trovare in natura.
     * </p>
     *
     */

    public static final BlockEntry<Block> BAUXITE =
            REGISTRATE.block("bauxite", Block::new)
                    .initialProperties(Material.STONE)
                    .properties(p -> p.strength(2.5F))
                    .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
                    .properties(p -> p.color(MaterialColor.TERRACOTTA_BROWN))
                    .properties(p -> p.sound(SoundType.TUFF))
                    .transform(pickaxeOnly())
                    .item()
                    .transform(customItemModel())
                    .register();

    /**
     * /// -  ORES  - ///
     * <p>
     *     # Minerali grezzi che si possono trovare in natura.
     * </p>
     *
     */

    public static final BlockEntry<DropExperienceBlock> SULFUR_ORE =
            REGISTRATE.block("sulfur_ore", DropExperienceBlock::new)
                    .initialProperties(() -> Blocks.COAL_ORE)
                    .properties(p -> p.strength(3.0F))
                    .properties(p -> p.color(MaterialColor.SAND))
                    .properties(p -> p.requiresCorrectToolForDrops()
                            .sound(SoundType.STONE))
                    .transform(pickaxeOnly())
                    .loot((lt, b) -> lt.add(b,
                            RegistrateBlockLootTables.createSilkTouchDispatchTable(b,
                                    RegistrateBlockLootTables.applyExplosionDecay(b, LootItem.lootTableItem(IndexItems.SULFUR.get())
                                            .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))))
                    .tag(Tags.Blocks.ORES)
                    .transform(tagBlockAndItem("ores/sulfur", "ores_in_ground/stone"))
                    .tag(Tags.Items.ORES)
                    .build()
                    .register();

    public static final BlockEntry<DropExperienceBlock> DEEPSLATE_SULFUR_ORE =
            REGISTRATE.block("deepslate_sulfur_ore", DropExperienceBlock::new)
                    .initialProperties(() -> Blocks.DEEPSLATE_COAL_ORE)
                    .properties(p -> p.strength(4.5F, 3.0F))
                    .properties(p -> p.color(MaterialColor.SAND))
                    .properties(p -> p.requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE))
                    .transform(pickaxeOnly())
                    .loot((lt, b) -> lt.add(b,
                            RegistrateBlockLootTables.createSilkTouchDispatchTable(b,
                                    RegistrateBlockLootTables.applyExplosionDecay(b, LootItem.lootTableItem(IndexItems.SULFUR.get())
                                            .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))))
                    .tag(Tags.Blocks.ORES)
                    .transform(tagBlockAndItem("ores/sulfur", "ores_in_ground/deepslate"))
                    .tag(Tags.Items.ORES)
                    .build()
                    .register();

    public static final BlockEntry<UraniumOre> URANIUM_ORE =
            REGISTRATE.block("uranium_ore", UraniumOre::new)
                    .initialProperties(() -> Blocks.GOLD_ORE)
                    .properties(p -> p.color(MaterialColor.COLOR_LIGHT_GREEN))
                    .properties(p -> p.requiresCorrectToolForDrops()
                            .sound(SoundType.STONE))
                    .transform(pickaxeOnly())
                    .tag(Tags.Blocks.ORES)
                    .transform(tagBlockAndItem("ores/uranium", "ores_in_ground/stone"))
                    .tag(Tags.Items.ORES)
                    .build()
                    .register();

    public static final BlockEntry<DeepslateUraniumOre> DEEPSLATE_URANIUM_ORE =
            REGISTRATE.block("deepslate_uranium_ore", DeepslateUraniumOre::new)
                    .initialProperties(() -> Blocks.DEEPSLATE_GOLD_ORE)
                    .properties(p -> p.color(MaterialColor.COLOR_LIGHT_GREEN))
                    .properties(p -> p.requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE))
                    .transform(pickaxeOnly())
                    .tag(Tags.Blocks.ORES)
                    .transform(tagBlockAndItem("ores/uranium", "ores_in_ground/deepslate"))
                    .tag(Tags.Items.ORES)
                    .build()
                    .register();

    /**
     * /// -  BLOCKS OF RAW ORE  - ///
     * <p>
     *     # Blocchi di minerali grezzi che si possono trovare in natura.
     *     # Usati per un miglior stoccaggio.
     * </p>
     *
     */

    public static final BlockEntry<RawUraniumBlock> RAW_URANIUM_BLOCK =
            REGISTRATE.block("raw_uranium_block", RawUraniumBlock::new)
                    .initialProperties(() -> Blocks.RAW_GOLD_BLOCK)
                    .properties(p -> p.color(MaterialColor.COLOR_LIGHT_GREEN))
                    .properties(p -> p.requiresCorrectToolForDrops()
                            .sound(SoundType.STONE))
                    .transform(pickaxeOnly())
                    .tag(Tags.Blocks.STORAGE_BLOCKS)
                    .transform(tagBlockAndItem("storage_blocks/raw_uranium"))
                    .tag(Tags.Items.STORAGE_BLOCKS)
                    .build()
                    .register();

    /**
     * /// -  BLOCKS OF ORE  - ///
     * <p>
     *     # Blocchi di minerali lavorati, usati per un miglior stoccaggio.
     * </p>
     *
     */

    public static final BlockEntry<Block> SULFUR_BLOCK =
            REGISTRATE.block("sulfur_block", Block::new)
                    .initialProperties(() -> Blocks.COAL_BLOCK)
                    .properties(p -> p.color(MaterialColor.SAND))
                    .properties(p -> p.requiresCorrectToolForDrops()
                            .sound(SoundType.STONE))
                    .transform(pickaxeOnly())
                    .tag(Tags.Blocks.STORAGE_BLOCKS)
                    .transform(tagBlockAndItem("storage_blocks/sulfur"))
                    .tag(Tags.Items.STORAGE_BLOCKS)
                    .build()
                    .register();

    public static final BlockEntry<UraniumBlock> URANIUM_BLOCK =
            REGISTRATE.block("uranium_block", UraniumBlock::new)
                    .initialProperties(() -> Blocks.GOLD_BLOCK)
                    .properties(p -> p.color(MaterialColor.COLOR_LIGHT_GREEN))
                    .properties(p -> p.requiresCorrectToolForDrops()
                            .sound(SoundType.METAL))
                    .properties(p -> p.lightLevel(s -> 15))
                    .transform(pickaxeOnly())
                    .tag(Tags.Blocks.STORAGE_BLOCKS)
                    .transform(tagBlockAndItem("storage_blocks/uranium"))
                    .tag(Tags.Items.STORAGE_BLOCKS)
                    .build()
                    .register();


    // Load this class

    public static void register() {}
}
