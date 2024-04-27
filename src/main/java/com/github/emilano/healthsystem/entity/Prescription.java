/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emilano
 */
public class Prescription {
    private long id;
    private List<Medication> medications;
    
    public Prescription(long id) {
        this.id = id;
        this.medications = new ArrayList<>();
    }
    
    public Prescription(long id, ArrayList<Medication> medications) {
        this.id = id;
        this.medications = medications;
    }
    
    public long getId() {
        return this.id;
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
    private double duration;

    public Medication(String dosage, String instructions, double duration) {
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
    
    public void setDuration(double duration) {
        this.duration = duration;
    }
    
    public String getDosage() {
        return this.dosage;
    }
    
    public String getInstructions() {
        return this.instructions;
    }
    
    public double getDuration() {
        return this.duration;
    }
}
