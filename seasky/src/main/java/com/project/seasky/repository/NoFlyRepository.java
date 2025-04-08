package com.project.seasky.repository;

import com.project.seasky.models.NoFly;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoFlyRepository extends MongoRepository<NoFly, String> {
    Optional<NoFly> findByPassportNumber(String passportNumber);
    boolean existsByPassportNumber(String passportNumber);
}
