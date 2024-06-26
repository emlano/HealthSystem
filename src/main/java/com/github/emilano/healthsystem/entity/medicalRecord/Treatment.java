/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity.medicalRecord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.emilano.healthsystem.dao.DoctorDAO;
import com.github.emilano.healthsystem.entity.Doctor;
import com.github.emilano.healthsystem.exception.ResourceNotFoundException;

/**
 *
 * @author emilano
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Treatment {
    private Doctor doctor;
    private String procedure;
    private String dateOfTreatment;
    
    public Treatment(@JsonProperty("doctorId") long doctorId, @JsonProperty("procedure") String procedure, @JsonProperty("dateOfTreatment") String dateOfTreatment) throws ResourceNotFoundException {
        this.doctor = DoctorDAO.getDoctor(doctorId);
        this.procedure = procedure;
        this.dateOfTreatment = dateOfTreatment;
    }
    
    public void setDoctor(long doctorId) throws ResourceNotFoundException {
        this.doctor = DoctorDAO.getDoctor(doctorId);
    }
    
    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setTreatment(String treatment) {
        this.procedure = procedure;
    }
    
    public String getProcedure() {
        return this.procedure;
    }
    
    public void setDateOfTreatment(String date) {
        this.dateOfTreatment = date;
    }
    
    public String getDateOfTreatment() {
        return this.dateOfTreatment;
    }
}
