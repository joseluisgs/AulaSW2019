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
public class Coordenada {
    private int clave;
    private String valor;

    public Coordenada(int clave, String valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Coordenada{" + "clave=" + clave + ", valor=" + valor + '}';
    }
    
    
}
