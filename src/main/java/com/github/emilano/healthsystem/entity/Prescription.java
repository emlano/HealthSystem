/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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


class Medication {
    private String dosage;
    private String instructions;
    private String duration;

    public Medication(@JsonProperty("dosage") String dosage, @JsonProperty("instructions") String instructions, @JsonProperty("duration") String duration) {
        this.dosage = dosage;
        this.duration = duration;
        this.instructions = instructions;
    }
    
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    
    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public String getDosage() {
        return this.dosage;
    }
    
    public String getInstructions() {
        return this.instructions;
    }
    
    public String getDuration() {
        return this.duration;
    }
}
