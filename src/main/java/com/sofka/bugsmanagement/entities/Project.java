package com.sofka.bugsmanagement.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

//    @LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<AppUser> teamMembers = new ArrayList<>();

//    @LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//
//    private List<AppUser> owners = new ArrayList<>();

    private String description;


    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(
            mappedBy = "projectId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Task> tasksList = new ArrayList<>();

    private Enum<ProjectStatus> status;
}
