package net.semppi.semppis_mythical_legends_mod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.block.custom.PukisSkullBlock;
import net.semppi.semppis_mythical_legends_mod.block.custom.RicottaCheeseWheelBlock;
import net.semppi.semppis_mythical_legends_mod.block.custom.SatyrSkullBlock;
import net.semppi.semppis_mythical_legends_mod.item.ModCreativeModeTab;
import net.semppi.semppis_mythical_legends_mod.item.ModItems;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SemppisMythicalLegendsMod.MOD_ID);

    public static final RegistryObject<Block> SATYR_SKULL = registerBlock("satyr_skull",
            () -> new SatyrSkullBlock(BlockBehaviour.Properties.of(Material.DECORATION)
                    .strength(0.5f).noOcclusion()), ModCreativeModeTab.SML_ITEM);

    public static final RegistryObject<Block> RICOTTA_CHEESE_WHEEL = registerBlock("ricotta_cheese_wheel",
            () -> new RicottaCheeseWheelBlock(BlockBehaviour.Properties.of(Material.CAKE)
                    .strength(0.3f).noOcclusion()), ModCreativeModeTab.SML_FOOD_TAB);

    public static final RegistryObject<Block> PUKIS_SKULL = registerBlock("pukis_skull",
            () -> new PukisSkullBlock(BlockBehaviour.Properties.of(Material.DECORATION)
                    .strength(0.5f).noOcclusion()), ModCreativeModeTab.SML_ITEM);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}