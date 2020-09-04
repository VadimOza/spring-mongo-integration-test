package com.vadym.repository;

import com.vadym.domain.SomeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SomeRepository extends MongoRepository<SomeEntity, String> {

}
