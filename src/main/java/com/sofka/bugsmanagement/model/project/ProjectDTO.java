package com.sofka.bugsmanagement.model.project;

import lombok.Data;
import org.springframework.data.annotation.Transient;

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

    @Transient
    public ProjectStatus getStatus() {
        return ProjectStatus.fromValue(status);
    }

    public void setStatus(ProjectStatus projectStatus) {
        this.status = projectStatus.toValue();
    }
}
