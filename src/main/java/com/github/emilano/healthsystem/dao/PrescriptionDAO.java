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
public class PrescriptionDAO {
    private static Map<Long, Prescription> prescriptions = new HashMap<>();
    
    public static List<Prescription> getAllPrescriptions() {
        return prescriptions.values().stream().toList();
    }
    
    public static Prescription getPrescription(long id) {
        return prescriptions.get(id);
    }
    
    public static void addPrescription(Prescription prescription) {
        prescriptions.put(prescription.getId(), prescription);
    }
    
    public static void updatePrescription(Prescription prescription) {
        prescriptions.replace(prescription.getId(), prescription);
    }
    
    public static void deletePrescription(long id) {
        prescriptions.remove(id);
    }
}
