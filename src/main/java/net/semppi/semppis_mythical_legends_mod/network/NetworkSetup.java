package net.semppi.semppis_mythical_legends_mod.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.entity.CrouchPacket;

@Mod.EventBusSubscriber(modid = SemppisMythicalLegendsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetworkSetup {
    public static SimpleChannel NETWORK;
    private static final String PROTOCOL_VERSION = "1";
    private static boolean initialized = false;

    @SubscribeEvent
    public static void init(final FMLCommonSetupEvent event) {
        if (initialized) return;
        initialized = true;

        NETWORK = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "main_channel"),
                () -> PROTOCOL_VERSION,
                PROTOCOL_VERSION::equals,
                PROTOCOL_VERSION::equals
        );

        registerMessages();
    }

    private static void registerMessages() {
        int id = 0;
        NETWORK.registerMessage(id++, CrouchPacket.class, CrouchPacket::encode, CrouchPacket::decode, CrouchPacket::handle);
        NETWORK.registerMessage(id++, JumpPacket.class, JumpPacket::encode, JumpPacket::decode, JumpPacket::handle);
    }
}