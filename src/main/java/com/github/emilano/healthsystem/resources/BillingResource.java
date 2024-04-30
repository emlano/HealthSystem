/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import com.github.emilano.healthsystem.dao.BillingDAO;
import com.github.emilano.healthsystem.entity.Billing;
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
@Path("/billing")
public class BillingResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Billing> getAllBillings() {
        return BillingDAO.getAllBilling();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getBilling(@PathParam("id") long id) throws ResourceNotFoundException {
        return BillingDAO.getBilling(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postBilling(Billing billing) {
        BillingDAO.addBilling(billing);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putBilling(@PathParam("id") long id, Billing updated) throws ResourceNotFoundException {
        BillingDAO.updateBilling(id, updated);
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteBilling(@PathParam("id") long id) throws ResourceNotFoundException {
        BillingDAO.deleteBilling(id);
    }
}
