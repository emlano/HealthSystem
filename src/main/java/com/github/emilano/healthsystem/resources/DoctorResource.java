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
import java.util.List;
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

@Path("/doctor")
public class DoctorResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Doctor> getAllDoctors() {
        return DoctorDAO.getAllDoctors();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctor(@PathParam("id") long id) throws ResourceNotFoundException {
        return DoctorDAO.getDoctor(id);
    }
    
    /* Get all appointments scheduled with the provided doctor */
    @GET
    @Path("/{id}/appointment")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Appointment> getDoctorAppointments(@PathParam("id")long id) {
        ArrayList<Appointment> appts = new ArrayList<>();
        
        for (Appointment i : AppointmentDAO.getAllAppointments()) {
            if (i.getDoctor() != null && i.getDoctor().getId() == id) appts.add(i);
        }
        
        return appts;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postDoctor(@PathParam("id") long id, Doctor doctor) throws ImproperOrBadRequestException {
        DoctorDAO.addDoctor(doctor);
        return "Status: OK";
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String putDoctor(@PathParam("id") long id, Doctor updated) throws Exception {
        DoctorDAO.updateDoctor(id, updated);
        return "Status: OK";
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteDoctor(@PathParam("id") long id) throws ResourceNotFoundException {
        DoctorDAO.deleteDoctor(id);
        return "Status: OK";
    }
}
