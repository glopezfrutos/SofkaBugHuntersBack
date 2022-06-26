package com.sofka.bugsmanagement.model.bug;

public enum Lifecycle {
    PLANNING("PLANNING"),
    ANALYSIS("ANALYSIS"),
    DESIGN("DESIGN"),
    EXECUTION("EXECUTION"),
    TEST("TEST"),
    DEPLOY("DEPLOY"),
    MAINTENANCE("MAINTENANCE");

    private final String value;

    Lifecycle(String value) {
        this.value = value;
    }

    public static Lifecycle fromValue(String value) {
        if (value != null) {
            for (Lifecycle lifecycle : values()) {
                if (lifecycle.value.equals(value)) {
                    return lifecycle;
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

    public static Lifecycle getDefault() {
        return PLANNING;
    }

}
