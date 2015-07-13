/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.dto;

import java.io.Serializable;
import java.util.List;


/**
 * 
 * {   
       "properties": {
          "candidat": {
            "properties": {
              "age": {
                "type": "long"
              },
              "autoMaticProfiled": {
                "type": "boolean"
              },
              "cvContends": {
                "type": "string"
              },
              "email": {
                "type": "string",
                 "index" : "not_analyzed"
              },
              "enterDate": {
                "type": "date",
                "format": "dateOptionalTime"
              },
              "id": {
                "type": "string"
              },
              "mobilite": {
                "type": "string",
                 "index" : "not_analyzed"
              },
              "name": {
                "type": "string",
                 "index" : "not_analyzed"
              },
              "nbYearExp": {
                "type": "double"
              },
              "phone": {
                "type": "string",
                 "index" : "not_analyzed"
              },
              "preavis": {
                "type": "double"
              },
              "profiled": {
                "type": "boolean"
              },
              "surname": {
                "type": "string",
                 "index" : "not_analyzed"
              },
              "updateDate": {
                "type": "date",
                "format": "dateOptionalTime"
              }
            }
          },
          "compagny": {
            "type": "string",
            "index" : "not_analyzed"
          },
          "end": {
            "type": "date",
            "format": "dateOptionalTime"
          },
          "expContend": {
            "type": "string"
          },
          "id": {
            "type": "string",
            "index" : "not_analyzed"
          },
          "start": {
            "type": "date",
            "format": "dateOptionalTime"
          },
          "tecnoList": {
            "type": "string",
           "index" : "not_analyzed"
          },
          "title": {
            "type": "string",
            "index" : "not_analyzed"
          }
        }
}
    
 */


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
    private List<String> tecnoList;

    public Experiences() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
 
    public List<String> getTecnoList() {
        return tecnoList;
    }

    public void setTecnoList(List<String> tecnoList) {
        this.tecnoList = tecnoList;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }
    
}
