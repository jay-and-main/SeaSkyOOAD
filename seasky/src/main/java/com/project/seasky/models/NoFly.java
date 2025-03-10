package com.project.seasky.models;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "noflies")
public class NoFly {
    @Id
    private String id;
    private String passportNumber;
    private String reason;
    private Date dateAdded;

    public NoFly(){
        this.dateAdded = new Date();
    }

    public NoFly(String passportNumber, String reason){
        this.passportNumber = passportNumber;
        this.reason = reason;
        this.dateAdded = new Date();
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getPassportNumber(){
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber){
        this.passportNumber = passportNumber;
    }

    public String getReason(){
        return reason;
    }

    public void setReason(String reason){
        this.reason = reason;
    }

    public Date getDateAdded(){
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded){
        this.dateAdded = dateAdded;
    }
}
