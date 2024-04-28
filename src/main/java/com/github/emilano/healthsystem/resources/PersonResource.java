/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.PersonDAO;
import com.github.emilano.healthsystem.entity.MedicalRecord;
import com.github.emilano.healthsystem.entity.Patient;
import com.github.emilano.healthsystem.entity.Person;
import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author emilano
 */
@Path("person")
public class PersonResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Person> getAllPersons() {
        PersonDAO.addPerson(new Patient(0, "Harry Potter", "Cupboard under the stairs", "Private Drive", "Nominal", new MedicalRecord(0)));
        PersonDAO.addPerson(new Patient(1, "James Potter", "Cupboard under the stairs", "Private Drive", "Nominal", new MedicalRecord(1)));

        return PersonDAO.getAllPersons();
    }
}
