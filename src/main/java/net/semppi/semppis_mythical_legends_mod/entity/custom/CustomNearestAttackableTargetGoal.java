package net.semppi.semppis_mythical_legends_mod.entity.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;

public class CustomNearestAttackableTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
    private final float aggroRange;

    public CustomNearestAttackableTargetGoal(BehemothEntity behemoth, Class<T> targetClass, boolean checkVisibility, boolean checkCanNavigate, float aggroRange) {
        super(behemoth, targetClass, 0, checkVisibility, checkCanNavigate, null);
        this.aggroRange = aggroRange;
    }

    @Override
    protected double getFollowDistance() {
        return aggroRange * aggroRange;
    }
}