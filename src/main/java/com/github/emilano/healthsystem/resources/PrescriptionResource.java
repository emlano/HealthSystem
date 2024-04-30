/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.PrescriptionDAO;
import com.github.emilano.healthsystem.entity.Prescription;
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
@Path("/prescription")
public class PrescriptionResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Prescription> getAllPrescriptions() {
        return PrescriptionDAO.getAllPrescriptions();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prescription getPrescription(@PathParam("id") long id) throws ResourceNotFoundException {
        Prescription presc = PrescriptionDAO.getPrescription(id);
        if (presc == null) throw new ResourceNotFoundException();
        return presc;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postPrescription(Prescription prescription) {
        PrescriptionDAO.addPrescription(prescription);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putPrescription(@PathParam("id") long id, Prescription updated) throws ResourceNotFoundException {
        Prescription prescription = PrescriptionDAO.getPrescription(id);
        if (prescription == null) throw new ResourceNotFoundException();
        
        updated.setId(id);
        PrescriptionDAO.updatePrescription(updated);
    }
    
    @DELETE
    @Path("/{id}")
    public void deletePrescription(@PathParam("id") long id) throws ResourceNotFoundException {
        Prescription presc = PrescriptionDAO.getPrescription(id);
        if (presc == null) throw new ResourceNotFoundException();
        
        PrescriptionDAO.deletePrescription(presc, id);
    }
}
