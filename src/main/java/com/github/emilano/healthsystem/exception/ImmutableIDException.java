/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.exception;

/**
 *
 * @author emilano
 */
public class ImmutableIDException extends Exception {
    public ImmutableIDException() {
        super("Changing immutable ID values not allowed");
    }
}
