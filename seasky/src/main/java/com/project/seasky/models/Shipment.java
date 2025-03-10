package com.project.seasky.models;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shipments")
public class Shipment {
    @Id
    private String shipmentId;
    private Date bookingDate;
    private Date departureDate;
    private String shipmentStatus;

    public Shipment() {
        this.bookingDate = new Date();
    }

    public Shipment(Date departureDate, String status) {
        this.bookingDate = new Date();
        this.departureDate = departureDate;
        this.shipmentStatus = status;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
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

    public String getShipmentStatus(){
        return shipmentStatus;
    }

    public void setShipmentStatus(String status){
        this.shipmentStatus = status;
    }
}
