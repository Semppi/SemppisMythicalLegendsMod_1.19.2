package net.semppi.semppis_mythical_legends_mod.banneradditions;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;

//public class ModPatterns {
//    public static final DeferredRegister<BannerPattern> BANNER_PATTERNS = DeferredRegister.create(ForgeRegistries.BANNER_PATTERNS, SemppisMythicalLegendsMod.MOD_ID);
//
//    public static final RegistryObject<BannerPattern> SATYR = BANNER_PATTERNS.register("satyr_pattern",
//            () -> SatyrBannerPattern.create("satyr_pattern", 3, 5, LoomRecipe.EMPTY, new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "textures/entity/banner/satyr_banner_icon.png")));
//
//    @SubscribeEvent
//    public static void onRegisterPatterns(RegistryEvent.Register<BannerPattern> event) {
//        event.getRegistry().registerAll(
//                // Your pattern registrations here
//        );
//    }
//}