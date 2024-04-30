/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.MedicalRecordDAO;
import com.github.emilano.healthsystem.entity.MedicalRecord;
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
        MedicalRecord record = MedicalRecordDAO.getMedicalRecord(id);
        if (record == null) throw new ResourceNotFoundException();
        return record;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postRecord(MedicalRecord record) {
        MedicalRecordDAO.addMedicalRecord(record);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putRecord(@PathParam("id") long id, MedicalRecord updated) throws ResourceNotFoundException {
        MedicalRecord record = MedicalRecordDAO.getMedicalRecord(id);
        if (record == null) throw new ResourceNotFoundException();
        
        updated.setId(id);
        MedicalRecordDAO.updateMedicaRecord(updated);
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteRecord(@PathParam("id") long id) throws ResourceNotFoundException {
        MedicalRecord record = MedicalRecordDAO.getMedicalRecord(id);
        if (record == null) throw new ResourceNotFoundException();
        MedicalRecordDAO.deleteMedicalRecord(record, id);
    }
}
