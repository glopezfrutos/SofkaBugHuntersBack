package com.sofka.bugsmanagement.collections.history;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="bug-history")
public class BugHistory {

    @Id
    private String bugHistoryId;

    private String id;

    private String date;

    private String projectId;

    private String taskId;

    private String title; //max 50 characters.

    private String description; // max 500 characters

    private String createdAt; // YYYY-MM-DD

    private String responsible;

    private String contextInfo; // max 1000 characters

    private String lifecycle; //(Planificación; Análisis; Diseño; Implementación; Pruebas; Despliegue; Uso o mantenimiento).

    private String additionalFile;

    private String severity; //(Bajo; Medio; Alto)

    private String priority; //(Bajo; Medio; Alto)

    private String status; // (asignado, cancelado, rechazado, cerrado con defectos, reinsidente, solucionado)

    private String conclusion; // 5000 max characters

    private String globalIssues; // 5000 max characters

    private String references; // 5000 max characters

    private String closedAt; // YYYY-MM-DD nullable

    private String solutionResponsible;

    private String developerObservations;

    public BugHistory( String id, String date, String projectId, String taskId, String title, String description, String createdAt, String responsible, String contextInfo, String lifecycle, String additionalFile, String severity, String priority, String status, String conclusion, String globalIssues, String references, String closedAt, String solutionResponsible, String developerObservations) {
        this.id = id;
        this.date = date;
        this.projectId = projectId;
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.responsible = responsible;
        this.contextInfo = contextInfo;
        this.lifecycle = lifecycle;
        this.additionalFile = additionalFile;
        this.severity = severity;
        this.priority = priority;
        this.status = status;
        this.conclusion = conclusion;
        this.globalIssues = globalIssues;
        this.references = references;
        this.closedAt = closedAt;
        this.solutionResponsible = solutionResponsible;
        this.developerObservations = developerObservations;
    }
}
