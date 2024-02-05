package net.galuxy.mche_create.block.charred_wood;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public interface ICharred {
    default void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(5) == 0) {
            for (int i = 0; i < randomSource.nextInt(1) + 1; ++i) {
                level.addParticle(ParticleTypes.LAVA, (double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D, (double) (randomSource.nextFloat() / 2.0F), 5.0E-5D, (double) (randomSource.nextFloat() / 2.0F));
            }
        }
    }

    default void onEntityStepOn(BlockState state, Entity entity) {
        if (!entity.isSteppingCarefully() && !entity.fireImmune() && entity instanceof LivingEntity &&
                !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
            entity.hurt(DamageSource.HOT_FLOOR, 1.0F);
        }

    }
}
