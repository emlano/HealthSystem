/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.dao;

import com.github.emilano.healthsystem.entity.prescription.Prescription;
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
public class PrescriptionDAO {
    private static Map<Long, Prescription> prescriptions = new HashMap<>();
    
    public static Collection<Prescription> getAllPrescriptions() {
        return prescriptions.values();
    }
    
    public static Prescription getPrescription(long id) throws ResourceNotFoundException {
        return checkPrescriptionKey(id);
    }
    
    public static void addPrescription(Prescription prescription) throws ImproperOrBadRequestException {
        long id = SharedUtils.getNextId(prescriptions);
        checkPrescriptionObject(prescription);
        prescription.setId(id);
        prescriptions.put(id, prescription);
    }
    
    public static void updatePrescription(long id, Prescription prescription) throws Exception {
        checkPrescriptionKey(id);
        checkPrescriptionObject(prescription);
        prescription.setId(id);
        prescriptions.replace(prescription.getId(), prescription);
    }
    
    public static void deletePrescription(long id) throws ResourceNotFoundException {
        checkPrescriptionKey(id);
        prescriptions.remove(id);
    }
    
    private static Prescription checkPrescriptionKey(long id) throws ResourceNotFoundException {
        Prescription prescription = prescriptions.get(id);
        if (prescription == null) throw new ResourceNotFoundException("Prescription", id);
        return prescription;
    }
    
    private static void checkPrescriptionObject(Prescription obj) throws ImproperOrBadRequestException {
        if (obj == null) throw new ImproperOrBadRequestException("Prescription");
        if (obj.getMedications() == null) throw new ImproperOrBadRequestException("Medications");
    }
}
