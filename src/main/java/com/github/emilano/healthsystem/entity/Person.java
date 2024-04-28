/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

/**
 *
 * @author emilano
 */
public class Person {
    private long id;
    private String name;
    private String contactNum;
    private String address;
    
    public Person(String name, String contact, String address) {
        this.name = name;
        this.contactNum = contact;
        this.address = address;
    }
    
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public void setContact(String newContact) {
        this.contactNum = newContact;
    }
    
    public void setAddress(String newAddress) {
        this.address = newAddress;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getContact() {
        return contactNum;
    }
    
    public String getAddress() {
        return address;
    }
}
