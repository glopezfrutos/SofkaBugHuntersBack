package com.sofka.bugsmanagement.entities;

import lombok.*;
import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
