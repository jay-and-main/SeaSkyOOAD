package com.project.seasky.repository;

import com.project.seasky.models.TravelLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TravelLogRepository extends MongoRepository<TravelLog, String> {
}
