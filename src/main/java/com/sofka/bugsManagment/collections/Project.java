package com.sofka.bugsManagment.collections;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "project")

public class Project {
    private String mongoId;
    private Integer id;
    private String name;
    private LocalDate createdAt;
    private LocalDate closedAt;
    private String emails;
    private List<Object> owners;
    private String description;
    private List<Object> tasksList;
}
