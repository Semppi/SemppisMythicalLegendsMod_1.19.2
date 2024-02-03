package net.semppi.semppis_mythical_legends_mod.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum PukisVariant {
    DARK(0),
    JADE(1);

    private static final PukisVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(PukisVariant::getId)).toArray(PukisVariant[]::new);
    private final int id;

    PukisVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static PukisVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}