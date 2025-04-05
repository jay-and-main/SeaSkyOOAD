package com.project.seasky.repository;

import com.project.seasky.models.TravelLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface TravelLogRepository extends MongoRepository<TravelLog, String> {
    Optional<TravelLog> findByShipmentNumberId(String shipmentNumberId);
}
