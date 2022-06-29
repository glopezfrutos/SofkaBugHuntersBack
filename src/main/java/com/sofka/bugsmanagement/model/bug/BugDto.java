package com.sofka.bugsmanagement.model.bug;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class BugDto {
    private String id;

    private String projectId;
    private String taskId;
    @NotNull
    @Size(message= "Bug title must have maximum 50 characters", max=50)
    private String title; //max 50 characters.
    @NotNull
    @Size(message= "Bug description must have maximum 500 characters", max=500)
    private String description; // max 500 characters
    private String createdAt; // YYYY-MM-DD
    @Valid
    @NotEmpty(message = "Responsible must not be empty")
    private String responsible;
    @NotNull
    @Size(message= "Bug contextInfo must have maximum 1000 characters", max=1000)
    private String contextInfo; // max 1000 characters
    @NotNull
    private String lifecycle; //(Planificación; Análisis; Diseño; Implementación; Pruebas; Despliegue; Uso o mantenimiento).
    @NotNull
    private String additionalFile;
    private String severity; //(Bajo; Medio; Alto)
    private String priority; //(Bajo; Medio; Alto)

    private String clientImportance; //(Bajo; Medio; Alto)
    private String status; // (asignado, cancelado, rechazado, cerrado con defectos, reinsidente, solucionado)
    @NotNull
    @Size(message= "Bug conclusion must have maximum 5000 characters", max=5000)
    private String conclusion; // 5000 max characters
    @NotNull
    @Size(message= "Bug global issues must have maximum 5000 characters", max=5000)
    private String globalIssues; // 5000 max characters
    @NotNull
    @Size(message= "Bug references must have maximum 5000 characters", max=5000)
    private String references; // 5000 max characters
    @NotNull
    private String closedAt; // YYYY-MM-DD nullable
    @NotNull
    private String solutionResponsible;
    @Size(message= "Bug developer observations must have maximum 5000 characters", max=5000)
    private String developerObservations; // 5000 max characters

    @Transient
    public Lifecycle getLifecycle() {
        return Lifecycle.fromValue(lifecycle);
    }

    public void setRole(Lifecycle lifecycle) {
        this.lifecycle = lifecycle.toValue();
    }

    @Transient
    public Level getSeverity() {
        return Level.fromValue(severity);
    }

    public void setSeverity(Level level) {
        this.severity = level.toValue();
    }

    @Transient
    public Level getPriority() {
        return Level.fromValue(priority);
    }

    public void setPriority(Level level) {
        this.priority = level.toValue();
    }

    @Transient
    public Level getClientImportance() {
        return Level.fromValue(clientImportance);
    }

    public void setClientImportance(Level level) {
        this.clientImportance = level.toValue();
    }

    @Transient
    public BugStatus getStatus() {
        return BugStatus.fromValue(status);
    }

    public void setStatus(BugStatus bugStatus) {
        this.status = bugStatus.toValue();
    }
}
