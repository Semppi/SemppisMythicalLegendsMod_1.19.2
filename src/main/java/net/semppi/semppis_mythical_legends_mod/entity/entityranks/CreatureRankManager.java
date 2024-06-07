package net.semppi.semppis_mythical_legends_mod.entity.entityranks;

import net.minecraft.world.entity.EntityType;
import java.util.HashMap;
import java.util.Map;

public class CreatureRankManager {
    private static final Map<EntityType<?>, CreatureRank> rankRegistry = new HashMap<>();

    public static void registerRank(EntityType<?> entityType, CreatureRank rank) {
        rankRegistry.put(entityType, rank);
    }

    public static CreatureRank getRankForEntity(EntityType<?> entityType) {
        return rankRegistry.getOrDefault(entityType, null); // Return null or a default rank as needed
    }
}