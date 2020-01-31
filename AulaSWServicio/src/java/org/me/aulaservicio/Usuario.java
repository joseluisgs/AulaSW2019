/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.aulaservicio;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author link
 */
public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String password;
    private Timestamp momento;

    public Usuario(int id, String nombre, String email, String password, Timestamp momento) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.momento = momento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getMomento() {
        return momento;
    }

    public void setMomento(Timestamp momento) {
        this.momento = momento;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password + ", momento=" + momento + '}';
    }
    
    
    
}
