package com.project.seasky.controller;

import com.project.seasky.models.Receiver;
import com.project.seasky.repository.ReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receivers")
public class ReceiverController {
    
    @Autowired
    private ReceiverRepository receiverRepository;

    @PostMapping("/create")
    public Receiver createReceiver(@RequestBody Receiver receiver) {
        return receiverRepository.save(receiver);
    }

    @GetMapping("/all")
    public List<Receiver> getAllReceivers() {
        return receiverRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Receiver> getReceiverById(@PathVariable String id) {
        return receiverRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteReceiver(@PathVariable String id) {
        receiverRepository.deleteById(id);
        return "Receiver with ID " + id + " deleted successfully.";
    }
}
