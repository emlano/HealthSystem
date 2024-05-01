/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity.prescription;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.emilano.healthsystem.entity.prescription.Medication;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emilano
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Prescription {
    private long id;
    private List<Medication> medications;
    
    public Prescription(@JsonProperty("medications") ArrayList<Medication> medications) {
        this.medications = medications;
    }
    
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setMedications(ArrayList<Medication> medications) {
        this.medications = medications;
    }
    
    public List<Medication> getMedications() {
        return this.medications;
    }
}