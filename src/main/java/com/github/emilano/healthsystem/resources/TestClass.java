/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author emilano
 */
@Path("test")
public class TestClass {
    @GET
    @Path("test")
    public String NoGoodDays() {
        return "Sometimes I cry!";
    }
}
