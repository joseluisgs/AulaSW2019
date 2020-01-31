/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaswclienteswing.modelo;

/**
 *
 * @author link
 */
public class Alumno {
    private int id;
    private String nombre;
    private float nota;
    
    
    public Alumno(int id, String nombre, float nota) {
        this.id = id;
        this.nombre = nombre;
        this.nota = nota;
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

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", nota=" + nota + '}';
    }
    
    
}
