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
public class AppointmentDAO {
    private static Map<Long, Appointment> appointments = new HashMap<>();
    
    public static Collection<Appointment> getAllAppointments() {
        return appointments.values();
    }
    
    public static Appointment getAppointment(long id) throws ResourceNotFoundException {
        Appointment apt = appointments.get(id);
        if (apt == null) throw new ResourceNotFoundException();
        return apt;
    }
    
    public static void addAppointment(Appointment appt) {
        long id = SharedUtils.getNextId(appointments);
        appt.setId(id);
        appointments.put(id, appt);
    }
    
    public static void updateAppointment(long id, Appointment appt) throws ResourceNotFoundException {
        if (appointments.get(id) == null) throw new ResourceNotFoundException();
        appt.setId(id);
        appointments.replace(id, appt);
    }
    
    public static void deleteAppointment(long id) throws ResourceNotFoundException {
        if (appointments.get(id) == null) throw new ResourceNotFoundException();
        appointments.remove(id);
    }
}
