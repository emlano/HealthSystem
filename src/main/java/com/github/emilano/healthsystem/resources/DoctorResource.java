/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.DoctorDAO;
import com.github.emilano.healthsystem.entity.Doctor;
import com.github.emilano.healthsystem.exception.ResourceNotFoundException;
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
        Doctor doctor = DoctorDAO.getDoctor(id);
        if (doctor == null) throw new ResourceNotFoundException();
        return doctor;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postDoctor(@PathParam("id") long id, Doctor doctor) {
        DoctorDAO.addDoctor(doctor);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putDoctor(@PathParam("id") long id, Doctor updated) throws ResourceNotFoundException {
        Doctor doctor = DoctorDAO.getDoctor(id);
        if (doctor == null) throw new ResourceNotFoundException();
        
        updated.setId(id);
        DoctorDAO.updateDoctor(updated);
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteDoctor(@PathParam("id") long id) throws ResourceNotFoundException {
        Doctor doctor = DoctorDAO.getDoctor(id);
        if (doctor == null) throw new ResourceNotFoundException();
        
        DoctorDAO.deleteDoctor(doctor, id);
    }
}
