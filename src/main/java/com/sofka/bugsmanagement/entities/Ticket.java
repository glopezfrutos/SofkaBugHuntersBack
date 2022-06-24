package com.sofka.bugsmanagement.entities;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {
    private String taskId;
    private Integer id;
    private String title; //max 50 characters.
    private String description; // max 500 characters
    private LocalDate createdAt; // YYYY-MM-DD
    private LocalDate closedAt; // YYYY-MM-DD // nullable
    private String responsible;
    private String  spottedAt; //(Planificación; Análisis; Diseño; Implementación; Pruebas; Despliegue; Uso o mantenimiento).
    private List<String> proof;
    private  String severity; //(Bajo; Medio; Alto)
    private String priority; //(Bajo; Medio; Alto)
    private String importance;//(Bajo; Medio; Alto)
    private String status; // (asignado, cancelado, rechazado, cerrado con defectos, reinsidente, solucionado)
    private String conclusion;// 5000 max characters
    private String globalProblems; // 5000 max characters
    private String email;
    private String developerObservations; // 5000 max characters
}
