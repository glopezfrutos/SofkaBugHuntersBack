package com.sofka.bugsmanagement.model;

import com.sofka.bugsmanagement.collections.ProjectStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class ProjectDTO {
    private String id;
    private String name;
    private String createdAt;
    private String closedAt;
    private Set<String> teamEmails;
    private Set<String> owners;
    private String description;
    private String status;
}
