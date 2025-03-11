package com.project.seasky.controller;

import com.project.seasky.models.Regulation;
import com.project.seasky.repository.RegulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/regulations")
public class RegulationController {
    
    @Autowired
    private RegulationRepository regulationRepository;

    @PostMapping("/create")
    public Regulation createRegulation(@RequestBody Regulation regulation) {
        return regulationRepository.save(regulation);
    }

    @GetMapping("/all")
    public List<Regulation> getAllRegulations() {
        return regulationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Regulation> getRegulationById(@PathVariable String id) {
        return regulationRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteRegulation(@PathVariable String id) {
        regulationRepository.deleteById(id);
        return "Regulation with ID " + id + " deleted successfully.";
    }
}
