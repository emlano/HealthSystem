/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

/**
 *
 * @author emilano
 */
public class Doctor extends Person {
    private String specialization;
    private String officeContact;
    
    public Doctor(String name, String contact, String address, String specialization, String office) {
        super(name, contact, address);
        this.specialization = specialization;
        this.officeContact = office;
    }
    
    public void setSpecialization(String newSpecialization) {
        this.specialization = newSpecialization;
    }
    
    public void setOfficeContact(String newOfficeContact) {
        this.officeContact = newOfficeContact;
    }
        
    public String getSpecialization() {
        return this.specialization;
    }
            
    public String getOfficeContact() {
        return this.officeContact;
    }
}
