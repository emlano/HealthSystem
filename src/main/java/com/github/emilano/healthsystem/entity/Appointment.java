/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

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
    
    public Appointment(long id, Doctor doctor, Patient patient) {
        this.id = id;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.doctor = doctor;
        this.patient = patient;
    }
    
    public Appointment(long id, Doctor doctor, Patient patient, LocalDate date, LocalTime time) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
    }
    
    public long getId() {
        return this.id;
    }
    
    public void setDate(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
    }
    
    public void setTime(int hours, int minutes) {
        this.time = LocalTime.of(hours, minutes, 0);
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
