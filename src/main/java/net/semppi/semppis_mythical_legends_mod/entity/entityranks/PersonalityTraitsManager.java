package net.semppi.semppis_mythical_legends_mod.entity.entityranks;

import net.minecraft.world.entity.EntityType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonalityTraitsManager {
    private static final Map<EntityType<?>, List<String>> personalityTraitsMap = new HashMap<>();

    // Method to assign personality traits to a specific entity type
    public static void assignTraits(EntityType<?> entityType, List<String> traits) {
        personalityTraitsMap.put(entityType, traits);
    }

    // Method to retrieve the personality traits of a specific entity type
    public static List<String> getTraits(EntityType<?> entityType) {
        return personalityTraitsMap.getOrDefault(entityType, List.of()); // Returns an empty list if no traits are found
    }
}