package net.galuxy.mche_create.fluids;

import net.galuxy.mche_create.MCHE_Create;
import net.galuxy.mche_create.fluids.acid.SulfuricAcidFluidBlock;
import net.galuxy.mche_create.index.IndexFluids;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCHE_Create.MOD_ID);

    //public static final RegistryObject<LiquidBlock> SULFURIC_ACID = BLOCKS.register("sulfuric_acid", () -> new SulfuricAcidFluidBlock(IndexFluids.ACID_FLUID_SOURCE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).noCollission().strength(100.0F).lightLevel(state -> 7).emissiveRendering((state, world, pos) -> false).noLootTable().replaceable()));
    public static final RegistryObject<LiquidBlock> SULFURIC_ACID = BLOCKS.register("sulfuric_acid_block",
            () -> new SulfuricAcidFluidBlock(ModFluids.SOURCE_SULFURIC_ACID, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
