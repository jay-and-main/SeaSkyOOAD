package com.project.seasky.repository;

import com.project.seasky.models.Good;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GoodRepository extends MongoRepository<Good, String>{
}
