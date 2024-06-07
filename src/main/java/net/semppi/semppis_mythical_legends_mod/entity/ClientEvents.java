package net.semppi.semppis_mythical_legends_mod.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.semppi.semppis_mythical_legends_mod.network.JumpPacket;
import net.semppi.semppis_mythical_legends_mod.network.NetworkSetup;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = "semppis_mythical_legends_mod")
public class ClientEvents {
    public static final KeyMapping CROUCH_KEY = new KeyMapping("key.semppis_mythical_legends_mod.crouch", GLFW.GLFW_KEY_C, "key.categories.gameplay");

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(CROUCH_KEY);
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (Minecraft.getInstance().player != null) {
            Player player = Minecraft.getInstance().player;

            if (player.getVehicle() instanceof TransformPlayerMount) {
                TransformPlayerMount mount = (TransformPlayerMount) player.getVehicle();
                mount.controlEntity(player);
            }
        }
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (Minecraft.getInstance().player == null) return;

        // Example using key mapping; you need to define a KeyMapping for the crouch action
        if (CROUCH_KEY.consumeClick()) {
            if (Minecraft.getInstance().player.getVehicle() instanceof TransformPlayerMount) {
                CrouchPacket packet = new CrouchPacket();
                NetworkSetup.NETWORK.sendToServer(packet);
                event.setCanceled(true); // Cancel the dismount action
            }
        }

        // Handle jump
        if (Minecraft.getInstance().options.keyJump.consumeClick()) {
            if (Minecraft.getInstance().player.getVehicle() instanceof TransformPlayerMount) {
                JumpPacket packet = new JumpPacket();
                NetworkSetup.NETWORK.sendToServer(packet);
            }
        }
    }
}