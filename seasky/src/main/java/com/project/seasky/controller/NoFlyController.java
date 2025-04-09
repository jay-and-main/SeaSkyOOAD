package com.project.seasky.controller;

import com.project.seasky.models.NoFly;
import com.project.seasky.repository.NoFlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/nofly")
public class NoFlyController {
    
    @Autowired
    private NoFlyRepository noFlyRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addToNoFly(@RequestBody NoFly noFly) {
        try {
            // Check if passport already exists in no-fly list
            if (noFlyRepository.existsByPassportNumber(noFly.getPassportNumber())) {
                Map<String, String> response = new HashMap<>();
                response.put("error", "This passport number is already in the no-fly list");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
            }
            
            NoFly savedNoFly = noFlyRepository.save(noFly);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedNoFly);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Failed to add to no-fly list: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchByPassport(@RequestParam String passportNumber) {
        try {
            Optional<NoFly> noFly = noFlyRepository.findByPassportNumber(passportNumber);
            if (noFly.isPresent()) {
                return ResponseEntity.ok(noFly.get());
            } else {
                Map<String, String> response = new HashMap<>();
                response.put("message", "Passport number not found in no-fly list");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Error searching the no-fly list: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllNoFlies() {
        try {
            List<NoFly> noFlies = noFlyRepository.findAll();
            return ResponseEntity.ok(noFlies);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Error retrieving no-fly list: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/check")
    public ResponseEntity<?> checkPassport(@RequestParam String passportNumber) {
        try {
            boolean isOnNoFlyList = noFlyRepository.existsByPassportNumber(passportNumber);
            Map<String, Object> response = new HashMap<>();
            response.put("isOnNoFlyList", isOnNoFlyList);
            
            if (isOnNoFlyList) {
                Optional<NoFly> noFly = noFlyRepository.findByPassportNumber(passportNumber);
                if (noFly.isPresent()) {
                    response.put("reason", noFly.get().getReason());
                }
            }
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Error checking no-fly list: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeFromNoFly(@PathVariable String id) {
        try {
            if (!noFlyRepository.existsById(id)) {
                Map<String, String> response = new HashMap<>();
                response.put("error", "No-fly entry not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            
            noFlyRepository.deleteById(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Successfully removed from no-fly list");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Failed to remove from no-fly list: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
