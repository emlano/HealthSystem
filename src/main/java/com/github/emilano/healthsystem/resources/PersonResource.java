/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.PersonDAO;
import com.github.emilano.healthsystem.entity.Person;
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
@Path("/person")
public class PersonResource {
    private Logger logger = Logger.getLogger(PersonResource.class.getName());
    
    /*
    URI: localhost:8080/HealthSystem/v1/person/
    */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Person> getAllPersons() {
        logger.info("GET request at /person");
        return PersonDAO.getAllPersons();
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/person/{id}
    */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("id") int id) throws ResourceNotFoundException {
        logger.info("GET request at /person/{id} with id " + id);
        return PersonDAO.getPerson(id);
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/person/
    {
        "name": "Harry",
        "contact": "232",
        "address": "Private Drive"
    }
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postPerson(Person person) throws ImproperOrBadRequestException {
        logger.info("POST request at /person/");
        PersonDAO.addPerson(person);
        return "Status: OK";
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/person/{id}
    {
        "name": "Harry",
        "contact": "232",
        "address": "Grimmauld Place"
    }
    */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String putPerson(@PathParam("id") int id, Person updated) throws Exception {
        logger.info("PUT request at /person/{id} with id " + id);
        PersonDAO.updatePerson(id, updated);
        return "Status: OK";
    }
    
    /*
    URI: localhost:8080/HealthSystem/v1/person/
    */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deletePerson(@PathParam("id") int id) throws ResourceNotFoundException {
        logger.info("DELETE request at /person/{id} with id " + id);
        PersonDAO.deletePerson(id);
        return "Status: OK";
    }
}
