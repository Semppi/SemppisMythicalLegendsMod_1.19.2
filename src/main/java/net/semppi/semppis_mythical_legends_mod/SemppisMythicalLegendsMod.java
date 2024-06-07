package net.semppi.semppis_mythical_legends_mod;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.semppi.semppis_mythical_legends_mod.block.ModBlocks;
import net.semppi.semppis_mythical_legends_mod.commands.CancelTransformCommand;
import net.semppi.semppis_mythical_legends_mod.commands.TransformCommand;
import net.semppi.semppis_mythical_legends_mod.commands.TransformHelper;
import net.semppi.semppis_mythical_legends_mod.entity.EntitySpawnHandler;
import net.semppi.semppis_mythical_legends_mod.entity.ModEntityTypes;
import net.semppi.semppis_mythical_legends_mod.entity.client.*;
import net.semppi.semppis_mythical_legends_mod.entity.entityranks.RankSetup;
import net.semppi.semppis_mythical_legends_mod.entity.ClientEvents;
import net.semppi.semppis_mythical_legends_mod.event.TransformationEventHandler;
import net.semppi.semppis_mythical_legends_mod.item.ModItems;
import net.semppi.semppis_mythical_legends_mod.network.NetworkSetup;
import net.semppi.semppis_mythical_legends_mod.sound.ModSounds;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;
import software.bernie.geckolib3.GeckoLib;

@Mod(SemppisMythicalLegendsMod.MOD_ID)
public class SemppisMythicalLegendsMod {
    public static final String MOD_ID = "semppis_mythical_legends_mod";
    private static final Logger LOGGER = LogManager.getLogger();

    public SemppisMythicalLegendsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        ModEntityTypes.register(modEventBus);
        ModSounds.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(new TransformationEventHandler());

        GeckoLib.initialize();
        MinecraftForge.EVENT_BUS.register(EntitySpawnHandler.class);
        modEventBus.addListener(ClientEvents::registerKeyMappings);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        NetworkSetup.init(event); // Ensure network setup is initialized here
        event.enqueueWork(() -> {
            RankSetup.setupCreatureRanks();
            SpawnPlacements.register(ModEntityTypes.SATYR.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ModEntityTypes.BEHEMOTH.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ModEntityTypes.PUKIS.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ModEntityTypes.WENDIGO.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ModEntityTypes.LOVELAND_FROGMAN.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ModEntityTypes.COLOSSALLOBSTER.get(),
                    SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING,
                    WaterAnimal::checkMobSpawnRules);
        });
    }

    @SubscribeEvent
    public void onServerStarting(RegisterCommandsEvent event) {
        TransformCommand.register(event.getDispatcher());
        CancelTransformCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public void onSetupComplete(FMLCommonSetupEvent event) {
        TransformHelper.initializeAllowedTransformations();
    }

    @Mod.EventBusSubscriber(modid = SemppisMythicalLegendsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventSubscriber {
        private static ResourceLocation location(String name) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, name);
        }
    }

    @Mod.EventBusSubscriber(modid = SemppisMythicalLegendsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.SATYR.get(), SatyrRenderer::new);
            EntityRenderers.register(ModEntityTypes.COLOSSALLOBSTER.get(), ColossalLobsterRenderer::new);
            EntityRenderers.register(ModEntityTypes.BEHEMOTH.get(), BehemothRenderer::new);
            EntityRenderers.register(ModEntityTypes.PUKIS.get(), PukisRenderer::new);
            EntityRenderers.register(ModEntityTypes.MANDRAKE.get(), MandrakeRenderer::new);
            EntityRenderers.register(ModEntityTypes.WENDIGO.get(), WendigoRenderer::new);
            EntityRenderers.register(ModEntityTypes.LOVELAND_FROGMAN.get(), LovelandFrogmanRenderer::new);
            EntityRenderers.register(ModEntityTypes.MALPHAS.get(), MalphasRenderer::new);
            LOGGER.info("Registering custom item renderers");
            event.enqueueWork(() -> {
                ItemProperties.register(ModItems.WRAPPED_PUKIS.get(), new ResourceLocation("using"), (stack, world, entity, seed) -> {
                    LOGGER.info("Custom renderer for WrappedPukis registered.");
                    return 0; // Example placeholder
                });
            });
        }
    }
}