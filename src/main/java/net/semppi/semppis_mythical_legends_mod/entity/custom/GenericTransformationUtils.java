package net.semppi.semppis_mythical_legends_mod.entity.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class GenericTransformationUtils {

    private static final String TRANSFORMED_TAG = "IsTransformed";

    // Tag an entity as transformed
    public static void tagAsTransformed(LivingEntity entity) {
        entity.getPersistentData().putBoolean(TRANSFORMED_TAG, true);
    }

    // Check if an entity is tagged as transformed
    public static boolean isTransformed(LivingEntity entity) {
        return entity.getPersistentData().getBoolean(TRANSFORMED_TAG);
    }

    public static void configureForPlayerControl(Mob entity) {
        // Remove only the AI goals that affect autonomous behavior
        entity.goalSelector.getAvailableGoals().stream()
                .filter(wrappedGoal -> wrappedGoal.getGoal() instanceof Goal)
                .forEach(wrappedGoal -> entity.goalSelector.removeGoal(wrappedGoal.getGoal()));

        // Remove target selectors that are for finding targets autonomously
        entity.targetSelector.getAvailableGoals().forEach(wrappedGoal -> {
            if (wrappedGoal.getGoal() instanceof Goal) {
                entity.targetSelector.removeGoal(wrappedGoal.getGoal());
            }
        });

        // Optionally keep certain behaviors that do not interfere with player control
        // For example, if there's a goal for looking around that does not affect movement or actions
        entity.goalSelector.addGoal(1, new LookAtPlayerGoal(entity, Player.class, 8.0F));
    }

    public static void performAction(LivingEntity entity, String action) {
        if ("moveForward".equals(action)) {
            Vec3 direction = Vec3.directionFromRotation(entity.getRotationVector());
            if (direction != null) {
                entity.setDeltaMovement(entity.getDeltaMovement().add(direction.scale(0.1)));
            } else {
                System.err.println("Direction vector is null in performAction!");
            }
        }
    }

    public static void applyAttributes(LivingEntity entity, double health, float width, float height) {
        entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(health);
        // Assuming you want to handle size changes, use attribute modifiers or other means as direct size setting isn't supported.
    }

    public static boolean isBeingControlled(LivingEntity entity) {
        return entity.getControllingPassenger() != null;
    }

    public static void travelControlled(LivingEntity entity, Vec3 travelVector) {
        if (travelVector == null) {
            System.err.println("Travel vector is null in travelControlled!");
            return;
        }
        if (isBeingControlled(entity)) {
            entity.travel(travelVector);
            // You may need to simulate rotation changes here if necessary by adjusting entity heading based on controller.
        } else {
            entity.travel(travelVector);
        }
    }
}