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
public class ClientOffers {
    
    
    private String id;
    private String title;
    private String desc;
    private PartialsClients partialsClients;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public PartialsClients getPartialsClients() {
        return partialsClients;
    }

    public void setPartialsClients(PartialsClients partialsClients) {
        this.partialsClients = partialsClients;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
