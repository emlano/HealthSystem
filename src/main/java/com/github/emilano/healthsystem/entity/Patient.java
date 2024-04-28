/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author emilano
 */
public class Patient extends Person {
    private String status;
    private MedicalRecord history;
    
    public Patient(@JsonProperty("name") String name, @JsonProperty("contact") String contact, @JsonProperty("address") String address, @JsonProperty("status") String status, @JsonProperty("medicalRecord") MedicalRecord history) {
        super(name, contact, address);
        this.status = status;
        this.history = history;
    }
    
    public void setStatus(String newStatus) {
        this.status = newStatus;
    }
    
    public void setMedicalHistory(MedicalRecord newRecord) {
        this.history = newRecord;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public MedicalRecord getMedicalRecord() {
        return this.history;
    }
}
