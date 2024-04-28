/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.PersonDAO;
import com.github.emilano.healthsystem.entity.Doctor;
import com.github.emilano.healthsystem.entity.Person;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author emilano
 */
@Path("/person")
public class PersonResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Person> getAllPersons() {
        
        PersonDAO.addPerson(new Doctor(0, "John H. Watson", "078-6751325", "221b, Baker Street, London", "Surgeon", "055-5555"));
        PersonDAO.addPerson(new Doctor(1, "Arthur C. Doyle", "078-6751325", "221b, Baker Street, London", "Surgeon", "055-5555"));
        return PersonDAO.getAllPersons();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("id") int id) {
        return PersonDAO.getPerson(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postPerson(Person person) {
        
    }
}
