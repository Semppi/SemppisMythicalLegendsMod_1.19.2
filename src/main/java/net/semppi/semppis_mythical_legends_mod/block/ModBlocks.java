package net.semppi.semppis_mythical_legends_mod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.block.custom.SatyrSkullBlock;
import net.semppi.semppis_mythical_legends_mod.item.ModCreativeModeTab;
import net.semppi.semppis_mythical_legends_mod.item.ModItems;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SemppisMythicalLegendsMod.MOD_ID);

    public static final RegistryObject<Block> SATYR_SKULL = BLOCKS.register("satyr_skull",
            () -> new SatyrSkullBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Item> SATYR_SKULL_ITEM = ModItems.ITEMS.register("satyr_skull",
            () -> new BlockItem(SATYR_SKULL.get(), new Item.Properties().tab(ModCreativeModeTab.SML_TAB)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}