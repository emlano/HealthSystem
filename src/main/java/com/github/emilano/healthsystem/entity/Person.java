/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

import com.github.emilano.healthsystem.exception.ImmutableIDException;

/**
 *
 * @author emilano
 */
public abstract class Person {
    private long id;
    private String name;
    private String contactNum;
    private String address;
    
    public Person(String name, String contact, String address) {
        this.name = name;
        this.contactNum = contact;
        this.address = address;
    }
    
    public Person(long id, String name, String contact, String address) {
        this(name, contact, address);
        this.id = id;
    }
    
    public void setId(long id) throws ImmutableIDException {
        if (id != 0) throw new ImmutableIDException();
        this.id = id;
    }
    
    public long getId() {
        return this.id;
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
