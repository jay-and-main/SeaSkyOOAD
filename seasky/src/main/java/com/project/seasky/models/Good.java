package com.project.seasky.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "goods")
public class Good {
    @Id
    private String packageId;
    private double weight;
    private double volume;
    private String regulationStatus;
    private String category;
    private boolean fragile;
    private String description;
    private String shipmentNumberId;

    public Good() {
    }

    public Good(double weight, double volume, String regulationStatus, String category, boolean fragile, String description, String shipmentNumberId) {
        this.weight = weight;
        this.volume = volume;
        this.regulationStatus = regulationStatus;
        this.category = category;
        this.fragile = fragile;
        this.description = description;
        this.shipmentNumberId = shipmentNumberId;
    }

    public String getPackageId(){
        return packageId;
    }

    public void setPackageId(String packageId){
        this.packageId = packageId;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public double getVolume(){
        return volume;
    }

    public void setVolume(double volume){
        this.volume = volume;
    }

    public String getRegulationStatus(){
        return regulationStatus;
    }

    public void setRegulationStatus(String regulationStatus){
        this.regulationStatus = regulationStatus;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public boolean getFragile(){
        return fragile;
    }

    public void setFragile(boolean fragile){
        this.fragile = fragile;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getShipmentNumberId(){
        return shipmentNumberId;
    }
}
