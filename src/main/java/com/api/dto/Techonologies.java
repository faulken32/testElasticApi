/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.dto;

import java.io.Serializable;

/**
 *
 * @author Utilisateur
 */
public class Techonologies implements Serializable {
    
    
    private String name;

    public Techonologies(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
}
