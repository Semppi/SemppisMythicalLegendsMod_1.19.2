package net.semppi.semppis_mythical_legends_mod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//import net.semppi.semppis_mythical_legends_mod.banneradditions.ModPatterns;
import net.semppi.semppis_mythical_legends_mod.block.ModBlocks;
import net.semppi.semppis_mythical_legends_mod.entity.ModEntityTypes;
import net.semppi.semppis_mythical_legends_mod.entity.client.*;
import net.semppi.semppis_mythical_legends_mod.item.ModItems;
import net.semppi.semppis_mythical_legends_mod.sound.ModSounds;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SemppisMythicalLegendsMod.MOD_ID)
public class SemppisMythicalLegendsMod {
    public static final String MOD_ID = "semppis_mythical_legends_mod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SemppisMythicalLegendsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        ModEntityTypes.register(modEventBus);

        ModSounds.register(modEventBus);

        //modEventBus.register(ModPatterns.class);

        GeckoLib.initialize();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntityTypes.SATYR.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ModEntityTypes.BEHEMOTH.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ModEntityTypes.PUKIS.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);
        });
    }

    @Mod.EventBusSubscriber(modid = SemppisMythicalLegendsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class ModEventSubscriber {
        private static ResourceLocation location(String name) {
            return new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, name);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = SemppisMythicalLegendsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.SATYR.get(), SatyrRenderer::new);
            EntityRenderers.register(ModEntityTypes.COLOSSALLOBSTER.get(), ColossalLobsterRenderer::new);
            EntityRenderers.register(ModEntityTypes.BEHEMOTH.get(), BehemothRenderer::new);
            EntityRenderers.register(ModEntityTypes.PUKIS.get(), PukisRenderer::new);
            EntityRenderers.register(ModEntityTypes.MANDRAKE.get(), MandrakeRenderer::new);
        }
    }
}