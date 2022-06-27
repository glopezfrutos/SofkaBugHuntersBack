package com.sofka.bugsmanagement.model.task;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.Set;

@Getter
@Setter
public class TaskHistoryDto {

    @Id
    private String id;
    private String taskHistoryId;
    private String date;
    private String projectId;
    private String projectName;
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
