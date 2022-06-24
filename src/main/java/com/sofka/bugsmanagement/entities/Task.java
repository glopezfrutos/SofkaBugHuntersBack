package com.sofka.bugsmanagement.entities;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    private String id;
    private String projectId;
    private String name; // max 50 characters
    private LocalDate createdAt; // YYYY-MM-DD
    private LocalDate closedAt; // YYYY-MM-DD
    private List<?> tags;
    private String description; // max 100 characters
    private List<Object> additionalFiles;
    private var status; // opened - closed - blocked
    private  List<String> responsibles;// emails
}
