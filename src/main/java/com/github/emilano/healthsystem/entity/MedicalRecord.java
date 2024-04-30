/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emilano
 */
public class MedicalRecord {
    private long id;
    private List<Diagnosis> diagnoses;
    private List<Treatment> treatments;
    
    public MedicalRecord(@JsonProperty("diagnoses") ArrayList<Diagnosis> diagnoses, @JsonProperty("treatments") ArrayList<Treatment> treatments) {
        this.diagnoses = diagnoses;
        this.treatments = treatments;
    }
    
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setDiagnoses(ArrayList<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }
    
    public void setTreatments(ArrayList<Treatment> treatments) {
        this.treatments = treatments;
    }
    
    public List<Diagnosis> getDiagnoses() {
        return this.diagnoses;
    }
    
    public List<Treatment> getTreatments() {
        return this.treatments;
    }
    
    public void addDiagnosis(Diagnosis diagnosis) {
        this.diagnoses.add(diagnosis);
    }
    
    public void addTreatment(Treatment treatment) {
        this.treatments.add(treatment);
    }
    
    public void removeDiagnosis(Diagnosis diagnosis) {
        this.diagnoses.remove(diagnosis);
    }
    
    public void removeTreatment(Treatment treatment) {
        this.treatments.remove(treatment);
    }
}


class Diagnosis {
    private long doctorId;
    private String diagnosis;
    private String dateOfDiagnosis;
    
    public Diagnosis(@JsonProperty("doctorId") long doctorId, @JsonProperty("diagnosis") String diagnosis) {
        this.doctorId = doctorId;
        this.diagnosis = diagnosis;
        this.dateOfDiagnosis = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
    
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }
    
    public long getDoctorId() {
        return this.doctorId;
    }
    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
    public String getDiagnosis() {
        return this.diagnosis;
    }
    
    public void setDateOfDiagnosis(String newDateOfDiagnosis) {
        this.dateOfDiagnosis = newDateOfDiagnosis;
    }
    
    public String getDateOfDiagnosis() {
        return this.dateOfDiagnosis;
    }
}


class Treatment {
    private long doctorId;
    private String procedure;
    private String dateOfTreatment;
    
    public Treatment(@JsonProperty("doctorId") long doctorId, @JsonProperty("procedure") String procedure) {
        this.doctorId = doctorId;
        this.procedure = procedure;
        this.dateOfTreatment = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
    
    public void setDoctorId(long doctor) {
        this.doctorId = doctorId;
    }
    
    public long getDoctorId() {
        return this.doctorId;
    }
    
    public void setTreatment(String treatment) {
        this.procedure = procedure;
    }
    
    public String getProcedure() {
        return this.procedure;
    }
    
    public void setDateOfTreatment(String date) {
        this.dateOfTreatment = date;
    }
    
    public String getDateOfTreatment() {
        return this.dateOfTreatment;
    }
}