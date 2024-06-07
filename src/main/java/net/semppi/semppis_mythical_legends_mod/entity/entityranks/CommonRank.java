package net.semppi.semppis_mythical_legends_mod.entity.entityranks;

import java.util.List;

public class CommonRank extends CreatureRank {
    private static final int[] POINTS_THRESHOLDS = {-600, -300, -215, -120, -55, 0, 55, 120, 215, 300, 600};

    public CommonRank() {
        super("Common", POINTS_THRESHOLDS, 1); // `1` might represent a difficulty or other rank-specific parameter
    }

    @Override
    protected String getStatusLabel(int index) {
        switch (index) {
            case 0: return "Ferocious";
            case 1: return "Aggressive";
            case 2: return "Hostile";
            case 3: return "Unfriendly";
            case 4: return "Distrustful";
            case 5: return "Neutral";
            case 6: return "Docile";
            case 7: return "Friendly";
            case 8: return "Trusting";
            case 9: return "Tamed";
            case 10: return "Loyal";
            default: return "Unknown";
        }
    }

    @Override
    public int calculatePointsChange(String actionType, List<String> personalityTraits) {
        // Define base points change values
        int basePointsChange;
        switch (actionType) {
            case "feed":
                basePointsChange = 10;  // Example value
                break;
            case "hit":
                basePointsChange = -15;  // Example value
                break;
            default:
                return 0;
        }

        // Apply personality trait modifiers
        for (String trait : personalityTraits) {
            switch (trait) {
                case "playful":
                    basePointsChange += (actionType.equals("feed") ? 2 : -2);
                    break;
                case "mischievous":
                    basePointsChange += (actionType.equals("hit") ? -3 : 1);
                    break;
            }
        }

        return basePointsChange;
    }
}