package com.sofka.bugsmanagement.model.dashboard;

import com.sofka.bugsmanagement.model.bug.BugStatus;
import com.sofka.bugsmanagement.model.bug.Lifecycle;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DashboardDto {

    @NotNull
    private String lifecycle;

    private String status;

    @Transient
    public Lifecycle getLifecycle() {
        return Lifecycle.fromValue(lifecycle);
    }

    public void setRole(Lifecycle lifecycle) {
        this.lifecycle = lifecycle.toValue();
    }

    @Transient
    public BugStatus getStatus() {
        return BugStatus.fromValue(status);
    }

    public void setStatus(BugStatus bugStatus) {
        this.status = bugStatus.toValue();
    }
}
