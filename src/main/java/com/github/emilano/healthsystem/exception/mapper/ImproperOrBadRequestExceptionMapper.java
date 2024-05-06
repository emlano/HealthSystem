/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.exception.mapper;

import com.github.emilano.healthsystem.exception.ImproperOrBadRequestException;
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
public class ImproperOrBadRequestExceptionMapper implements ExceptionMapper<ImproperOrBadRequestException>{
    private Logger logger = LoggerFactory.getLogger(ImproperOrBadRequestException.class.getName());
    @Override
    public Response toResponse(ImproperOrBadRequestException e) {
        logger.warn("Error: Bad request received!");
        for (StackTraceElement i : e.getStackTrace()) {
            logger.warn(i.toString());
        }
        return Response
                   .status(Response.Status.BAD_REQUEST)
                   .entity("Error: " + e.getMessage())
                   .type(MediaType.TEXT_PLAIN)
                   .build();
    }
    
}
