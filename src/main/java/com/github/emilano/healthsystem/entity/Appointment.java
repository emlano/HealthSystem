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
    private Doctor doctor;
    private Patient patient;
    
    public Appointment(@JsonProperty("doctor") Doctor doctor, @JsonProperty("patient") Patient patient) {
        this.date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        this.time = LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
        this.doctor = doctor;
        this.patient = patient;
    }
    
    public Appointment(@JsonProperty("doctor") Doctor doctor, @JsonProperty("patient") Patient patient, @JsonProperty("date") String date, @JsonProperty("time") String time) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
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
    
    public void setDoctor(Doctor newDoctor) {
        this.doctor = newDoctor;
    }
    
    public void setPatient(Patient newPatient) {
        this.patient = newPatient;
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
