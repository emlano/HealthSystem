/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.dao;

import com.github.emilano.healthsystem.SharedUtils;
import com.github.emilano.healthsystem.entity.*;
import com.github.emilano.healthsystem.exception.ResourceNotFoundException;
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
    
    public static Patient getPatient(long id) throws ResourceNotFoundException {
        Patient patient = patients.get(id);
        if (patient == null) throw new ResourceNotFoundException();
        return patient;
    }
    
    public static void addPatient(Patient patient) {
        long id = SharedUtils.getNextId(patients);
        patient.setId(id);
        patients.put(id, patient);
    }
    
    public static void updatePatient(long id, Patient patient) throws ResourceNotFoundException {
        if (patients.get(id) == null) throw new ResourceNotFoundException();
        patient.setId(id);
        patients.replace(id, patient);
    }
    
    public static void deletePatient(long id) throws ResourceNotFoundException {
        if (patients.get(id) == null) throw new ResourceNotFoundException();
        patients.remove(id);
    }
}
