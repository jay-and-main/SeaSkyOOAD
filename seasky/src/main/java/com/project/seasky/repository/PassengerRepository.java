package com.project.seasky.repository;

import com.project.seasky.models.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassengerRepository extends MongoRepository<Passenger, String>{
}
