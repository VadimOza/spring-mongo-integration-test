package com.repository.repositoryintegration;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("some")
public class SomeEntity {
    @Id
    private String id;
    private String name;
}
