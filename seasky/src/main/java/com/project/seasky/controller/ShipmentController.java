package com.project.seasky.controller;

import com.project.seasky.models.Shipment;
import com.project.seasky.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {
    
    @Autowired
    private ShipmentRepository shipmentRepository;

    @PostMapping("/create")
    public Shipment createShipment(@RequestBody Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    @GetMapping("/all")
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Shipment> getShipmentById(@PathVariable String id) {
        return shipmentRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Shipment updateShipment(@PathVariable String id, @RequestBody Shipment updateShipment){
        return shipmentRepository.findById(id).map(shipment -> {
            shipment.setShipmentStatus(updateShipment.getShipmentStatus());
            return shipmentRepository.save(shipment);
        }).orElseThrow(() -> new RuntimeException("Shipment not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteShipment(@PathVariable String id) {
        shipmentRepository.deleteById(id);
        return "Shipment with ID " + id + " deleted successfully.";
    }
}
