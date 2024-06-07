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
import net.semppi.semppis_mythical_legends_mod.item.custom.CustomBowlFoodItem;
import net.semppi.semppis_mythical_legends_mod.item.custom.MandrakeBerriesItem;
import net.semppi.semppis_mythical_legends_mod.item.custom.WrappedPukis;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SemppisMythicalLegendsMod.MOD_ID);

    public static final RegistryObject<Item> MANDRAKE_ROOT = ITEMS.register("mandrake_root",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> MANDRAKE_LEAF = ITEMS.register("mandrake_leaf",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));
    public static final RegistryObject<Item> SATYR_HORN = ITEMS.register("satyr_horn",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> FROG_BUCKET = ITEMS.register("frog_bucket",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> BABY_TURTLE_BUCKET = ITEMS.register("baby_turtle_bucket",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> LOBSTER_CRICKET_BUCKET = ITEMS.register("lobster_cricket_bucket",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> FROGMAN_BUCKET = ITEMS.register("frogman_bucket",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> MEDIUM_TADPOLE_BUCKET = ITEMS.register("medium_tadpole_bucket",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));


    public static final RegistryObject<Item> ALICANTO_SPAWN_EGG = ITEMS.register("alicanto_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MANDRAKE, 0xF2AE3E, 0x51BC6D,
                    new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> BEHEMOTH_SPAWN_EGG = ITEMS.register("behemoth_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BEHEMOTH, 0x645137, 0x433420,
                    new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> COLOSSAL_LOBSTER_SPAWN_EGG = ITEMS.register("colossal_lobster_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.COLOSSALLOBSTER, 0x223227, 0xf08632,
                    new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> LOVELAND_FROGMAN_SPAWN_EGG = ITEMS.register("loveland_frogman_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.LOVELAND_FROGMAN, 0x386c3f, 0xadbc6e,
                    new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> MANDRAKE_SPAWN_EGG = ITEMS.register("mandrake_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MANDRAKE, 0x383226, 0x75713a,
                    new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> PUKIS_SPAWN_EGG = ITEMS.register("pukis_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PUKIS, 0x3b3497, 0x2c1830,
                    new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> SATYR_SPAWN_EGG = ITEMS.register("satyr_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SATYR, 0x95866d, 0x323232,
                    new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> WENDIGO_SPAWN_EGG = ITEMS.register("wendigo_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.WENDIGO, 0xb6b6b6, 0x4c4944,
                    new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> STAMP = ITEMS.register("stamp",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> WRAPPED_PUKIS = ITEMS.register("wrapped_pukis",
            () -> new WrappedPukis(new Item.Properties().tab(ModCreativeModeTab.SML_ITEM)));

    public static final RegistryObject<Item> COD_SOUP = ITEMS.register("cod_soup",
            () -> new CustomBowlFoodItem(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(8).saturationMod(9.6f).build())));

    public static final RegistryObject<Item> BAKED_CHEESY_FISH = ITEMS.register("baked_cheesy_fish",
            () -> new CustomBowlFoodItem(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(14).saturationMod(15.4f).build())));

    public static final RegistryObject<Item> PORRIDGE = ITEMS.register("porridge",
            () -> new CustomBowlFoodItem(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(6).saturationMod(6.3f).build())));

    public static final RegistryObject<Item> HONEYED_PORRIDGE = ITEMS.register("honeyed_porridge",
            () -> new CustomBowlFoodItem(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(12).saturationMod(7.5f).build())));

    public static final RegistryObject<Item> CHOCOLATE_PORRIDGE = ITEMS.register("chocolate_porridge",
            () -> new CustomBowlFoodItem(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(7).saturationMod(8.7f).build())));

    public static final RegistryObject<Item> MANDRAKE_BERRIES = ITEMS.register("mandrake_berries",
            () -> new MandrakeBerriesItem(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.4f).build())));

    public static final RegistryObject<Item> RICOTTA_CHEESE = ITEMS.register("ricotta_cheese",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(1.0f).build())));

    public static final RegistryObject<Item> NOPALE_PASTE = ITEMS.register("nopale_paste",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(1.4f).build())));

    public static final RegistryObject<Item> NOPALE_PASTE_ON_BREAD = ITEMS.register("nopale_paste_on_bread",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(5).saturationMod(4.4f).build())));

    public static final RegistryObject<Item> COOKED_MUSHROOM = ITEMS.register("cooked_mushroom",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(3.6f).build())));

    public static final RegistryObject<Item> HONEYED_MEAT_PIE = ITEMS.register("honeyed_meat_pie",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(5).saturationMod(4.5f).build())));

    public static final RegistryObject<Item> HONEYED_BERRY_TREAT = ITEMS.register("honeyed_berry_treat",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(14).saturationMod(2.8f).build())));

    public static final RegistryObject<Item> FISHY_KELP_TREAT = ITEMS.register("fishy_kelp_treat",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(9).saturationMod(3.1f).build())));

    public static final RegistryObject<Item> COOKED_FISHY_KELP_TREAT = ITEMS.register("cooked_fishy_kelp_treat",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(20).saturationMod(21.3f).build())));

    public static final RegistryObject<Item> VEGGIE_KELP_TREAT = ITEMS.register("veggie_kelp_treat",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(7).saturationMod(6.2f).build())));

    public static final RegistryObject<Item> HUMANOID_FLESH_PIECE = ITEMS.register("humanoid_flesh_piece",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.7f).build())));

    public static final RegistryObject<Item> HUMANOID_STEAK_PIECE = ITEMS.register("humanoid_steak_piece",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(3.2f).build())));

    public static final RegistryObject<Item> HUMANOID_FLESH = ITEMS.register("humanoid_flesh",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(1.6f).build())));

    public static final RegistryObject<Item> HUMANOID_STEAK = ITEMS.register("humanoid_steak",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(7).saturationMod(10.3f).build())));

    public static final RegistryObject<Item> HUMANOID_FLESH_CHUNK = ITEMS.register("humanoid_flesh_chunk",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)));

    public static final RegistryObject<Item> HUMANOID_STEAK_CHUNK = ITEMS.register("humanoid_steak_chunk",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SML_FOOD_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
