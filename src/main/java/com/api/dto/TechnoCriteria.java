/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.dto;

/**
 *
 * @author t311372
 */
public class TechnoCriteria {

    
    
    private String id;
    private String  TechnoName;
    private int expDurationStart;
    private int expDurationEnd;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTechnoName() {
        return TechnoName;
    }

    public void setTechnoName(String TechnoName) {
        this.TechnoName = TechnoName;
    }

    public int getExpDurationStart() {
        return expDurationStart;
    }

    public void setExpDurationStart(int expDurationStart) {
        this.expDurationStart = expDurationStart;
    }

    public int getExpDurationEnd() {
        return expDurationEnd;
    }

    public void setExpDurationEnd(int expDurationEnd) {
        this.expDurationEnd = expDurationEnd;
    }

    
    
    
    
    
}
