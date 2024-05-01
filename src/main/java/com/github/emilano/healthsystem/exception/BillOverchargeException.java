/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.exception;

/**
 *
 * @author emilano
 */
public class BillOverchargeException extends Exception {
    public BillOverchargeException(double amount, long id) {
        super("Bill cannot be overpaid by amount: " + amount + " for bill id " + id);
    }
}
