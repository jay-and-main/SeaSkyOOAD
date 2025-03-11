package com.project.seasky.controller;

import com.project.seasky.models.Passenger;
import com.project.seasky.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    
    @Autowired
    private PassengerRepository passengerRepository;

    @PostMapping("/create")
    public Passenger creatPassenger(@RequestBody Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @GetMapping("/all")
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Passenger> getPassengerById(@PathVariable String id) {
        return passengerRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deletePassenger(@PathVariable String id) {
        passengerRepository.deleteById(id);
        return "Passenger with ID " + id + " deleted successfully.";
    }
}
