package com.project.seasky.controller;

import com.project.seasky.models.Good;
import com.project.seasky.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/goods")
public class GoodController {
    
    @Autowired
    private GoodRepository goodRepository;

    @PostMapping("/create")
    public Good createGood(@RequestBody Good good) {
        return goodRepository.save(good);
    }

    @GetMapping("/all")
    public List<Good> getAllGoods() {
        return goodRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Good> getGoodById(@PathVariable String id) {
        return goodRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Good updateGood(@PathVariable String id, @RequestBody Good updateGood){
        return goodRepository.findById(id).map(good -> {
            good.setRegulationStatus(updateGood.getRegulationStatus());
            return goodRepository.save(good);
        }).orElseThrow(() -> new RuntimeException("Good not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteGood(@PathVariable String id) {
        goodRepository.deleteById(id);
        return "Good with ID " + id + " deleted successfully.";
    }
}
