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
public class TablaAlumnoModel extends DefaultTableModel {
    
    public TablaAlumnoModel() {

        // Añadimos Cabecera
        this.addColumn("Nº");
        this.addColumn("Nombre");
        this.addColumn("Nota");
 
    }
    
    public TablaAlumnoModel(String[] columnas) {
        this.setColumnIdentifiers(columnas);
    }
    
    public void setFila(ArrayList<Alumno> filaAlumno){
        // Añadimos Filas
        if(filaAlumno!=null) {
            for(Alumno a: filaAlumno) {
                Vector v = new Vector();
                v.add(a.getId());
                v.add(a.getNombre());
                v.add(a.getNota());
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
