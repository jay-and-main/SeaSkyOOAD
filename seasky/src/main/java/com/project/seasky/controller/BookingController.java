package com.project.seasky.controller;

import com.project.seasky.models.Booking;
import com.project.seasky.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    
    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/create")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }

    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getBookingById(@PathVariable String id) {
        return bookingRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable String id, @RequestBody Booking updateBooking){
        return bookingRepository.findById(id).map(booking -> {
            booking.setBookingStatus(updateBooking.getBookingStatus());
            return bookingRepository.save(booking);
        }).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable String id) {
        bookingRepository.deleteById(id);
        return "Booking with ID " + id + " deleted successfully.";
    }

}
