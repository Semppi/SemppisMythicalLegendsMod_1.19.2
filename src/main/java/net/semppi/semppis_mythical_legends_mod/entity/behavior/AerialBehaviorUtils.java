package net.semppi.semppis_mythical_legends_mod.entity.behavior;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.util.RandomPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.semppi.semppis_mythical_legends_mod.entity.custom.PukisEntity;

import java.util.EnumSet;
import java.util.Random;

//public class AerialBehaviorUtils {
//
//    public static void enableFlyingAbilities(Mob entity) {
//        if (entity instanceof PathfinderMob && entity instanceof FlyingEntityInterface && ((FlyingEntityInterface) entity).canFly()) {
//            entity.getNavigation().stop();
//            entity.getNavigation().setCanFloat(true);
//            ((FlyingEntityInterface) entity).setMoveControl(new FlyingMoveControl(entity, 10, true));
//        }
//    }
//
//    public interface FlyingEntityInterface {
//        void setMoveControl(MoveControl control);
//        boolean canFly();
//    }
//
//    // General method to set MoveControl, checks if entity has a specific setMoveControl method
//    private static void setFlyingMoveControl(Mob entity, int adjustmentTicks, boolean canLand) {
//        if (entity instanceof PukisEntity.FlyingEntityInterface) {  // Assume there's an interface for flying entities
//            ((PukisEntity.FlyingEntityInterface) entity).setMoveControl(new FlyingMoveControl(entity, adjustmentTicks, canLand));
//        }
//    }
//
//    // Adding flying goals
//    public static void addFlyingGoals(Mob entity) {
//        if (entity instanceof PathfinderMob && canFly(entity)) {
//            PathfinderMob mob = (PathfinderMob) entity;
//            mob.goalSelector.addGoal(1, new FlyingWanderGoal(mob, 1.0));
//            mob.goalSelector.addGoal(2, new LookAtPlayerGoal(mob, Player.class, 8.0F));
//        }
//    }
//
//    // Custom MoveControl for flying entities
//    public static class FlyingMoveControl extends MoveControl {
//        private final boolean canLand;
//
//        public FlyingMoveControl(Mob entity, int adjustmentTicks, boolean canLand) {
//            super(entity);
//            this.canLand = canLand;
//        }
//
//        @Override
//        public void tick() {
//            // Implement custom flying logic here, possibly handling 'canLand'
//        }
//    }
//
//    // Flying wander goal
//    public static class FlyingWanderGoal extends Goal {
//        protected final PathfinderMob mob;
//        protected double x;
//        protected double y;
//        protected double z;
//        protected final double speedModifier;
//
//        public FlyingWanderGoal(PathfinderMob creature, double speed) {
//            this.mob = creature;
//            this.speedModifier = speed;
//            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
//        }
//
//        @Override
//        public boolean canUse() {
//            if (mob.isVehicle() || !canFly(mob)) {
//                return false;
//            }
//            return getRandomPosition();
//        }
//
//        // Custom method to find a random air position
//        // Custom method to find a random air position
//        private boolean getRandomPosition() {
//            RandomSource random = mob.getRandom();
//            Level level = mob.level;
//            BlockPos currentPos = mob.blockPosition();
//
//            // Try to find an air position within a range
//            for (int i = 0; i < 10; i++) {  // Try multiple times to find a valid position
//                int x = random.nextInt(21) - 10 + currentPos.getX();  // Generate a random offset between -10 and 10
//                int y = random.nextInt(15) - 7 + currentPos.getY();   // Generate a random offset between -7 and 7
//                int z = random.nextInt(21) - 10 + currentPos.getZ();
//
//                BlockPos targetPos = new BlockPos(x, y, z);
//                if (level.isEmptyBlock(targetPos)) {  // Check if the block at the position is air
//                    this.x = targetPos.getX() + 0.5;  // Center the position
//                    this.y = targetPos.getY() + 0.5;
//                    this.z = targetPos.getZ() + 0.5;
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        @Override
//        public boolean canContinueToUse() {
//            return !mob.getNavigation().isDone();
//        }
//
//        @Override
//        public void start() {
//            mob.getNavigation().moveTo(this.x, this.y, this.z, this.speedModifier);
//        }
//    }
//
//    // Check if the entity can fly based on its status
//    private static boolean canFly(Mob entity) {
//        if (entity instanceof PukisEntity.FlyingEntityInterface) {
//            return ((PukisEntity.FlyingEntityInterface) entity).canFly();
//        }
//        return false;
//    }
//}