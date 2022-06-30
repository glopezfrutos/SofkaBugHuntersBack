package com.sofka.bugsmanagement.model.history;

import com.sofka.bugsmanagement.model.project.ProjectStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class ProjectHistoryDto {
    @Transient
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    @Id
    private String projectHistoryId;
    private String id;
    private String date = dateFormat.format(new Date());
    private String name;
    private String createdAt;
    private String closedAt;
    private Set<String> teamEmails;
    private Set<String> owners;
    private String description;
    private String status;
    @Transient
    public ProjectStatus getStatus() {
        return ProjectStatus.fromValue(status);
    }

    public void setStatus(ProjectStatus projectStatus) {
        this.status = projectStatus.toValue();
    }

}
