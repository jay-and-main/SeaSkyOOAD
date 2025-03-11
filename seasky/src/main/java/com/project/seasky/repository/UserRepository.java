package com.project.seasky.repository;

import com.project.seasky.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {    
}