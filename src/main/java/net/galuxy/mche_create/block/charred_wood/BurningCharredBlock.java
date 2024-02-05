package net.galuxy.mche_create.block.charred_wood;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BurningCharredBlock extends Block implements ICharred {
    public BurningCharredBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        ICharred.super.animateTick(state, level, pos, random);
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        onEntityStepOn(state, entity);
        super.stepOn(world, pos, state, entity);
    }
}
