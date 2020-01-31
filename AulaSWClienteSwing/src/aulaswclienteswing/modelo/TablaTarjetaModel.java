/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaswclienteswing.modelo;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author link
 */
public class TablaTarjetaModel extends DefaultTableModel {
    
    public TablaTarjetaModel() {

        // Añadimos Cabecera
        this.addColumn("Clave");
        this.addColumn("Valor");
 
    }
    
    public TablaTarjetaModel(String[] columnas) {
        this.setColumnIdentifiers(columnas);
    }
    
    public void setFila(ArrayList<Coordenada> filaTarjeta){
        // Añadimos Filas
        if(filaTarjeta!=null) {
            for(Coordenada a: filaTarjeta) {
                Vector v = new Vector();
                v.add(a.getClave());
                v.add(a.getValor());
                this.addRow(v);

            }
        }
    }
   
    
      @Override
        public boolean isCellEditable(int row, int column){
            // make read only fields except column 0,13,14
            //return column == 0 || column == 13 || column == 14;
            return false;
    }
    
}
