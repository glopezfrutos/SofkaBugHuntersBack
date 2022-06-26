package com.sofka.bugsmanagement.model.task;

import com.sofka.bugsmanagement.collections.Project;
import lombok.Data;

import org.springframework.data.annotation.Transient;
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
    private Set<String> additionalFilesId;
    private Set<String> responsibleEmail;
    private String status;

    @Transient
    public TaskStatus getStatus() {return TaskStatus.fromValue(status);}

    public void setStatus(TaskStatus status) {this.status= status.toValue();}
}
