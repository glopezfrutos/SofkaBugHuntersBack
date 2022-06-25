package com.sofka.bugsmanagement.model;

public enum Role {
    ADMIN("ADMIN"), TESTER("TESTER"), DEVELOPER("DEVELOPER");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public static Role fromValue(String value) {
        if (value != null) {
            for (Role role : values()) {
                if (role.value.equals(value)) {
                    return role;
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

    public static Role getDefault() {
        return DEVELOPER;
    }
}
