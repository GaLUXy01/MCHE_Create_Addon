package net.galuxy.mche_create.mobeffect;

import net.galuxy.mche_create.index.IndexItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

public class RadiationEffect extends MobEffect {

    public RadiationEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    float DamagePerSecond = 10.0F; // frequenza di danno comune ai 4 slot dell'armatura.

    int HeadArmorTimer = 0;
    int ChestArmorTimer = 0;
    int LegsArmorTimer = 0;
    int FeetArmorTimer = 0;

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level.isClientSide()) {
            //pLivingEntity.hurt(IndexDamageSources.RADIATION, AMOUNT); //non causa danno diretto, corrode soltanto la tuta
            if (pLivingEntity.getItemBySlot(EquipmentSlot.HEAD).is(IndexItems.HAZMAT_MASK.get())) {
                HeadArmorTimer++;
                if (HeadArmorTimer > ((DamagePerSecond * 20) / (pAmplifier + 1))) {
                    HeadArmorTimer = 0;
                    pLivingEntity.getItemBySlot(EquipmentSlot.HEAD).hurtAndBreak(1, pLivingEntity, (p_150686_) -> {
                        p_150686_.broadcastBreakEvent(EquipmentSlot.HEAD);
                    });
                }
            }
            if (pLivingEntity.getItemBySlot(EquipmentSlot.CHEST).is(IndexItems.HAZMAT_GOWN.get())) {
                ChestArmorTimer++;
                if (ChestArmorTimer > ((DamagePerSecond * 20) / (pAmplifier + 1))) {
                    ChestArmorTimer = 0;
                    pLivingEntity.getItemBySlot(EquipmentSlot.CHEST).hurtAndBreak(1, pLivingEntity, (p_150686_) -> {
                        p_150686_.broadcastBreakEvent(EquipmentSlot.CHEST);
                    });
                }
            }
            if (pLivingEntity.getItemBySlot(EquipmentSlot.LEGS).is(IndexItems.HAZMAT_PANTS.get())) {
                LegsArmorTimer++;
                if (LegsArmorTimer > ((DamagePerSecond * 20) / (pAmplifier + 1))) {
                    LegsArmorTimer = 0;
                    pLivingEntity.getItemBySlot(EquipmentSlot.LEGS).hurtAndBreak(1, pLivingEntity, (p_150686_) -> {
                        p_150686_.broadcastBreakEvent(EquipmentSlot.LEGS);
                    });
                }
            }
            if (pLivingEntity.getItemBySlot(EquipmentSlot.FEET).is(IndexItems.HAZMAT_BOOTS.get())) {
                FeetArmorTimer++;
                if (FeetArmorTimer > ((DamagePerSecond * 20) / (pAmplifier + 1))) {
                    FeetArmorTimer = 0;
                    pLivingEntity.getItemBySlot(EquipmentSlot.FEET).hurtAndBreak(1, pLivingEntity, (p_150686_) -> {
                        p_150686_.broadcastBreakEvent(EquipmentSlot.FEET);
                    });
                }
            }
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
