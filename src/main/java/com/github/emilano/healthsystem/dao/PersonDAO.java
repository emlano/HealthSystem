/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.dao;

import com.github.emilano.healthsystem.SharedUtils;
import com.github.emilano.healthsystem.entity.*;
import com.github.emilano.healthsystem.exception.ImproperOrBadRequestException;
import com.github.emilano.healthsystem.exception.ResourceNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author emilano
 */
public class PersonDAO {
    private static Map<Long, Person> persons = new HashMap<>();
    
    public static Collection<Person> getAllPersons() {
        return persons.values();
    }
    
    public static Person getPerson(long id) throws ResourceNotFoundException {
        return checkPersonKey(id);
    }
    
    public static void addPerson(Person person) throws ImproperOrBadRequestException {
        long id = SharedUtils.getNextId(persons);
        checkPersonObject(person);
        person.setId(id);
        persons.put(id, person);
    }
    
    public static void updatePerson(long id, Person person) throws Exception {
        checkPersonKey(id);
        checkPersonObject(person);
        person.setId(id);
        persons.replace(person.getId(), person);
    }
    
    public static void deletePerson(long id) throws ResourceNotFoundException {
        checkPersonKey(id);
        persons.remove(id);
    }
    
    private static Person checkPersonKey(long id) throws ResourceNotFoundException {
        Person person = persons.get(id);
        if (person == null) throw new ResourceNotFoundException("Person", id);
        return person;
    }
    
    private static void checkPersonObject(Person obj) throws ImproperOrBadRequestException {
        if (obj == null) throw new ImproperOrBadRequestException("Person");
        if (obj.getName() == null) throw new ImproperOrBadRequestException("Name");
        if (obj.getContact() == null) throw new ImproperOrBadRequestException("Contact");
        if (obj.getAddress() == null) throw new ImproperOrBadRequestException("Address");
    }
}
