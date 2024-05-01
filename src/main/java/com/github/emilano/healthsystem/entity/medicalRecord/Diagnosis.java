/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity.medicalRecord;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.emilano.healthsystem.dao.DoctorDAO;
import com.github.emilano.healthsystem.entity.Doctor;
import com.github.emilano.healthsystem.exception.ResourceNotFoundException;

/**
 *
 * @author emilano
 */
public class Diagnosis {
    private Doctor doctor;
    private String diagnosis;
    private String dateOfDiagnosis;
    
    public Diagnosis(@JsonProperty("doctorId") long doctorId, @JsonProperty("diagnosis") String diagnosis, @JsonProperty("dateOfDiagnosis") String dateOfDiagnosis) throws ResourceNotFoundException {
        this.doctor = DoctorDAO.getDoctor(doctorId);
        this.diagnosis = diagnosis;
        this.dateOfDiagnosis = dateOfDiagnosis;
    }
    
    public void setDoctor(long doctorId) throws ResourceNotFoundException {
        this.doctor = DoctorDAO.getDoctor(doctorId);
    }
    
    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
    public String getDiagnosis() {
        return this.diagnosis;
    }
    
    public void setDateOfDiagnosis(String newDateOfDiagnosis) {
        this.dateOfDiagnosis = newDateOfDiagnosis;
    }
    
    public String getDateOfDiagnosis() {
        return this.dateOfDiagnosis;
    }
}
