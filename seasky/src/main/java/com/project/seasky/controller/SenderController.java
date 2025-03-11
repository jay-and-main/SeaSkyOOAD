package com.project.seasky.controller;

import com.project.seasky.models.Sender;
import com.project.seasky.repository.SenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/senders")
public class SenderController {
    
    @Autowired
    private SenderRepository senderRepository;

    @PostMapping("/create")
    public Sender createSender(@RequestBody Sender sender) {
        return senderRepository.save(sender);
    }

    @GetMapping("/all")
    public List<Sender> getAllSenders() {
        return senderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Sender> getSenderById(@PathVariable String id) {
        return senderRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteSender(@PathVariable String id) {
        senderRepository.deleteById(id);
        return "Sender with ID " + id + " deleted successfully.";
    }
}
