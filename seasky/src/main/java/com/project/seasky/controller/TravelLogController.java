package com.project.seasky.controller;

import com.project.seasky.models.TravelLog;
import com.project.seasky.repository.TravelLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/travellogs")
public class TravelLogController {
    
    @Autowired
    private TravelLogRepository travelLogRepository;

    @PostMapping("/create")
    public TravelLog createTravelLog(@RequestBody TravelLog travelLog) {
        return travelLogRepository.save(travelLog);
    }

    @GetMapping("/all")
    public List<TravelLog> getAllTravelLogs() {
        return travelLogRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TravelLog> getTravelLogById(@PathVariable String id) {
        return travelLogRepository.findById(id);
    }

    @PutMapping("/{id}")
    public TravelLog updateTravelLog(@PathVariable String id, @RequestBody TravelLog updateTravelLog){
        return travelLogRepository.findById(id).map(travellog -> {
            travellog.setTravelStatus(updateTravelLog.getTravelStatus());
            return travelLogRepository.save(travellog);
        }).orElseThrow(() -> new RuntimeException("TravelLog not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteTravelLog(@PathVariable String id) {
        travelLogRepository.deleteById(id);
        return "TravelLog with ID " + id + " deleted successfully.";
    }
}
