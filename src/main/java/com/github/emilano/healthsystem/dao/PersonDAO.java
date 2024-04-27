/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.dao;

import com.github.emilano.healthsystem.entity.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author emilano
 */
public class PersonDAO {
    private static Map<Long, Person> persons = new HashMap<>();
    
    public static List<Person> getAllPersons() {
        return persons.values().stream().toList();
    }
    
    public static Person getPerson(long id) {
        return persons.get(id);
    }
    
    public static void addPerson(Person person) {
        persons.put(person.getId(), person);
    }
    
    public static void updatePerson(Person person) {
        persons.replace(person.getId(), person);
    }
    
    public static void deletePerson(long id) {
        persons.remove(id);
    }
}
