/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.PersonDAO;
import com.github.emilano.healthsystem.entity.Person;
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
@Path("/person")
public class PersonResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Person> getAllPersons() {
        return PersonDAO.getAllPersons();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("id") int id) throws ResourceNotFoundException {
        Person person = PersonDAO.getPerson(id);
        if (person == null) throw new ResourceNotFoundException();
        return person;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postPerson(Person person) {
        PersonDAO.addPerson(person);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putPerson(@PathParam("id") int id, Person updated) throws ResourceNotFoundException {
        Person person = PersonDAO.getPerson(id);
        if (person == null) throw new ResourceNotFoundException();
        
        updated.setId(person.getId());
        PersonDAO.updatePerson(updated);
    }
    
    @DELETE
    @Path("/{id}")
    public void deletePerson(@PathParam("id") int id) throws ResourceNotFoundException {
        Person person = PersonDAO.getPerson(id);
        if (person == null) throw new ResourceNotFoundException();
        PersonDAO.deletePerson(person, id);
    }
}
