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
public class SharedUtils<T> {
    public long getNextId(Map<Long, T> map) {
        for (long i = 0; i < map.size(); i++) {
            T obj = map.getOrDefault(i, null);
            
            if (obj == null) return i;
        }
        
        return map.size();
    }
}
