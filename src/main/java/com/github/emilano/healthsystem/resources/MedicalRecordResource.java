/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.MedicalRecordDAO;
import com.github.emilano.healthsystem.entity.medicalRecord.Diagnosis;
import com.github.emilano.healthsystem.entity.medicalRecord.MedicalRecord;
import com.github.emilano.healthsystem.entity.medicalRecord.Treatment;
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
@Path("/record")
public class MedicalRecordResource {
    private Logger logger = Logger.getLogger(MedicalRecordResource.class.getName());
    
    /*
    URI: localhost:8080/HealthSystem/v1/record/
    */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<MedicalRecord> getAllRecords() {
        logger.info("GET request at /record/");
        return MedicalRecordDAO.getAllMedicalRecords();
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/record/{id}
    */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord getRecord(@PathParam("id") long id) throws ResourceNotFoundException {
        logger.info("GET request at /record/{id} with id " + id);
        return MedicalRecordDAO.getMedicalRecord(id);
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/record/
    {
        "diagnoses": [],
        "treatments": []
    }
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postRecord(MedicalRecord record) throws ImproperOrBadRequestException {
        logger.info("POST request at /record/");
        if (record == null || record.getDiagnoses() == null || record.getTreatments() == null) 
            throw new ImproperOrBadRequestException("MedicalRecord");
        
        MedicalRecordDAO.addMedicalRecord(record);
        return "Status: OK";
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/record/{id}/diagnosis
    {
        "doctor": "1",
        "diagnosis": "Hay fever",
        "dateOfDiagnosis": "2022-01-01"
    }
    */
    @POST
    @Path("/{id}/diagnosis")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postDiagnosis(@PathParam("id") long id, Diagnosis diagnosis) throws Exception {
        logger.info("POST request at /record/{id}/diagnosis");
        
        if (diagnosis.getDiagnosis() == null) throw new ImproperOrBadRequestException("Diagnosis");
        if (diagnosis.getDoctor() == null) throw new ImproperOrBadRequestException("Doctor");
        if (diagnosis.getDateOfDiagnosis() == null) throw new ImproperOrBadRequestException("Date");
        
        MedicalRecord record = MedicalRecordDAO.getMedicalRecord(id);
        record.addDiagnosis(diagnosis);
        
        return "Status: OK";
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/record/{id}/treatment
    {
        "doctor": "1",
        "treatment": "Steam Therapy",
        "dateOfTreatment": "2022-02-12"
    }
    */
    @POST
    @Path("/{id}/treatment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postTreatment(@PathParam("id") long id, Treatment treatment) throws Exception {
        logger.info("POST request at /record/{id}/treatment");
        
        if (treatment.getProcedure()== null) throw new ImproperOrBadRequestException("Procedure");
        if (treatment.getDoctor() == null) throw new ImproperOrBadRequestException("Doctor");
        if (treatment.getDateOfTreatment()== null) throw new ImproperOrBadRequestException("Date");
        
        MedicalRecord record = MedicalRecordDAO.getMedicalRecord(id);
        record.addTreatment(treatment);
        
        return "Status: OK";
    } 
    
    /*
    URI: localhost:8080/HealthSystem/v1/record/{id}
    {
        "diagnoses": [
            {
                "doctorId": "0",
                "diagnosis": "Common Cold",
                "dateOfDiagnosis": "2017-01-21"
            }
        ],
        "treatments": [
            {
                "doctorId": "0",
                "procedure": "Knee Surgey",
                "dateOfTreatment": "2018-03-01"
            }
        ]
    }
    */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String putRecord(@PathParam("id") long id, MedicalRecord updated) throws Exception {
        logger.info("PUT request at /record/{id} with id " + id);
        MedicalRecordDAO.updateMedicaRecord(id, updated);
        return "Status: OK";
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/record/{id}
    */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteRecord(@PathParam("id") long id) throws ResourceNotFoundException {
        logger.info("DELETE request at /record/{id} with id " + id);
        MedicalRecordDAO.deleteMedicalRecord(id);
        return "Status: OK";
    }
}
