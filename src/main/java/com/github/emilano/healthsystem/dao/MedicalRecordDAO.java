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
public class MedicalRecordDAO {
    private static Map<Long, MedicalRecord> records = new HashMap<>();
    
    public static Collection<MedicalRecord> getAllMedicalRecords() {
        return records.values();
    }
    
    public static MedicalRecord getMedicalRecord(long id) {
        return records.get(id);
    }
    
    public static void addMedicalRecord(MedicalRecord record) {
        SharedUtils<MedicalRecord> utils = new SharedUtils<>();
        records.put(utils.getNextId(records), record);
    }
    
    
    public static void updateMedicaRecord(MedicalRecord record) {
        records.replace(record.getId(), record);
    }
    
    public static void deleteMedicalRecord(long id) {
        records.remove(id);
    }
}
