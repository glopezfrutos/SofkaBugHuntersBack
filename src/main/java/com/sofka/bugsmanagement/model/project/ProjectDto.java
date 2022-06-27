package com.sofka.bugsmanagement.model.project;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class ProjectDto {
    private String id;
    @NotBlank
    @Size(message= "Project name must have maximum 50 characters", max=50)
    private String name;
    private String createdAt;
    private String closedAt;

    @Valid
    @NotEmpty(message = "Emails list must not be empty")
    private Set<String> teamEmails;
    @Valid
    @NotEmpty(message = "Owners list must not be empty")
    private Set<String> owners;
    @NotBlank
    @Size(message= "Project description must have maximum 2000 characters", max=2000)
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
