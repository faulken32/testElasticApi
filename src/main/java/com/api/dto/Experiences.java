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
public class Experiences implements Serializable{
    
    
    
    private String id;
    private String title;
    private String compagny;
    private String start; 
    private String end;
    private String expContend;
    private Candidat candidat;

    public Experiences(String title, String compagny, String start, String end, String expContend, Candidat candidat) {
        this.title = title;
        this.compagny = compagny;
        this.start = start;
        this.end = end;
        this.expContend = expContend;
        this.candidat = candidat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    public Experiences() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompagny() {
        return compagny;
    }

    public void setCompagny(String compagny) {
        this.compagny = compagny;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getExpContend() {
        return expContend;
    }

    public void setExpContend(String expContend) {
        this.expContend = expContend;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

   

    
    
    
    
    
        
    
}
