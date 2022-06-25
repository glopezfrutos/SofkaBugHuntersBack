package com.sofka.bugsmanagement.model;

import com.sofka.bugsmanagement.collections.Project;
import lombok.Data;

import java.util.Set;

@Data
public class TaskDTO {

    private String id;
    private Project projectId;
    private Project projectName;
    private String name;
    private String createdAt;
    private String closedAt;
    private Set<String> tag;
    private String description;
    private String status;
    private Set<String> additionalFilesId;
    private Set<String> responsibleEmail;

}
