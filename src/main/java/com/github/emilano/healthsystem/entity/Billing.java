/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emilano
 */
public class Billing {
    private long id;
    private Invoice invoice;
    private List<Payment> payments;
    private double dueAmount;
    
    public Billing(@JsonProperty("invoice") Invoice invoice, @JsonProperty("dueAmount") double dueAmount) {
        this.invoice = invoice;
        this.dueAmount = dueAmount;
        this.payments = new ArrayList<>();
    }
    
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    
    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }
    
    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }
    
    public Invoice getInvoice() {
        return this.invoice;
    }
    
    public double getDueAmount() {
        return this.dueAmount;
    }
    
    public List<Payment> getPayments() {
        return this.payments;
    }
    
    public void addPayment(Payment payment) {
        this.payments.add(payment);
        this.dueAmount -= payment.getAmount();
    }
}


class Invoice {
    private Doctor doctor;
    private Patient patient;
    private MedicalRecord record;
    private Prescription prescription;
    
    public Invoice(@JsonProperty("doctor") Doctor doctor, @JsonProperty("patient") Patient patient, @JsonProperty("record") MedicalRecord record, @JsonProperty("prescription") Prescription prescription) {
        this.doctor = doctor;
        this.patient = patient;
        this.record = record;
        this.prescription = prescription;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public void setPatientRecord(MedicalRecord record) {
        this.record = record;
    }
    
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
    
    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public Patient getPatient() {
        return this.patient;
    }
    
    public MedicalRecord getPatientRecord() {
        return this.record;
    }
    
    public Prescription getPrescription() {
        return this.prescription;
    }
}


class Payment {
    private double amount;
    private String date;
    private String time;
    
    public Payment(@JsonProperty("amount") double amount) {
        this.amount = amount;
        this.date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        this.time = LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public double getAmount() {
        return this.amount;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public String getTime() {
        return this.time;
    }
}