/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.testelasticapi;

/**
 *
 * @author ncanicatti
 */
public class Cv {
    
    private String id;
    private String name;
    private String cv;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Cv(String id, String name, String cv) {
        this.id = id;
        this.name = name;
        this.cv = cv;
    }

    
    
}
