package net.galuxy.mche_create.block.radioactive;

import com.simibubi.create.foundation.block.IBE;
import net.galuxy.mche_create.index.IndexItems;
import net.galuxy.mche_create.index.IndexTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class UraniumOre extends DropExperienceBlock implements IBE<UraniumOre_TE> {
    public UraniumOre(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Class<UraniumOre_TE> getBlockEntityClass() {
        return UraniumOre_TE.class;
    }

    @Override
    public BlockEntityType<? extends UraniumOre_TE> getBlockEntityType() {
        return IndexTileEntities.URANIUM_ORE_TE.get();
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        UraniumOre_TE.setDamage(3, 1F, 1.5F, 0);
        return IndexTileEntities.URANIUM_ORE_TE.create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, IndexTileEntities.URANIUM_ORE_TE.get(), UraniumOre_TE::tick);
    }

    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> type, BlockEntityType<E> correctType, BlockEntityTicker<? super E> ticker) {
        return correctType == type ? (BlockEntityTicker<A>)ticker : null;
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        if (entity instanceof LivingEntity && !(
                ((LivingEntity) entity).getItemBySlot(EquipmentSlot.HEAD).is(IndexItems.HAZMAT_MASK.get()) &&
                        ((LivingEntity) entity).getItemBySlot(EquipmentSlot.CHEST).is(IndexItems.HAZMAT_GOWN.get()) &&
                        ((LivingEntity) entity).getItemBySlot(EquipmentSlot.LEGS).is(IndexItems.HAZMAT_PANTS.get()) &&
                        ((LivingEntity) entity).getItemBySlot(EquipmentSlot.FEET).is(IndexItems.HAZMAT_BOOTS.get())
        )){
            ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.POISON, 3*20, 1));
        }

        super.stepOn(level, blockPos, blockState, entity);
    }

}