package net.semppi.semppis_mythical_legends_mod.entity;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import java.util.function.Supplier;

public class CrouchPacket {
    public CrouchPacket() {}

    public static void encode(CrouchPacket packet, FriendlyByteBuf buffer) {}

    public static CrouchPacket decode(FriendlyByteBuf buffer) {
        return new CrouchPacket();
    }

    public static void handle(CrouchPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            // Server-side logic for crouching
            Player player = context.getSender();
            if (player.getVehicle() instanceof TransformPlayerMount) {
                ((TransformPlayerMount) player.getVehicle()).toggleCrouch();
            }
        });
        context.setPacketHandled(true);
    }
}