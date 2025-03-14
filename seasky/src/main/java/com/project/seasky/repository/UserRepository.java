package com.project.seasky.repository;

import com.project.seasky.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {  
    Optional<User> findByEmail(String email);  
}