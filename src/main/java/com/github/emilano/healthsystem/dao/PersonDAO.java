/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.dao;

import com.github.emilano.healthsystem.SharedUtils;
import com.github.emilano.healthsystem.entity.*;
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
    
    public static Person getPerson(long id) {
        return persons.get(id);
    }
    
    public static void addPerson(Person person) {
        long id = new SharedUtils<Person>().getNextId(persons);
        person.setId(id);
        persons.put(id, person);
    }
    
    public static void updatePerson(Person person) {
        persons.replace(person.getId(), person);
    }
    
    public static void deletePerson(long id) {
        persons.remove(id);
    }
}
