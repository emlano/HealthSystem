/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.MedicalRecordDAO;
import com.github.emilano.healthsystem.entity.medicalRecord.MedicalRecord;
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

/**
 *
 * @author emilano
 */
@Path("/record")
public class MedicalRecordResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<MedicalRecord> getAllRecords() {
        return MedicalRecordDAO.getAllMedicalRecords();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord getRecord(@PathParam("id") long id) throws ResourceNotFoundException {
        return MedicalRecordDAO.getMedicalRecord(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postRecord(MedicalRecord record) throws ImproperOrBadRequestException {
        if (record == null || record.getDiagnoses() == null || record.getTreatments() == null) 
            throw new ImproperOrBadRequestException("MedicalRecord");
        
        MedicalRecordDAO.addMedicalRecord(record);
        return "Status: OK";
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String putRecord(@PathParam("id") long id, MedicalRecord updated) throws Exception {
        MedicalRecordDAO.updateMedicaRecord(id, updated);
        return "Status: OK";
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteRecord(@PathParam("id") long id) throws ResourceNotFoundException {
        MedicalRecordDAO.deleteMedicalRecord(id);
        return "Status: OK";
    }
}
