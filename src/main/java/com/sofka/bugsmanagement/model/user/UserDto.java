package com.sofka.bugsmanagement.model.user;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.util.UUID;

@Data
public class UserDto {
    private String id;

    private String email;

    private String role;
    private  boolean enabled;
    private String sessionId = UUID.randomUUID().toString();

    @Transient
    public Role getRole() {
        return Role.fromValue(role);
    }

    public void setRole(Role role) {
        this.role = role.toValue();
    }
}
