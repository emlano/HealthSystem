/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.PatientDAO;
import com.github.emilano.healthsystem.entity.Patient;
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
        Patient patient = PatientDAO.getPatient(id);
        if (patient == null) throw new ResourceNotFoundException();
        
        return patient;
    
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postPatient(Patient patient) {
        PatientDAO.addPatient(patient);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putPatient(@PathParam("id") long id, Patient updated) throws ResourceNotFoundException {
        Patient patient = PatientDAO.getPatient(id);
        if (patient == null) throw new ResourceNotFoundException();
        
        updated.setId(id);
        PatientDAO.updatePatient(updated);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePatient(@PathParam("id") long id) throws ResourceNotFoundException {
        Patient patient = PatientDAO.getPatient(id);
        if (patient == null) throw new ResourceNotFoundException();
        
        PatientDAO.deletePatient(patient, id);
    }
}
