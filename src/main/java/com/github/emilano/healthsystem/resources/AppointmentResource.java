/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.AppointmentDAO;
import com.github.emilano.healthsystem.entity.Appointment;
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

@Path("/appointment")
public class AppointmentResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Appointment> getAllAppointments() {
        return AppointmentDAO.getAllAppointments();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointment(@PathParam("id") long id) {
        return AppointmentDAO.getAppointment(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postAppointment(Appointment appointment) {
        AppointmentDAO.addAppointment(appointment);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putAppointment(@PathParam("id") long id, Appointment updated) {
        Appointment appt = AppointmentDAO.getAppointment(id);
        updated.setId(id);
        AppointmentDAO.updateAppointment(updated);
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteAppointment(@PathParam("id") long id) {
        AppointmentDAO.deleteAppointment(id);
    }
}
