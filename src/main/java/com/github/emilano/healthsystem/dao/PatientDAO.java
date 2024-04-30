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
public class PatientDAO {
    private static Map<Long, Patient> patients = new HashMap<>();
    
    public static Collection<Patient> getAllPatient() {
        return patients.values();
    }
    
    public static Patient getPatient(long id) throws ResourceNotFoundException {
        return checkPatientKey(id);
    }
    
    public static void addPatient(Patient patient) throws ImproperOrBadRequestException {
        long id = SharedUtils.getNextId(patients);
        checkPatientObject(patient);
        patient.setId(id);
        patients.put(id, patient);
    }
    
    public static void updatePatient(long id, Patient patient) throws Exception {
        checkPatientKey(id);
        checkPatientObject(patient);
        patient.setId(id);
        patients.replace(id, patient);
    }
    
    public static void deletePatient(long id) throws ResourceNotFoundException {
        checkPatientKey(id);
        patients.remove(id);
    }
    
    private static Patient checkPatientKey(long id) throws ResourceNotFoundException {
        Patient patient = patients.get(id);
        if (patient == null) throw new ResourceNotFoundException("Patient", id);
        return patient;
    }
    
    private static void checkPatientObject(Patient patient) throws ImproperOrBadRequestException {
        if (patient == null) throw new ImproperOrBadRequestException("Patient");
        if (patient.getName() == null) throw new ImproperOrBadRequestException("Name");
        if (patient.getContact() == null) throw new ImproperOrBadRequestException("Contact");
        if (patient.getAddress() == null) throw new ImproperOrBadRequestException("Address");
        if (patient.getStatus() == null) throw new ImproperOrBadRequestException("Status");
        if (patient.getMedicalRecord() == null) throw new ImproperOrBadRequestException("MedicalRecord");
    }
}
