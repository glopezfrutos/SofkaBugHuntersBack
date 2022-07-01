package com.sofka.bugsmanagement.collections.history;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
@Data
@NoArgsConstructor
@Getter
@Setter
@Document(collection="project-history")

public class ProjectHistory {
    @Id
    private String projectHistoryId;
    private String date;
    private String name;
    private String createdAt;
    private String closedAt;
    private Set<String> teamEmails;
    private Set<String> owners;
    private String description;
    private String status;

    public ProjectHistory(String id, String date, String name, String createdAt, String closedAt, Set<String> teamEmails, Set<String> owners, String description, String status) {
        this.projectHistoryId = id;
        this.date = date;
        this.name = name;
        this.createdAt = createdAt;
        this.closedAt = closedAt;
        this.teamEmails = teamEmails;
        this.owners = owners;
        this.description = description;
        this.status = status;
    }

}

