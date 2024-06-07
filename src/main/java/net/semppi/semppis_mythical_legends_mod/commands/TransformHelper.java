package net.semppi.semppis_mythical_legends_mod.commands;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.semppi.semppis_mythical_legends_mod.entity.ModEntityTypes;
import net.semppi.semppis_mythical_legends_mod.entity.TransformPlayerMount;
import net.semppi.semppis_mythical_legends_mod.entity.custom.GenericTransformationUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TransformHelper {
    private static final Map<UUID, Boolean> transformedPlayers = new ConcurrentHashMap<>();
    public static final Map<UUID, Entity> transformedEntities = new ConcurrentHashMap<>();
    private static final Set<EntityType<? extends Mob>> allowedTransformations = new HashSet<>();

    // Public static method to access transformed entities map
    public static Map<UUID, Entity> getTransformedEntities() {
        return new HashMap<>(transformedEntities);  // Return a copy to prevent external modification
    }
    private static void addAllowedTransformations() {
        allowedTransformations.add(EntityType.ZOMBIE);
        allowedTransformations.add(EntityType.COW);
        allowedTransformations.add(EntityType.SHEEP);
        allowedTransformations.add(ModEntityTypes.SATYR.get());
        allowedTransformations.add(ModEntityTypes.COLOSSALLOBSTER.get());
        allowedTransformations.add(ModEntityTypes.BEHEMOTH.get());
        allowedTransformations.add(ModEntityTypes.PUKIS.get());
        allowedTransformations.add(ModEntityTypes.MANDRAKE.get());
        allowedTransformations.add(ModEntityTypes.WENDIGO.get());
        allowedTransformations.add(ModEntityTypes.LOVELAND_FROGMAN.get());
        allowedTransformations.add(ModEntityTypes.MALPHAS.get());
        // Add other entity types as necessary...
    }

    // Static initializer block to call addAllowedTransformations at class loading
    static {
        addAllowedTransformations();
    }

    public static void initializeAllowedTransformations() {
        addAllowedTransformations();  // Ensure it's called on mod setup if needed
    }
    public static Entity transformPlayer(ServerPlayer player, String entityTypeName) {
        UUID playerId = player.getUUID();
        if (transformedPlayers.getOrDefault(playerId, false)) {
            revertTransformation(player);
            return null;
        }

        EntityType<?> rawType = EntityType.byString(entityTypeName).orElse(null);
        if (rawType == null) {
            player.displayClientMessage(Component.literal("Invalid entity type for transformation."), false);
            return null;
        }

        if (!allowedTransformations.contains(rawType)) {
            player.displayClientMessage(Component.literal("This entity type cannot be transformed into."), false);
            return null;
        }

        @SuppressWarnings("unchecked") // Safe cast after check against allowedTransformations
        EntityType<? extends Mob> entityType = (EntityType<? extends Mob>) rawType;

        TransformPlayerMount entity = new TransformPlayerMount(entityType, player.level);
        entity.moveTo(player.getX(), player.getY(), player.getZ(), player.getYRot(), player.getXRot());
        player.level.addFreshEntity(entity);
        player.startRiding(entity, true);
        player.setInvisible(true);
        player.setInvulnerable(true);

        transformedPlayers.put(playerId, true);
        transformedEntities.put(playerId, entity);

        GenericTransformationUtils.configureForPlayerControl(entity); // Apply the player control configuration

        return entity;
    }

    public static boolean isPlayerTransformed(UUID playerId) {
        return transformedPlayers.getOrDefault(playerId, false);
    }

    public static Entity getTransformedEntity(UUID playerId) {
        return transformedEntities.get(playerId);
    }

    public static void revertTransformation(ServerPlayer player) {
        UUID playerId = player.getUUID();
        if (transformedPlayers.getOrDefault(playerId, false)) {
            player.stopRiding();
            player.setInvisible(false);
            player.setInvulnerable(false);
            player.displayClientMessage(Component.literal("Transformation reverted."), true);
            Entity entity = transformedEntities.remove(playerId);
            if (entity != null) {
                entity.remove(Entity.RemovalReason.DISCARDED);
            }
            transformedPlayers.remove(playerId);
        } else {
            player.displayClientMessage(Component.literal("No transformation to revert."), false);
        }
    }
}