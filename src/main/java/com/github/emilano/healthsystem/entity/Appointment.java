/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author emilano
 */
public class Appointment {
    private long id;
    private LocalDate date;
    private LocalTime time;
    private Doctor doctor;
    private Patient patient;
    
    public Appointment(@JsonProperty("doctor") Doctor doctor, @JsonProperty("patient") Patient patient) {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.doctor = doctor;
        this.patient = patient;
    }
    
    public Appointment(@JsonProperty("doctor") Doctor doctor, @JsonProperty("patient") Patient patient, @JsonProperty("minute") int minute, @JsonProperty("hour") int hour, @JsonProperty("day") int day, @JsonProperty("month") int month, @JsonProperty("year") int year) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = LocalDate.of(year, month, day);
        this.time = LocalTime.of(hour, minute);
    }
    
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setDate(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
    }
    
    public void setTime(int hours, int minutes) {
        this.time = LocalTime.of(hours, minutes);
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
    
    public LocalDate getDate() {
        return this.date;
    }
    
    public LocalTime getTime() {
        return this.time;
    }
}
