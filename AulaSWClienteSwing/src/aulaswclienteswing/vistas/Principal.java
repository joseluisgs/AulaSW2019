/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaswclienteswing.vistas;

import aulaswclienteswing.modelo.Alumno;
import aulaswclienteswing.modelo.Coordenada;
import aulaswclienteswing.modelo.TablaAlumnoModel;
import aulaswclienteswing.modelo.TablaTarjetaModel;
import aulaswclienteswing.modelo.Usuario;
import aulaswclienteswing.utils.Utilidad;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author link
 */
public class Principal extends javax.swing.JFrame {

    private javax.swing.JFrame anterior;
    private Usuario usuario;
    private TablaAlumnoModel tablaAlumnoModel = new TablaAlumnoModel();

    public void setAnterior(javax.swing.JFrame anterior) {
        this.anterior = anterior;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.setTitle("Cliente Aula WS: " + this.usuario.getNombre());
    }

    public void iniciarComponentes() {
        acceso();
        resumen();
        valores();
        cargarTablaAlumnos();
    }

    /**
     * Creates new form Inicio
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tNota = new javax.swing.JTextField();
        bCalificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lTotal = new javax.swing.JLabel();
        lAprobados = new javax.swing.JLabel();
        lSuspensos = new javax.swing.JLabel();
        lNotaMedia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lConexion = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        mRegistrar = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente Aula WS-Swing");
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Calificar Alumno/a:"));

        jLabel5.setText("Nombre:");

        jLabel6.setText("Nota:");

        bCalificar.setText("Calificar");
        bCalificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCalificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bCalificar)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNota, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCalificar))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estadísticas"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Total:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Aprobados:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Suspensos:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nota Media:");

        lTotal.setText("0");

        lAprobados.setText("0");

        lSuspensos.setText("0");

        lNotaMedia.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(lNotaMedia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lSuspensos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lAprobados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lAprobados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lSuspensos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lNotaMedia))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Alumnos/as:"));

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaAlumnos);

        jButton1.setText("Imprimir lista");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lConexion.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lConexion)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lConexion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Eliminar alumno/a");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jMenu1.setText("App");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tarjeta");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Mi Tarjeta");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        mRegistrar.setText("Acceso");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Cerrar Sesion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mRegistrar.add(jMenuItem2);

        jMenuBar1.add(mRegistrar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        cerrarSesion();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        tarjeta();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        imprimir();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bCalificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCalificarActionPerformed
        // TODO add your handling code here:
        calificar();
    }//GEN-LAST:event_bCalificarActionPerformed

    private void tarjeta() {
        // TODO add your handling code here:
        this.setVisible(false);
        Tarjeta t = new Tarjeta();
        t.setLocationRelativeTo(null);
        t.setResizable(false);
        t.setAnterior(this);
        t.setUsuario(this.usuario);
        t.iniciarComponentes(); // porque tengo componentes personalizados
        t.setVisible(true);
    }

    private void cerrarSesion() {
        // Me cargo la sesión que es borrar el usuario
        this.usuario = null;
        this.anterior.setVisible(true);
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCalificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lAprobados;
    private javax.swing.JLabel lConexion;
    private javax.swing.JLabel lNotaMedia;
    private javax.swing.JLabel lSuspensos;
    private javax.swing.JLabel lTotal;
    private javax.swing.JMenu mRegistrar;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tNota;
    private javax.swing.JTable tablaAlumnos;
    // End of variables declaration//GEN-END:variables

    private void acceso() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd'/'MM'/'yyyy 'a las' H':'mm':'s", new Locale("es_ES"));
        Date fechaDate = new Date(this.usuario.getMomento());
        this.lConexion.setText(this.usuario.getNombre() + " - Acceso: " + formateador.format(fechaDate));
    }

    private void resumen() {
        String result = this.estadisticas(this.usuario.getId());
        //out.println("Result = "+result);
        // Procesamos el JSON
        JsonParser parser = new JsonParser();
        JsonObject jO = parser.parse(result).getAsJsonObject();

        this.lTotal.setText(Integer.toString(jO.get("total").getAsInt()));
        this.lAprobados.setText(Integer.toString(jO.get("aprobados").getAsInt()) + " - " + Float.toString(jO.get("aprobados100").getAsFloat()) + "%");
        this.lSuspensos.setText(Integer.toString(jO.get("suspensos").getAsInt()) + " - " + Float.toString(jO.get("suspensos100").getAsFloat()) + "%");
        this.lNotaMedia.setText(Float.toString(jO.get("media").getAsFloat()));

    }

    private static String estadisticas(int id) {
        org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
        org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
        return port.estadisticas(id);
    }

    private void cargarTablaAlumnos() {
        this.tablaAlumnoModel = new TablaAlumnoModel();
        this.tablaAlumnos.setRowSelectionAllowed(true);
        this.tablaAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tablaAlumnos.setModel(tablaAlumnoModel);
        this.tablaAlumnoModel.setFila(listaAlumnos());
    }

    private ArrayList<Alumno> listaAlumnos() {
        ArrayList<Alumno> lista = new ArrayList<Alumno>();
        String result = this.listar(this.usuario.getId());
        JsonParser parser = new JsonParser();
        JsonArray gsonArr = parser.parse(result).getAsJsonArray();
        if (gsonArr.size() != 0) {

            for (JsonElement obj : gsonArr) {
                JsonObject gsonObj = obj.getAsJsonObject();
                Alumno a = new Alumno(gsonObj.get("id").getAsInt(), gsonObj.get("nombre").getAsString(), gsonObj.get("nota").getAsFloat());
                lista.add(a);
            }
        }
        return lista;
    }

    private static String listar(int id) {
        org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
        org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
        return port.listar(id);
    }

    private void imprimir() {
        // Primero es obtener la ruta del fichero a guardar con un elemento de la interfaz
        JFileChooser elegirRuta = new JFileChooser();
        elegirRuta.setDialogTitle("Indica el nombre del Fichero");
        FileNameExtensionFilter filtroFichero = new FileNameExtensionFilter("TXT", "txt");
        elegirRuta.setFileFilter(filtroFichero);
        int seleccion = elegirRuta.showSaveDialog(this);
        // Si pulsa guardar o aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = elegirRuta.getSelectedFile();
            //System.out.println("fichero " + fichero.getAbsolutePath());
            escribirFichero(fichero);
            // guardamos el fichero como sabemos
            imprimirFichero(fichero);

        }
    }

    private void escribirFichero(File file) {
        File fichero = file; // no hace falta pero asi uso la funcion directa que vimos en clase
        PrintWriter f = null;
        try {
            //System.out.println("Escribiendo en el fichero:"+fichero.getAbsolutePath());
            f = new PrintWriter(new FileWriter(fichero));
            f.println("Listado de Alumnos/as\n");
            for (int i = 0; i < tablaAlumnos.getRowCount(); i++) {
                f.println(tablaAlumnos.getValueAt(i, 0).toString() + " - " + tablaAlumnos.getValueAt(i, 1).toString() + " - " + tablaAlumnos.getValueAt(i, 2).toString());

            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al salvar", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (f != null) {
                    f.close();
                }
                JOptionPane.showMessageDialog(null, "Fichero: " + fichero.getName() + " guardado con éxito", "Fichero guardado", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, e2.getMessage(), "Error al salvar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void imprimirFichero(File file) {
        Desktop app = Desktop.getDesktop();
        try {
            app.edit(file); // Se puede poner el método print, o mandarlo por correo, etc. Aquí lo dejo
            //app.mail();
            //app.browse(new URI("https://www.google.es/search?q=uri"));
            //app.print(new File("prueba.txt"));
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void eliminar() {
        int i = this.tablaAlumnos.getSelectedRow();
        if(i>=0){
            Alumno a = new Alumno(Integer.parseInt(tablaAlumnos.getValueAt(i, 0).toString()), tablaAlumnos.getValueAt(i, 1).toString(), Float.parseFloat(tablaAlumnos.getValueAt(i, 2).toString()));
            //System.out.println(a.toString());
            this.setVisible(false);
            Eliminar e = new Eliminar();
            e.setLocationRelativeTo(null);
            e.setResizable(false);
            e.setAnterior(this);
            e.setUsuario(this.usuario);
            e.setAlumno(a);
            e.iniciarComponentes(); // porque tengo componentes personalizados
            e.setVisible(true);
            
        }
    }
    
    private void calificar(){
         // TODO add your handling code here:
         Utilidad u = Utilidad.nuevaInstancia();
        boolean cNombre;
        String nombre = this.tNombre.getText();
        
        if(nombre.length()>0)
            cNombre = true;
        else
            cNombre = false;
        
        boolean cNota;
        String nota = this.tNota.getText();
        if(nota.length()>0 && u.notaValida(nota) && Float.parseFloat(nota) >=0 && Float.parseFloat(nota)<=10)
            cNota = true;
        else
            cNota = false;
        
        if(cNombre && cNota){
            this.setVisible(false);
            Calificar t = new Calificar();
            t.setLocationRelativeTo(null);
            t.setResizable(false);
            t.setAnterior(this);
            t.setUsuario(this.usuario);
            Alumno a = new Alumno(0, nombre, Float.parseFloat(nota));
            t.setAlumno(a);
            t.iniciarComponentes(); // porque tengo componentes personalizados
            t.setVisible(true);
        }else{
            error("");
        }
    }
    
    private void error(String error)  {
        JOptionPane.showMessageDialog(this, "Existe un error en el calificar, por favor, inténtelo de nuevo\n"+error, "Error al calificar", JOptionPane.ERROR_MESSAGE);
    }

    private void valores() {
        this.tNombre.setText("");
        this.tNota.setText("");
    }

}