package net.galuxy.mche_create.index;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.galuxy.mche_create.MCHE_Create;
import net.galuxy.mche_create.block.radioactive.*;

public class IndexTileEntities {
    
    /**
     * /// -  RADIOACTIVE BLOCKS  - ///
     * <p>
     *     # Minerali radioattivi
     * </p>
     *
     */
    
    public static final BlockEntityEntry<RadioactiveBlockTileEntity> RADIOACTIVE_BLOCK_TE = MCHE_Create.REGISTRATE
            .blockEntity("radioactive_block", RadioactiveBlockTileEntity::new)
            .validBlocks(
                    IndexBlocks.URANIUM_ORE,
                    IndexBlocks.DEEPSLATE_URANIUM_ORE,
                    IndexBlocks.RAW_URANIUM_BLOCK,
                    IndexBlocks.URANIUM_BLOCK
            )
            .register();

    public static final BlockEntityEntry<UraniumOre_TE> URANIUM_ORE_TE = MCHE_Create.REGISTRATE
            .blockEntity("uranium_ore", UraniumOre_TE::new)
            .validBlocks(IndexBlocks.URANIUM_ORE)
            .register();

    public static final BlockEntityEntry<DeepslateUraniumOre_TE> DEEPSLATE_URANIUM_ORE_TE = MCHE_Create.REGISTRATE
            .blockEntity("deepslate_uranium_ore", DeepslateUraniumOre_TE::new)
            .validBlocks(IndexBlocks.DEEPSLATE_URANIUM_ORE)
            .register();

    public static final BlockEntityEntry<RawUraniumBlock_TE> RAW_URANIUM_BLOCK_TE = MCHE_Create.REGISTRATE
            .blockEntity("raw_uranium_block", RawUraniumBlock_TE::new)
            .validBlocks(IndexBlocks.RAW_URANIUM_BLOCK)
            .register();

    public static final BlockEntityEntry<UraniumBlock_TE> URANIUM_BLOCK_TE = MCHE_Create.REGISTRATE
            .blockEntity("uranium_block", UraniumBlock_TE::new)
            .validBlocks(IndexBlocks.URANIUM_BLOCK)
            .register();


    // Load this class

    public static void register() {}
}
