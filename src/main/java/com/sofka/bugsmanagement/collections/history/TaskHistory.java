package com.sofka.bugsmanagement.collections.history;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="task-history")
public class TaskHistory {
    @Id
    private String taskHistoryId;
    private String id;
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
}

