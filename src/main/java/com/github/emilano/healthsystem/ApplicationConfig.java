/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author emilano
 */
// Start point of the server, web.xml points here
@Path("helloworld")
public class ApplicationConfig {
    
    @GET
    public String getStatus() {
        return "Status: OK!";
    }
}
