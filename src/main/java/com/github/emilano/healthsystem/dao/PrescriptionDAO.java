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
public class PrescriptionDAO {
    private static Map<Long, Prescription> prescriptions = new HashMap<>();
    
    public static Collection<Prescription> getAllPrescriptions() {
        return prescriptions.values().stream().toList();
    }
    
    public static Prescription getPrescription(long id) {
        return prescriptions.get(id);
    }
    
    public static void addPrescription(Prescription prescription) {
        long id = SharedUtils.getNextId(prescriptions);
        prescription.setId(id);
        prescriptions.put(id, prescription);
    }
    
    public static void updatePrescription(Prescription prescription) {
        prescriptions.replace(prescription.getId(), prescription);
    }
    
    public static void deletePrescription(Prescription presc, long id) {
        prescriptions.remove(presc, id);
    }
}
