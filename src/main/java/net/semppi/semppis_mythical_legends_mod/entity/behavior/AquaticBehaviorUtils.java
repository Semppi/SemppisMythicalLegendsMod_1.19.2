package net.semppi.semppis_mythical_legends_mod.entity.behavior;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.phys.Vec3;

public class AquaticBehaviorUtils {

    /**
     * Adds a water movement goal with dynamic speed adjustments.
     * @param entity The entity to which the goal is added.
     * @param defaultSpeed The normal speed on land.
     * @param waterSpeed The modified speed in water.
     */
    public static void addWaterMovementGoal(PathfinderMob entity, double defaultSpeed, double waterSpeed) {
        entity.goalSelector.addGoal(1, new WaterMovementGoal(entity, defaultSpeed, waterSpeed));
    }

    public static class WaterMovementGoal extends RandomStrollGoal {
        private final double defaultSpeed;
        private final double waterSpeed;
        private final PathfinderMob mob;

        public WaterMovementGoal(PathfinderMob mob, double defaultSpeed, double waterSpeed) {
            super(mob, defaultSpeed, 60); // Assuming a long delay (60 ticks)
            this.mob = mob;
            this.defaultSpeed = defaultSpeed;
            this.waterSpeed = waterSpeed;
        }

        @Override
        public boolean canUse() {
            if (mob.isInWater()) {
                this.mob.getNavigation().setSpeedModifier(waterSpeed);
            } else {
                this.mob.getNavigation().setSpeedModifier(defaultSpeed);
            }
            return super.canUse();
        }
    }

    /**
     * Apply a sinking behavior to entities in water.
     * @param entity The entity to apply sinking behavior.
     * @param sinkSpeed The vertical speed to sink, negative values sink down.
     */
    public static void applySinkingBehavior(Mob entity, double sinkSpeed) {
        entity.goalSelector.addGoal(1, new Goal() {
            @Override
            public boolean canUse() {
                return entity.isInWater();
            }

            @Override
            public void tick() {
                Vec3 deltaMovement = entity.getDeltaMovement();
                entity.setDeltaMovement(deltaMovement.add(0, sinkSpeed, 0));
            }
        });
    }
}