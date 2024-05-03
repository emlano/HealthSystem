/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem.dao;

import com.github.emilano.healthsystem.entity.billing.Billing;
import com.github.emilano.healthsystem.SharedUtils;
import com.github.emilano.healthsystem.exception.ImproperOrBadRequestException;
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
        return checkBillingKey(id);
    }
    
    public static void addBilling(Billing bill) throws ImproperOrBadRequestException {
        long id = SharedUtils.getNextId(billings);
        checkBillingObject(bill);
        bill.setId(id);
        billings.put(id, bill);
    }
    
    public static void updateBilling(long id, Billing bill) throws Exception {
        checkBillingKey(id);
        checkBillingObject(bill);
        bill.setId(id);
        billings.replace(id, bill);
    }
    
    public static void deleteBilling(long id) throws ResourceNotFoundException {
        checkBillingKey(id);
        billings.remove(id);
    }
    
    private static Billing checkBillingKey(long id) throws ResourceNotFoundException {
        Billing bill = billings.get(id);
        if (bill == null) throw new ResourceNotFoundException("Billing", id);
        return bill;
    }
    
    private static void checkBillingObject(Billing obj) throws ImproperOrBadRequestException {
        if (obj == null) throw new ImproperOrBadRequestException("Billing");
        if (obj.getDueAmount() == 0) throw new ImproperOrBadRequestException("DueAmount");
        if (obj.getInvoice() == null) throw new ImproperOrBadRequestException("Invoice");
    }
}
