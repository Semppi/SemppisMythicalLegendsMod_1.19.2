package net.semppi.semppis_mythical_legends_mod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.ModEntityTypes;
import net.semppi.semppis_mythical_legends_mod.entity.custom.*;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = SemppisMythicalLegendsMod.MOD_ID)

    public class ForgeEvents {

    }

    @Mod.EventBusSubscriber(modid = SemppisMythicalLegendsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.SATYR.get(), SatyrEntity.setAttributes());
            event.put(ModEntityTypes.COLOSSALLOBSTER.get(), ColossalLobsterEntity.setAttributes());
            event.put(ModEntityTypes.BEHEMOTH.get(), BehemothEntity.setAttributes());
            event.put(ModEntityTypes.PUKIS.get(), PukisEntity.setAttributes());
            event.put(ModEntityTypes.MANDRAKE.get(), MandrakeEntity.setAttributes());
            event.put(ModEntityTypes.WENDIGO.get(), WendigoEntity.setAttributes());
            event.put(ModEntityTypes.LOVELAND_FROGMAN.get(), LovelandFrogmanEntity.setAttributes());
            event.put(ModEntityTypes.MALPHAS.get(), MalphasEntity.setAttributes());
        }
    }
}
