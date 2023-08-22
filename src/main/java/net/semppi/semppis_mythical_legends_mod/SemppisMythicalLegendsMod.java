package net.semppi.semppis_mythical_legends_mod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
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
import net.semppi.semppis_mythical_legends_mod.block.ModBlockEntities;
import net.semppi.semppis_mythical_legends_mod.block.ModBlocks;
import net.semppi.semppis_mythical_legends_mod.block.entity.SatyrSkullBlockEntity;
import net.semppi.semppis_mythical_legends_mod.client.renderer.SatyrSkullBlockRenderer;
import net.semppi.semppis_mythical_legends_mod.entity.ModEntityTypes;
import net.semppi.semppis_mythical_legends_mod.entity.client.BehemothRenderer;
import net.semppi.semppis_mythical_legends_mod.entity.client.PukisRenderer;
import net.semppi.semppis_mythical_legends_mod.entity.client.SatyrRenderer;
import net.semppi.semppis_mythical_legends_mod.entity.client.ColossalLobsterRenderer;
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

        ModBlockEntities.register(modEventBus);

        modEventBus.register(ModBlockEntities.class);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        ModEntityTypes.register(modEventBus);

        ModSounds.register(modEventBus);

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
            BlockEntityRenderers.register(ModBlockEntities.SATYR_SKULL.get(), SatyrSkullBlockRenderer::new);
        }
    }
}