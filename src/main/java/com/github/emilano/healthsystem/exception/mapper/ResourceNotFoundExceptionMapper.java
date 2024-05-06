/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.exception.mapper;

import com.github.emilano.healthsystem.exception.ResourceNotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author emilano
 */
@Provider
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException> {
    private Logger logger = LoggerFactory.getLogger(ResourceNotFoundException.class.getName());
    @Override
    public Response toResponse(ResourceNotFoundException e) {
        logger.warn("Error: Resource was not found!");
        for (StackTraceElement i : e.getStackTrace()) {
            logger.warn(i.toString());
        }
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity("Error: " + e.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}