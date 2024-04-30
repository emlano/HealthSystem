/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.exception;

/**
 *
 * @author emilano
 */
public class ImproperOrBadRequestException extends Exception {
    public ImproperOrBadRequestException(String resource) {
        super("Cannot parse request body of resource " + resource + "!");
    }
}
