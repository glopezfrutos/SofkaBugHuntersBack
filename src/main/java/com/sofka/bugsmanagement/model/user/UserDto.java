package com.sofka.bugsmanagement.model.user;

import lombok.Data;
import org.springframework.data.annotation.Transient;

@Data
public class UserDto {
    private String id;

    private String email;

    private String role;

    @Transient
    public Role getRole() {
        return Role.fromValue(role);
    }

    public void setRole(Role role) {
        this.role = role.toValue();
    }
}
