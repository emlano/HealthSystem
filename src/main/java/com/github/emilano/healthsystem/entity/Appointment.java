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
    private LocalDate date;
    private LocalTime time;
    private Doctor doctor;
    private Patient patient;
    
    public Appointment(Doctor doctor, Patient patient) {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.doctor = doctor;
        this.patient = patient;
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
