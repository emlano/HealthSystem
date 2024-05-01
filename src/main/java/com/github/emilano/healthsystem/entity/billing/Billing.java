/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity.billing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.emilano.healthsystem.entity.billing.Invoice;
import com.github.emilano.healthsystem.entity.billing.Payment;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emilano
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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