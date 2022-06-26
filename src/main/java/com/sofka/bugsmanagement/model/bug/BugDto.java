package com.sofka.bugsmanagement.model.bug;

import com.sofka.bugsmanagement.model.user.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import java.util.Set;

@Getter
@Setter
public class BugDto {
    private String id;

    private String projectId;

    private String taskId;

    private String title; //max 50 characters.

    private String description; // max 500 characters

    private String createdAt; // YYYY-MM-DD

    private Set<String> responsible;

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
    public BugStatus getStatus() {
        return BugStatus.fromValue(status);
    }

    public void setStatus(BugStatus bugStatus) {
        this.status = bugStatus.toValue();
    }
}
