package net.semppi.semppis_mythical_legends_mod.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import net.semppi.semppis_mythical_legends_mod.entity.TransformPlayerMount;

import java.util.function.Supplier;

public class JumpPacket {
    public JumpPacket() {}

    public static void encode(JumpPacket packet, FriendlyByteBuf buffer) {}

    public static JumpPacket decode(FriendlyByteBuf buffer) {
        return new JumpPacket();
    }

    public static void handle(JumpPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            // Server-side logic for jumping
            Player player = context.getSender();
            if (player.getVehicle() instanceof TransformPlayerMount) {
                ((TransformPlayerMount) player.getVehicle()).setJumping(true);
            }
        });
        context.setPacketHandled(true);
    }
}