package net.galuxy.mche_create.index;

import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.Create;
import net.galuxy.mche_create.MCHE_Create;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.registries.RegisterEvent;

import java.util.HashMap;
import java.util.Map;

public class IndexSoundEvents {
    public static final Map<ResourceLocation, AllSoundEvents.SoundEntry> ALL = new HashMap<>();

    public static final AllSoundEvents.SoundEntry

        ACID_BURN = create("acid_burn").subtitle("Dissolving in acid")
            .category(SoundSource.BLOCKS)
            .build();

    private static AllSoundEvents.SoundEntryBuilder create(String name) {
        return create(MCHE_Create.asResource(name));
    }

    public static AllSoundEvents.SoundEntryBuilder create(ResourceLocation id) {
        return new AllSoundEvents.SoundEntryBuilder(id);
    }

    public static void prepare() {
        for (AllSoundEvents.SoundEntry entry : ALL.values())
            entry.prepare();
    }

    public static void register(RegisterEvent event) {
        event.register(Registry.SOUND_EVENT_REGISTRY, helper -> {
            for (AllSoundEvents.SoundEntry entry : ALL.values())
                entry.register(helper);
        });
    }
}
