package net.semppi.semppis_mythical_legends_mod.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

//public class ControlEntityPacket {
//    private final String action;
//
//    public ControlEntityPacket(String action) {
//        this.action = action;
//    }
//
//    public static void encode(ControlEntityPacket packet, FriendlyByteBuf buffer) {
//        buffer.writeUtf(packet.action);
//    }
//
//    public static ControlEntityPacket decode(FriendlyByteBuf buffer) {
//        return new ControlEntityPacket(buffer.readUtf(256));
//    }
//
//    public static void handle(final ControlEntityPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
//        NetworkEvent.Context context = contextSupplier.get();
//        context.enqueueWork(() -> {
//            ServerPlayer serverPlayer = context.getSender();
//            if (serverPlayer == null) return;
//
//            Entity vehicle = serverPlayer.getVehicle();
//            if (vehicle != null && vehicle instanceof LivingEntity) {
//                LivingEntity livingEntity = (LivingEntity) vehicle;
//                // Assuming a method exist directly in entities or using reflection to call it conditionally
//                if ("moveForward".equals(packet.getAction())) {
//                    // Implement specific forward movement logic
//                }
//                // Handle other actions similarly
//            }
//        });
//        context.setPacketHandled(true);
//    }
//
//    public String getAction() {
//        return action;
//    }
//}