/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity.medicalRecord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.emilano.healthsystem.entity.medicalRecord.Diagnosis;
import com.github.emilano.healthsystem.entity.medicalRecord.Treatment;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emilano
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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