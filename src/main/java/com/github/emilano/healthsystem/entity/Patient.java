/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

/**
 *
 * @author emilano
 */
public class Patient extends Person {
    private String status;
    private MedicalRecord history;
    
    public Patient(long id, String name, String contact, String address, String status, MedicalRecord history) {
        super(id, name, contact, address);
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
