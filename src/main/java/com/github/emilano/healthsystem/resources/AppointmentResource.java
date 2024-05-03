/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.AppointmentDAO;
import com.github.emilano.healthsystem.entity.Appointment;
import com.github.emilano.healthsystem.exception.ImproperOrBadRequestException;
import com.github.emilano.healthsystem.exception.ResourceNotFoundException;
import java.util.Collection;
import java.util.logging.Logger;
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

@Path("/appointment")
public class AppointmentResource {
    private Logger logger = Logger.getLogger(AppointmentResource.class.getName());
    
    /*
    URI: localhost:8080/HealthSystem/v1/appointment/
    */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Appointment> getAllAppointments() {
        logger.info("GET request at /appointment/");
        return AppointmentDAO.getAllAppointments();
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/appointment/{id}
    */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointment(@PathParam("id") long id) throws ResourceNotFoundException {
        logger.info("GET request at /appointment/{id} with id " + id);
        return AppointmentDAO.getAppointment(id);
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/appointment/
    {
        "name": "Harry",
        "contact": "232",
        "address": "Private Drive"
    }
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postAppointment(Appointment appointment) throws ImproperOrBadRequestException {
        logger.info("POST request at /appointment/");
        AppointmentDAO.addAppointment(appointment);
        return "Status: OK";
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/appointment/{id}
    {
        "name": "Harry",
        "contact": "232",
        "address": "Grimmauld Place"
    }
    */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String putAppointment(@PathParam("id") long id, Appointment updated) throws Exception {
        logger.info("PUT request at /appointment/{id} with id " + id);
        AppointmentDAO.updateAppointment(id,updated);
        return "Status: OK";
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/appointment/{id}
    */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteAppointment(@PathParam("id") long id) throws ResourceNotFoundException {
        logger.info("DELETE request at /appointment/{id} with id " + id);
        AppointmentDAO.deleteAppointment(id);
        return "Status: OK";
    }
}
