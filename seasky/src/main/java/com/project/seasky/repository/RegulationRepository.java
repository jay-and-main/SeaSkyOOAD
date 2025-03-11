package com.project.seasky.repository;

import com.project.seasky.models.Regulation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegulationRepository extends MongoRepository<Regulation, String> {
}
