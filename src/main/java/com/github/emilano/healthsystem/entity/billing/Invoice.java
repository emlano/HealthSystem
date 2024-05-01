/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity.billing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.emilano.healthsystem.dao.AppointmentDAO;
import com.github.emilano.healthsystem.dao.PrescriptionDAO;
import com.github.emilano.healthsystem.entity.Appointment;
import com.github.emilano.healthsystem.entity.prescription.Prescription;
import com.github.emilano.healthsystem.exception.ResourceNotFoundException;

/**
 *
 * @author emilano
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice {
    private Appointment appointment;
    private Prescription prescription;
    
    public Invoice(@JsonProperty("appointmentId") long appointmentId, @JsonProperty("prescriptionId") long prescriptionId) throws ResourceNotFoundException {
        this.appointment = AppointmentDAO.getAppointment(appointmentId);
        this.prescription = PrescriptionDAO.getPrescription(prescriptionId);
    }
    
    public void setAppointment(long appointmentId) throws ResourceNotFoundException {
        this.appointment = AppointmentDAO.getAppointment(appointmentId);
    }
    
    public void setPrescription(long prescriptionId) throws ResourceNotFoundException {
        this.prescription = PrescriptionDAO.getPrescription(prescriptionId);
    }
    
    public Appointment getAppointment() {
        return appointment;
    }
    
    public Prescription getPrescription() {
        return this.prescription;
    }
}