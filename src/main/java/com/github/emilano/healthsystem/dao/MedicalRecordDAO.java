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
public class MedicalRecordDAO {
    private static Map<Long, MedicalRecord> records = new HashMap<>();
    
    public static Collection<MedicalRecord> getAllMedicalRecords() {
        return records.values();
    }
    
    public static MedicalRecord getMedicalRecord(long id) throws ResourceNotFoundException {
        MedicalRecord record = records.get(id);
        if (record == null) throw new ResourceNotFoundException();
        return record;
    }
    
    public static void addMedicalRecord(MedicalRecord record) {
        long id = SharedUtils.getNextId(records);
        record.setId(id);
        records.put(id, record);
    }
    
    public static void updateMedicaRecord(long id, MedicalRecord record) throws ResourceNotFoundException {
        if (records.get(id) == null) throw new ResourceNotFoundException();
        record.setId(id);
        records.replace(id, record);
    }
    
    public static void deleteMedicalRecord(long id) throws ResourceNotFoundException {
        if (records.get(id) == null) throw new ResourceNotFoundException();
        records.remove(id);
    }
}
