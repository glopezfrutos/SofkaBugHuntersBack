package com.sofka.bugsManagment.model;

import java.time.LocalDate;
import java.util.List;

public class TaskDTO {
    private String id;
    private String projectId;
    private String name; // max 50 characters
    private LocalDate createdAt; // YYYY-MM-DD
    private LocalDate closedAt; // YYYY-MM-DD
    private List<Tag> tags;
    private String description; // max 100 characters
    private List<Object> additionalFiles;
    private Status status; // opened - closed - blocked
    private  List<String> responsables;// emails
}
