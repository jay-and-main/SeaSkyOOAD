package com.project.seasky.repository;

import com.project.seasky.models.Receiver;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReceiverRepository extends MongoRepository<Receiver, String>{
}
