/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.exception;

/**
 *
 * @author emilano
 */
public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String resource, long id) {
        super("No such resource found of " + resource + " with id " + id);
    }
}
