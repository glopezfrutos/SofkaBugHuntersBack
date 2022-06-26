package com.sofka.bugsmanagement.model.bug;

public enum Level {
HIGH("HIGH"),
    MID("MID"),
    LOW("LOW");

    private final String value;

    Level(String value) {
        this.value = value;
    }

    public static Level fromValue(String value) {
        if (value != null) {
            for (Level level : values()) {
                if (level.value.equals(value)) {
                    return level;
                }
            }
        }
        // you may return a default value
        return getDefault();
        // or throw an exception
        // throw new IllegalArgumentException("Invalid color: " + value);
    }

    public String toValue() {
        return value;
    }

    public static Level getDefault() {
        return LOW;
    }
}
