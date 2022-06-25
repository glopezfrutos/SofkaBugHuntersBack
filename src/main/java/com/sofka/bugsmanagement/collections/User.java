package com.sofka.bugsmanagement.collections;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "user")
public class User {
    @Id
    private String id;

    private String email;

    private String role;
}
