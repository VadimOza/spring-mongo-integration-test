package com.repository.repositoryintegration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class SomeRepositoryTest extends TestApplication {

    @Autowired
    private SomeRepository repository;

    @Test
    void save_entity_test() {
        assertThat(repository.save(new SomeEntity())).isNotNull();
        assertThat(repository.findAll().size()).isEqualTo(1);
    }

}