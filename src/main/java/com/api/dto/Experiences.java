/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.dto;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Utilisateur
 */
public class Experiences implements Serializable{

    private String  title;
    private String  compagny;
    private Date start; 
    private Date end;
    private String expContend;
    private Candidat candidat;

    public Experiences(String title, String compagny, Date start, Date end, String expContend, Candidat candidat) {
        
        this.title = title;
        this.compagny = compagny;
        this.start = start;
        this.end = end;
        this.expContend = expContend;
        this.candidat = candidat;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
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
