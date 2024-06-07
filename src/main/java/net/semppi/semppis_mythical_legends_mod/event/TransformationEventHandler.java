package net.semppi.semppis_mythical_legends_mod.event;

import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fml.common.Mod;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;
import net.semppi.semppis_mythical_legends_mod.commands.TransformHelper;

import java.util.HashMap;
import java.util.UUID;
import java.util.Map;

@Mod.EventBusSubscriber(modid = SemppisMythicalLegendsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TransformationEventHandler {

    @SubscribeEvent
    public void onLivingDeath(LivingDeathEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof ServerPlayer) {
            ServerPlayer player = (ServerPlayer) entity;
            UUID playerUUID = player.getUUID();
            if (TransformHelper.isPlayerTransformed(playerUUID)) {
                Entity transformedEntity = TransformHelper.getTransformedEntity(playerUUID);
                if (transformedEntity != null) {
                    transformedEntity.remove(Entity.RemovalReason.DISCARDED);
                }
                TransformHelper.revertTransformation(player);
                player.displayClientMessage(Component.literal("Your transformation has been reverted due to death."), true);
            }
        } else {
            UUID ownerUUID = findOwnerOfTransformedEntity(entity);
            if (ownerUUID != null) {
                ServerPlayer owner = (ServerPlayer) entity.getServer().getPlayerList().getPlayer(ownerUUID);
                if (owner != null && TransformHelper.isPlayerTransformed(ownerUUID)) {
                    owner.hurt(DamageSource.GENERIC, Float.MAX_VALUE);
                    TransformHelper.revertTransformation(owner);
                    owner.displayClientMessage(Component.literal("Your transformation entity has died, and you have been reverted."), true);
                }
            }
        }
    }

    private UUID findOwnerOfTransformedEntity(Entity transformedEntity) {
        for (Map.Entry<UUID, Entity> entry : TransformHelper.getTransformedEntities().entrySet()) {
            if (entry.getValue().equals(transformedEntity)) {
                return entry.getKey();
            }
        }
        return null;
    }
}