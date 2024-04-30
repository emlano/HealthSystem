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
public class DoctorDAO {
    private static Map<Long, Doctor> doctors = new HashMap<>();
    
    public static Collection<Doctor> getAllDoctors() {
        return doctors.values();
    }
    
    public static Doctor getDoctor(long id) throws ResourceNotFoundException {
        return checkDoctorKey(id);
    }
    
    public static void addDoctor(Doctor doctor) throws ImproperOrBadRequestException {
        long id = SharedUtils.getNextId(doctors);
        checkDoctorObject(doctor);
        doctor.setId(id);
        doctors.put(id, doctor);
    }
    
    public static void updateDoctor(long id, Doctor doctor) throws Exception {
        checkDoctorKey(id);
        checkDoctorObject(doctor);
        doctor.setId(id);
        doctors.replace(id, doctor);
    }
    
    
    public static void deleteDoctor(long id) throws ResourceNotFoundException {
        checkDoctorKey(id);
        doctors.remove(id);
    }
    
    private static Doctor checkDoctorKey(long id) throws ResourceNotFoundException {
        Doctor doc = doctors.get(id);
        if (doc == null) throw new ResourceNotFoundException("Doctor", id);
        return doc;
    }
    
    private static void checkDoctorObject(Doctor obj) throws ImproperOrBadRequestException {
        if (obj == null) throw new ImproperOrBadRequestException("Doctor");
        if (obj.getName() == null) throw new ImproperOrBadRequestException("Name");
        if (obj.getContact() == null) throw new ImproperOrBadRequestException("Contact");
        if (obj.getAddress() == null) throw new ImproperOrBadRequestException("Address");
        if (obj.getOfficeContact() == null) throw new ImproperOrBadRequestException("OfficeContact");
        if (obj.getSpecialization() == null) throw new ImproperOrBadRequestException("Specialization");
    }
}
