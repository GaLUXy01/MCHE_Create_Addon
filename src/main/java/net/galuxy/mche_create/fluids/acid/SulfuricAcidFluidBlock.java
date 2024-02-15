package net.galuxy.mche_create.fluids.acid;

import net.galuxy.mche_create.index.IndexDamageSources;
import net.galuxy.mche_create.index.IndexSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import java.util.function.Supplier;

public class SulfuricAcidFluidBlock extends LiquidBlock {
    public SulfuricAcidFluidBlock(Supplier<? extends FlowingFluid> pFluid, Properties pProperties) {
        super(pFluid, pProperties);
    }
//    public SulfuricAcidFluidBlock(Properties properties) {
//        super(properties);
//    }

//    public SulfuricAcidFluidBlock(Supplier<? extends FlowingFluid> flowingFluid, Properties properties) {
//        super(flowingFluid, properties);
//    }

    public void entityInside(BlockState blockState, Level level, BlockPos pos, Entity entity) {
        boolean armor = false;
        boolean hurtSound = false;
        float dmgMultiplier = 1.0F;

        if (entity instanceof LivingEntity living) {
            for (EquipmentSlot slot : EquipmentSlot.values()) {
                ItemStack item = living.getItemBySlot(slot);
                if (item != null && item.isDamageableItem()) {
                    armor = true;
                    if (living.getRandom().nextFloat() < 0.05F && !(entity instanceof Player player && player.isCreative())) {
                        item.hurtAndBreak(1, living, e -> e.broadcastBreakEvent(slot));
                    }
                }
            }
        }
        if (level.random.nextFloat() < dmgMultiplier) {
            hurtSound = entity.hurt(IndexDamageSources.ACID, dmgMultiplier * (float) (armor ? 0.01D : 1.0D));
        }
        if (hurtSound) {
            entity.playSound(SoundEvents.FIRE_EXTINGUISH);
        }
    }

//    @Override
//    public boolean isSource(FluidState pState) {
//        return false;
//    }
//
//    @Override
//    public int getAmount(FluidState pState) {
//        return 0;
//    }
}
