package net.semppi.semppis_mythical_legends_mod.entity.goals;

import net.minecraft.world.entity.ai.goal.Goal;
import net.semppi.semppis_mythical_legends_mod.entity.custom.PukisEntity;

//public class FlightLandGoal extends Goal {
//    private final PukisEntity pukis;
//
//    public FlightLandGoal(PukisEntity pukis) {
//        this.pukis = pukis;
//    }
//
//    @Override
//    public boolean canUse() {
//        return pukis.getCurrentState() == PukisEntity.State.FLYING && shouldLand();
//    }
//
//    @Override
//    public void start() {
//        pukis.changeState(PukisEntity.State.WALKING);
//    }
//
//    private boolean shouldLand() {
//        // Define your landing condition logic here
//        return true;
//    }
//}