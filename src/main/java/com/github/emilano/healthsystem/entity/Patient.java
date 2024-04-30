/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.emilano.healthsystem.dao.MedicalRecordDAO;
import com.github.emilano.healthsystem.exception.ResourceNotFoundException;

/**
 *
 * @author emilano
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient extends Person {
    private String status;
    private MedicalRecord record;
    
    public Patient(@JsonProperty("name") String name, @JsonProperty("contact") String contact, @JsonProperty("address") String address, @JsonProperty("status") String status, @JsonProperty("medicalRecordId") long historyId) throws ResourceNotFoundException {
        super(name, contact, address);
        this.status = status;
        this.record = MedicalRecordDAO.getMedicalRecord(historyId);
    }
    
    public void setStatus(String newStatus) {
        this.status = newStatus;
    }
    
    public void setMedicalHistory(long newRecordId) throws ResourceNotFoundException {
        this.record = MedicalRecordDAO.getMedicalRecord(newRecordId);
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public MedicalRecord getMedicalRecord() {
        return this.record;
    }
}
