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
public class AppointmentDAO {
    private static Map<Long, Appointment> appointments = new HashMap<>();
    
    public static Collection<Appointment> getAllAppointments() {
        return appointments.values();
    }
    
    public static Appointment getAppointment(long id) {
        return appointments.get(id);
    }
    
    public static void addAppointment(Appointment appt) {
        long id = new SharedUtils<Appointment>().getNextId(appointments);
        appt.setId(id);
        appointments.put(id, appt);
    }
    
    public static void updateAppointment(Appointment appt) {
        appointments.replace(appt.getId(), appt);
    }
    
    public static void deleteAppointment(long id) {
        appointments.remove(id);
    }
}
