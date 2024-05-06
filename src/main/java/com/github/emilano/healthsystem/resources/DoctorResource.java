/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.AppointmentDAO;
import com.github.emilano.healthsystem.dao.DoctorDAO;
import com.github.emilano.healthsystem.entity.Appointment;
import com.github.emilano.healthsystem.entity.Doctor;
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

@Path("/doctor")
public class DoctorResource {
    private Logger logger = LoggerFactory.getLogger(DoctorResource.class.getName());
    
    /*
    URI: localhost:8080/HealthSystem/v1/doctor/
    */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Doctor> getAllDoctors() {
        logger.info("GET request at /doctor");
        return DoctorDAO.getAllDoctors();
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/doctor/{id}
    */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctor(@PathParam("id") long id) throws ResourceNotFoundException {
        logger.info("GET request at /doctor/{id} with id " + id);
        return DoctorDAO.getDoctor(id);
    }
    
    /*
    Get all appointments scheduled with the provided doctor
    URI: localhost:8080/HealthSystem/v1/doctor/{id}/appointment
    */
    @GET
    @Path("/{id}/appointment")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Appointment> getDoctorAppointments(@PathParam("id")long id) {
        logger.info("GET request at /doctor/{id}/appointment");
        ArrayList<Appointment> appts = new ArrayList<>();
        
        for (Appointment i : AppointmentDAO.getAllAppointments()) {
            if (i.getDoctor() != null && i.getDoctor().getId() == id) appts.add(i);
        }
        
        return appts;
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/doctor/
    {
        "name": "John H. Watson",
        "contact": "876",
        "address": "221b Baker Street",
        "officeContact": "111",
        "specialization": "Surgery"
    }
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postDoctor(Doctor doctor) throws ImproperOrBadRequestException {
        logger.info("POST request at /doctor");
        DoctorDAO.addDoctor(doctor);
        return "Status: OK";
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/doctor/{id}
    {
        "name": "John H. Watson",
        "contact": "876",
        "address": "221b Baker Street",
        "officeContact": "111",
        "specialization": "General Practice"
    }
    */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String putDoctor(@PathParam("id") long id, Doctor updated) throws Exception {
        logger.info("PUT request at /doctor/{id} with id " + id);
        DoctorDAO.updateDoctor(id, updated);
        return "Status: OK";
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/doctor/{id}
    */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteDoctor(@PathParam("id") long id) throws ResourceNotFoundException {
        logger.info("DELETE request at /doctor/{id} with id " + id);
        DoctorDAO.deleteDoctor(id);
        return "Status: OK";
    }
}
