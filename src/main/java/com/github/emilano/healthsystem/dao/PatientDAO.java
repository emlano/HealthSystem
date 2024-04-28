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
public class PatientDAO {
    private static Map<Long, Patient> patients = new HashMap<>();
    
    public static Collection<Patient> getAllPatient() {
        return patients.values();
    }
    
    public static Patient getPatient(long id) {
        return patients.get(id);
    }
    
    public static void addPatient(Patient patient) {
        SharedUtils<Patient> utils = new SharedUtils<>();
        patients.put(utils.getNextId(patients), patient);
    }
    
    public static void updatePatient(Patient patient) {
        patients.replace(patient.getId(), patient);
    }
    
    
    public static void deletePatient(long id) {
        patients.remove(id);
    }
}
