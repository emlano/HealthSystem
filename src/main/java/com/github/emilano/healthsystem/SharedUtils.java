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
public class SharedUtils {
    public static long getNextId(Map map) {
        return map.size();
    }
}
