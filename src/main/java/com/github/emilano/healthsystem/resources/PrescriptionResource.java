/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.PrescriptionDAO;
import com.github.emilano.healthsystem.entity.prescription.Prescription;
import com.github.emilano.healthsystem.exception.ImproperOrBadRequestException;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author emilano
 */
@Path("/prescription")
public class PrescriptionResource {
    private Logger logger = LoggerFactory.getLogger(PrescriptionResource.class.getName());
   
    /*
    URI: localhost:8080/HealthSystem/v1/prescription/
    */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Prescription> getAllPrescriptions() {
        logger.info("GET request /prescription");
        return PrescriptionDAO.getAllPrescriptions();
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/prescription/{id}
    */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prescription getPrescription(@PathParam("id") long id) throws ResourceNotFoundException {
        logger.info("GET request /prescription/{id} with id " + id);
        return PrescriptionDAO.getPrescription(id);
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/prescription/
    {
        "medications": []
    }
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postPrescription(Prescription prescription) throws ImproperOrBadRequestException {
        logger.info("POST request /prescription");
        PrescriptionDAO.addPrescription(prescription);
        return "Status: OK";
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/prescription/{id}
    {
        "medications": [
            {
                "medicine": "Placebo",
                "instructions": "Once a day",
                "duration": "For six months"
            }
        ]
    }
    */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String putPrescription(@PathParam("id") long id, Prescription updated) throws Exception {
        logger.info("PUT request /prescription/{id} with id " + id);
        PrescriptionDAO.updatePrescription(id, updated);
        return "Status: OK";
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/prescription/{id}
    */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deletePrescription(@PathParam("id") long id) throws ResourceNotFoundException {
        logger.info("DELETE request /prescription/{id} with id " + id);
        PrescriptionDAO.deletePrescription(id);
        return "Status: OK";
    }
}
