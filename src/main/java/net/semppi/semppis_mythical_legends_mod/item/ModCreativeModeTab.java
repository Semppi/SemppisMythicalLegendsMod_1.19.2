package net.semppi.semppis_mythical_legends_mod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab SML_TAB = new CreativeModeTab("smltab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SATYR_HORN.get());
        }
    };

    public static final CreativeModeTab SML_FOOD = new CreativeModeTab("smlfoods") {
        @Override
        public ItemStack makeIcon() {return new ItemStack(ModItems.COD_SOUP.get());}
    };
}
