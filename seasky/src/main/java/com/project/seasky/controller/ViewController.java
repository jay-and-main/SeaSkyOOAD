package com.project.seasky.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @GetMapping("/home")
    public String showHome() {
        return "index";
    }

    @GetMapping("/bookings")
    public String showBookings() {
        return "bookings";
    }

    @GetMapping("/flight")
    public String showFlight() {
        return "flight";
    }

    @GetMapping("flight-suggestions")
    public String showFlightSuggestions() {
        return "flight-suggestions";
    }

    @GetMapping("/parcel")
    public String showParcel(){
        return "parcel";
    }

    @GetMapping("/parcel-suggestions")
    public String showParcelSuggestions(){
        return "parcel-suggestions";
    }

    @GetMapping("/past-bookings")
    public String showPastBookings(){
        return "past-bookings";
    }

    @GetMapping("/admin")
    public String showAdmin(){
        return "admin-home";
    }

    @GetMapping("/admin-no-fly")
    public String showAdminNoFly(){
        return "admin-no-fly";
    }

    @GetMapping("/admin-booking-status")
    public String showAdminBookingStatus(){
        return "admin-booking-status";
    }

    @GetMapping("/admin-shipment-status")
    public String showAdminShipmentStatus(){
        return "admin-shipment-status";
    }

    @GetMapping("/error")
    public String showError() {
        return "error";
    }
}