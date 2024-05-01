/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.emilano.healthsystem;

import java.util.Map;

/**
 *
 * @author emilano
 */
// Used to generate a unique key for each objects
public class SharedUtils {
    public static long getNextId(Map map) {
        for (long i = 0; i <= map.size(); i++) {
            if (!map.containsKey(i)) return i;
        }
        
        return map.size() + 1;
    }
}
