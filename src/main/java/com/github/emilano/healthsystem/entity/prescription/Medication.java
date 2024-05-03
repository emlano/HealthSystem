/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity.prescription;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author emilano
 */
public class Medication {
    private String medicine;
    private String instructions;
    private String duration;

    public Medication(@JsonProperty("medicine") String dosage, @JsonProperty("instructions") String instructions, @JsonProperty("duration") String duration) {
        this.medicine = dosage;
        this.duration = duration;
        this.instructions = instructions;
    }
    
    public void setMedicine(String dosage) {
        this.medicine = dosage;
    }
    
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    
    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public String getMedicine() {
        return this.medicine;
    }
    
    public String getInstructions() {
        return this.instructions;
    }
    
    public String getDuration() {
        return this.duration;
    }
}
