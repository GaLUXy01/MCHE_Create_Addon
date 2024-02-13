package net.galuxy.mche_create.item.radioactive;

import net.galuxy.mche_create.index.IndexDamageSources;
import net.galuxy.mche_create.index.IndexEffects;
import net.galuxy.mche_create.index.IndexItems;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RadioactiveItem extends Item {
    public RadioactiveItem(Properties pProperties, float freqSecond, float amount, int effect_amplifier) {
        super(pProperties);
        FREQUENCY = freqSecond;
        AMOUNT = amount;
        EFFECT_AMPLIFIER = effect_amplifier;
    }

    int timer = 0;
    boolean isActive = true;

    float FREQUENCY;
    float AMOUNT;

    int EFFECT_AMPLIFIER;

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        if (!level.isClientSide && entity instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(IndexEffects.RADIATION.get(), (10*20)+5, EFFECT_AMPLIFIER));
            if ( !(
                    living.getItemBySlot(EquipmentSlot.HEAD).is(IndexItems.HAZMAT_MASK.get()) &&
                    living.getItemBySlot(EquipmentSlot.CHEST).is(IndexItems.HAZMAT_GOWN.get()) &&
                    living.getItemBySlot(EquipmentSlot.LEGS).is(IndexItems.HAZMAT_PANTS.get()) &&
                    living.getItemBySlot(EquipmentSlot.FEET).is(IndexItems.HAZMAT_BOOTS.get())
            )){
                this.timer++;
                if (this.timer > FREQUENCY * 20)
                {
                    this.timer = 0;

                    // only do this once per n second
                    living.hurt(IndexDamageSources.RADIATION, AMOUNT);
                }
            }
        }
    }
}
