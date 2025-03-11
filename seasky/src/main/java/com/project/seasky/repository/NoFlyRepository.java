package com.project.seasky.repository;

import com.project.seasky.models.NoFly;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoFlyRepository extends MongoRepository<NoFly, String> {
}
