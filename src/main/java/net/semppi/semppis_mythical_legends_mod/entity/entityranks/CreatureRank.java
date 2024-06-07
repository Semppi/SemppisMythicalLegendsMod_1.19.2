package net.semppi.semppis_mythical_legends_mod.entity.entityranks;

import java.util.List;

public abstract class CreatureRank {
    protected String rankName;
    protected int[] pointsThresholds;
    protected int tamingDifficulty;

    public CreatureRank(String rankName, int[] pointsThresholds, int tamingDifficulty) {
        this.rankName = rankName;
        this.pointsThresholds = pointsThresholds;
        this.tamingDifficulty = tamingDifficulty;
    }

    public String determineStatus(int points) {
        for (int i = 0; i < pointsThresholds.length; i++) {
            if (points < pointsThresholds[i]) {
                return getStatusLabel(i);
            }
        }
        return "Unknown";
    }

    protected abstract String getStatusLabel(int index);

    public abstract int calculatePointsChange(String actionType, List<String> personalityTraits);
}