/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity.billing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author emilano
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {
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
