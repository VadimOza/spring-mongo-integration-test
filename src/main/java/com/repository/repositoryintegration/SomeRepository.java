package com.repository.repositoryintegration;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SomeRepository extends MongoRepository<SomeEntity, String> {

}
