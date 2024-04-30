/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.dao;

import com.github.emilano.healthsystem.SharedUtils;
import com.github.emilano.healthsystem.entity.*;
import com.github.emilano.healthsystem.exception.ResourceNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author emilano
 */
public class BillingDAO {
    private static Map<Long, Billing> billings = new HashMap<>();
    
    public static Collection<Billing> getAllBilling() {
        return billings.values();
    }
    
    public static Billing getBilling(long id) throws ResourceNotFoundException {
        Billing bill = billings.get(id);
        if (bill == null) throw new ResourceNotFoundException();
        
        return bill;
    }
    
    public static void addBilling(Billing bill) {
        long id = SharedUtils.getNextId(billings);
        bill.setId(id);
        billings.put(id, bill);
    }
    
    public static void updateBilling(long id, Billing bill) throws ResourceNotFoundException {
        if (billings.get(id) == null) throw new ResourceNotFoundException();
        bill.setId(id);
        billings.replace(id, bill);
    }
    
    public static void deleteBilling(long id) throws ResourceNotFoundException {
        if (billings.get(id) == null) throw new ResourceNotFoundException();
        billings.remove(id);
    }
}
