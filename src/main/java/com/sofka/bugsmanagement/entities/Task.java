package com.sofka.bugsmanagement.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    private Long projectId;

//    @OneToMany(
//            mappedBy = "taskId",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.EAGER
//    )
//    private List<Bug> bugList = new ArrayList<>();

    private String name; // max 50 characters
    private String createdAt; // YYYY-MM-DD
    private String closedAt; // YYYY-MM-DD

//    @OneToMany(
//            mappedBy = "taskId",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.EAGER
//    )
//    private List<Tag> tags = new ArrayList<>();

    private String description; // max 100 characters

    private String additionalFile;
//    private Enum<TaskStatus> status; // opened - closed - blocked

//    @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.EAGER
//    )
//    private List<AppUser> responsible = new ArrayList<>();
}
