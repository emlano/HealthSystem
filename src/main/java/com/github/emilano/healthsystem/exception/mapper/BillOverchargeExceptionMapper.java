/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.exception.mapper;

import com.github.emilano.healthsystem.exception.BillOverchargeException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author emilano
 */
@Provider
public class BillOverchargeExceptionMapper implements ExceptionMapper<BillOverchargeException> {
    @Override
    public Response toResponse(BillOverchargeException e) {
        return Response
                .status(Response.Status.CONFLICT)
                .entity("Error: " + e.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}
