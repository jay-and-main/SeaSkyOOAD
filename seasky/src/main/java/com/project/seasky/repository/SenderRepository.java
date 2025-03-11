package com.project.seasky.repository;

import com.project.seasky.models.Sender;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SenderRepository extends MongoRepository<Sender, String> {
}
