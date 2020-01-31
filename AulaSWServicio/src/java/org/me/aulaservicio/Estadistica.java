/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.aulaservicio;

import java.text.DecimalFormat;

/**
 *
 * @author link
 */
public class Estadistica {
    private int aprobados;
    private int suspensos;
    private float media;
    private int total;
    private float aprobados100;
    private float suspensos100;
    
    public Estadistica() {
        
    }
    public Estadistica(int aprobados, int suspensos, float media) {
        this.aprobados = aprobados;
        this.suspensos = suspensos;
        setMedia(media);
    }

    public int getAprobados() {
        return aprobados;
    }

    public void setAprobados(int aprobados) {
        this.aprobados = aprobados;
        actualizar();
    }

    public int getSuspensos() {
        return suspensos;
    }

    public void setSuspensos(int suspensos) {
        this.suspensos = suspensos;
        actualizar();
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media =  media;
    }

    public int getTotal() {
        return total;
    }

    public float getAprobados100() {
        return aprobados100;
    }

    public float getSuspensos100() {
        return suspensos100;
    }
    
    
    
    private void actualizar(){
        this.total = aprobados + suspensos;
        this.aprobados100 = Math.round(((this.aprobados * 100)/this.total)*100)/100;
        this.suspensos100 = Math.round(((this.suspensos * 100)/this.total)*100)/100;
        
    }
    @Override
    public String toString() {
        return "Estadistica{" + "aprobados=" + aprobados + ", suspensos=" + suspensos + ", media=" + media + ", total=" + total + ", aprobados100=" + aprobados100 + ", suspensos100=" + suspensos100 + '}';
    }
    
    
    
}
