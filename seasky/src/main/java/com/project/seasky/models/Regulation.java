package com.project.seasky.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "regulations")
public class Regulation {
    @Id
    private String regulationId;
    private String country;
    private String details;
    private double taxRate;

    public Regulation() {

    }

    public Regulation(String country, String details, double taxRate) {
        this.country = country;
        this.details = details;
        this.taxRate = taxRate;
    }

    public String getRegulationId() {
        return regulationId;
    }

    public void setRegulationId(String regulationId) {
        this.regulationId = regulationId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
}
