/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.entity;

import java.time.LocalDate;
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
    
    public MedicalRecord(ArrayList<Diagnosis> diagnoses, ArrayList<Treatment> treatments) {
        this.diagnoses = diagnoses;
        this.treatments = treatments;
    }
    
    public MedicalRecord(long id) {
        this(new ArrayList<>(), new ArrayList<>());
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
    private Doctor doctor;
    private String diagnosis;
    private LocalDate dateOfDiagnosis;
    
    public Diagnosis(Doctor doctor, String diagnosis) {
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.dateOfDiagnosis = LocalDate.now();
    }
    
    public Diagnosis(Doctor doctor, String diagnosis, LocalDate dateDiagnosed) {
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.dateOfDiagnosis = dateDiagnosed;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
    public String getDiagnosis() {
        return this.diagnosis;
    }
    
    public void setDateOfDiagnosis(LocalDate newDateOfDiagnosis) {
        this.dateOfDiagnosis = newDateOfDiagnosis;
    }
    
    public LocalDate getDateOfDiagnosis() {
        return this.dateOfDiagnosis;
    }
}


class Treatment {
    private Doctor doctor;
    private String procedure;
    private LocalDate dateOfTreatment;
    
    public Treatment(Doctor doctor, String procedure) {
        this.doctor = doctor;
        this.procedure = procedure;
        this.dateOfTreatment = LocalDate.now();
    }
    
    public Treatment(Doctor doctor, String procedure, LocalDate dateOfTreatment) {
        this.doctor = doctor;
        this.procedure = procedure;
        this.dateOfTreatment = dateOfTreatment;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setTreatment(String treatment) {
        this.procedure = procedure;
    }
    
    public String getProcedure() {
        return this.procedure;
    }
    
    public void setDateOfTreatment(LocalDate date) {
        this.dateOfTreatment = date;
    }
    
    public LocalDate getDateOfTreatment() {
        return this.dateOfTreatment;
    }
}