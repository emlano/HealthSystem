/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.dao;

import com.github.emilano.healthsystem.entity.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author emilano
 */
public class BillingDAO {
    private static Map<Long, Billing> billings = new HashMap<>();
    
    public static List<Billing> getAllBilling() {
        return billings.values().stream().toList();
    }
    
    public static Billing getBilling(long id) {
        return billings.get(id);
    }
    
    public static void addBilling(Billing bill) {
        billings.put(bill.getId(), bill);
    }
    
    public static void updateBilling(Billing bill) {
        billings.replace(bill.getId(), bill);
    }
    
    public static void deleteBilling(long id) {
        billings.remove(id);
    }
}
