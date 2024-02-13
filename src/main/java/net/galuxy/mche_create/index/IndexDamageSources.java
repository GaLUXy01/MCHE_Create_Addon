package net.galuxy.mche_create.index;

import net.minecraft.world.damagesource.DamageSource;

public class IndexDamageSources extends DamageSource {
    public IndexDamageSources(String pMessageId) {
        super(pMessageId);
    }

    public static final DamageSource ACID = (new DamageSource("acid"));
    public static final DamageSource RADIATION = (new DamageSource("radiation")).bypassArmor();
    public static final DamageSource BASALTIC_LAVA = (new DamageSource("lava")).setIsFire();
}
