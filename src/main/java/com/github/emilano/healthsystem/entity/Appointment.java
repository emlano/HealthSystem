/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author emilano
 */
public class Appointment {
    private long id;
    private String date;
    private String time;
    private long doctorId;
    private long patientId;
    
    public Appointment(@JsonProperty("doctorId") long doctorId, @JsonProperty("patientId") long patientId) {
        this.date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        this.time = LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
        this.doctorId = doctorId;
        this.patientId = patientId;
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
    
    public void setDoctorId(long newDoctorId) {
        this.doctorId = newDoctorId;
    }
    
    public void setPatientId(long newPatientId) {
        this.patientId = newPatientId;
    }
    
    public long getDoctorId() {
        return this.doctorId;
    }
    
    public long getPatientId() {
        return this.patientId;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public String getTime() {
        return this.time;
    }
}
