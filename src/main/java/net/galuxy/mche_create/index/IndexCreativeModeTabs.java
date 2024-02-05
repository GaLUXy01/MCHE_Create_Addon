package net.galuxy.mche_create.index;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class IndexCreativeModeTabs {
    public static final CreativeModeTab MCHE_CREATE_TAB = new CreativeModeTab("mche_create_tab") {
        @Override
        /*public ItemStack makeIcon() {
            return new ItemStack(IndexBlocks.STEEL_MOTOR.get());
        }*/
        public ItemStack makeIcon() {
            return new ItemStack(IndexItems.URANIUM_INGOT.get());
        }
    };

    public static void init() {
    }
}
