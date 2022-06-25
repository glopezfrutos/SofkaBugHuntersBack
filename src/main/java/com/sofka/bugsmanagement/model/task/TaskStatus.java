package com.sofka.bugsmanagement.model.task;

public enum TaskStatus {
    OPENED("OPENED") , CLOSED("CLOSED"), BLOCKED("BLOCKED");

    private final String value;

    TaskStatus(String value) {this.value=value;}

    public static TaskStatus fromValue(String value) {
        if (value!=null) {
            for (TaskStatus status : values()) {
                if (status.value.equals(value)){
                    return status;
                }
            }
        }
        return getDefault();
    }

    public String toValue() { return value;}

    public static TaskStatus getDefault() { return OPENED; }
}
