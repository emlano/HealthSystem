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
    private long doctorId;
    private long patientId;
    private long recordId;
    private long prescriptionId;
    
    public Invoice(@JsonProperty("doctorId") long doctorId, @JsonProperty("patientId") long patientId, @JsonProperty("recordId") long recordId, @JsonProperty("prescriptionId") long prescriptionId) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.recordId = recordId;
        this.prescriptionId = prescriptionId;
    }
    
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }
    
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }
    
    public void setPatientRecordId(long recordId) {
        this.recordId = recordId;
    }
    
    public void setPrescriptionId(long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }
    
    public long getDoctorId() {
        return this.doctorId;
    }
    
    public long getPatientId() {
        return this.patientId;
    }
    
    public long getPatientRecordId() {
        return this.recordId;
    }
    
    public long getPrescriptionId() {
        return this.prescriptionId;
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