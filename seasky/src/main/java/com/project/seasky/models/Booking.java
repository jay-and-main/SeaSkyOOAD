package com.project.seasky.models;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookings")
public class Booking {
    @Id
    private String bookingId;
    private Date bookingDate;
    private Date departureDate;
    private String bookingStatus;

    public Booking() {
        this.bookingDate = new Date();
    }

    public Booking(Date departureDate, String bookingStatus) {
        this.bookingDate = new Date();
        this.departureDate = departureDate;
        this.bookingStatus = bookingStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate){
        this.departureDate = departureDate;
    }

    public String getBookingStatus(){
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus){
        this.bookingStatus = bookingStatus;
    }
}
