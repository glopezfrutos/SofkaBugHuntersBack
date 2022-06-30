package com.sofka.bugsmanagement.collections.history;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@NoArgsConstructor
@Getter
@Setter
@Document(collection="task-history")
public class TaskHistory {
    @Id
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

    public TaskHistory(String id, String date, String projectId, String projectName, String name, String createdAt, String closedAt, Set<String> tag, String description, Set<String> additionalFilesId, Set<String> responsibleEmail, String status) {
        this.taskHistoryId = id;
        this.date = date;
        this.projectId = projectId;
        this.projectName = projectName;
        this.name = name;
        this.createdAt = createdAt;
        this.closedAt = closedAt;
        this.tag = tag;
        this.description = description;
        this.additionalFilesId = additionalFilesId;
        this.responsibleEmail = responsibleEmail;
        this.status = status;
    }
}

