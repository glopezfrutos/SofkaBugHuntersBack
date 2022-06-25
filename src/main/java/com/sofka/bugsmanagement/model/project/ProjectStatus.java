package com.sofka.bugsmanagement.model.project;

public enum ProjectStatus {
    CREATED("CREATED"), ACTIVE("ACTIVE"), PAUSED("PAUSED"), FINISHED("FINISHED");
    private final String value;
    ProjectStatus(String value) {
        this.value = value;
    }

    public static ProjectStatus fromValue(String value) {
        if (value != null) {
            for (ProjectStatus projectStatus : values()) {
                if (projectStatus.value.equals(value)) {
                    return projectStatus;
                }
            }
        }
        return getDefault();
    }
    public String toValue() {
        return value;
    }

    public static ProjectStatus getDefault() {
        return CREATED;
    }
}
