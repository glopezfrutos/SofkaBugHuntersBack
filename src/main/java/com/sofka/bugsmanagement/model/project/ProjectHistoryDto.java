package com.sofka.bugsmanagement.model.project;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.Set;

@Getter
@Setter
public class ProjectHistoryDto {

    @Id
    private String id;
    private String projectHistoryId;
    private String date;
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
