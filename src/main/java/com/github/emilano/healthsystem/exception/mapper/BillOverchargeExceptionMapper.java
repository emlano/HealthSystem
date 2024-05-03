/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.exception.mapper;

import com.github.emilano.healthsystem.exception.BillOverchargeException;
import java.util.logging.Logger;
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
    private Logger logger = Logger.getLogger(BillOverchargeExceptionMapper.class.getName());
    @Override
    public Response toResponse(BillOverchargeException e) {
        logger.warning("Error: Attempted to over pay bill!");
        for (StackTraceElement i : e.getStackTrace()) {
            logger.warning(i.toString());
        }
        
        return Response
                .status(Response.Status.CONFLICT)
                .entity("Error: " + e.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}
