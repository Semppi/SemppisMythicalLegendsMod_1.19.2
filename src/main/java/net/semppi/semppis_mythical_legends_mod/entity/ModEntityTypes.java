package net.semppi.semppis_mythical_legends_mod.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.custom.BehemothEntity;
import net.semppi.semppis_mythical_legends_mod.entity.custom.ColossalLobsterEntity;
import net.semppi.semppis_mythical_legends_mod.entity.custom.PukisEntity;
import net.semppi.semppis_mythical_legends_mod.entity.custom.SatyrEntity;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SemppisMythicalLegendsMod.MOD_ID);

    public static final RegistryObject<EntityType<SatyrEntity>> SATYR =
            ENTITY_TYPES.register("satyr",
                    () -> EntityType.Builder.of(SatyrEntity::new, MobCategory.MONSTER)
                            .sized(0.5f, 1.7f)
                            .build(new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "satyr").toString()));
    public static final RegistryObject<EntityType<ColossalLobsterEntity>> COLOSSALLOBSTER =
            ENTITY_TYPES.register("colossal_lobster",
                    () -> EntityType.Builder.of(ColossalLobsterEntity::new, MobCategory.WATER_CREATURE)
                            .sized(1.7f, 2.3f)
                            .build(new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "colossal_lobster").toString()));

    public static final RegistryObject<EntityType<BehemothEntity>> BEHEMOTH =
            ENTITY_TYPES.register("behemoth",
                    () -> EntityType.Builder.of(BehemothEntity::new, MobCategory.MONSTER)
                            .sized(9.0f, 8.5f)
                            .build(new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "behemoth").toString()));

    public static final RegistryObject<EntityType<PukisEntity>> PUKIS =
            ENTITY_TYPES.register("pukis",
                    () -> EntityType.Builder.of(PukisEntity::new, MobCategory.MONSTER)
                            .sized(1.5f, 2.0f)
                            .build(new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "pukis").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
