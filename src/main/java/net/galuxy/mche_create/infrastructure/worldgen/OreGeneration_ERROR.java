package net.galuxy.mche_create.infrastructure.worldgen;



import com.simibubi.create.foundation.utility.Couple;
import com.simibubi.create.infrastructure.worldgen.AllOreFeatureConfigEntries;
import com.simibubi.create.infrastructure.worldgen.OreFeatureConfigEntry;
import net.galuxy.mche_create.MCHE_Create;
import net.galuxy.mche_create.index.IndexBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraftforge.common.ForgeConfigSpec;

public class OreGeneration_ERROR extends AllOreFeatureConfigEntries {
    public static final OreFeatureConfigEntry SULFUR_ORE =
            create("sulfur_ore", 12, 10, -35, 95)
                    .standardDatagenExt()
                    .withBlocks(Couple.create(IndexBlocks.SULFUR_ORE, IndexBlocks.DEEPSLATE_SULFUR_ORE))
                    .biomeTag(BiomeTags.IS_OVERWORLD)
                    .parent();

//    public static final OreFeatureConfigEntry URANIUM_ORE =
//            create("uranium_ore", 10, 8, -63, 20)
//                    .standardDatagenExt()
//                    .withBlocks(Couple.create(IndexBlocks.URANIUM_ORE, IndexBlocks.DEEPSLATE_URANIUM_ORE))
//                    .biomeTag(BiomeTags.IS_OVERWORLD)
//                    .parent();

    private static OreFeatureConfigEntry create(String name, int clusterSize, float frequency,
                                                int minHeight, int maxHeight) {
        ResourceLocation id = MCHE_Create.asResource(name);
        OreFeatureConfigEntry configDrivenFeatureEntry = new OreFeatureConfigEntry(id, clusterSize, frequency, minHeight, maxHeight);
        return configDrivenFeatureEntry;
    }

    public static void fillConfig(ForgeConfigSpec.Builder builder, String namespace) {
        OreFeatureConfigEntry.ALL
                .forEach((id, entry) -> {
                    if (id.getNamespace().equals(namespace)) {
                        builder.push(entry.getName());
                        entry.addToConfig(builder);
                        builder.pop();
                    }
                });
    }

    public static void init() {}

}
