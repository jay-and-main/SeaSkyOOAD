package com.project.seasky.models;

import java.util.Date;
import java.time.LocalTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "travellogs")
public class TravelLog {
    @Id
    private String logId;
    private String travelStatus;
    private String origin;
    private String destination;
    private Date travelDate;
    private String modeOfTransport;
    private LocalTime eta;
    private LocalTime actualEndTime;
    private LocalTime startTime;

    public TravelLog() {

    }

    public TravelLog(String travelStatus, String origin, String destination, Date travelDate, String modeOfTransport, LocalTime eta, LocalTime actualEndTime, LocalTime startTime){
        this.travelStatus = travelStatus;
        this.origin = origin;
        this.destination = destination;
        this.travelDate = travelDate;
        this.modeOfTransport = modeOfTransport;
        this.eta = eta;
        this.actualEndTime = actualEndTime;
        this.startTime = startTime;
    }

    public String getLogId(){
        return logId;
    }

    public void setLogId(String logId){
        this.logId = logId;
    }

    public String getTravelStatus(){
        return travelStatus;
    }

    public void setTravelStatus(String travelStatus){
        this.travelStatus = travelStatus;
    }

    public String getOrigin(){
        return origin;
    }

    public void setOrigin(String origin){
        this.origin = origin;
    }

    public String getDestination(){
        return destination;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }

    public Date getTravelDate(){
        return travelDate;
    }

    public void setDate(Date travelDate){
        this.travelDate = travelDate;
    }

    public String getModeOfTransport(){
        return modeOfTransport;
    }

    public void setModeOfTransport(String modeOfTransport){
        this.modeOfTransport = modeOfTransport;
    }

    public LocalTime getEta(){
        return eta;
    }

    public void setEta(LocalTime eta){
        this.eta = eta;
    }

    public LocalTime getActualEndTime(){
        return actualEndTime;
    }

    public void setActualEndTime(LocalTime actualEndTime){
        this.actualEndTime = actualEndTime;
    }

    public LocalTime getStartTime(){
        return startTime;
    }

    public void setStartTime(LocalTime startTime){
        this.startTime = startTime;
    }
}
