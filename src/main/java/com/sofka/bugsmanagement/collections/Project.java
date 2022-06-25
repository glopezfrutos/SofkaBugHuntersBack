package com.sofka.bugsmanagement.collections;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "project")
public class Project {
    @Id
    private String id;
    private String name;
    private String createdAt;
    private String closedAt;
    private Set<String> teamEmails;
    private Set<String> owners;
    private String description;
    private String status;
}
