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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author emilano
 */
@Path("/patient")
public class PatientResource {
    private Logger logger = LoggerFactory.getLogger(PatientResource.class.getName());
    
    /*
    URI: localhost:8080/HealthSystem/v1/patient/
    */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Patient> getAllPatients() {
        logger.info("GET request at /patient/");
        return PatientDAO.getAllPatient();
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/patient/{id}
    */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatient(@PathParam("id") long id) throws ResourceNotFoundException {
        logger.info("GET request at /patient/{id} with id " + id);
        return PatientDAO.getPatient(id);
    }
    
    /* 
    Get all appointments booked by this patient 
    URI: localhost:8080/HealthSystem/v1/patient/{id}/appointment
    */
    @GET
    @Path("/{id}/appointment/")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Appointment> getPatientAppointments(@PathParam("id") long id) {
        logger.info("GET request at /patient/{id}/appointment with id " + id);
        ArrayList<Appointment> appts = new ArrayList<>();
        
        for (Appointment i : AppointmentDAO.getAllAppointments()) {
            if (i.getPatient() != null && i.getPatient().getId() == id) {
                appts.add(i);
            }
        }
        
        return appts;
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/patient/
    {
        "name": "Sally Michelle",
        "contact": "999",
        "address": "Michigan",
        "status": "Nominal",
        "record": "0"
    }
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postPatient(Patient patient) throws ImproperOrBadRequestException {
        logger.info("POST request at /patient/");
        PatientDAO.addPatient(patient);
        return "Status: OK";
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/patient/{id}
    {
        "name": "Henry Ford",
        "contact": "443",
        "address": "Houstan",
        "status": "Nominal",
        "record": "0"
    }
    */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String putPatient(@PathParam("id") long id, Patient updated) throws Exception {
        logger.info("PUT request at /patient/{id} with id " + id);
        PatientDAO.updatePatient(id, updated);
        return "Status: OK";
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/patient/{id}
    */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deletePatient(@PathParam("id") long id) throws ResourceNotFoundException {
        logger.info("DELETE request at /patient/{id} with id " + id);
        PatientDAO.deletePatient(id);
        return "Status: OK";
    }
}
