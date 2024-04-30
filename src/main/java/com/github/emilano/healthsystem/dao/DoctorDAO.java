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
public class DoctorDAO {
    private static Map<Long, Doctor> doctors = new HashMap<>();
    
    public static Collection<Doctor> getAllDoctors() {
        return doctors.values();
    }
    
    public static Doctor getDoctor(long id) throws ResourceNotFoundException {
        Doctor doctor = doctors.get(id);
        if (doctor == null) throw new ResourceNotFoundException();
        
        return doctor;
    }
    
    public static void addDoctor(Doctor doctor) {
        long id = SharedUtils.getNextId(doctors);
        doctor.setId(id);
        doctors.put(id, doctor);
    }
    
    public static void updateDoctor(long id, Doctor doctor) throws ResourceNotFoundException {
        if (doctors.get(id) == null) throw new ResourceNotFoundException();
        doctor.setId(id);
        doctors.replace(id, doctor);
    }
    
    
    public static void deleteDoctor(long id) throws ResourceNotFoundException {
        if (doctors.get(id) == null) throw new ResourceNotFoundException();
        doctors.remove(id);
    }
}
