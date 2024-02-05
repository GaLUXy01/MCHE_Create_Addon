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


public class RadioactiveBlockTileEntity extends BlockEntity {
    public RadioactiveBlockTileEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(IndexTileEntities.RADIOACTIVE_BLOCK_TE.get(), pos, state);
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

    public static void tick(Level level, BlockPos pos, BlockState state, RadioactiveBlockTileEntity tile) {
        if (!level.isClientSide() && tile.isActive){
            tile.hurtMobs(tile);
            /*tile.timer++;
            if (tile.timer > FREQUENCY * 20){
                tile.timer = 0;

                // only do this once per n second
                tile.hurtMobs(tile);
            }*/
        }

        if (tile.isRemoved()) {
            tile.setRemoved();
        }
    }

    private void hurtMobs(RadioactiveBlockTileEntity tile) {
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
                // deal damage to the entity
                //target.hurt(DamageSource.MAGIC, AMOUNT);
                //RadiationEffect.AMOUNT = AMOUNT;
                //((LivingEntity) target).addEffect(new MobEffectInstance(IndexEffects.RADIATION.get(), (11*20)+5, 0));
                    tile.timer++;
                    if (tile.timer > FREQUENCY * 20){
                        tile.timer = 0;

                        // only do this once per n second
                        target.hurt(IndexDamageSources.RADIATION, AMOUNT);
                    }

                //target.hurt(DamageSource.SWEET_BERRY_BUSH, AMOUNT);
                }
            }
            else
                hurtHazmatArmor();
        }
    }

    private void hurtHazmatArmor()
    {
        // define a cube that goes RANGE blocks out from our block
        BlockPos topCorner = this.worldPosition.offset(RANGE, RANGE, RANGE);
        BlockPos bottomCorner = this.worldPosition.offset(-RANGE, -RANGE, -RANGE);
        AABB box = new AABB(topCorner, bottomCorner);

        // get all the entities within that cube
        List<Entity> entities = this.level.getEntities(null, box);

        for (Entity target : entities){
            // check that the entity is living (ie. not an arrow) and not a player
            if (target instanceof LivingEntity)
            {
                ((LivingEntity) target).getItemBySlot(EquipmentSlot.HEAD).setDamageValue(
                        ((LivingEntity) target).getItemBySlot(EquipmentSlot.HEAD).getDamageValue() - 1);
                ((LivingEntity) target).getItemBySlot(EquipmentSlot.CHEST).setDamageValue(
                        ((LivingEntity) target).getItemBySlot(EquipmentSlot.CHEST).getDamageValue() - 1);
                ((LivingEntity) target).getItemBySlot(EquipmentSlot.LEGS).setDamageValue(
                        ((LivingEntity) target).getItemBySlot(EquipmentSlot.LEGS).getDamageValue() - 1);
                ((LivingEntity) target).getItemBySlot(EquipmentSlot.FEET).setDamageValue(
                        ((LivingEntity) target).getItemBySlot(EquipmentSlot.FEET).getDamageValue() - 1);
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


//public class RadioactiveBlockTileEntity extends BlockEntity implements ITickable {
//    //super(IndexTileEntities.RADIOACTIVE_BLOCK_TE, pos, state);
//    public RadioactiveBlockTileEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
//        super(type, pos, state);
//    }
//
//    double effectRadius = 16.0;
//    int effectDurationSeconds = 7;
//    int effectAmplifier = 1;
//
//    @Override
//    public void tick() {
//        assert level != null;
//        for(LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, new AABB(getBlockPos()).inflate(effectRadius))){
//            //lastConsumedPotion.applyEffects(null, null, entity);
//            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, effectDurationSeconds*20, effectAmplifier-1, true, true));
//        }
//    }
//}
