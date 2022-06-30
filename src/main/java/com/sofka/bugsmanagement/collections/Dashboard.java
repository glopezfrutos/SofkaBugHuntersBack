package com.sofka.bugsmanagement.collections;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "dashboard")
public class Dashboard {

    private String id;

    private String lifecycle;

    private String status;

    private String date;

}
