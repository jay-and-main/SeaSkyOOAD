package com.project.seasky.controller;

import com.project.seasky.models.NoFly;
import com.project.seasky.repository.NoFlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/noflies")
public class NoFlyController {
    
    @Autowired
    private NoFlyRepository noFlyRepository;

    @PostMapping("/create")
    public NoFly createNoFly(@RequestBody NoFly noFly) {
        return noFlyRepository.save(noFly);
    }

    @GetMapping("/all")
    public List<NoFly> getAllNoFlies() {
        return noFlyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<NoFly> getNoFlyById(@PathVariable String id) {
        return noFlyRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteNoFly(@PathVariable String id) {
        noFlyRepository.deleteById(id);
        return "NoFly with ID " + id + " deleted successfully.";
    }
}
