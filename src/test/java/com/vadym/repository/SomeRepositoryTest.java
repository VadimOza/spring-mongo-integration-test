package com.vadym.repository;

import com.vadym.domain.SomeEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class SomeRepositoryTest extends BaseMongoTest {

    @Autowired
    private SomeRepository repository;

    @Test
    void save_entity_test() {
        assertThat(repository.save(new SomeEntity())).isNotNull();
        assertThat(repository.findAll().size()).isEqualTo(1);
    }

}