/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.dto;


import java.io.Serializable;


/**
 *
 * @author ncanicatti
 */
public class Candidat  implements Serializable{
    
    private String id;
    private String name;
    private int age;
    private String surname;
    private String email;
    private String phone;
    private String cvContends;

    public Candidat() {
    }

    
    
    public Candidat(String id, String name, int age, String surname, String email, String phone, String cvContends) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.cvContends = cvContends;
    }
        
    
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCvContends() {
        return cvContends;
    }

    public void setCvContends(String cvContends) {
        this.cvContends = cvContends;
    }
    
    
    
  
  
  
    
  

    

    
    
}
