package com.sofka.bugsmanagement.model.task;

import com.sofka.bugsmanagement.collections.Task;
import lombok.Data;

import org.springframework.data.annotation.Transient;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class TaskDTO {


    @Size(message="Task ID must have 50 characters as maximum", max=50)
    private String id;

    private String projectId;
    private String projectName;

    @NotBlank
    @Size(message="Task name must have 50 characters as maximum", max=50)
    private String name;
    private String createdAt;
    private String closedAt;
    private Set<String> tag;

    @NotBlank
    @Size(message="Task description must have 100 characters as maximum", max=100)
    private String description;

    @Valid
    @NotEmpty(message="Additional Filed must not be empty")
    private Set<String> additionalFilesId;

    @Valid
    @NotEmpty(message="Additional Filed must not be empty")
    private Set<String> responsibleEmail;
    private String status;

    @Transient
    public TaskStatus getStatus() {return TaskStatus.fromValue(status);}

    public void setStatus(TaskStatus status) {this.status= status.toValue();}
}
