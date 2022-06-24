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
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String createdAt;
    private String closedAt;

    @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<AppUser> teamMembers = new ArrayList<>();

//    @OneToMany(
////            cascade = CascadeType.ALL,
////            orphanRemoval = true,
//            fetch = FetchType.EAGER
//    )
//    private List<AppUser> owners = new ArrayList<>();

    private String description;


    @OneToMany(
//            mappedBy = "projectId",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Task> tasksList = new ArrayList<>();

//    private Enum<ProjectStatus> status;
}
