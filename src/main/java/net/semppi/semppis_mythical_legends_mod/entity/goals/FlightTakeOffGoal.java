package net.semppi.semppis_mythical_legends_mod.entity.goals;

import net.minecraft.world.entity.ai.goal.Goal;
import net.semppi.semppis_mythical_legends_mod.entity.custom.PukisEntity;

import java.util.EnumSet;

//public class FlightTakeOffGoal extends Goal {
//    private final PukisEntity pukis;
//
//    public FlightTakeOffGoal(PukisEntity pukis) {
//        this.pukis = pukis;
//        setFlags(EnumSet.of(Goal.Flag.MOVE));
//    }
//
//    @Override
//    public boolean canUse() {
//        return pukis.getCurrentState() == PukisEntity.State.WALKING;
//    }
//
//    @Override
//    public void start() {
//        pukis.changeState(PukisEntity.State.FLYING);
//    }
//}