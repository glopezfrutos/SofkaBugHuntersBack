package com.sofka.bugsmanagement.model.project;

import com.sofka.bugsmanagement.model.task.TaskDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class ProjectDetailsDto {
    private String id;
    private String name;
    private String createdAt;
    private String closedAt;
    private Set<String> teamEmails;
    private Set<String> owners;
    private String description;
    private String status;
    private List<TaskDTO> tasks = new ArrayList<>();

    public ProjectStatus getStatus() {
        return ProjectStatus.fromValue(status);
    }

    public void setStatus(ProjectStatus projectStatus) {
        this.status = projectStatus.toValue();
    }
}
