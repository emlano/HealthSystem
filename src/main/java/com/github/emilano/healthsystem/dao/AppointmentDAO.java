/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.dao;

import com.github.emilano.healthsystem.entity.*;
import java.util.List;

/**
 *
 * @author emilano
 */
public interface AppointmentDAO {
    List<Object> getAllAppointments();
    Appointment getAppointment(long time);
}
