package com.sofka.bugsmanagement.model.bug;

public enum BugStatus {
    ASSIGNED("ASSIGNED"),
    CANCELED("CANCELED"),
    REJECTED("REJECTED"),
    CLOSED_WITH_DEFECTS("CLOSED_WITH_DEFECTS"),
    RECIDIVIST("RECIDIVIST"),
    SOLVED("SOLVED");

    private final String value;

    BugStatus(String value) {
        this.value = value;
    }

    public static BugStatus fromValue(String value) {
        if (value != null) {
            for (BugStatus status : values()) {
                if (status.value.equals(value)) {
                    return status;
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

    public static BugStatus getDefault() {
        return ASSIGNED;
    }
}
