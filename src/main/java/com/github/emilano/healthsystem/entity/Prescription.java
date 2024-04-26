/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

import java.util.ArrayList;

/**
 *
 * @author emilano
 */
public class Prescription {
    private ArrayList<Medication> medications;
    
    public Prescription() {
        this.medications = new ArrayList<>();
    }
    
    public Prescription(ArrayList<Medication> medications) {
        this.medications = medications;
    }
    
    public void setMedications(ArrayList<Medication> medications) {
        this.medications = medications;
    }
    
    public ArrayList<Medication> getMedications() {
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
