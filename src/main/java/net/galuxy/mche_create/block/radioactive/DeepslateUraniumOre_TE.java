package net.galuxy.mche_create.block.radioactive;

import net.galuxy.mche_create.index.IndexDamageSources;
import net.galuxy.mche_create.index.IndexEffects;
import net.galuxy.mche_create.index.IndexItems;
import net.galuxy.mche_create.index.IndexTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;


public class DeepslateUraniumOre_TE extends BlockEntity {
    public DeepslateUraniumOre_TE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(IndexTileEntities.DEEPSLATE_URANIUM_ORE_TE.get(), pos, state);
    }

    int timer = 0;
    boolean isActive = true;

    static float RANGE;
    static float FREQUENCY;
    static float AMOUNT;

    static int EFFECT_AMPLIFIER;

    public static void setDamage(float range, float freqSecond, float amount, int effect_amplifier){
        RANGE = range;
        FREQUENCY = freqSecond;
        AMOUNT = amount;
        EFFECT_AMPLIFIER = effect_amplifier;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, DeepslateUraniumOre_TE tile) {
        if (!level.isClientSide() && tile.isActive){
            tile.hurtMobs(tile);
        }
    }

    private void hurtMobs(DeepslateUraniumOre_TE tile) {
        // define a cube that goes RANGE blocks out from our block
        BlockPos topCorner = this.worldPosition.offset(RANGE, RANGE, RANGE);
        BlockPos bottomCorner = this.worldPosition.offset(-RANGE, -RANGE, -RANGE);
        AABB box = new AABB(topCorner, bottomCorner);

        // get all the entities within that cube
        List<Entity> entities = this.level.getEntities(null, box);

        for (Entity target : entities) {
            // check that the entity is living (ie. not an arrow)
            if (target instanceof LivingEntity) {
                ((LivingEntity) target).addEffect(new MobEffectInstance(IndexEffects.RADIATION.get(), (10*20)+5, EFFECT_AMPLIFIER));
                if ( !
                        (((LivingEntity) target).getItemBySlot(EquipmentSlot.HEAD).is(IndexItems.HAZMAT_MASK.get()) &&
                        ((LivingEntity) target).getItemBySlot(EquipmentSlot.CHEST).is(IndexItems.HAZMAT_GOWN.get()) &&
                        ((LivingEntity) target).getItemBySlot(EquipmentSlot.LEGS).is(IndexItems.HAZMAT_PANTS.get()) &&
                        ((LivingEntity) target).getItemBySlot(EquipmentSlot.FEET).is(IndexItems.HAZMAT_BOOTS.get()))
                ){
                    tile.timer++;
                    if (tile.timer > FREQUENCY * 20){
                        tile.timer = 0;

                        // only do this once per n second
                        target.hurt(IndexDamageSources.RADIATION, AMOUNT);
                    }
                }
            }
        }
    }

    public void toggle(){
        this.isActive = !this.isActive;
    }

    @Override
    public void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.putBoolean("active", this.isActive);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.isActive = nbt.getBoolean("active");
    }
}
