/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.AppointmentDAO;
import com.github.emilano.healthsystem.dao.PatientDAO;
import com.github.emilano.healthsystem.entity.Appointment;
import com.github.emilano.healthsystem.entity.Patient;
import com.github.emilano.healthsystem.exception.ImproperOrBadRequestException;
import com.github.emilano.healthsystem.exception.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author emilano
 */
@Path("/patient")
public class PatientResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Patient> getAllPatients() {
        return PatientDAO.getAllPatient();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatient(@PathParam("id") long id) throws ResourceNotFoundException {
        return PatientDAO.getPatient(id);
    }
    
    /* Get all appointments booked by this patient */
    @GET
    @Path("/{id}/appointment/")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Appointment> getPatientAppointments(@PathParam("id") long id) {
        ArrayList<Appointment> appts = new ArrayList<>();
        
        for (Appointment i : AppointmentDAO.getAllAppointments()) {
            if (i.getPatient() != null && i.getPatient().getId() == id) {
                appts.add(i);
            }
        }
        
        return appts;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postPatient(Patient patient) throws ImproperOrBadRequestException {
        PatientDAO.addPatient(patient);
        return "Status: OK";
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String putPatient(@PathParam("id") long id, Patient updated) throws Exception {
        PatientDAO.updatePatient(id, updated);
        return "Status: OK";
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deletePatient(@PathParam("id") long id) throws ResourceNotFoundException {
        PatientDAO.deletePatient(id);
        return "Status: OK";
    }
}
