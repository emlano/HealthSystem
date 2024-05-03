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
public class AppointmentDAO {
    private static Map<Long, Appointment> appointments = new HashMap<>();
    
    public static Collection<Appointment> getAllAppointments() {
        return appointments.values();
    }
    
    public static Appointment getAppointment(long id) throws ResourceNotFoundException {
        return checkAppointmentKey(id);
    }
    
    public static void addAppointment(Appointment appt) throws ImproperOrBadRequestException {
        long id = SharedUtils.getNextId(appointments);
        checkAppointmentObject(appt);
        appt.setId(id);
        appointments.put(id, appt);
    }
    
    public static void updateAppointment(long id, Appointment appt) throws Exception {
        checkAppointmentKey(id);
        checkAppointmentObject(appt);
        appt.setId(id);
        appointments.replace(id, appt);
    }
    
    public static void deleteAppointment(long id) throws ResourceNotFoundException {
        checkAppointmentKey(id);
        appointments.remove(id);
    }
    
    // Guarantees the objects parsed from the Json inputs are correct, if there's any missing fields,
    // object is rejected and a message is displayed to the user
    private static void checkAppointmentObject(Appointment appt) throws ImproperOrBadRequestException {
        if (appt == null) throw new ImproperOrBadRequestException("Appointment");
        if (appt.getDoctor() == null) throw new ImproperOrBadRequestException("Doctor");
        if (appt.getPatient() == null) throw new ImproperOrBadRequestException("Patient");
        if (appt.getDate() == null) throw new ImproperOrBadRequestException("Date");
        if (appt.getTime() == null) throw new ImproperOrBadRequestException("Time");
    }
    
    // Checks to see if the provided key is directs to a valid value in the HashMap
    private static Appointment checkAppointmentKey(long id) throws ResourceNotFoundException {
        Appointment appt = appointments.get(id);
        if (appt == null) throw new ResourceNotFoundException("Appointment", id);
        return appt;
    }
}
