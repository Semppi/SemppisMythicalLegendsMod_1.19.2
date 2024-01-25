package net.semppi.semppis_mythical_legends_mod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.ModEntityTypes;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SemppisMythicalLegendsMod.MOD_ID);

    public static final RegistryObject<Item> SATYR_HORN = ITEMS.register("satyr_horn",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> LOBSTER_CRICKET_BUCKET = ITEMS.register("lobster_cricket_bucket",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));



    public static final RegistryObject<Item> BEHEMOTH_SPAWN_EGG = ITEMS.register("behemoth_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BEHEMOTH, 0x645137, 0x433420,
                    new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> COLOSSAL_LOBSTER_SPAWN_EGG = ITEMS.register("colossal_lobster_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.COLOSSALLOBSTER, 0x223227, 0xf08632,
                    new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> PUKIS_SPAWN_EGG = ITEMS.register("pukis_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PUKIS, 0x3b3497, 0xbbc609,
                    new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> SATYR_SPAWN_EGG = ITEMS.register("satyr_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SATYR, 0x95866d, 0x323232,
                    new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> COD_SOUP = ITEMS.register("cod_soup",
            () -> new BowlFoodItem(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(8).saturationMod(9.6f).build())));

    public static final RegistryObject<Item> RICOTTA_CHEESE = ITEMS.register("ricotta_cheese",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(1.0f).build())));

    public static final RegistryObject<Item> NOPALE_PASTE = ITEMS.register("nopale_paste",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(1.4f).build())));

    public static final RegistryObject<Item> HUMANOID_FLESH = ITEMS.register("humanoid_flesh",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(1.6f).build())));

    public static final RegistryObject<Item> HUMANOID_STEAK = ITEMS.register("humanoid_steak",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(7).saturationMod(10.3f).build())));

    public static final RegistryObject<Item> HUMANOID_FLESH_PIECE = ITEMS.register("humanoid_flesh_piece",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.7f).build())));

    public static final RegistryObject<Item> HUMANOID_STEAK_PIECE = ITEMS.register("humanoid_steak_piece",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(3.2f).build())));

    public static final RegistryObject<Item> HUMANOID_FLESH_CHUNK = ITEMS.register("humanoid_flesh_chunk",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)));

    public static final RegistryObject<Item> HUMANOID_STEAK_CHUNK = ITEMS.register("humanoid_steak_chunk",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
