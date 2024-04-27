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
public class DoctorDAO {
    private static Map<Long, Doctor> doctors = new HashMap<>();
    
    public static List<Doctor> getAllDoctors() {
        return doctors.values().stream().toList();
    }
    
    public static Doctor getDoctor(long id) {
        return doctors.get(id);
    }
    
    public static void addDoctor(Doctor doctor) {
        doctors.put(doctor.getId(), doctor);
    }
    
    public static void updateDoctor(Doctor doctor) {
        doctors.replace(doctor.getId(), doctor);
    }
    
    
    public static void deleteDoctor(long id) {
        doctors.remove(id);
    }
}
