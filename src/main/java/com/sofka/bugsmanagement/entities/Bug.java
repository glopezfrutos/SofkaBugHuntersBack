package com.sofka.bugsmanagement.entities;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long taskId;

    private String title; //max 50 characters.

    private String description; // max 500 characters

    private String createdAt; // YYYY-MM-DD

//    @LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<AppUser> responsible = new ArrayList<>();

    private String contextInfo; // max 1000 characters

    private Enum<Lifecycle> lifecycle; //(Planificación; Análisis; Diseño; Implementación; Pruebas; Despliegue; Uso o mantenimiento).

    private String additionalFile;

//    private Enum<Level> severity; //(Bajo; Medio; Alto)

//    private Enum<Level> priority; //(Bajo; Medio; Alto)

    private Enum<BugStatus> status; // (asignado, cancelado, rechazado, cerrado con defectos, reinsidente, solucionado)

    private String conclusion; // 5000 max characters

    private String globalIssues; // 5000 max characters

    private String references; // 5000 max characters

    private String closedAt; // YYYY-MM-DD nullable

//    @OneToOne(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.EAGER
//    )
//    private AppUser solutionResponsible;

    private String developerObservations; // 5000 max characters
}
