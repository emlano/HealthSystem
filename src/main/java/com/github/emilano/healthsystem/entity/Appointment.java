/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.emilano.healthsystem.dao.DoctorDAO;
import com.github.emilano.healthsystem.dao.PatientDAO;
import com.github.emilano.healthsystem.exception.ResourceNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author emilano
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Appointment {
    private long id;
    private String date;
    private String time;
    private Doctor doctor;
    private Patient patient;
    
    // Constructor takes in ids rather than json objects for specific fields. The ids are also checked in the respective data structures.
    // This way, as an example, for Appointment a Doctor object and a Patient object must be present in their respective data structures,
    // Otherwise the Appointment object would not be created. Constructor uses the DAOs to get the respective objects and stores them. 
    public Appointment(@JsonProperty("doctorId") long doctorId, @JsonProperty("patientId") long patientId) throws ResourceNotFoundException {
        this.date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        this.time = LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
        this.doctor = DoctorDAO.getDoctor(doctorId);
        this.patient = PatientDAO.getPatient(patientId);
    }
    
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    // As with the constructors, the setter follow similar rationale
    public void setDoctor(long newDoctorId) throws ResourceNotFoundException {
        this.doctor = DoctorDAO.getDoctor(newDoctorId);
    }
    
    public void setPatient(long newPatientId) throws ResourceNotFoundException {
        this.patient = PatientDAO.getPatient(newPatientId);
    }
    
    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public Patient getPatient() {
        return this.patient;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public String getTime() {
        return this.time;
    }
}
