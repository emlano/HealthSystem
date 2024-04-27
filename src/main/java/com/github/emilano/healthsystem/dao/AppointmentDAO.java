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
public class AppointmentDAO {
    private static Map<Long, Appointment> appointments = new HashMap<>();
    
    public static List<Appointment> getAllAppointments() {
        return appointments.values().stream().toList();
    }
    
    public static Appointment getAppointment(long id) {
        return appointments.get(id);
    }
    
    public static void addAppointment(Appointment appt) {
        appointments.put(appt.getId(), appt);
    }
    
    public static void updateAppointment(Appointment appt) {
        appointments.replace(appt.getId(), appt);
    }
    
    public static void deleteAppointment(long id) {
        appointments.remove(id);
    }
}
